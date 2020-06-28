package app;

public enum Shapes {
    NONE(0), BOX(1), OVAL(3), TRIANGLE(4);

    private final int codigo;

    Shapes(int c){
        this.codigo = c;
    }

    public static Shapes escolherForma(int c){
        for (Shapes shape : Shapes.values()) {
            if (c == shape.codigo) {
                return shape;
            }
        }
        throw new IllegalArgumentException();
    }
}
