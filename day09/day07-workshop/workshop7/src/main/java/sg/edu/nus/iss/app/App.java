package sg.edu.nus.iss.app;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        /*if (args[0].equals("kill")) {
            System.exit(0);
        }*/
    

     List<Employee> employees = getEmployees();
        System.out.println(employees);

        threadExecutorExample();
        threadExample();
        UnreadExample();

        // sort  Array
        public static void example01() {
            String arr[] = {"practice", "workshop", "lecture", "revision"};

            Arrays.sort(arr);
            System.out.println("Ascending sorted array:", + Arrays.toString(arr));

            Arrays.sort(arr, Collections.reverseOrder());
            System.out.println("Descending sorted array:" + Arrays.toString(arr));
            
        }

        //  sort Map
        public  static void sortMap() {
            Map<String, Integer> mapList = new HashMap<>();
            mapList.put("sushi", 5 );
            mapList.put("bread", 4);
            mapList.put("milk", 2);
            mapList.put("cookies", 8);
            mapList.put("candy", 7);
            
            mapList.forEach((k, v) -> {
                System.out.println(k +">>>"+ v);
            });

            List<Entry<String, Integer>> list = new ArrayList<>(mapList.entrySet());  
            list.sort(Entry.comparingByValue());
            list.forEach(System.out::println);

        }


    
        // Run a thread without ExecutorService, use Thread 
        public  static void threadExample() {
            MyRunnableImplementation c1 = new MyRunnableImplementation("Task1");
            MyRunnableImplementation c2 = new MyRunnableImplementation("Task2");
            MyRunnableImplementation c3 = new MyRunnableImplementation("Task3");
            MyRunnableImplementation c4 = new MyRunnableImplementation("Task4");
            
            Thread t1 = new Thread(c1);
            t1.start();
            Thread t2 = new Thread(c2);
            t2.start();
            Thread t3 = new Thread(c3);
            t3.start();
            Thread t4 = new Thread(c4);
            t4.start();

        }
        

        // Execute a thread without any function
        new Thread(
            () -> {
                for (int i = 0; i < 5; i++){
                    System.out.println(i);
                }
            }
            i.start();
        )


          

       
    }

    // Run a thread with ExecutorService
    public static void executorExample() {
        MyRunnableImplementation c1 = new MyRunnableImplementation("Task1");
        MyRunnableImplementation c2 = new MyRunnableImplementation("Task2");
        MyRunnableImplementation c3 = new MyRunnableImplementation("Task3");
        MyRunnableImplementation c4 = new MyRunnableImplementation("Task4");
        MyRunnableImplementation  c5 = new MyRunnableImplementation("Task5");
        
        // Can constrain the thread number
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(c1);
        es.execute(c2);
        es.execute(c3);
        es.execute(c4);
        es.execute(c5);
        es.shutdown();
                }
        
        

      // Stack Example
      public  static void stackExample() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 5; i++) {
Integer item = stack.pop();
System.out.println("Pop >>>" + item);

Integer peek = stack.peek();
System.out.println("Peek last element >>>" + peek);

Integer firstElement = stack.firstElement();
System.out.println("Peek first element in stack >>>" + firstElement);

Iterator<Integer> iterator = stack.iterator();
while (iterator.hasNext()) {
Integer stackItem = iterator.next();
System.out.println("Iterate through stack >>>" + stackItem);
}
        }
        
    }

     // LinkedList example
     public  static void linkedListExample() {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(2,"E");

        System.out.println(list);

        list.remove("C");
        System.out.println(list.peekFirst());


        list.removeFirst();
        System.out.println(list);

    }



    public static void streamFilterSortExample(List<Employee> employees) {
        //  stream and filter
     List<Employee> filterEmployee = employees.stream()
     .filter(e -> e.getLastName().equalsIgnoreCase("o"))
     .collect(Collectors.toList());
     System.out.println(filterEmployee);
     

     Employee emp = employees.stream().filter(e -> e.getLastName().equalsIgnoreCase("lo")).findFirst().get();
     System.out.println(emp);

    

    // sort by firstName in ascending order
    employees.sort(Comparator.comparing(e -> e.getFirstName()));
    System.out.println(employees);


    // sort by firstName in descending order
    Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
    employees.sort(comparator.reversed());
    System.out.println(employees);

    List<Integer> integers = Arrays.asList(3,8,12,6,9);
    integers.sort(Comparator.naturalOrder());
    System.out.println(integers);
     }   


    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee(0, "Long", "long", 18));
        employees.add(new Employee(1, "Pi", "pi", 30));
        employees.add(new Employee(2, "Yo", "yo", 60));
        employees.add(new Employee(3, "Ro", "ro", 40));
        employees.add(new Employee(4, "Vo", "vo", 50));
        employees.add(new Employee(5, "Lo", "lo", 30));
        employees.add(new Employee(6, "Ci", "ci", 44));

        return employees;
    }

}
