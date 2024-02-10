package com.nps.AppNps.converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorDatoscols {

    public static void main(String[] args) {
        String rutaArchivo = "C:/data/cabecerasscotiabank_b2b_callback.txt";
        try {
            String datosEnUnaColumna = procesarArchivo(rutaArchivo);
            System.out.println(datosEnUnaColumna);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String procesarArchivo(String rutaArchivo) throws IOException {
        StringBuilder datosEnUnaColumna = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            if ((linea = br.readLine()) != null) {
                // Dividir la línea en tokens usando la coma como delimitador
                String[] tokens = linea.split(",");

                // Iterar sobre los tokens y agregarlos a la columna final
                for (String token : tokens) {
                    datosEnUnaColumna.append(token.trim()).append("\n");
                }
            }
        }

        return datosEnUnaColumna.toString().trim();
    }
}