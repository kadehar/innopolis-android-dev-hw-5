package homework.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedParser implements Parser<String> {
    @Override
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
