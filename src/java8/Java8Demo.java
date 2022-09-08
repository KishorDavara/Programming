package java8;

import java.util.*;
import java.util.stream.Collectors;


public class Java8Demo {
    public static void main(String[] args) {
        iterateList();
        iterateMap();
        optionalAndNullableDemo();
        convertListOfObjectsToMap();
    }

    // Different Ways to Iterate List
    private static void iterateList() {
        List<String> elements = new ArrayList<>();
        elements.add("element1");
        elements.add("element2");
        elements.add("element3");
        elements.add("element4");
        elements.add("element3");

        // Using Iterator
        System.out.println("Print using Iterator Approach::");
        Iterator<String> iterator = elements.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }

        // Using foreach method
        System.out.println("\n\nPrint using foreach method::");
        for(String element: elements) {
            System.out.print(element+" ");
        }

        // Using forEach lamda function
        System.out.println("\n\nPrint using forEach lambda function::");
        elements.forEach(element -> System.out.print(element+" "));

        // Using Method reference
        System.out.println("\n\nPrint using method reference::");
        elements.stream().forEach(System.out::print);

        // Using stream and filter
        System.out.println("\n\nPrint only if element3 is present::");
        elements
                .stream()
                .filter(element -> element.contains("element3"))
                .forEach(System.out::println);

        // Convert elements into uppercase
        System.out.println("\n\n Convert elements into uppercase and print it");
        elements
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // Different Ways to Iterate Map
    private static void iterateMap() {
        Map<Integer,String> students = new HashMap<>();
        students.put(1,"Kishor");
        students.put(2,"Harsh");
        students.put(3,"Mayur");
        students.put(4,"Sharad");

        // Using EntrySet Approach
        System.out.println("Print using entrySet Approach::");
        for(Map.Entry<Integer,String> entry : students.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        // Using KeySet Approach
        System.out.println("\n\nPrint using keySet Approach::");
        for(Integer key : students.keySet()) {
            System.out.println(key+" "+students.get(key));
        }

        // Using Lambda Function Approach
        System.out.println("\n\nPrint using lambda function Approach::");
        students.forEach((key,value) -> System.out.println(key+" "+ value));

        // Using Stream API
        System.out.println("\n\nPrint using stream API Approach::");
        students.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
    }

    private static void optionalAndNullableDemo() {
        List<Notes> notes = new ArrayList<>();
        notes.add(new Notes(1,"note1"));
        notes.add(new Notes(4,"note4"));
        notes.add(new Notes(2,"note2"));
        notes.add(new Notes(5,"note5"));
        notes.add(new Notes(3,"note3"));

        // Check if list is not empty using Optional and if not null iterate through it and print it
        Optional.ofNullable(notes)
                .orElseGet(Collections::emptyList)
                .stream()
                .forEach(System.out::println);

        // sort notes using id
        System.out.println("\n\n Sort notes using id");
        notes.stream().sorted((note1,note2) -> note1.getId() - note2.getId()).forEach(System.out::println);

        System.out.println();
        //Better way to do the same thing is using Comparator.comparingInt
        notes.stream().sorted(Comparator.comparingInt(Notes::getId)).forEach(System.out::println);
    }

    //Convert list of objects to map by handling duplicate keys
    private static void convertListOfObjectsToMap() {
        List<Notes> notes = new ArrayList<>();
        notes.add(new Notes(1,"note1"));
        notes.add(new Notes(2,"note2"));
        notes.add(new Notes(3,"note3"));
        notes.add(new Notes(4,"note4"));
        notes.add(new Notes(5,"note5"));
        notes.add(new Notes(6,"note3"));


        // this will take the old value "3" for the key "note3"
        System.out.println("Take the old value into consideration for duplicate keys(i.e, note3=3)::");
        Map<String,Integer> map = notes
                .stream()
                .collect(               //keyMapper    valueMapper   mergeFunction
                        Collectors.toMap(Notes::getName,Notes::getId, (oldValue, newValue) -> oldValue)
                );
        System.out.println(map);

        // this will take the new value "6" for the key "note3"
        System.out.println("Take the new value into consideration for duplicate keys(i.e, note3=6)::");
        map = notes
                .stream()
                .collect(                //keyMapper    valueMapper   mergeFunction
                        Collectors.toMap(Notes::getName,Notes::getId, (oldValue, newValue) -> newValue)
                );
        System.out.println(map);

        // store the result in sorted order, after converting list to map and handling duplicate keys
        System.out.println("Convert list to map in the sorted order::");
        map = notes
                .stream()
                .sorted(Comparator.comparing(Notes::getName))
                .collect(Collectors.toMap(
                        Notes::getName,Notes::getId,(oldValue,newValue)->newValue,
                        LinkedHashMap::new // for maintaining the insertion order
                        )
                );
        System.out.println(map);
    }

    static class Notes {
        private int id;
        private String name;

        Notes(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Notes{" +
                    "id=" + id +
                    ", name=" + name +
                    '}';
        }
    }

}
