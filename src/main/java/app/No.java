package app;

import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private String nomeNo;
    private ArrayList<String> associacao;

    public No(String nome) {
        this.nomeNo = nome;
        this.associacao = new ArrayList<>();
    }

    public No(String nome, ArrayList<String> associacao) {
        this.nomeNo = nome;
        this.associacao = associacao;
    }

    public boolean associacarNos(String outroNo) {
        for (String str : associacao) {
            if (! str.equalsIgnoreCase(outroNo)) {
                this.associacao.add(outroNo);
                return true;
            }
        }
        return false;
    }

    public boolean verificarAssociacao(String no) {
        for (String str : associacao) {
            if (! str.equalsIgnoreCase(no)) return true;
        }
        return false;
    }

    public void removerAssociacao(String outroNo) {
        associacao.removeIf(str -> str.equalsIgnoreCase(outroNo));
    }

    public boolean NoExiste(String nome) {
        return this.nomeNo.equalsIgnoreCase(nome);
    }

    public String getNomeNo() {
        return nomeNo;
    }

    public void setNomeNo(String nomeNo) {
        this.nomeNo = nomeNo;
    }

    public ArrayList<String> getAssociacao() {
        return associacao;
    }
}
