package homework.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordsCounter {
    private Converter converter = new Converter();

    public void count(ArrayList<String> list, String root) {
        ArrayList<String> words = converter.toList(list);
        HashMap<String, Long> frequencyMap = converter.toMap(words);
        AtomicInteger count = new AtomicInteger();

        frequencyMap
                .entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getValue()
                        .compareTo(o1.getValue())))
                .forEach(k -> {
                    if (k.getKey().contains(root)) {
                        System.out.printf("%s = %d %n", k.getKey(), k.getValue());
                        count.getAndAdd(Math.toIntExact(k.getValue()));
                    }
                });
        System.out.println("TOTAL: " + count);
    }

    public void count(String message, ArrayList<String> list, String root) {
        System.out.println(message);
        count(list, root);
        System.out.println();
    }
}
