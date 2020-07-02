package app;

public enum Styles {
    SOLID("solid"),BOLD("bold"),FILLED("filled"),DOTTED("dotted");

    private final String codigo;

    Styles(String c){
        this.codigo = c;
    }

    public static String escolherEstilo(String c){
        for (Styles style : Styles.values()) {
            if (c == style.codigo) {
                return style.codigo;
            }
        }
        throw new IllegalArgumentException();
    }
}
