package Learn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CoppeliaLearn {

    private static String corpus = null;
    private static String[] splitString;
    private int n;

    public CoppeliaLearn(int n){
        this.n = n;
    }

    public static void readCorpus() {
        Path fileName = Path.of("corpus.txt");
        try {
            corpus = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(corpus);
        // Reference: https://www.geeksforgeeks.org/java-program-to-read-a-file-to-string/

        /*
        // Reference: https://www.interviewsansar.com/how-to-print-arraylist-elements-in-java/
        for (int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i));
        }*/
    }

    public static String[] sentenceSegmentation(){
        String delimiter = "[.?!]";
        splitString = (corpus.split(delimiter));
        for (int i = 0; i < splitString.length; i++){
            splitString[i] = splitString[i] + " #END#";
        }
        return splitString;
    }

    public static List<String> stringTokenizers(List<String> tokens) {
        // Reference: https://www.baeldung.com/java-stringtokenizer
        for (int i = 0; i < splitString.length; i++){
            StringTokenizer tokenizer = new StringTokenizer(splitString[i], " ");
            while (tokenizer.hasMoreElements()) {
                tokens.add(tokenizer.nextToken());
            }
        }
        return tokens;
    }

    public static Map<String, List<String>> createDic(Map<String, List<String>> NGrams, List<String> values, List<String> tokens){
        return NGrams;
    }
}
