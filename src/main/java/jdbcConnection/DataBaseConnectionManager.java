package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import constants.wordtraceconstants.WordTraceConstants;

/**
 * Manages database connections and audit logging
 * provides methods to establish a database connection and insert audit logs
 */

public class DataBaseConnectionManager {
    /**
     * Establishes and returns a connection to the database.
     *
     * @return connection object for database interaction.
     * @throws SQLException if a database access error occurs.
     */
    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(WordTraceConstants.MYSQL_URL, WordTraceConstants.MYSQL_USERNAME, WordTraceConstants.MYSQL_PASSWORD);
    }

    /**
     * inserts an audit log entry into the database
     *
     * @param inputFilePath the path of the file that is to be processed
     * @param searchWord    the word searched in the file
     * @param result        the result of the search operation
     * @param wordCount     the number of times the word appeared in the file
     * @param errorMessage  any error message encountered during the operation
     */
    public static void insertAuditLog(String inputFilePath, String searchWord, String result, int wordCount, String errorMessage) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(WordTraceConstants.INSERT_AUDIT_LOG)) {
            preparedStatement.setString(1, inputFilePath);
            preparedStatement.setString(2, searchWord);
            preparedStatement.setString(3, result);
            preparedStatement.setInt(4, wordCount);
            preparedStatement.setString(5, errorMessage);
            preparedStatement.executeUpdate();
            System.out.println(WordTraceConstants.MESSAGE_LOG_SUCCESS);
        } catch (SQLException sqlException) {
            System.out.println(WordTraceConstants.MESSAGE_LOG_FAIL);
            sqlException.printStackTrace();

        }
    }
}
