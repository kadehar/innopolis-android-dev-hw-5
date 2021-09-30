package homework.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Converter {
    public HashMap<String, Long> toMap(ArrayList<String> list, String filter) {
        return list.stream()
                .filter(str -> str.matches(filter))
                .collect(groupingBy(
                        Function.identity(),
                        HashMap::new,
                        counting()));
    }

    public ArrayList<String> toList(ArrayList<String> list) {
        ArrayList<String> words = new ArrayList<>();
        list.forEach(str -> {
            words.addAll(Arrays.asList(str.split("[^а-яА-Я]+")));
        });
        return words;
    }
}
