package core.practise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {


    private static boolean validate(String regex, String input){

        /**
         * 2nd direct way
         * return Pattern.matches(regex,input);
         */

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(input);
        return matcher.matches();
    }


    public static void main(String[] args) {

        /**
         * java.util.regex is package in java provide classes to work with regex
         * 1. Pattern class - compile version of regex , every regular expression string must be compiled into instance of this in java
         * Pattern have methods like compile() to compile regex string
         * Then this pattern is used to create Matcher class object
         *
         * 2. Matcher class-is engine which match arbitrary char sequence to interpreting pattern
         *  perform 3 main operations
         *  i. matches() - matches entire input char seq with pattern
         *  ii. lookingAt() -
         *  iii. find() -
         *  Matcher implements MatchResult interface
         *
         *  PatternSyntaxException -  RuntimeException->IllegalArgumentException->PatternSyntaxException
         *  occurs when syntax error in regular expression pattern
         *
         *  PatternResult interface
         */


        while(true){

            System.out.println("Enter regex:");
            Scanner sc=new Scanner(System.in);
            String regex=sc.nextLine();
            System.out.println("Enter input to validate:");
            String input=sc.nextLine();
            System.out.println("Result :"+validate(regex,input));
            System.out.println("Do you want to terminate Y|N");
            String dec=sc.nextLine();
            if("Y".equalsIgnoreCase(dec)){
               break;
            }
        }





    }
}
