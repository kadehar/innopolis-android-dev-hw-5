package homework.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class WordsCounter {
    private final Converter converter = new Converter();

    public void count(ArrayList<String> list, String root) {
        ArrayList<String> words = converter.toList(list);
        HashMap<String, Long> frequencyMap = converter.toMap(words, root);
        AtomicLong count = new AtomicLong();

        frequencyMap
                .entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getValue()
                        .compareTo(o1.getValue())))
                .forEach(k -> {
                    if (k.getKey().matches(root)) {
                        System.out.printf("%s = %d %n", k.getKey(), k.getValue());
                        count.getAndAdd(k.getValue());
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
