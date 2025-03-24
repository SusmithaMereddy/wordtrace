package com.susmitha.wordtrace.databaseConstants;

/**
 * defines constants used for database operations
 */

public class DatabaseConstants {
    public static final int COUNT_ZERO = 0;
    public static final String EMPTY_STRING = "";
    public static final String ERROR_MESSAGE_WORD_NOT_FOUND = " Word not found!";
    public static final String INSERT_AUDIT_LOG = "INSERT INTO audit(InputFile_Path, Search_Word, Search_Date_Time, Result_Status, Word_Count, Error_Message) VALUES (?, ?, NOW(), ?, ?, ?)";
    public static final String MESSAGE_LOG_FAIL = "Error logging audit entry";
    public static final String MESSAGE_LOG_SUCCESS = "Audit log inserted successfully";
    public static final String MESSAGE_SUCCESS = "Success";
}
