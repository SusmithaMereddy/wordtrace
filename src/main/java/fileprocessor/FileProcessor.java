package com.susmitha.wordtrace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    public static int countWordOccurrences(String inputFilePath, String searchWord) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fileWords = line.split("\\s+");
                for (String word : fileWords) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
