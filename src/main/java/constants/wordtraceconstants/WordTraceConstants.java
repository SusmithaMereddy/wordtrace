package constants.wordtraceconstants;

/**
 * This class defines constant values used across the WordTrace Application
 */
public class WordTraceConstants {
    public static final String ERROR_INSUFFICIENT_ARGUMENTS = "Please provide both the file path and the word to search";
    public static final String ERROR_INVALID_FILE = "File path is incorrect or file doesn't exist";
    public static final String ERROR_MORE_ARGUMENTS = "Please provide only the file path and the word to be searched";
    public static final String FILE_EXTENSION_JSON = ".json";
    public static final String FILE_EXTENSION_TXT = ".txt";
    public static final String INVALID_FILE_TYPE = "Invalid file type. Only " + FILE_EXTENSION_TXT + " and " + FILE_EXTENSION_JSON + " are allowed";
    public static final String MESSAGE_FILEPATH_CORRECT = "File path is correct!";
    public static final String MESSAGE_INPUT_FILEPATH = "File Path : ";
    public static final String MESSAGE_PROCESSING = "Processing....";
    public static final String MESSAGE_SEARCH_WORD = "Word to search : ";
    public static final String MESSAGE_COUNT_WORD = "The word '" + "searchWord" + "' occured '" + "%d" + "' times in the file %s.";

}
