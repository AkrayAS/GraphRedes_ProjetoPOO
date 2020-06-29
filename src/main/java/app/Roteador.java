package app;

public class Roteador extends No{
    private String imagem;

    public Roteador(String nome) {
        super(nome);
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 2;
    }
}
