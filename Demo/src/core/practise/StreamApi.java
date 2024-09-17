package core.practise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class StreamApi {

    public static void main(String[] args) {

        /**
         * Stream API is used for collection of objects, and it different from io stream (which is sequence of data)
         * Stream API reduced code and provide diff methods to get things done at one place
         * Stream is Interface part of java.util.Stream and extends BaseStream Interface part of java.util.stream.BaseStream
         */

         List<Integer> list1= List.of(23353,24474,23877,24444);
         List<String> list2= Arrays.asList("John","Steve","Ray","Jacob");
        /**
         *  list return by List.of or Arrays.asList is immutable, we cannot modify that
         */
//        list1.add(25566);
//        list2.add("Eleven");

        /**
         * Collections in java provide stream() method to get Stream object
         */
        Stream<Integer> stream= list1.stream();

        /**
         * forEach() methods used to iterate over each item in list
         * It need Consumer function, .i.e. function which return void and part of java.util.function.Consumer package
         */

        /**
         *  System.out::println  known as method reference
         *  You can replace a method reference for your lambda expression whenever you just refer to a method with a lambda expression.
         */
//        list2.stream().forEach(i->{System.out.println(i);});
        list2.stream().forEach(System.out::println);

        /**
         *  filter()  method in stream is used to perform filtration logic on stream
         *  It needs Predicate i.e. part of java.util.function package, f
         *  Predicate is function which returns boolean
         */
        List<Integer> res=stream.filter(i->i%2==0).toList();

        /**
         * map() method is used to modify items in list
         * It needs Function i.e. part of java.util.function.Function, to perform ops and return
         */

        /**
         * If we perform any operations on Stream which is used we get IllegalStateException
         * Stream can be pass only one time
         */
//        List<Integer> res2= stream.map(i->i/100).toList();

         List<Integer> res2= list1.stream().map(i->i/100).toList();

        System.out.println(res);
        System.out.println(res2);

        /**
         * sorted()  method used to do sorting on stream
         * By default use given object sorting impl if any
         * Else we need to provide comparator
         */

        List<String> res3= list2.stream().sorted((a,b)->-(a.compareTo(b))).toList();
        System.out.println(res3);

        /**
         *  min() and max() methods needs comparator define comparison logic
         *  returns Optional<T> object
         */

        int max= list1.stream().max((a,b)->a-b).get();
        int min=list1.stream().min((a,b)->a-b).get();

        System.out.println("Min :"+min);
        System.out.println("Max :"+max);

        /**
         * For array, we cant use stream() method directly
         * Need to use Arrays.stream(array) which return IntStream
         * IntStream is part of java.util.stream package, IntStream also extends BaseStream
         */
        int[] array=new int[]{83,59,25,40,98};
        IntStream intStream= Arrays.stream(array);

        /**
         * We don't use comparator for intStream max or min as it takes int normal behavior
         */
        int maxInt= intStream.max().getAsInt();
        System.out.println(maxInt);

        /**
         * sorted() for IntStream provide IntStream, we con convert to array using toArray()
         */
        int[] ll=  Arrays.stream(array).sorted().toArray();
        System.out.println(ll);

        /**
//        The boxed() method works for streams of primitive types, but it is specific to the three primitive streams available in Java:
//
//        IntStream (for int)
//        LongStream (for long)
//        DoubleStream (for double)
//        For these primitive streams, boxed() converts the primitive values to their corresponding wrapper types:
//
//        IntStream → Stream<Integer>
//        LongStream → Stream<Long>
//        DoubleStream → Stream<Double>

         */

        List<Integer> l2=  Arrays.stream(array).sorted().boxed().toList();
        System.out.println(l2);

        /**
         * distinct()
         * Removes duplicate elements from the stream.
         */
        System.out.println("--------********-------------");
        List<Integer> numbers = Arrays.asList( 1,2, 2, 3, 4, 4);
        List<Integer> distinctIntList= numbers.stream().distinct().toList();
        System.out.println(distinctIntList);
        System.out.println("--------********-------------");

        /**
         * reduce()
         * Combines the elements of the stream into a single result by repeatedly applying a binary operator.
         */
        System.out.println("--------********-------------");
        int listSum=numbers.stream().reduce(0,(sum,element)->sum+element);
        System.out.println(listSum);
        System.out.println("--------********-------------");

        /**
         * count()
         * Returns the number of elements in the stream.
         */
        System.out.println("--------********-------------");
        long cnt= numbers.stream().count();
        System.out.println(cnt);
        System.out.println("--------********-------------");

        /**
         *   findFirst() returns the first element of the stream (if available).
         *   findAny() returns any element from the stream, which is useful in parallel streams for efficiency.
         */
        System.out.println("--------********-------------");
         Optional<Integer> firstEle=numbers.stream().findFirst();
         if(firstEle.isPresent())
             System.out.println(firstEle.get());
         Optional<Integer> anyEle=  numbers.stream().findAny();
         if(anyEle.isPresent())
             System.out.println(anyEle.get());
        System.out.println("--------********-------------");

        /**
         * anyMatch() checks if any element matches the predicate.
         * allMatch() checks if all elements match the predicate.
         * noneMatch() checks if no elements match the predicate.
         */
        System.out.println("--------********-------------");
        boolean b1= numbers.stream().anyMatch(i->i%2==0);
        boolean b2= numbers.stream().allMatch(i->i%2==0);
        boolean b3= numbers.stream().noneMatch(i->i<0);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println("--------********-------------");

        /**
         * Comparator.comparing:
         * This method creates a Comparator that compares objects based on a specified key extracted from the objects.
         * thenComparing:
         *
         * This method is used to specify additional comparison criteria.
         * If two objects are equal based on the first comparator, thenComparing is used to break ties.
         */

        // Create a list of Person objects
        List<Person> people = Arrays.asList(
        new Person("Alice", 30),
        new Person("Bob", 25),
        new Person("Charlie", 30),
        new Person("Dave", 20)
    );

    // Sorting by age in ascending order, and by name alphabetically if ages are equal
    List<Person> sortedPeople = people.stream()
            .sorted(Comparator.comparing(Person::getAge)
                    .thenComparing(Person::getName))
            .collect(Collectors.toList());

        System.out.println(sortedPeople);
    }
}
