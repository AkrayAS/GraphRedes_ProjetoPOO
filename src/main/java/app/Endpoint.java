package app;

import java.util.ArrayList;

public class Endpoint extends No{
    private String imagem;

    public Endpoint(String nome) {
        super(nome);
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
