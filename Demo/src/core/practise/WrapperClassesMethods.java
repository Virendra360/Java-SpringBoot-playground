package core.practise;

public class WrapperClassesMethods {

    public static void main(String[] args) {

        /**
         * valueOf() method is used to convert a primitive or a String into its corresponding wrapper object.
         */
        System.out.println("--------********-------------");

        Integer i= Integer.valueOf(5);
        Double d = Double.valueOf("45.67");
        System.out.println(d);
        System.out.println(i);

        try{
             Integer.valueOf("s");
        }catch (NumberFormatException e){
            System.out.println("Invalid conversion :"+e);
        }
        System.out.println("--------********-------------");

        /**
         * parseXxx() methods convert a String to a primitive type.
         */
        System.out.println("--------********-------------");
        int pr= Integer.parseInt("5");
        System.out.println(pr);
        double dr=  Double.parseDouble("45.23");
        System.out.println(dr);
        System.out.println("--------********-------------");

        /**
         *  toString() method converts a wrapper object or primitive type into a String.
         */
        System.out.println("--------********-------------");
        String s1= Integer.toString(3445);
        String s2 = Boolean.toString(Boolean.TRUE);
        System.out.println(s1);
        System.out.println(s2);
        Integer pr2= 34;
        String s3= pr2.toString();
        System.out.println(s3);
        System.out.println("--------********-------------");

        /**
         * xxxValue() Methods like intValue,
         * These methods return the value of a wrapper object as its corresponding primitive type.
         */
        System.out.println("--------********-------------");
        Integer intwr= 77;
        Double doubwr= 35.90;
        int intpr= intwr.intValue();
        double doubpr= doubwr.doubleValue();
        System.out.println(intpr);
        System.out.println(doubpr);
        System.out.println("--------********-------------");

        /**
         * compare() Method
         * This method compares two values (either primitives or wrapper objects).
         * returns 0 if equal , + value if x>y and - if x<y
         */
        System.out.println("--------********-------------");
        int r1= Integer.compare(5,6);
        int r2= Integer.compare(8,6);
        int r3 =Double.compare(23.45,23.45);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println("--------********-------------");

        /**
         * equals() method compares two wrapper objects for equality.
         */
        System.out.println("--------********-------------");
        Integer num= 7;
        boolean res=num.equals(Integer.valueOf(7));
        System.out.println(res);
        System.out.println("--------********-------------");

        /**
         * compareTo() method is used to compare two wrapper objects.
         * It returns a negative number if the object is less than the specified object,
         * 0 if equal, and a positive number if greater.
         * Diff in compare vs compareTo() is that compare is static method of Wrapper Classes and compareTo is on object of Wrapper class
         */
        System.out.println("--------********-------------");
        Integer num1 = 10;
        Integer num2 = 20;
        int res2=num1.compareTo(num2);
        System.out.println(res2);
        System.out.println("--------********-------------");

        /**
         * Constants :
         * Integer.MAX_VALUE: Represents the largest possible value for an int, which is 2^31-1
         *  Double.MAX_VALUE: Represents the largest possible value for a double
         *  Integer.MIN_VALUE: Represents the smallest possible value for an int, which is -2^31
         *  Double.MIN_VALUE: Represents the smallest positive value for a double, not the most negative number.
         */

        /**
         * Helper Methods:
         *  isXxx() methods are part of the Character class and are used to check certain properties of characters
         *  , such as whether a character is a digit, letter, uppercase, or lowercase, isLetterOrDigit
         */
        System.out.println("--------********-------------");
        char ch = '5';
        char ch2 = 's';
        System.out.println(Character.isDigit(ch));
        System.out.println(Character.isLetter(ch2));
        System.out.println(Character.isUpperCase(ch2));
        System.out.println(Character.isLowerCase(ch2));
//        Character.isLetterOrDigit(ch);
        System.out.println("--------********-------------");

        /**
         * toXxxCase() Methods
         * These methods are also part of the Character class and convert characters to uppercase or lowercase.
         */
        System.out.println("--------********-------------");
        char ch3 = 'a';
        char ch4 = 'D';
        System.out.println(Character.toLowerCase(ch4));
        System.out.println(Character.toUpperCase(ch3));
        System.out.println("--------********-------------");

    }
}

