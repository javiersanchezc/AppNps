package com.nps.AppNps.loadProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {

    private String inputFilePath;
    private String outputFilePath;
    private String firstLine;

    public CSV(String inputFilePath, String outputFilePath, String firstLine) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.firstLine = firstLine;
    }

    public void transformCsv() {
        try {
            String content = readFileContent(inputFilePath);

            // Eliminar la primera línea del archivo original
            int indexOfFirstLineBreak = content.indexOf("\n");
            if (indexOfFirstLineBreak != -1) {
                content = content.substring(indexOfFirstLineBreak + 1);
            }

            // Agregar la primera línea proporcionada como parámetro
            content = firstLine + "\n" + content;

            String modifiedContent = replaceCommasAndQuotes(content);
            writeToFile(outputFilePath, modifiedContent);
            System.out.println("Transformation completed. Result written to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    private String replaceCommasAndQuotes(String input) {
        StringBuilder result = new StringBuilder();
        boolean insideQuotes = false;

        for (char c : input.toCharArray()) {
            if (c == '\"') {
                insideQuotes = !insideQuotes; // Cambiar el estado dentro o fuera de las comillas
            } else if (insideQuotes && c == ',') {
                result.append('.'); // Reemplazar la coma por un punto dentro de las comillas
            } else if (c != '\"') {
                result.append(c); // Agregar el carácter a menos que sea una comilla
            }
        }

        return result.toString();
    }
}
