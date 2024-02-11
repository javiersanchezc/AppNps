package com.nps.AppNps.loadProcess;
import com.opencsv.CSVReader;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

public class CsvToSqlServerBPulsescotiabank_b2b_responses_export {

    private String jdbcUrl;
    private String inputFilePathwm_bPulse_Response_Export;
    private String tableNamebPulse_bPulse_Response_Export;
    private String errorFilePath;
    public CsvToSqlServerBPulsescotiabank_b2b_responses_export() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("No se pudo encontrar el archivo de propiedades.");
                return;
            }
            properties.load(input);

            inputFilePathwm_bPulse_Response_Export = properties.getProperty("inputFilePathwm_bPulse_Response_Export");
            tableNamebPulse_bPulse_Response_Export = properties.getProperty("tableNamebPulse_bPulse_Response_Export");
            jdbcUrl = properties.getProperty("jdbcUrl");
            errorFilePath = properties.getProperty("errorFilePath");
        } catch (Exception e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convertCsvToSqlServer() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             CSVReader csvReader = new CSVReader(new FileReader(inputFilePathwm_bPulse_Response_Export))) {

            String[] headers = csvReader.readNext();

            String insertionSql = buildInsertionSql(headers);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertionSql)) {
                String[] row;
                while ((row = csvReader.readNext()) != null) {
                    try {
                        // Omitir espacios iniciales (si es el problema)
                        row[0] = row[0].trim();

                        // Reemplazar caracteres especiales (si es necesario)
                        row[0] = Pattern.compile("[^\\w\\s]").matcher(row[0]).replaceAll("");

                        // Validar si el primer campo es numérico
                        if (!isNumeric(row[0])) {
                            System.err.println("El primer campo de la línea " + Arrays.toString(row) + " no es numérico. Saltando línea.");
                            continue;
                        }

                        setParameters(preparedStatement, row, headers.length);
                        preparedStatement.executeUpdate();
                        System.out.println("Fila insertada exitosamente.");
                    } catch (Exception e) {
                        // Registrar el error y continuar con la siguiente línea
                        e.printStackTrace();
                        logErrorRecord(row);
                    }
                }

                System.out.println("Datos cargados exitosamente en SQL Server.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para verificar si una cadena es numérica
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDecimal(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String buildInsertionSql(String[] headers) {
        String sql = "INSERT INTO " + tableNamebPulse_bPulse_Response_Export + " VALUES (";
        for (int i = 0; i < headers.length; i++) {
            sql += (i == 0) ? "?" : ", ?";
        }
        sql += ")";
        return sql;
    }

    private void setParameters(PreparedStatement preparedStatement, String[] values, int expectedLength) throws SQLException {
        for (int i = 0; i < expectedLength; i++) {
            if (i < values.length) {
                preparedStatement.setString(i + 1, values[i]);
            } else {
                preparedStatement.setNull(i + 1, java.sql.Types.VARCHAR);
            }
        }
    }
    private void logErrorRecord(String[] values) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(errorFilePath, true))) {
            // Append the error record to the error file
            for (String value : values) {
                writer.write(value + ",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
