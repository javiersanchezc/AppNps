package com.nps.AppNps.loadProcess;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CsvToSqlServerBPulsescotiabank_b2b_callback {

    private String jdbcUrl;
    private String inputFilePathwm_scotiabank_b2b_callback;
    private String tableNamescotiabank_b2b_callback;

    public CsvToSqlServerBPulsescotiabank_b2b_callback() {
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

            inputFilePathwm_scotiabank_b2b_callback = properties.getProperty("inputFilePathwm_scotiabank_b2b_callback");
            tableNamescotiabank_b2b_callback = properties.getProperty("tableNamescotiabank_b2b_callback");
            jdbcUrl = properties.getProperty("jdbcUrl");

        } catch (Exception e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convertCsvToSqlServer() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             CSVReader csvReader = new CSVReader(new FileReader(inputFilePathwm_scotiabank_b2b_callback))) {

            String[] headers = csvReader.readNext();

            String insertionSql = buildInsertionSql(headers);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertionSql)) {
                String[] row;
                while ((row = csvReader.readNext()) != null) {
                    setParameters(preparedStatement, row, headers.length);
                    preparedStatement.executeUpdate();
                }

                System.out.println("Data successfully loaded into SQL Server.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException error){
            error.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildInsertionSql(String[] headers) {
        String sql = "INSERT INTO " + tableNamescotiabank_b2b_callback + " VALUES (";
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
                // Si la cantidad de valores en la fila es menor que la cantidad de columnas esperadas,
                // establece el parámetro como nulo o ajusta según tus requisitos.
                preparedStatement.setNull(i + 1, java.sql.Types.VARCHAR);

            }
        }
    }
}
