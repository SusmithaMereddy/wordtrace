package com.susmitha.wordtrace.validator;

import com.susmitha.wordtrace.wordtraceconstants.WordTraceConstants;

import java.io.File;

/**
 * This class provides methods for validating input arguments.It ensures correct argument count, file existence and valid file types
 */
public class InputValidator {
    /**
     * Ensures exactly two arguments are passed
     * verifies if the file exists and is a valid file
     * checks whether the file has valid extension
     * ensures that the file is not empty
     *
     * @param args inputFilePath and searchWord
     * @return errorMessage if any of the checks fail , null otherwise (indicating valid inputs)
     */
    public String validateInputs(String[] args) {
        if (args.length < 2) {
            System.out.println(WordTraceConstants.ERROR_INSUFFICIENT_ARGUMENTS);
            return WordTraceConstants.ERROR_INSUFFICIENT_ARGUMENTS;
        }
        if (args.length > 2) {
            System.out.println(WordTraceConstants.ERROR_MORE_ARGUMENTS);
            return WordTraceConstants.ERROR_MORE_ARGUMENTS;
        }
        String inputFilePath = args[0];
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            System.out.println(WordTraceConstants.ERROR_FILE_DOES_NOT_EXIST);
            return WordTraceConstants.ERROR_FILE_DOES_NOT_EXIST;
        }
        if (!inputFile.isFile()) {
            System.out.println(WordTraceConstants.ERROR_INVALID_FILE_PATH);
            return WordTraceConstants.ERROR_INVALID_FILE_PATH;
        }
        if (!hasValidFileType(inputFilePath)) {
            System.out.println(WordTraceConstants.INVALID_FILE_TYPE);
            return WordTraceConstants.INVALID_FILE_TYPE;
        }
        if (inputFile.length() == 0) {
            System.out.println(WordTraceConstants.MESSAGE_EMPTY_FILE);
            return WordTraceConstants.MESSAGE_EMPTY_FILE;
        }
        return null;
    }

    private boolean hasValidFileType(String inputFilePath) {
        return !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_TXT) || !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_JSON);
    }
}
