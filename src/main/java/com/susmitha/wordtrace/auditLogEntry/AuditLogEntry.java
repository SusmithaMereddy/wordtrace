package com.susmitha.wordtrace.auditLogEntry;

import lombok.Getter;
import lombok.Setter;

/**
 * encapsulates details about single audit log record
 * An instance of this class is used to log operation details into database
 */
@Getter
@Setter
public class AuditLogEntry {
    private String inputFilePath;
    private String searchWord;
    private String result;
    private int count;
    private String errorMessage;
}
