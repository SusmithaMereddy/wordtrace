package com.susmitha.wordtrace.util;

import com.susmitha.wordtrace.auditLogEntry.AuditLogEntry;

/**
 * utility class for creating and managing audit log entries
 */

public class AuditEntryUtil {
    /**
     * creates and returns AuditLogEntry object with the given details
     *
     * @param inputFilePath   the file path where the search is to be performed
     * @param searchWord      the word we are searching for
     * @param result          "success" if the file is processed and "error" otherwise.
     * @param searchWordCount the number of times the search word has appeared.
     * @param errorMessage    if any file validation or processing fails.
     * @return AuditLogEntry object.
     */
    public AuditLogEntry setAuditEntry(String inputFilePath, String searchWord, String result, int searchWordCount, String errorMessage) {
        AuditLogEntry auditLogEntry = new AuditLogEntry();
        auditLogEntry.setInputFilePath(inputFilePath);
        auditLogEntry.setSearchWord(searchWord);
        auditLogEntry.setCount(searchWordCount);
        auditLogEntry.setResult(result);
        auditLogEntry.setErrorMessage(errorMessage);
        return auditLogEntry;
    }
}
