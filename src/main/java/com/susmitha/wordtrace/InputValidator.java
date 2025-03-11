package com.susmitha.wordtrace;
import com.susmitha.wordtraceconstants.WordTraceConstants;
import java.io.File;
public class InputValidator {
    public static String validateInputs(String[] args){
        if (args.length < 2) {
            return WordTraceConstants.ERROR_INSUFFICIENT_ARGUMENTS;
        }
        else if(args.length>2){
            return WordTraceConstants.ERROR_MORE_ARGUMENTS;
        }
        String inputFilePath=args[0];
        File file = new File(inputFilePath);
        if (!file.exists() || !file.isFile()) {
            return WordTraceConstants.ERROR_INVALID_FILE;
        }
        if (!inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_TXT) && !inputFilePath.endsWith(WordTraceConstants.FILE_EXTENSION_JSON)) {
            System.out.println("Invalid file type. Only " + WordTraceConstants.FILE_EXTENSION_TXT + " and " + WordTraceConstants.FILE_EXTENSION_JSON + " are allowed");
            return "Invalid file type. Only " + WordTraceConstants.FILE_EXTENSION_TXT + " and "  + WordTraceConstants.FILE_EXTENSION_JSON + " are allowed";
        }
        return "";
    }
}
