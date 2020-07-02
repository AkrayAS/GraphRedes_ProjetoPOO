package app;

public enum Colors {
    BLACK("black"), RED("red"), GREEN("green"), YELLOW("yellow"),
    BLUE("blue"), WHITE("white");

    private final String codigo;

    Colors(String c) {
        this.codigo = c;
    }

    public static String escolherCor(String c) {
        for (Colors cor : Colors.values()) {
            if (c == cor.codigo) {
                return cor.codigo;
            }
        }
        throw new IllegalArgumentException();
    }
}

