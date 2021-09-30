package homework;

import homework.parser.BufferedParser;
import homework.parser.Roots;
import homework.parser.ScannerParser;
import homework.table.MultiplicationTable;
import homework.util.WordsCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        MultiplicationTable table = new MultiplicationTable();
        System.out.println("With for loop");
        table.simple();
        System.out.println("With IntStream");
        table.complex();

        File file = new File("src/main/resources/voyna.txt");
        ScannerParser scannerParser = new ScannerParser();
        ArrayList<String> scannerList = scannerParser.parse(file);
        BufferedParser bufferedParser = new BufferedParser();
        ArrayList<String> bufferedList = bufferedParser.parse(file);

        WordsCounter counter = new WordsCounter();
        counter.count("Using Scanner class",
                scannerList, Roots.SUFFERING.pattern());
        counter.count("Using BufferedReader class",
                bufferedList, Roots.SUFFERING.pattern());
    }
}
