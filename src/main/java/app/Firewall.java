package app;

public class Firewall extends No {
    private String imagem;

    public Firewall(String nome) {
        super(nome);
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 2;
    }
}
