package com.susmitha.wordtrace;

import constants.wordtraceconstants.WordTraceConstants;
import fileprocessing.WordOccurrenceCounter;
import validator.InputValidator;
import jdbcConnection.DataBaseConnectionManager;

import java.io.File;

/**
 * Main entry point for the WordTrace Application
 */
public class WordTraceApp {
    /**
     * main method to execute the application
     * This class initiates the process of input validation
     *
     * @param args command line arguments where args[0] is the file path and args[1] is the word to search in the file
     */
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        if (!inputValidator.validateInputs(args)) {
            return;
        }
        String inputFilePath = args[0];
        String searchWord = args[1];
        //Creating object for File class
        File inputFile = new File(inputFilePath);
        String inputFileName = inputFile.getName();
        System.out.println(
                WordTraceConstants.MESSAGE_INPUT_FILEPATH + inputFilePath + "\n" +
                        WordTraceConstants.MESSAGE_SEARCH_WORD + searchWord + "\n" +
                        WordTraceConstants.MESSAGE_FILEPATH_CORRECT + "\n" +
                        WordTraceConstants.MESSAGE_PROCESSING
        );
        //Creating object for wordCounter class
        WordOccurrenceCounter wordOccurrenceCounter = new WordOccurrenceCounter();
        int count = wordOccurrenceCounter.countWordOccurrences(inputFilePath, searchWord);
        if (count > 0) {
            System.out.printf((WordTraceConstants.MESSAGE_COUNT_WORD) + "%n", searchWord, count, inputFileName);
            DataBaseConnectionManager.insertAuditLog(inputFilePath, searchWord, WordTraceConstants.MESSAGE_SUCCESS, count, WordTraceConstants.EMPTY_STRING);
        } else {
            System.out.printf((WordTraceConstants.KEY_WORD_NOT_FOUND) + "%n", searchWord, inputFileName);
            DataBaseConnectionManager.insertAuditLog(inputFilePath, searchWord, WordTraceConstants.MESSAGE_SUCCESS, WordTraceConstants.COUNT_ZERO, WordTraceConstants.ERROR_MESSAGE_WORD_NOT_FOUND);
        }
    }
}
