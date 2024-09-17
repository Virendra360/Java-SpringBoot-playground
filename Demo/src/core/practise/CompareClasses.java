package core.practise;

import java.util.*;

class Emp implements Comparable<Emp>{

    String name;
    int empId;
    String dept;

    public Emp() {
    }

    public Emp(String name, int empId, String dept) {
        this.name = name;
        this.empId = empId;
        this.dept = dept;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", dept='" + dept + '\'' +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        return this.empId-o.empId;
    }
}

class empNameComparator implements Comparator<Emp>{

    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


public class CompareClasses {
    public static void main(String[] args) {
        /**
         * For any collections in Java to sort we have Collections.sort(list);
         * But for that class of that object should have implemented Comparable or else use Collections.sort(list, comparator implementation class object )
         * Java provides two Interface for Object comparison
         *
         * 1. Comparable
         * -> Need to be implemented by Class which wants comparison
         * -> Provide int compareTo(T o) method where need to write logic of comparison
         *
         * 2. Comparator
         * -> For Comparator we don't write comparison logic in class on which object we perform sort
         * -> Comparator is used to provide dynamic comparison implementation at sort
         * -> On same class object collection we can sort according diff logic which is not possible in Comparable impl
         */

        List<Emp> list= Arrays.asList(new Emp("John",24432,"EDD")
                                   ,new Emp("Rayon",2354,"OPS")
                                   ,new Emp("Steve",24497,"BLOCKCHAIN") );

        /**
         * By default use comparable impl if present
         */
//        Collections.sort(list);

        /**
         *  provide dynamic logic of comparison using
         *  1. comparator class
         *  2. lambda expression
         */
//        Collections.sort(list,new empNameComparator());
//        Collections.sort(list,(a,b)->a.getName().compareTo(b.getName()));

        System.out.println(list);

    }
}
