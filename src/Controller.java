/*  import json jar files
    https://www.ewdna.com/2008/10/jsonjar.html

    read write json file
    https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {

    private static String[] splitString;

    public static void main(String[] args) {
        Path fileName = Path.of("train.txt");
        String trainTexts = null;
        try {
            trainTexts = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(trainTexts);
        // Reference: https://www.geeksforgeeks.org/java-program-to-read-a-file-to-string/

        splitString = sentenceSegmentation(trainTexts);
    }

    private static String[] sentenceSegmentation(String trainTexts){
        String delimiter = "[.?!]";
        return (trainTexts.split(delimiter));
    }

}
