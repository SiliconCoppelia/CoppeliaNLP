/*  import json jar files
    https://www.ewdna.com/2008/10/jsonjar.html

    read write json file
    https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
*/

import Learn.*;
import Generation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    private static final int n = 2;
    private static String[] values = new String[n];

    public static void main(String[] args) {

        CoppeliaLearn learn = new CoppeliaLearn(n);
        learn.readCorpus();
        // Step 1: Sentence Segmentation
        learn.sentenceSegmentation();

        // Step 2: Tokenization
        List<String> tokens = new ArrayList<>();
        learn.stringTokenizers(tokens);

        // Step 3: Create Dictionary (Map) for N-Gram
        Map<String, List<String>> NGrams = new HashMap<>();
        List<String> values = new ArrayList<>();
        //learn.createDic(NGrams, values, tokens);

        CoppeliaResponse response = new CoppeliaResponse(n);
    }



}
