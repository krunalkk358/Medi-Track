package com.airtribe.meditrack.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void writeToFile(String fileName, List<String> data) {

        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for(String line : data) {
                writer.println(line);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String[]> readFromFile(String fileName) {

        List<String[]> rows = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while((line = reader.readLine()) != null) {
                rows.add(line.split(","));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

}