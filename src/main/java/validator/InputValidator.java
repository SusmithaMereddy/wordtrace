package validator;

import constants.wordtraceconstants.WordTraceConstants;

import java.io.File;

/**
 * This class provides methods for validating input arguments.It ensures correct argument count, file existence and valid file types
 */
public class InputValidator {
    /**
     * Validates that exactly two arguments are provided
     *
     * @param args array of input arguments where args[0] is the file path and args[1] is the search word
     * @return
     */
    private boolean hasValidArguments(String[] args) {
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
     * @param inputFilePath stores the path of the file
     * @return true if the file exists and is a normal file
     */
    private boolean doesFileExists(String inputFilePath) {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println(WordTraceConstants.ERROR_INVALID_FILE);
            return false;
        }
        return true;
    }

    /**
     * Validates that the file has an accepted extension (.txt or .json)
     *
     * @param inputFilePath Stores the file path
     * @return true if the file is in the .txt or .json format
     */
    private boolean hasValidFileType(String inputFilePath) {
        if (!inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_TXT) && !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_JSON)) {
            System.out.println(WordTraceConstants.INVALID_FILE_TYPE);
            return false;
        }
        return true;
    }

    /**
     * validates all input arguments and returns an error message if any validation fails
     *
     * @param args The array of input arguments, where args[0] is the file path and args[1] is the word we are searching for
     * @return true if all validations pass
     */
    public boolean validateInputs(String[] args) {
        return hasValidArguments(args) && doesFileExists(args[0]) && hasValidFileType(args[0]);
    }
}
