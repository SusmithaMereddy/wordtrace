package com.susmitha.wordtrace;

import com.susmitha.wordtraceconstants.WordTraceConstants;

public class WordTraceApp {
    public static void main(String[] args) {
        String validationMessage = InputValidator.validateInputs(args);
        if (!validationMessage.isEmpty()) {
            System.out.println(validationMessage);
            return;
        }
        String inputFilePath = args[0];
        String searchWord = args[1];
        System.out.println(WordTraceConstants.MESSAGE_INPUT_FILEPATH + inputFilePath);
        System.out.println(WordTraceConstants.MESSAGE_SEARCH_WORD + searchWord);
        System.out.println(WordTraceConstants.MESSAGE_PROCESSING);
    }
}
