package app;

public class Switch extends No{
    private String imagem;

    public Switch(String nome) { super(nome); }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 1;
    }
}
