package app;

public class Internet extends No{
    public Internet(String nome) {
        super(nome);
    }

    @Override
    public void setImagens(int c) {
        this.imagens = "img/cloud.png";
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 1;
    }
}
