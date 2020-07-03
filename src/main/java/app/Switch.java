package app;

public class Switch extends No{
    public Switch(String nome) { super(nome); }

    @Override
    public void setImagens(int c) {
        this.imagens = "img/switch.png";
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 1;
    }
}
