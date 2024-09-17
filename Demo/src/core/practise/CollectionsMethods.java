package core.practise;

import java.text.CollationElementIterator;
import java.util.*;

public class CollectionsMethods {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Alice", "Bob");

        /**
         * Collections class provide variety of methods
         */

        /**
         * Collections.sort(Collection) sort using standard nature of Class
         * Collections.sort(Collection,comparator) sort using custom logic
         */
        System.out.println("--------********-------------");
//        Collections.sort(names);
//        System.out.println(names);
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
        System.out.println("--------********-------------");

        /**
         * binarySearch(collection,key) for natural sorted collection
         * binarySearch(collection,key,comparator) for comparator sorted collection
         */
        System.out.println("--------********-------------");
//        int index1= Collections.binarySearch(names,"Alice");
//        System.out.println(index1);
          int index2 = Collections.binarySearch(names,"Bob",Comparator.reverseOrder());
        System.out.println(index2);
        System.out.println("--------********-------------");

        /**
         * shuffle(collection) -> Randomly permutes the elements of the list.
         */
        System.out.println("--------********-------------");
        Collections.shuffle(names);
        System.out.println(names);
        System.out.println("--------********-------------");

        /**
         * reverse(List<?> list) - Reverses the order of elements in the list.
         */
        System.out.println("--------********-------------");
        System.out.println("Before reverse :"+names);
        Collections.reverse(names);
        System.out.println("After reverse :"+names);
        System.out.println("--------********-------------");

        /**
         * min(collection) / min(collection,comparator)
         * max(collection) / max(collection,comparator)
         */
        System.out.println("--------********-------------");
        String min= Collections.min(names);
        String max = Collections.max(names);
        System.out.println(min);
        System.out.println(max);
        System.out.println("--------********-------------");

        /**
         * frequency() -> gives no of occurrence
         */
        System.out.println("--------********-------------");
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
        int cnt= Collections.frequency(items,"apple");
        int cnt2= Collections.frequency(items,"mango");
        System.out.println(cnt);
        System.out.println(cnt2);
        System.out.println("--------********-------------");

        /**
         * disjoint(Collection<?> c1, Collection<?> c2) - Returns true if the two collections have no elements in common.
         */
        System.out.println("--------********-------------");
        List<String> list1 = Arrays.asList("apple", "banana");
        boolean disjoint= Collections.disjoint(names,items);
        boolean disjoint2= Collections.disjoint(list1,items);
        System.out.println(disjoint);
        System.out.println(disjoint2);
        System.out.println("--------********-------------");

        /**
         * addAll -> add all specified elements to given list
         * replaceAll -> replace all occurrence of old element with new element to replace
         */
        System.out.println("--------********-------------");
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana","apple"));
        System.out.println("fruits before addAll call :"+fruits);
        Collections.addAll(fruits,"mango","cherry");
        System.out.println("fruits after addAll call :"+fruits);
        Collections.replaceAll(fruits,"apple","watermelon");
        System.out.println("fruits after replace all :"+fruits);
        System.out.println("--------********-------------");

    }
}
