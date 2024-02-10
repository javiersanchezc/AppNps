package com.nps.AppNps.converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorDatos {

    public static void main(String[] args) {
        String rutaArchivo = "C:/data/cabeceraBpulseinvitation.txt";

        try {
            String datosEnUnaFila = procesarArchivo(rutaArchivo);
            System.out.println(datosEnUnaFila);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String procesarArchivo(String rutaArchivo) throws IOException {
        StringBuilder datosEnUnaFila = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en tokens usando la coma como delimitador
                String[] tokens = linea.split(",");

                // Iterar sobre los tokens y agregarlos a la fila final separados por coma
                for (String token : tokens) {
                    datosEnUnaFila.append(token.trim()).append(",");
                }
            }
        }

        // Eliminar la última coma si existe
        if (datosEnUnaFila.length() > 0) {
            datosEnUnaFila.deleteCharAt(datosEnUnaFila.length() - 1);
        }

        return datosEnUnaFila.toString();
    }
}