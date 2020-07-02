package app;

public enum Shapes {
    NONE("none"), BOX("box"), OVAL("oval"), TRIANGLE("triangle");

    private final String codigo;

    Shapes(String c){
        this.codigo = c;
    }

    public static String escolherForma(String c){
        for (Shapes shape : Shapes.values()) {
            if (c == shape.codigo) {
                return shape.codigo;
            }
        }
        throw new IllegalArgumentException();
    }
}
