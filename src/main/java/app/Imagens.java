package app;

public enum Imagens {
    ROTEADORazul(0), INTERNET(1), DESKTOP(2), FIREWALL(3), ROTEADORverde(4),
    CAMERA(5), SERVER(6), RACK(7), SWITCH(8);

    private final int codigo;

    Imagens(int c) {
        this.codigo = c;
    }

    public static Imagens escolherImagem(int c){
        for (Imagens imagens : Imagens.values()) {
            if (c == imagens.codigo) {
                return imagens;
            }
        }
        throw new IllegalArgumentException();
    }
}
