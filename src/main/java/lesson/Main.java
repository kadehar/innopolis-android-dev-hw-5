package lesson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, TestSubject> hashMap = new HashMap<>();
        String selected = "";

        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            hashMap.put(subject.getId(), subject);
            if (i == 27) {
                selected = subject.getId();
            }
        }

        System.out.println(hashMap.get(selected));
        check(hashMap.get(selected).getId(), selected);

        TreeMap<Integer, TestSubject> treeMap =
                new TreeMap<>(new TestComparator());
        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            treeMap.put(subject.getOrdinal(), subject);
        }
        System.out.println(treeMap.lastEntry());

        Parser parser = new Parser();
        File file = new File("src/main/resources/voyna.txt");
        ArrayList<String> list = parser.parse(file);
        System.out.println(list.get(0));
    }

    private static void check(String... ids) {
        if (ids[0].equals(ids[1])) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
