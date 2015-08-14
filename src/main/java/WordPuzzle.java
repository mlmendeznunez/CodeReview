// let me use stuff from Sparky, HashMap on this web page
import static spark.Spark.*;
import java.io.*;
import java.lang.*;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.lang.System;

// match the filename & to build.gradle
public class WordPuzzle {

    public static void main(String[] args) {
        // serves files from Resources/public
        //staticFileLocation("/Public");
        String layout = "templates/layout.vtl";

    // // serves a page from template/layout.vtl
    get("/", (request, response) -> 
        {
            System.out.println("I hope this is working!");

            HashMap<String, Object> replacements = new HashMap<String, Object>();

            // this is the list of things we want to swap out in the page
            // look in the page for $title, $template, etc. to swap out for what is on the 
            // right side ("", ____)
            replacements.put("title", "Word Puzzle Builder");

            // when they use #parse ($template)  it puts another file in that spot
            replacements.put("template", "Template/homepage.vtl");
        
            // put it all together, starting from layout.vtl with our replacements
            return new ModelAndView(replacements, "Template/Layout.vtl");
        }, new VelocityTemplateEngine());

    // looks for localhost:4567/detector and then runs
    get("/detector", (request, response) -> 
        {
            System.out.println("I am trying hard! ");

            HashMap<String, Object> replacements = new HashMap<String, Object>();
            // a different "sub"page, detector
            replacements.put("template", "Template/detector.vtl");

            //  in the URL sent back
            //String inputString = request.queryParams("WordPuzzle"); //Input from webpage, goes to isPuzzle
            String inputString = request.queryParams("WordPuzzle"); //Input from webpage, goes to isPuzzle
            String finalString = isPuzzle(inputString); 

            //Input string entered into WordPuzzle & goes to method isPuzzle below

            replacements.put("results", finalString);
            //replacements.put("title", "Word Puzzle");
            //balance returned from isPuzzle & sent to webpage
            //results on webpage will be swapped out for finalString from WordPuzzle.java

            return new ModelAndView(replacements, "Template/Layout.vtl");
        }, new VelocityTemplateEngine());
    
    }
    public static String isPuzzle(String inputString) {
        //String [] wordsString;  
        //Char [] charArray;
        //String [] modifiedString;
        //String finalString;

        char letterA ='a', letterE = 'e', letterI ='i', letterO ='o', letterU ='u', dash = '-'; 

        //Taking the inputString and making it into a String array
        //Each word becomes a separate array item creating an array composed of words
        
        //wordsString = inputString.split(" "); 


        //The array composed of words is further broken down
        //Making it into a character array
        //char[] charArray = wordsString.toCharArray();
        //char charArray[] = wordsString.toCharArray( );
        char charArray[] = inputString.toCharArray(); 

        //replacing vowels in the character array with dash simbols
        for ( Integer i = 0; i < charArray.length; i++)  {
            //System.out.println(i+"");
            if (charArray[i] == letterA){
                charArray[i] = dash;
            }
            else if (charArray[i] == letterE) {
                charArray[i] = dash;
            }
            else if (charArray[i] == letterI) {
                charArray[i] = dash;
            }
            else if (charArray[i] == letterO) {
                charArray[i] = dash;
            }
            else if (charArray [i] == letterU) {
                charArray[i] = dash;
            }
            else {
            }
        }
        //Transforming from character array back to a single string

        //String modifiedString = charArray.toString; 
        //String finalString = String[].join(",", modifiedString); ERROR MESS
        //String finalString = modifiedString.join(",");
        
        //String finalString = charArray.toString();

        String finalString = String.valueOf(charArray); 

        System.out.println("Returning a modified string");
        
        return finalString; 
    }
}
