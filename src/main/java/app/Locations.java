package app;

public enum Locations {
    CENTER(0),BOTTOM(1),TOP(2);

    private final int codigo;

    Locations(int c) {
        this.codigo = c;
    }

    public static Locations escolherLocalizacao(int c){
        for (Locations locations : Locations.values()) {
            if (c == locations.codigo) {
                return locations;
            }
        }
        throw new IllegalArgumentException();
    }
}
