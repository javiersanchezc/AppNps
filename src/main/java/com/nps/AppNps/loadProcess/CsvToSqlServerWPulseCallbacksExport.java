package com.nps.AppNps.loadProcess;

import com.opencsv.CSVReader;


import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CsvToSqlServerWPulseCallbacksExport {

    private String jdbcUrl;
    private String inputFilePathwm_callback;
    private String tableNamewPulse_Callbacks;
    private String errorFilePath;
    public CsvToSqlServerWPulseCallbacksExport() {
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

            inputFilePathwm_callback = properties.getProperty("inputFilePathwm_callback");
            tableNamewPulse_Callbacks = properties.getProperty("tableNamewPulse_Callbacks");
            jdbcUrl = properties.getProperty("jdbcUrl");
            errorFilePath = properties.getProperty("errorFilePath");
            System.out.println(inputFilePathwm_callback);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convertCsvToSqlServer() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             CSVReader csvReader = new CSVReader(new FileReader(inputFilePathwm_callback))) {

            String[] headers = csvReader.readNext();

            String insertionSql = buildInsertionSql(headers);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertionSql)) {
                String[] row;
                while ((row = csvReader.readNext()) != null) {
                    try {
                        setParameters(preparedStatement, row);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        logErrorRecord(row);
                    }
                }

                System.out.println("Data successfully loaded into SQL Server.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildInsertionSql(String[] headers) {
        String sql = "INSERT INTO " + tableNamewPulse_Callbacks + " VALUES (";
        for (int i = 0; i < headers.length; i++) {
            sql += (i == 0) ? "?" : ", ?";
        }
        sql += ")";
        System.out.println("sql = " + sql);
        return sql;
    }

    private void setParameters(PreparedStatement preparedStatement, String[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setString(i + 1, values[i]);
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
