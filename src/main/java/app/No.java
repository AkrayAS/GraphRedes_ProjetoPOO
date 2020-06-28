package app;

import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private String nomeNo;
    private String label;
    private ArrayList<No> filhas = new ArrayList<>();
    //Atributos especificos de cada no
    private int labelFsizenode;
    private String labellocNode;

    public No(String nome) {
        this.nomeNo = nome;
    }

    public void setNomeNo(String no) {
        this.nomeNo = no;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelFsizenode() {
        return labelFsizenode;
    }

    public void setLabelFsizenode(int labelFsizenode) {
        if(labelFsizenode < 14) {
            this.labelFsizenode = labelFsizenode;
        } else this.labelFsizenode = 10;
    }

    public String getLabellocNode() {
        return labellocNode;
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

    public boolean existemFilhas() {
        return this.filhas.size() > 0;
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
