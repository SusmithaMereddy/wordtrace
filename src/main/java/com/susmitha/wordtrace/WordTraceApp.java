package com.susmitha.wordtrace;
import java.io.File;
public class WordTraceApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(WordTraceConstants.Error_InsufficientArguments);
            return;
        }
        else if(args.length > 2){
            System.out.println(WordTraceConstants.Error_MoreArguments);
            return;
        }
        String inputFilePath = args[0];
        String searchWord = args[1];
        System.out.println(WordTraceConstants.Message_InputFilePath+" : " +inputFilePath);
        System.out.println(WordTraceConstants.Message_SearchWord+ " : "+searchWord);
        File file = new File(inputFilePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println(WordTraceConstants.Error_InvalidFile);
            return;
        }
        if (!inputFilePath.endsWith(WordTraceConstants.File_Extension_txt) && !inputFilePath.endsWith(WordTraceConstants.File_Extension_json)) {
            System.out.println(WordTraceConstants.Error_InvalidFileType);
            return;
        }
        System.out.println(WordTraceConstants.Message_FilePathCorrect);
        System.out.println(WordTraceConstants.Message_Searching+" "+ searchWord);
        System.out.println(WordTraceConstants.Message_Processing);
    }
}