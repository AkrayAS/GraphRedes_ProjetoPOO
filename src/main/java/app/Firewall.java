package app;

public class Firewall extends No {
    public Firewall(String nome) {
        super(nome);
    }

    @Override
    public void setImagens(int c) {
        Imagens imagens = Imagens.escolherImagem(c);
        this.imagens = "img/firewall.png";
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes >= 2;
    }
}
