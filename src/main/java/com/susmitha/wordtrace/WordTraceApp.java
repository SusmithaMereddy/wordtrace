package com.susmitha.wordtrace;

import com.susmitha.wordtrace.wordtraceconstants.WordTraceConstants;
import com.susmitha.wordtrace.fileprocessing.WordOccurrenceCounter;
import com.susmitha.wordtrace.util.AuditEntryUtil;
import com.susmitha.wordtrace.validator.InputValidator;
import com.susmitha.wordtrace.repository.WordTraceAuditRepository;
import com.susmitha.wordtrace.databaseConstants.DatabaseConstants;
import com.susmitha.wordtrace.auditLogEntry.AuditLogEntry;

import java.io.File;

/**
 * Main entry point for the WordTrace Application
 */
public class WordTraceApp {
    AuditLogEntry auditLogEntry;

    /**
     * main method to execute the application
     * This class initiates the process of input validation
     *
     * @param args command line arguments where args[0] is the file path and args[1] is the word to search in the file
     */
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        AuditEntryUtil auditEntryUtil = new AuditEntryUtil();
        WordTraceAuditRepository wordTraceAuditRepository = new WordTraceAuditRepository();
        String validationError = inputValidator.validateInputs(args);
        if (validationError != null) {

          wordTraceAuditRepository.insertAuditLog(auditEntryUtil.setAuditEntry(args.length > 0 ? args[0] : null,
                    args.length > 1 ? args[1] : null, "error", DatabaseConstants.COUNT_ZERO, validationError));
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
            System.out.printf((WordTraceConstants.MESSAGE_COUNT_WORD), searchWord, count, inputFileName);
            wordTraceAuditRepository.insertAuditLog(auditEntryUtil.setAuditEntry(inputFilePath, searchWord, DatabaseConstants.MESSAGE_SUCCESS, count, DatabaseConstants.EMPTY_STRING));
        } else {
            System.out.printf((WordTraceConstants.KEY_WORD_NOT_FOUND) + WordTraceConstants.NEW_LINE, searchWord, inputFileName);
            wordTraceAuditRepository.insertAuditLog(auditEntryUtil.setAuditEntry(inputFilePath, searchWord, DatabaseConstants.MESSAGE_SUCCESS, DatabaseConstants.COUNT_ZERO, DatabaseConstants.ERROR_MESSAGE_WORD_NOT_FOUND));
        }
    }
}
