package core.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMethods {

    public static void main(String[] args) {

        int[] intArray=new int[]{3,8,29,54,7,18,5};
        String[] stringArray= new String[]{"John","Dave","Steve","Eleven","Jack"};

        /**
         * Arrays class has different methods to perform operations
         * Arrays works on primitive plus Object arrays
         * Arrays can't directly work on collections but provide some bridge methods as below
         * Arrays.asList() and List.toArray() as part of your workflow.
         * Also Arrays.stream(array) to get stream
         */

        /**
         * Arrays don't have any reverse method
         */

        System.out.println("----------********------------------");
        System.out.println("Sorting using Arrays.sort()");
        Arrays.sort(intArray);
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
        System.out.println("----------********------------------");

        /**
         * For binary search we need sorted array
         */
        System.out.println("----------********------------------");
        System.out.println("Binary search using Arrays.sort()");
        int index1= Arrays.binarySearch(intArray,29);
        int index2=  Arrays.binarySearch(stringArray,"Eleven");
        int index3= Arrays.binarySearch(stringArray,"Reynolds");

        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println("equals method to compare with other array");
        int[] a1= new int[]{1,2,3,4,5};
        int[] a2= new int[]{1,2,3,4,5};
        int[] a3= new int[]{1,2,3,4,};
        System.out.println(Arrays.equals(a1,a2));
        System.out.println(Arrays.equals(a1,a3));
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println(" copyOf() methods to creating copy elements of specified length");
        int[] c1= Arrays.copyOf(a1,3);
        int[] c2=Arrays.copyOf(a1,7);
        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println(" copyOfRange() methods to creating copy elements withing range");
        // from is included and to is excluded for ranged
        int[] c3= Arrays.copyOfRange(a1,2,4);
        int[] c4=Arrays.copyOfRange(a1,3,7);
        System.out.println(Arrays.toString(c3));
        System.out.println(Arrays.toString(c4));
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println("fill() Assigns the specified value to each element of the specified array.");
         int[] f=new int[5];
         Arrays.fill(f,2);
        System.out.println(Arrays.toString(f));
        System.out.println("----------********------------------");

        /**
         * Note: Arrays.asList() method does not work directly with primitive arrays like int[]
         */
        System.out.println("----------********------------------");
        System.out.println("asList ->  Converts the specified array into a fixed-size List");
        List<String> l= Arrays.asList(stringArray);
        System.out.println(l);
        System.out.println("----------********------------------");


        System.out.println("----------********------------------");
        System.out.println("deepEquals() Returns true if the two specified arrays are deeply equal. It works for multidimensional arrays as well.");
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2}, {3, 4}};
        boolean isDeepEqual = Arrays.deepEquals(arr1, arr2);
        boolean equal = Arrays.equals(arr1, arr2);
        System.out.println("using deepEquals method :"+isDeepEqual);
        System.out.println("using equals method :"+equal);
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println("deepToString ->  a string representation of a multidimensional array.");
        System.out.println("2D Array using deepToString :"+Arrays.deepToString(arr1));
        System.out.println("2D Array using toString :"+Arrays.toString(arr1));
        System.out.println("----------********------------------");

        System.out.println("----------********------------------");
        System.out.println(" setAll() Sets all elements of the array using a generator function that applies the function to the index.");
        System.out.println("intArray before setAll"+Arrays.toString(intArray));
        Arrays.setAll(intArray,i->intArray[i]*2);
        System.out.println("intArray after setAll"+Arrays.toString(intArray));
        System.out.println("----------********------------------");
    }
}
