package constants.wordtraceconstants;

/**
 * This class defines constant values used across the WordTrace Application
 */
public class WordTraceConstants {
    public static final int COUNT_ZERO = 0;
    public static final String DELIMETER = "\t\n ";
    public static final String EMPTY_STRING = "";
    public static final String ERROR_INSUFFICIENT_ARGUMENTS = "Please provide both the file path and the word to search";
    public static final String ERROR_INVALID_FILE = "File path is incorrect or file doesn't exist. Please provide valid file path";
    public static final String ERROR_MESSAGE_INVALID_INPUTS = "Invalid Inputs";
    public static final String ERROR_MESSAGE_WORD_NOT_FOUND = " Word not found!";
    public static final String ERROR_MORE_ARGUMENTS = "Please provide only the file path and the word to be searched";
    public static final String FILE_EXTENSION_JSON = ".json";
    public static final String FILE_EXTENSION_TXT = ".txt";
    public static final String INSERT_AUDIT_LOG = "INSERT INTO audit(InputFile_Path, Search_Word, Search_Date_Time, Result_Status, Word_Count, Error_Message) VALUES (?, ?, NOW(), ?, ?, ?)";
    public static final String INVALID_FILE_TYPE = "Invalid file type. Only " + FILE_EXTENSION_TXT + " and " + FILE_EXTENSION_JSON + " are allowed";
    public static final String MESSAGE_COUNT_WORD = "The word '%s' has occurred '%d' times in the file '%s'.";
    public static final String MESSAGE_FILEPATH_CORRECT = "File path is correct!";
    public static final String MESSAGE_INPUT_FILEPATH = "Input file Path : ";
    public static final String MESSAGE_LOG_SUCCESS = "Audit log inserted successfully!!!";
    public static final String MESSAGE_LOG_FAIL = "Error logging audit entry!!";
    public static final String MESSAGE_PROCESSING = "Processing....";
    public static final String MESSAGE_SEARCH_WORD = "Word to search : ";
    public static final String MESSAGE_SUCCESS = "Success";
    public static final String KEY_WORD_NOT_FOUND = "The word '%s' is not found in the file '%s'";
    public static final String MYSQL_PASSWORD = "Susmitha@2002";
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/word_search_database";
    public static final String MYSQL_USERNAME = "root";
    public static final String TOKENIZER_DELIMETER_REGEX_PATTERN = "[^a-zA-Z0-9]";
}
