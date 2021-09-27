package homework.table;

import java.util.stream.IntStream;

public class MultiplicationTable {
    public void simple() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d ", j * i);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void complex() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            IntStream.rangeClosed(1, 10)
                    .forEach(j -> System.out.print(i * j + " "));
            System.out.println();
        });
        System.out.println();
    }
}
