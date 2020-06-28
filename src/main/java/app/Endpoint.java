package app;

public class Endpoint extends No{
    private String imagem;

    public Endpoint(String nome) {
        super(nome);
    }

    @Override
    public boolean adicionarFilha(No filha) {
        if (super.existemFilhas()) return false;
        else return super.adicionarFilha(filha);
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
