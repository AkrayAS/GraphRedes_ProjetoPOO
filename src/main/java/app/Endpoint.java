package app;

import java.util.ArrayList;

public class Endpoint extends No{

    public Endpoint(String nome) {
        super(nome);
    }

    @Override
    public void setImagens(int c) {
        Imagens imagens = Imagens.escolherImagem(c);
        if(imagens.equals(Imagens.RACK)) this.imagens = "img/rack-server.png";
        if(imagens.equals(Imagens.CAMERA)) this.imagens = "img/ip-camera.png";
        if(imagens.equals(Imagens.SERVER)) this.imagens = "img/network-server-generic.png";
        if(imagens.equals(Imagens.DESKTOP)) this.imagens = "img/desktop.png";
    }

    @Override
    public boolean adicionarFilha(No filha) {
        return false;
    }

    @Override
    public boolean verificarAssociacoes() {
        return this.associacoes == 1;
    }
}
