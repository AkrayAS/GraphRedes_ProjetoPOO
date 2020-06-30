package app;

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

    public boolean escolherPosLabel(String c) {
        try {
            graph.setLabelloc(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherFontSizeLabel(int f) {
        try {
            graph.setLabelFsize(f);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherEstilo(String c) {
        try {
            graph.setStyle(c);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean escolherCor(String c) {
        try {
            graph.setColor(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherFormatoNode(String c) {
        try {
            graph.setNodeShape(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherPosLabelNode(String c) {
        try {
            graph.setLabellocNode(c);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean escolherFontSizeNode(int f) {
        try{
            graph.setLabelFsizeNode(f);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean escolherCorNode(String c){
        try {
            graph.setNodeColor(c);
            return true;
        }catch (Exception e) {
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

    public boolean adicionarPropriedadesNode(String noID, String label ,int fsize, int c){
        try {
            return graph.propriedadesNo(noID, label ,fsize, c);
        } catch (Exception e){
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
                    if (! no.verificarAssociacoes()) return false;
                }
                if(no instanceof Firewall){
                    if(! no.verificarAssociacoes()) return false;
                }
                if(no instanceof Internet) {
                    if(! no.verificarAssociacoes()) return false;
                }
                if(no instanceof Roteador) {
                    if(! no.verificarAssociacoes()) return false;
                }
                if(no instanceof Switch) {
                    if(! no.verificarAssociacoes()) return false;
                }
            }
            for (Graph subgraph : graph.getSubgraphs()) {
                for (No no : subgraph.getNos()) {
                    if(no instanceof Endpoint) {
                        if (! no.verificarAssociacoes()) return false;
                    }
                    if(no instanceof Firewall){
                        if(! no.verificarAssociacoes()) return false;
                    }
                    if(no instanceof Internet) {
                        if(! no.verificarAssociacoes()) return false;
                    }
                    if(no instanceof Roteador) {
                        if(! no.verificarAssociacoes()) return false;
                    }
                    if(no instanceof Switch) {
                        if(! no.verificarAssociacoes()) return false;
                    }
                }
            }
            return arquivo.SalvarGrafoDot(nomeDoArquivo, graph);
        }catch (Exception e) {
            return false;
        }
    }

}
