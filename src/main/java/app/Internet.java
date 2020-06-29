package app;

public class Internet extends No{
    private String imagem;

    public Internet(String nome) {
        super(nome);
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 1;
    }
}
