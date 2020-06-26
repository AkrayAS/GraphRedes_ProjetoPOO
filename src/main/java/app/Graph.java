package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements Serializable {
    private String label;
    private ArrayList<No> nos = new ArrayList<>();
    private ArrayList<Graph> subgraphs = new ArrayList<>();

    public Graph(String label) {
        this.label = label;
    }

    public boolean adicionarNo(String noID) {
        if(existe(noID)) return false;
        No no = new No(noID);
        nos.add(no);
        return true;
    }

    public boolean adicionarNo(String noID, String subgraph) {
        if(existeSubgraph(subgraph)) {
            for (Graph graph : subgraphs) {
                if(graph.getLabel().equals(subgraph)) return graph.adicionarNo(noID);
            }
        }
        return false;
    }

    public boolean criaSubgraph(String label) {
        if (existeSubgraph(label)) return false;
        Graph graph = new Graph(label);
        subgraphs.add(graph);
        return true;
    }

    public boolean removeNo(String noID) {
        Iterator<No> filhas = nos.iterator();
        while (filhas.hasNext()) {
            No aux = filhas.next();
            if(aux.existeFilha(noID)) aux.removeFilha(noID);
        }
        Iterator<No> iterator = nos.iterator();
        while (iterator.hasNext()) {
            No aux = iterator.next();
            if (aux.getNomeNo().equals(noID)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeSubgraph(String label) {
        Iterator<Graph> graphIterator = subgraphs.iterator();
        while (graphIterator.hasNext()) {
            Graph aux = graphIterator.next();
            if(aux.getLabel().equals(label)) {
                aux.removeNo(label);
                return true;
            }
        }
        return false;
    }

    public boolean atualizaNo(String noID, String novoID) {
        Iterator<No> filhas = nos.iterator();
        while (filhas.hasNext()) {
            No aux = filhas.next();
            if(aux.existeFilha(noID)) aux.atualizaFilha(noID, novoID);
        }
        Iterator<No> iterator = nos.iterator();
        while (iterator.hasNext()) {
            No aux = iterator.next();
            if (aux.getNomeNo().equals(noID)) {
                aux.setNomeNo(novoID);
                return true;
            }
        }
        return false;
    }

    private No getNo(String nodeID) {
        for (No n : nos) {
            if (n.getNomeNo().equals(nodeID)) {
                return n;
            }
        }
        return null;
    }

    public boolean existe(String noID) {
        for (No n : nos) {
            if (n.getNomeNo().equals(noID)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeSubgraph(String label) {
        for (Graph g : subgraphs) {
            if (g.getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }

    public boolean associacar(String paiNoID, String filhaNoID) {
        No pai = getNo(paiNoID);
        if (pai == null || pai.existeFilha(filhaNoID)) {
            return false;
        }
        No filha = getNo(filhaNoID);
        if (filha == null) {
            return false;
        }
        pai.adicionarFilha(filha);
        return true;
    }

    public boolean associacar(String paiNoID, String filhaNoID, String label) {
        if (existeSubgraph(label)) {
            for (Graph graph : subgraphs) {
                if(graph.getLabel().equals(label)) {
                    graph.associacar(paiNoID, filhaNoID);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean associarSubgraph(String paiNoID, String filhaNoID, String label) {
        No pai = getNo(paiNoID);
        if (pai == null || pai.existeFilha(filhaNoID)) {
            return false;
        }
        for (Graph graph : subgraphs) {
            if(graph.getLabel().equals(label)) {
                No filha = graph.getNo(filhaNoID);
                if (filha == null) {
                    return false;
                }
                pai.adicionarFilha(filha);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("graph {" + "\n" );
        for (No no : this.nos) {
            ArrayList<No> aux = no.getFilhas();
            for (No filha : aux) {
                stringBuilder.append("  ").append(no.getNomeNo()).append(" -- ").append(filha.getNomeNo()).append("\n");
            }
        }
        if(subgraphs.size() > 0) {
            for (Graph graph : this.subgraphs) {
                stringBuilder.append("\n");
                stringBuilder.append("  subgraph ").append(graph.getLabel()).append("{").append("\n");
                for (No no : graph.nos) {
                    ArrayList<No> aux = no.getFilhas();
                    for (No filha : aux) {
                        stringBuilder.append("    ").append(no.getNomeNo()).append(" -- ").append(filha.getNomeNo()).append("\n");
                    }
                }
                stringBuilder.append("  }").append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getLabel() {
        return label;
    }
}
