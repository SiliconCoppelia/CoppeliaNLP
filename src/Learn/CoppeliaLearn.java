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
    private static int n;

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

    public Map<String, List<String>> createDic(Map<String, List<String>> NGrams, List<String> values, List<String> tokens){
        /* Reference:
            https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java
            https://stackoverflow.com/questions/4956844/hashmap-with-multiple-values-under-the-same-key

        for(int i = 0; i < tokens.size() - this.n; i++){
            if(tokens.get(i) != "#END#"){
                for(int j = 1; j <= this.n; j++){
                    if(tokens.get(i + j) == "#END#"){ break; }
                    else{ values.add(tokens.get(i + j)); }
                }
                NGrams.put(tokens.get(i), values);
            }
        }*/
        for(int i = 0; i < 12 - this.n; i++){
            if(!tokens.get(i).equals("#END#")){
                for(int j = 1; j <= this.n; j++){
                    if(tokens.get(i + j).equals("#END#")){ break; }
                    else{ values.add(tokens.get(i + j)); }
                }
                NGrams.put(tokens.get(i), values);
                System.out.println(NGrams);
            }
            values.clear();
        }
        return NGrams;
    }
}
