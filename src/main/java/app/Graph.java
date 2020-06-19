package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements Serializable {
    private String label;
    private ArrayList<No> nos;

    public Graph(String label) {
        this.label = label;
        this.nos = new ArrayList<>();
    }

    public boolean CriarNo(String nome) {
        if (this.nos.size() > 0) {
            for (No no : nos) {
                if (!no.NoExiste(nome)) {
                    No novo = new No(nome);
                    this.nos.add(novo);
                    return true;
                }
            }
        } else {
            No novo = new No(nome);
            this.nos.add(novo);
            return true;
        }
        return false;
    }

    public boolean DeletarNo(String nome) {
        for (No no : this.nos) {
            if (no.verificarAssociacao(nome)) no.removerAssociacao(nome);
        }
        Iterator<No> noIterator = this.nos.iterator();
        while (noIterator.hasNext()) {
            No no = noIterator.next();
            if (nome.equalsIgnoreCase(no.getNomeNo())) {
                noIterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean ModificarNo(String nome, String novoNome) {
        for (No no : this.nos) {
            if (!novoNome.equalsIgnoreCase(no.getNomeNo())) {
                if (nome.equalsIgnoreCase(no.getNomeNo())) {
                    no.setNomeNo(novoNome);
                    return true;
                }
            } else return false;
        }
        return false;
    }

    public boolean novaAssociacao(String nome, String associacao) {
        for (No no : this.nos) {
            if (nome.equalsIgnoreCase(no.getNomeNo())) {
                if (!no.verificarAssociacao(associacao)) {
                    no.associacarNos(associacao);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("graph {" + "\n" );
        for (No no : this.nos) {
            ArrayList<String> aux = no.getAssociacao();
            for (String str : aux) {
                stringBuilder.append("  ").append(no.getNomeNo()).append(" -- ").append(str).append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
