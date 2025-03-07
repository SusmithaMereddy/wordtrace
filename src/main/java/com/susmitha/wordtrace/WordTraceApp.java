package com.susmitha.wordtrace;
import java.util.Scanner;
import java.io.File;
public class WordTraceApp {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in)

       if(args.length!=2){
           System.out.println(args.length<2 ? "Please provide both the file path and the word to be sedarched ":"Please provide only the file path and the word to be searched");
           return;
       }

       String filePath=args[0];
       String search=args[1];

       File file=new File(filePath);
       if(file.exists() && file.isFile()){
           if(filePath.endsWith(".txt")||filePath.endsWith(".json")) {
               System.out.println("File Path is correct");
               System.out.println("Searching for word ? :" + search);
           }
           else{
               System.out.println("Invalid file type. only .txt and .json files are allowed");
           }
       }
       else{
           System.out.println("File path is incorrect or file doesnot exist");
       }

    }


}

