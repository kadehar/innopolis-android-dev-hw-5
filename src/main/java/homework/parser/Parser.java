package homework.parser;

import java.io.File;
import java.util.ArrayList;

public interface Parser<T> {
    ArrayList<T> parse(File file);
}
