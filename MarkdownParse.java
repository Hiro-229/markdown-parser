//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        System.out.println(currentIndex);
        while(currentIndex < markdown.length()) {

            //System.out.println("length of file: " + markdown.length());

            int openBracket = markdown.indexOf("[", currentIndex);
            //System.out.println("openBracket: " + openBracket);

            int closeBracket = markdown.indexOf("]", openBracket);
            //System.out.println("closeBracket: " + closeBracket);

            int lastOpenParen = markdown.indexOf("(", closeBracket);
            //System.out.println("openParen: " + openParen);

            int lastCloseParen = markdown.indexOf(")", lastOpenParen);
            //System.out.println("closeParen: " +closeParen);

            int nextLinkOpenBracket = markdown.indexOf("[", lastOpenParen);
            
            if(nextLinkOpenBracket == -1){
                lastCloseParen = markdown.length() - 1;
                toReturn.add(markdown.substring(lastOpenParen + 1, lastCloseParen));
                break;
            }else{
                lastCloseParen = markdown.lastIndexOf(")", nextLinkOpenBracket);
                toReturn.add(markdown.substring(lastOpenParen  + 1, lastCloseParen));
                currentIndex = lastCloseParen + 1;
                
            }
        }
       return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}