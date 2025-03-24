package com.susmitha.wordtrace.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.susmitha.wordtrace.auditLogEntry.AuditLogEntry;
import com.susmitha.wordtrace.databaseConstants.DatabaseConstants;

/**
 * Manages database connections and audit logging
 * provides methods to establish a database connection and insert audit logs
 */

public class WordTraceAuditRepository {
    /**
     * Establishes and returns a connection to the database.
     *
     * @return connection object for database interaction.
     * @throws SQLException if a database access error occurs.
     */
    Connection getConnection() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("C:/Susmitha/Internship/Poc1/wordtrace/src/main/resources/application.properties")) {
            properties.load(fileInputStream);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            return DriverManager.getConnection(properties.getProperty("db.connectionString"), properties.getProperty("db.username"), properties.getProperty("db.password"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * inserts an audit log entry into the database
     * stores information about inputFilePath, searchWord, result, word occurrence count and errorMessage
     *
     * @param auditLogEntry reference of AuditLogEntry class
     */
    public void insertAuditLog(AuditLogEntry auditLogEntry) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DatabaseConstants.INSERT_AUDIT_LOG)) {
            //setting values for the prepared statement
            preparedStatement.setString(1, auditLogEntry.getInputFilePath());
            preparedStatement.setString(2, auditLogEntry.getSearchWord());
            preparedStatement.setString(3, auditLogEntry.getResult());
            preparedStatement.setInt(4, auditLogEntry.getCount());
            preparedStatement.setString(5, auditLogEntry.getErrorMessage());
            //executing the query
            preparedStatement.executeUpdate();
            System.out.println(DatabaseConstants.MESSAGE_LOG_SUCCESS);
        } catch (SQLException sqlException) {
            System.out.println(DatabaseConstants.MESSAGE_LOG_FAIL);
            sqlException.printStackTrace();
        }
    }
}
