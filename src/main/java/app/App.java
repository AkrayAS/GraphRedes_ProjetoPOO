package app;

import jdk.jfr.events.ExceptionThrownEvent;

public class App {
    Graph graph = new Graph();
    Arquivo arquivo = new Arquivo();

    public boolean iniciarPrograma(String label) {
        try {
            graph.setLabel(label);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherCorArco(String c){
        try {
            graph.setEdgeColor(c);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean adicionarNode(String noID) {
        try {
            return graph.adicionarNo(noID);
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarNodeDatagrama(String noID, int c) {
        try {
            return graph.adicionarNo(noID, c);
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarNodeSubGraph(String noID, String nameSubGraph){
        try {
            return graph.adicionarNo(noID, nameSubGraph);
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarNodeSubGraphDatagrama(String noID, int c, String nameSubGraph){
        try {
            return graph.adicionarNo(noID, c ,nameSubGraph);
        } catch (Exception e){
            return false;
        }
    }

    public boolean criarSubGraph(String label) {
        try {
            return graph.criaSubgraph(label);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeNode(String noID){
        try {
            return graph.removeNo(noID);
        } catch (Exception e){
            return false;
        }
    }

    public boolean removeSubGraph(String label) {
        try {
            return graph.removeSubgraph(label);
        } catch (Exception e){
            return false;
        }
    }

    public boolean atualizarNode(String noID, String novoID){
        try {
            return graph.atualizaNo(noID, novoID);
        }catch (Exception e){
            return false;
        }
    }

    public  boolean adicionarPropriedadesGeralNode(String shape,String color, String labelloc, int labelFsizeNode){
        try {
            graph.propriedadesGeraisNode(shape, color, labelloc, labelFsizeNode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean adicinarPropriedadesGraph(String labelloc,int labelFsize) {
        try {
            graph.propriedadesGraph(labelloc, labelFsize);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarPropriedadesSubGraph(String subgraph ,String labelloc, int labelFsize, String style, String color){
        try {
           return graph.propriedadesSubGraph(subgraph, labelloc, labelFsize, style, color);
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarPropriedadesNode(String noID, String label ,int fsize, String c){
        try {
            return graph.propriedadesNo(noID, label ,fsize, c);
        } catch (Exception e){
            return false;
        }
    }

    public boolean adicionarPropriedadesNodeSubGraph(String SubGraph, String noID, String label ,int fsize, String c){
        try {
            return graph.propriedadesNoSubGraph(SubGraph, noID, label, fsize, c);
        }catch (Exception e) {
            return false;
        }
    }

    public boolean associarNodes(String paiNoID, String filhaNoID) {
        try {
            return graph.associacar(paiNoID, filhaNoID);
        } catch (Exception e){
            return false;
        }
    }

    public boolean associarNodesSubGraph(String paiNoID, String filhaNoID, String label) {
        try {
            return graph.associacar(paiNoID, filhaNoID, label);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean associarSubGraph(String paiNoID, String filhaNoID, String label) {
        try {
            return graph.associarSubgraph(paiNoID, filhaNoID, label);
        } catch (Exception e){
            return false;
        }
    }

    public boolean salvarArquivo(String nomeDoArquivo) {
        try {
            for (No no: graph.getNos()) {
                if(no instanceof Endpoint) {
                    if (! no.verificarAssociacoes()) {
                        System.out.println(no.getNomeNo() + " do tipo Endpoint não esta com suas Associações corretas.");
                        return false;
                    }
                }
                if(no instanceof Firewall){
                    if(! no.verificarAssociacoes()) {
                        System.out.println(no.getNomeNo() + " do tipo Firewall não esta com suas Associações corretas.");
                        return false;
                    }
                }
                if(no instanceof Internet) {
                    if(! no.verificarAssociacoes()) {
                        System.out.println(no.getNomeNo() + " do tipo Internet não esta com suas Associações corretas.");
                        return false;
                    }
                }
                if(no instanceof Roteador) {
                    if(! no.verificarAssociacoes()) {
                        System.out.println(no.getNomeNo() + " do tipo Roteador não esta com suas Associações corretas.");
                        return false;
                    }
                }
                if(no instanceof Switch) {
                    if(! no.verificarAssociacoes()){
                        System.out.println(no.getNomeNo() + " do tipo Switch não esta com suas Associações corretas.");
                        return false;
                    }
                }
            }
            for (Graph subgraph : graph.getSubgraphs()) {
                for (No no : subgraph.getNos()) {
                    if(no instanceof Endpoint) {
                        if (! no.verificarAssociacoes()) {
                            System.out.println("No SubGrafo " + subgraph.getLabel()+ " - " + no.getNomeNo() + " do tipo Endpoint não esta com suas Associações corretas.");
                            return false;
                        }
                    }
                    if(no instanceof Firewall){
                        if(! no.verificarAssociacoes()) {
                            System.out.println("No SubGrafo " + subgraph.getLabel()+ " - " + no.getNomeNo() + " do tipo Firewal não esta com suas Associações corretas.");
                            return false;
                        }
                    }
                    if(no instanceof Internet) {
                        if(! no.verificarAssociacoes()) {
                            System.out.println("No SubGrafo " + subgraph.getLabel()+ " - " + no.getNomeNo() + " do tipo Internet não esta com suas Associações corretas.");
                            return false;
                        }
                    }
                    if(no instanceof Roteador) {
                        if(! no.verificarAssociacoes()) {
                            System.out.println("No SubGrafo " + subgraph.getLabel()+ " - " + no.getNomeNo() + " do tipo Roteador não esta com suas Associações corretas.");
                            return false;
                        }
                    }
                    if(no instanceof Switch) {
                        if(! no.verificarAssociacoes()) {
                            System.out.println(no.getNomeNo() + " do tipo Switch não esta com suas Associações corretas.");
                            return false;
                        }
                    }
                }
            }
            return arquivo.SalvarGrafoDot(nomeDoArquivo, graph);
        }catch (Exception e) {
            return false;
        }
    }

}
