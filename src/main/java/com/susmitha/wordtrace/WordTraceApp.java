package com.susmitha.wordtrace;

import constants.wordtraceconstants.WordTraceConstants;
import inputvalidator.InputValidator;

/**
 * Main entry point for the WordTrace Application
 */
public class WordTraceApp {
    /**
     * main method to execute the application
     *
     * @param args
     */
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        if (!inputValidator.validateInputs(args)) {
            return;
        }
        String inputFilePath = args[0];
        String searchWord = args[1];
        System.out.println(WordTraceConstants.MESSAGE_INPUT_FILEPATH + inputFilePath);
        System.out.println(WordTraceConstants.MESSAGE_SEARCH_WORD + searchWord);
        System.out.println(WordTraceConstants.MESSAGE_FILEPATH_CORRECT);
        System.out.println(WordTraceConstants.MESSAGE_PROCESSING);
    }
}
