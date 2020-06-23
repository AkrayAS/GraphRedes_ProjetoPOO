package app;

import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private String nomeNo;
    private ArrayList<No> filhas = new ArrayList<>();

    public No(String nome) {
        this.nomeNo = nome;
    }

    public void setNomeNo(String no) {
        this.nomeNo = no;
    }

    public String getNomeNo() {
        return nomeNo;
    }

    public boolean adicionarFilha(No filha) {
        if(filha == null) {
            return false;
        } else {
            this.filhas.add(filha);
            return true;
        }
    }

    public boolean removeFilha(String noID) {
        Iterator<No> filha = filhas.iterator();
        while (filha.hasNext()) {
            No no = filha.next();
            if(no.getNomeNo().equals(noID)) {
                filha.remove();
                return true;
            }
        }
        return false;
    }

    public boolean atualizaFilha(String noID, String novoID) {
        Iterator<No> filha = filhas.iterator();
        while (filha.hasNext()) {
            No no = filha.next();
            if(no.getNomeNo().equals(noID)) {
                no.setNomeNo(novoID);
                return true;
            }
        }
        return false;
    }

    public boolean existeFilha(String noID) {
        for (No n : filhas) {
            if (n.getNomeNo().equals(noID)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<No> getFilhas() {
        return filhas;
    }
}
