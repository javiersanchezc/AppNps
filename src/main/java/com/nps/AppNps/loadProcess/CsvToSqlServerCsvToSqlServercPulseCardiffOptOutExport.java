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

public class CsvToSqlServerCsvToSqlServercPulseCardiffOptOutExport {

    private String jdbcUrl;
    private String inputFilePathwm_cPulseInsuranceCardiffOptOutExport;
    private String tableNamecPulseInsuranceCardiffOptOutExport;

    public CsvToSqlServerCsvToSqlServercPulseCardiffOptOutExport() {
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

            inputFilePathwm_cPulseInsuranceCardiffOptOutExport = properties.getProperty("inputFilePathwm_cPulseInsuranceCardiffOptOutExport");
            tableNamecPulseInsuranceCardiffOptOutExport = properties.getProperty("tableNamecPulseInsuranceCardiffOptOutExport");
            jdbcUrl = properties.getProperty("jdbcUrl");

        } catch (Exception e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convertCsvToSqlServer() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             CSVReader csvReader = new CSVReader(new FileReader(inputFilePathwm_cPulseInsuranceCardiffOptOutExport))) {

            String[] headers = csvReader.readNext();

            String insertionSql = buildInsertionSql(headers);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertionSql)) {
                String[] row;
                while ((row = csvReader.readNext()) != null) {
                    setParameters(preparedStatement, row);
                    preparedStatement.executeUpdate();
                }

                System.out.println("Data successfully loaded into SQL Server.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException error){
            error.printStackTrace();
            System.out.println("------------"+error);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildInsertionSql(String[] headers) {
        String sql = "INSERT INTO " + tableNamecPulseInsuranceCardiffOptOutExport + " VALUES (";
        for (int i = 0; i < headers.length; i++) {
            sql += (i == 0) ? "?" : ", ?";
        }
        sql += ")";
        return sql;
    }

    private void setParameters(PreparedStatement preparedStatement, String[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setString(i + 1, values[i]);
        }
    }

}