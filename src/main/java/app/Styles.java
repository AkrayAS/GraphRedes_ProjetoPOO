package app;

public enum Styles {
    SOLID(0),BOLD(1),FILLED(3),DOTTED(4);

    private final int codigo;

    Styles(int c){
        this.codigo = c;
    }

    public static Styles escolherEstilo(int c){
        for (Styles style : Styles.values()) {
            if (c == style.codigo) {
                return style;
            }
        }
        throw new IllegalArgumentException();
    }
}
