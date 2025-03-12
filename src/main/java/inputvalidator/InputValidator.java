package inputvalidator;

import constants.wordtraceconstants.WordTraceConstants;

import java.io.File;

/**
 * This class provides methods for validating input arguments.It ensures correct argument count, file existence and valid file types
 */
public class InputValidator {
    /**
     * Validates that exactly two arguments are provided
     *
     * @param args
     * @return
     */
    public String validateArguments(String[] args) {
        if (args.length < 2) {
            return WordTraceConstants.ERROR_INSUFFICIENT_ARGUMENTS;
        } else if (args.length > 2) {
            return WordTraceConstants.ERROR_MORE_ARGUMENTS;
        }
        return "";
    }

    /**
     * validates that the provided file path exists and is a valid file
     *
     * @param inputFilePath
     * @return
     */
    public String validateFileExistence(String inputFilePath) {
        File file = new File(inputFilePath);
        if (!file.exists() || !file.isFile()) {
            return WordTraceConstants.ERROR_INVALID_FILE;
        }
        return "";
    }

    /**
     * Validates that the file has an accepted extension (.txt or .json)
     *
     * @param inputFilePath
     * @return
     */
    public String validateFileType(String inputFilePath) {
        if (!inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_TXT) && !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_JSON)) {
            return WordTraceConstants.INVALID_FILE_TYPE;
        }
        return "";
    }

    /**
     * validates all input arguments and returns an error message if any validation fails
     *
     * @param args
     * @return
     */
    public String validateInputs(String[] args) {
        String message;
        message = validateArguments(args);
        if (!message.isEmpty()) return message;
        message = validateFileExistence(args[0]);
        if (!message.isEmpty()) return message;
        message = validateFileType(args[0]);
        if (!message.isEmpty()) return message;
        return "";
    }
}
