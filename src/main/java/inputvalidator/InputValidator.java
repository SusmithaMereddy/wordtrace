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
    boolean validateArguments(String[] args) {
        if (args.length < 2) {
            System.out.println(WordTraceConstants.ERROR_INSUFFICIENT_ARGUMENTS);
            return false;
        } else if (args.length > 2) {
            System.out.println(WordTraceConstants.ERROR_MORE_ARGUMENTS);
            return false;
        }
        return true;
    }

    /**
     * validates that the provided file path exists and is a valid file
     *
     * @param inputFilePath
     * @return
     */
    boolean validateFileExistence(String inputFilePath) {
        File file = new File(inputFilePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println(WordTraceConstants.ERROR_INVALID_FILE);
            return false;
        }
        return true;
    }

    /**
     * Validates that the file has an accepted extension (.txt or .json)
     *
     * @param inputFilePath
     * @return
     */
    boolean validateFileType(String inputFilePath) {
        if (!inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_TXT) && !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_JSON)) {
            System.out.println(WordTraceConstants.INVALID_FILE_TYPE);
            return false;
        }
        return true;
    }

    /**
     * validates all input arguments and returns an error message if any validation fails
     *
     * @param args
     * @return
     */
    public boolean validateInputs(String[] args) {
        if (!validateArguments(args)) {
            return false;
        }
        if (!validateFileExistence(args[0])) {
            return false;
        }
        return validateFileType(args[0]);
    }
}
