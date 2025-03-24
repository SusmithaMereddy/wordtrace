package com.susmitha.wordtrace.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import com.susmitha.wordtrace.wordtraceconstants.WordTraceConstants;
import com.susmitha.wordtrace.databaseConstants.DatabaseConstants;

/**
 * This class provides functionality to read a file and count the occurrences of a specific word in a file
 */
public class WordOccurrenceCounter {
    /**
     * Counts the occurrences of specific word in a file
     * This method reads the entire file contents as a string using Files.readString()
     * It then uses StringTokenizer to split the string into tokens at a specified delimeter
     * Checks if the token is matching with the delimeter and returns count
     *
     * @param inputFilePath the path of the file to read
     * @param searchWord    the word to search for in the file
     * @return the number of times the word appears in the file
     */
    public int countWordOccurrences(String inputFilePath, String searchWord) {
        int searchedWordCount = 0;
        try {
            String fileContents = Files.readString(Paths.get(inputFilePath));
            //StringTokenizer to split the words based on delimeter.
            StringTokenizer stringTokenizer = new StringTokenizer(fileContents, WordTraceConstants.DELIMETER);
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken().replaceAll(WordTraceConstants.TOKENIZER_DELIMETER_REGEX_PATTERN, DatabaseConstants.EMPTY_STRING);
                if (token.equalsIgnoreCase(searchWord)) {
                    searchedWordCount++;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return searchedWordCount;
    }
}
