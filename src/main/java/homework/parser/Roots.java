package homework.parser;

public enum Roots {
    SUFFERING("^[Сс]трада(.*)");

    private final String pattern;

    private Roots(String pattern) {
        this.pattern = pattern;
    }

    public String pattern() {
        return pattern;
    }
}
