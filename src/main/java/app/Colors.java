package app;

public enum Colors {
    BLACK(0), RED(1), GREEN(2), YELLOW(3),
    BLUE(4), WHITE(5);

    private final int codigo;

    Colors(int c) {
        this.codigo = c;
    }

    public static Colors escolherCor(int c) {
        for (Colors cor : Colors.values()) {
            if (c == cor.codigo) {
                return cor;
            }
        }
        throw new IllegalArgumentException();
    }
}

