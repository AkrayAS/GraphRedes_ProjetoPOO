package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements Serializable {
    private String label;
    private String labelloc;
    private ArrayList<No> nos = new ArrayList<>();
    private ArrayList<Graph> subgraphs = new ArrayList<>();
    private String nodeShape;
    private String nodeColor;
    private String edgeColor;

    public Graph(String label) {
        this.label = label;
    }

    public Graph(String label, String labelloc) {
        this.label = label;
        this.labelloc = labelloc;
    }

    public Graph(String label, String labelloc, String nodeShape) {
        this.label = label;
        this.labelloc = labelloc;
        this.nodeShape = nodeShape;
    }

    public Graph(String label, String labelloc, String nodeShape, String nodeColor) {
        this.label = label;
        this.labelloc = labelloc;
        this.nodeShape = nodeShape;
        this.nodeColor = nodeColor;
    }

    public Graph(String label, String labelloc, String nShape, String nColor, String eColor) {
        this.label = label;
        this.labelloc = labelloc;
        this.nodeShape = nShape;
        this.nodeColor = nColor;
        this.edgeColor = eColor;
    }

    public void adicionarPropriedadesGerais(String labelloc) {
        this.labelloc = labelloc;
    }

    public void adicionarPropriedadesGerais(String labelloc, String nShape) {
        this.labelloc = labelloc;
        this.nodeShape = nShape;
    }

    public void adicionarPropriedadesGerais(String labelloc, String nShape, String nColor){
        this.labelloc = labelloc;
        this.nodeShape = nShape;
        this.nodeColor = nColor;
    }

    public void adicionarPropriedadesGerais(String labelloc, String nShape, String nColor, String eColor) {
        this.labelloc = labelloc;
        this.nodeShape = nShape;
        this.nodeColor = nColor;
        this.edgeColor = eColor;
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
        if(this.label != null) {
            stringBuilder.append("  ").append("label = ").append("\"").append(this.label).append("\"").append("\n");
            if(this.labelloc != null) stringBuilder.append("  ").append("labelloc = ").append("\"").append(this.labelloc).append("\"").append("\n");
            stringBuilder.append("\n");
        }
        if(this.nodeShape != null || this.nodeColor != null) {
            stringBuilder.append("  ").append("node [");
            if(this.nodeShape != null){
                stringBuilder.append("shape=").append(this.nodeShape);
                if(this.nodeColor != null) stringBuilder.append(" ");
            }
            if(this.nodeColor != null) stringBuilder.append("color=").append(this.nodeColor);
            stringBuilder.append("]").append("\n");
        }
        if(this.edgeColor != null) {
            stringBuilder.append("  ").append("edge [");
            if(this.edgeColor != null) {
                stringBuilder.append("color=").append(this.edgeColor);
            }
            stringBuilder.append("]").append("\n");
        }
        stringBuilder.append("\n");
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
