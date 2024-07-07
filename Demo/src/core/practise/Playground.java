package core.practise;

import java.net.Inet4Address;
import java.util.*;

public class Playground {

    public static void main(String[] args){

        /**
         *  HashTable
         *  It is synchronized
         *  no null allowed
         */

        Hashtable hs= new Hashtable();

        hs.put(12,"viren");
        hs.put(10,"John");
        hs.put(15,"pranav");
//        hs.put(null,"rayn");

        System.out.println(hs);

        /**
         *  TreeMap
         */

//        TreeMap tm= new TreeMap();
//
//        tm.put(10,"viren");
//        tm.put(11,"ashish");
//        tm.put(15,"John");
//        tm.put(12,"pranay");
//        tm.put(null,"rayn");   // null not allowed

//        System.out.println(tm.headMap(12));
//        System.out.println(tm.tailMap(12));

//        System.out.println(tm.firstEntry());
//        System.out.println(tm.lastEntry());

//        System.out.println( tm.ceilingEntry(14));
//        System.out.println(tm.ceilingEntry(16));
//        System.out.println(tm.ceilingKey(14));
//
//        System.out.println(tm.floorEntry(11));
//        System.out.println(tm.floorEntry(8));
//
//        System.out.println(tm.higherEntry(12));
//        System.out.println(tm.lowerEntry(12));

//        System.out.println(tm);

        /**
         * HashMap
         */

//        HashMap hm= new HashMap();
//        HashMap<Integer,String> hm= new HashMap();

//        hm.put(101,"viren");
//        hm.put(234,"John");
//        hm.put(125,"Pranav");
//        hm.put(105,"Sonu");
//        hm.put(234,"Sohan");
//        hm.put(null,15);

//        System.out.println( hm.remove(134));
//        System.out.println(hm.replace(234,"pranav"));

//        System.out.println(hm.containsKey(234));
//        System.out.println(hm.containsValue("paranav"));

//        System.out.println(hm.get(125));
//        System.out.println(hm.get(134));

        // Retrieval
//        1. directly needs generic declare Map
//        for(Map.Entry entry : hm.entrySet()){
//            System.out.println(entry.getKey()+"->"+entry.getValue());
//        }

        // 2. using set and iterator
//        Set s= hm.entrySet();
//        System.out.println(s);
//        Iterator itr= s.iterator();
//
//        while(itr.hasNext()){
//            Map.Entry entry= (Map.Entry) itr.next();
//            System.out.println(entry);
//            System.out.println(entry.getKey()+" -> "+entry.getValue());
//        }

        // 3. using keySet
//        for(Object key: hm.keySet() ){
//            System.out.println(key+" -> "+hm.get(key));
//        }

        // 4. directly values
//        for(Object value: hm.values()){
//            System.out.println(value);
//        }

        // 5. after java 8 we got forEach loop
//        hm.forEach((key,value) ->{
//            System.out.println(key+" -> "+value);
//        });

//        System.out.println(hm);

        /**
         * Map Interface, doesn't extend Collection Interface
         * but it also part of Collection of Collection Framework
         */

//        Map m= new HashMap();
//
//        m.put(10,"rahul");
//        m.put(12,"viren");
//        m.put(14,"pranay");
//        m.put(10,"John");  // duplicates not allowed, it replaces value
//        m.put("abc",16);
//        m.put(null,"abc"); // only on null key allowed, values can null multiple times

//        System.out.println(m.remove(12));
//        System.out.println(m.replace(null,null));

//        System.out.println(m.containsValue("viren"));
//        System.out.println(m.containsValue(11));

//        System.out.println( m.containsKey(14));
//        System.out.println( m.containsKey("189"));

//        System.out.println( m.get(null));

//        System.out.println(m);

        /**
         * TreeSet
         */

//        TreeSet ts= new TreeSet();
//
//        ts.add(40);
//        ts.add(60);
//        ts.add(20);
//        ts.add(50);
//        ts.add("viren");  // not allowed as TreeSet is Homogeneous

//        ts.clear();

//        ts.remove(50);

//        Iterator itr= ts.descendingIterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        System.out.println(ts);

        /**
         * HashSet
         */

//        HashSet hs= new HashSet();
//
//        hs.add(10);
//        hs.add("viren");
//        hs.add(14);
//
//        System.out.println(hs.add("deepak"));
//        System.out.println(hs.add(10));
//
//        System.out.println(hs);
//
//        System.out.println(hs.remove("viren"));
//        System.out.println(hs.remove("abc"));
//
//        Iterator itr= hs.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
//
//        System.out.println("Empty :"+ hs.isEmpty());
//        hs.clear();
//        System.out.println(hs);

        /**
         * Stack
         */
//         Stack s= new Stack();
//
//         s.push(10);
//         s.push(15);
//         s.push("viren");
//         s.push(18);

//         s.remove(0);

//        System.out.println(s.peek());
//        System.out.println(s.pop());

//        System.out.println(s);

//        System.out.println(s.empty());
//        System.out.println(s.search("viren"));
//        System.out.println(s.search(20));
//        System.out.println(s.search(18));
//        System.out.println(s.search(10));


        /**
         *  Vector
         */

//        Vector v= new Vector();
//        v.addElement(13);
//        v.insertElementAt(14,1);
//        v.addElement("viren");
//        v.addElement(15);
//
//        System.out.println(v);
//
//        v.removeAllElements();
//        System.out.println(v);

//        System.out.println(v.removeElement("viren"));
//        v.removeElementAt(1);
//
//        System.out.println(v);

//        System.out.println(v.firstElement());
//        System.out.println(v.lastElement());
//
//        System.out.println(v);


        /**
         * LinkedList
         */

//        LinkedList ll= new LinkedList();
//        ll.addFirst(10);
//        ll.addLast("vaibhav");
//
//        System.out.println(ll.getFirst());
//        System.out.println(ll.getLast());
//
//        System.out.println(ll);
//        System.out.println(ll.removeFirst());
//        System.out.println(ll.removeLast());
//        System.out.println(ll);

        /**
         * ArrayList
         */

//        ArrayList arr1= new ArrayList();
//        arr1.add(10);
//        arr1.add("viren");
//        arr1.add(20);
//        arr1.add(40);
//        arr1.add(10);
//        arr1.add(null);
//        arr1.add(null);

//        arr1.add(1,15);

//       ArrayList arr2= new ArrayList();
//       arr2.add(10);
//       arr2.add(20);
//       arr2.add("John");

//       arr1.addAll(arr2);
//       arr1.addAll(2,arr2);

//        System.out.println("Is present :"+arr1.contains(10));
//        System.out.println("Is present :"+arr1.containsAll(arr2));

//        arr1.remove(1);
//        arr1.remove(Integer.valueOf(10));

//        arr1.removeAll(arr2);

//        arr1.set(1,15);

//        System.out.println("Element at index 2 :"+arr1.get(2));

//        arr1.clear();

//        Iterator itr = arr1.iterator();
//        while(itr.hasNext()){
//            System.out.print(itr.next()+" ");
//        }System.out.println("");

//        ListIterator listItr = arr1.listIterator();
//
//        while(listItr.hasNext()){
//            System.out.print(listItr.next()+" ");
//        }System.out.println("");
//
//        while(listItr.hasPrevious()){
//            System.out.print(listItr.previous()+" ");
//        }System.out.println("");

//        System.out.println("Index of 30 :"+arr1.indexOf(30));

//        System.out.println(arr1);


        /**
         * Enumeration cursor
         * use only with legacy classes like Vector, Stack
         * No add, remove, set methods just read
         * Only forward direction
         */
//        Vector<Integer> l= new Vector<>();
//        l.add(2);
//        l.add(5);
//        l.add(6);
//        l.add(9);
//
//        Enumeration<Integer> e= l.elements();
//
//        while(e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }


        /**
         * ListIterator Demo
         */

//        List<Integer> l= new ArrayList<>();
//        l.add(2);
//        l.add(5);
//        l.add(6);
//        l.add(9);
//

//        System.out.println(l);
//        System.out.println("____________________________________");
//
//        ListIterator<Integer> listItr= l.listIterator();
//
//        while(listItr.hasNext()){
//            listItr.next();
//        }
//
//        listItr.add(12);
//        listItr.add(15);
//
//        while(listItr.hasPrevious()){
//            Integer ele= listItr.previous();
//            if(ele.equals(5))
//                listItr.remove();
//            else if(ele%2 !=0)
//                listItr.set(-1);
//        }
//        System.out.println(l);
//        System.out.println("____________________________________");

        /**
         * Iterator Demo
         */

//        System.out.println(l);
//        System.out.println("____________________________________");
//
//        Iterator itr= l.iterator();
//
//        while(itr.hasNext()){
//           Object element= itr.next();
//             if((Integer) element %2 !=0)
//                 itr.remove();
//        }
//
//        System.out.println(l);
//        System.out.println("____________________________________");

    }

}
