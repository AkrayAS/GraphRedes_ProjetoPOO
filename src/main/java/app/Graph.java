package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements Serializable {
    //Atributos Gerais de Graph/Subgraph
    private String label;
    private String labelloc;
    private int labelFsize;
    private String style;
    private String color;
    //Nos e Subgraphs que compoem um graph
    private ArrayList<No> nos = new ArrayList<>();
    private ArrayList<Graph> subgraphs = new ArrayList<>();
    //Atributos Gerais de todos os nós e arcos.
    private String nodeShape;
    private String labellocNode;
    private int labelFsizeNode;
    private String nodeColor;
    private String edgeColor;

    public Graph() { }

    public Graph(String label) {
        this.label = label;
    }

    public Graph(String label, String labelloc) {
        this.label = label;
        this.labelloc = labelloc;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public void setLabelloc(int c) {
        Locations labelloc = Locations.escolherLocalizacao(c);

        switch (labelloc) {
            case TOP:
                this.labelloc = "t";
            case BOTTOM:
                this.labelloc = "b";
            case CENTER:
                this.labelloc = "c";
        }
    }

    public void setLabelFsize(int labelFsize) {
        if(labelFsize <= 14){
            this.labelFsize = labelFsize;
        } else this.labelFsize = 10;
    }

    public void setStyle(int c) {
        Styles s = Styles.escolherEstilo(c);
        switch (s) {
            case BOLD:
                this.style = "bold";
            case SOLID:
                this.style = "solid";
            case DOTTED:
                this.style = "dotted";
            case FILLED:
                this.style = "filled";
            default:
                this.style = null;
        }
    }

    public void setColor(int c) {
        Colors cor = Colors.escolherCor(c);
        switch (cor) {
            case RED:
                this.color = "red";
            case BLUE:
                this.color = "blue";
            case BLACK:
                this.color = "black";
            case GREEN:
                this.color = "green";
            case WHITE:
                this.color = "white";
            case YELLOW:
                this.color = "yellow";
            default:
                this.color = null;
        }
    }

    public void setNodeShape(int c) {
        Shapes s = Shapes.escolherForma(c);
        switch (s) {
            case BOX:
                this.nodeShape = "box";
            case NONE:
                this.nodeShape = "none";
            case OVAL:
                this.nodeShape = "oval";
            case TRIANGLE:
                this.nodeShape = "triangle";
            default:
                this.nodeShape = null;
        }
    }

    public void setLabellocNode(int c) {
        Locations labelloc = Locations.escolherLocalizacao(c);

        switch (labelloc) {
            case TOP:
                this.labellocNode = "t";
            case BOTTOM:
                this.labellocNode = "b";
            case CENTER:
                this.labellocNode = "c";
        }
    }

    public void setLabelFsizeNode(int labelFsizeNode) {
        if(labelFsizeNode <= 14) {
            this.labelFsizeNode = labelFsizeNode;
        } else this.labelFsizeNode = 10;
    }

    public void setNodeColor(int c) {
        Colors cor = Colors.escolherCor(c);
        switch (cor) {
            case RED:
                this.nodeColor = "red";
            case BLUE:
                this.nodeColor = "blue";
            case BLACK:
                this.nodeColor = "black";
            case GREEN:
                this.nodeColor = "green";
            case WHITE:
                this.nodeColor = "white";
            case YELLOW:
                this.nodeColor = "yellow";
            default:
                this.nodeColor = null;
        }
    }

    public void setEdgeColor(int c) {
        Colors cor = Colors.escolherCor(c);
        switch (cor) {
            case RED:
                this.edgeColor = "red";
            case BLUE:
                this.edgeColor = "blue";
            case BLACK:
                this.edgeColor = "black";
            case GREEN:
                this.edgeColor = "green";
            case WHITE:
                this.edgeColor = "white";
            case YELLOW:
                this.edgeColor = "yellow";
            default:
                this.edgeColor = null;
        }
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
                aux.desassociar();
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

    public boolean propriedadesNo(String noID, int fsize, int c) {
        if(this.existe(noID)) {
            for (No n : this.nos) {
                if(n.getNomeNo().equals(noID)) {
                    n.setLabelFsizenode(fsize);
                    n.setLabellocNode(c);
                    return true;
                }
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
        return pai.adicionarFilha(filha);
    }

    public boolean associacar(String paiNoID, String filhaNoID, String label) {
        if (existeSubgraph(label)) {
            for (Graph graph : subgraphs) {
                if(graph.getLabel().equals(label)) {
                    return graph.associacar(paiNoID, filhaNoID);
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
            if(this.labelloc != null) stringBuilder.append("  ").append("labelloc = ").append(this.labelloc).append("\n");
            if(this.labelFsize != 0) stringBuilder.append("  ").append("fontsize = ").append(this.labelFsize).append("\n");
            if(this.style != null) stringBuilder.append("  ").append("style = ").append(this.style).append(";").append("\n");
            if(this.color != null) stringBuilder.append("  ").append("bgcolor = ").append(this.color).append(";").append("\n");
            stringBuilder.append("\n");
        }
        if(this.nodeShape != null || this.nodeColor != null || this.labelFsizeNode != 0 || this.labellocNode != null ) {
            stringBuilder.append("  ").append("node [");
            if(this.nodeShape != null){
                stringBuilder.append("shape=").append(this.nodeShape);
                if(this.nodeColor != null || this.labelFsizeNode != 0 || this.labellocNode != null) stringBuilder.append(" ");
            }
            if(this.nodeColor != null) {
                stringBuilder.append("color=").append(this.nodeColor);
                if(this.labelFsizeNode != 0 || this.labellocNode != null) stringBuilder.append(" ");
            }
            if(this.labelFsizeNode != 0) {
                stringBuilder.append("fontsize = ").append(this.labelFsizeNode);
                if(this.labellocNode != null) stringBuilder.append(" ");
            }
            if(this.labellocNode != null) stringBuilder.append("labelloc = ").append(this.labellocNode);
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
            if(no.getLabel() != null || no.getLabellocNode() != null || no.getLabelFsizenode() != 0 || no.getImagens() != null) {
                stringBuilder.append("  ").append(no.getNomeNo()).append("  [");
                if (no.getLabel() != null) {
                    stringBuilder.append("label = ").append("\"").append(no.getLabel()).append("\"");
                    if(no.getLabellocNode() != null || no.getLabelFsizenode() != 0 || no.getImagens() != null) stringBuilder.append(" ");
                }
                if(no.getImagens() != null) {
                    stringBuilder.append("image = ").append("\"").append(no.getImagens()).append("\"");
                    if(no.getLabellocNode() != null || no.getLabelFsizenode() != 0) stringBuilder.append(" ");
                }
                if (no.getLabelFsizenode() > 0) {
                    stringBuilder.append("fontsize = ").append(no.getLabelFsizenode());
                    if(no.getLabellocNode() != null)stringBuilder.append(" ");
                }
                if (no.getLabellocNode() != null) {
                    stringBuilder.append("labelloc = ").append("\"").append(no.getLabellocNode()).append("\"");
                }
                stringBuilder.append("]").append("\n");
            }
        }
        if (subgraphs.size() > 0) {
            for (Graph graph : this.subgraphs) {
                for (No no : graph.nos) {
                    if (no.getLabel() != null || no.getLabellocNode() != null || no.getLabelFsizenode() != 0 ) {
                        stringBuilder.append("  ").append(no.getNomeNo()).append("  [");
                        if (no.getLabel() != null) {
                            stringBuilder.append("label = ").append("\"").append(no.getLabel()).append("\"");
                            if(no.getLabellocNode() != null || no.getLabelFsizenode() != 0) stringBuilder.append(" ");
                        }
                        if (no.getLabelFsizenode() > 0) {
                            stringBuilder.append("fontsize = ").append(no.getLabelFsizenode());
                            if(no.getLabellocNode() != null)stringBuilder.append(" ");
                        }
                        if (no.getLabellocNode() != null) {
                            stringBuilder.append("labelloc = ").append("\"").append(no.getLabellocNode()).append("\"");
                        }
                        stringBuilder.append("]").append("\n");
                    }
                }
            }
        }
        stringBuilder.append("\n");
        for (No no : this.nos) {
            if(no.existemFilhas()) {
                ArrayList<No> aux = no.getFilhas();
                for (No filha : aux) {
                    stringBuilder.append("  ").append(no.getNomeNo()).append(" -- ").append(filha.getNomeNo()).append("\n");
                }
            } else stringBuilder.append("  ").append(no.getNomeNo()).append("\n");
        }
        if(subgraphs.size() > 0) {
            for (Graph graph : this.subgraphs) {
                stringBuilder.append("\n");
                stringBuilder.append("  subgraph cluster_").append(graph.getLabel()).append("{").append("\n");
                if(graph.label != null) {
                    stringBuilder.append("    ").append("label = ").append("\"").append(graph.label).append("\"").append("\n");
                    if(graph.labelloc != null) stringBuilder.append("    ").append("labelloc = ").append(graph.labelloc).append("\n");
                    if(graph.labelFsize != 0) stringBuilder.append("    ").append("fontsize = ").append(graph.labelFsize).append("\n");
                    if(graph.style != null) stringBuilder.append("    ").append("style = ").append(graph.style).append(";").append("\n");
                    if(graph.color != null) stringBuilder.append("    ").append("bgcolor = ").append(graph.color).append(";").append("\n");
                    stringBuilder.append("\n");
                }
                for (No no : graph.nos) {
                    if(no.existemFilhas()) {
                        ArrayList<No> aux = no.getFilhas();
                        for (No filha : aux) {
                            stringBuilder.append("    ").append(no.getNomeNo()).append(" -- ").append(filha.getNomeNo()).append("\n");
                        }
                    } else stringBuilder.append("    ").append(no.getNomeNo()).append("\n");
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

    public ArrayList<No> getNos() {
        return nos;
    }

    public ArrayList<Graph> getSubgraphs() {
        return subgraphs;
    }
}
