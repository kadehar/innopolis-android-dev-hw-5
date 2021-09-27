package lesson;

import java.io.*;
import java.util.ArrayList;

public class Parser {
    public ArrayList<String> parse(File file) {
        ArrayList<String> strings = new ArrayList<>();
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                strings.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
