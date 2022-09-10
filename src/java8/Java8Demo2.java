package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
public class Java8Demo2 {
    public static void main(String[] args) {
        convertPrimitiveArrayToList();
        sortArrayOfPrimitiveTypesInDescendingOrder();
        concateStringUsingSeparator();
        countElementsOccurencesInArray();
        mapVsFlatMap();
    }

    // map returns one value for each input element whereas flatMap returns zero or more values for each input element
    private static void mapVsFlatMap() {
        //map demo
        System.out.println("----map demo----");
        List<String> fruits = Arrays.asList("Mango","Orange","Banana","Watermelon");
        System.out.println("List of fruits: "+fruits);
        List<Integer> mapList = fruits.stream()
                .map(fruit -> fruit.length())
                .collect(Collectors.toList());
        System.out.println("List generated after performing map operation: "+ mapList);

        // flatMap demo
        System.out.println("\n----flatMap demo----");
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1,2,3));
        numbers.add(Arrays.asList(4,5));
        numbers.add(Arrays.asList(6,7,8));
        numbers.add(Arrays.asList(9,10));
        System.out.println("List of numbers: "+ numbers);

        List<Integer> flapMapList = numbers.stream()
                .flatMap(number -> number.stream())
                .collect(Collectors.toList());
        System.out.println("List of numbers generated after performing flatMap operation: "+ flapMapList);
    }

    private static void convertPrimitiveArrayToList() {
        int[] a = new int[]{1, 2, 3, 4};

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        // 2nd approach is to use IntStream with boxed
        //list = IntStream.of(a).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    private static void sortArrayOfPrimitiveTypesInDescendingOrder() {
        int array[] = new int[]{20, 5, 30, 2, 56};
        array = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder()) //Collections.reverseOrder() is also fine to use here
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void concateStringUsingSeparator() {
        List<String> list = Arrays.asList("Welcome", "to the", "Java8 Learning Journey");
        String joinedString = list.stream()
                .collect(Collectors.joining("$$"));
        System.out.println(joinedString);
    }

    private static void countElementsOccurencesInArray() {
        List<String> word = Arrays.asList("AA", "BB", "AA", "CC", "BB", "AA");
        Map<String, Long> wordCount =
                word.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(), // this will return the current input value
                                Collectors.counting())
                        );
        System.out.println(wordCount);

        //find the duplicate elements by count
        wordCount = word.stream()
                .filter(w -> Collections.frequency(word, w) > 2)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(wordCount);
    }

    /* Collectors.groupingBy example:
    The following will classify Person objects by city:
    Map<String, List<Person>> peopleByCity
            = personStream.collect(Collectors.groupingBy(Person::getCity));

    The following will classify Person objects by state and city, cascading two Collectors together:
    Map<String, Map<String, List<Person>>> peopleByStateAndCity
            = personStream.collect(Collectors.groupingBy(Person::getState,
            Collectors.groupingBy(Person::getCity)));
    */
}
