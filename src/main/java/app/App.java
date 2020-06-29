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

    public boolean escolherPosLabel(int c) {
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

    public boolean escolherEstilo(int c) {
        try {
            graph.setStyle(c);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean escolherCor(int c) {
        try {
            graph.setColor(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherFormatoNode(int c) {
        try {
            graph.setNodeShape(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean escolherPosLabelNode(int c) {
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

    public boolean escolherCorNode(int c){
        try {
            graph.setNodeColor(c);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean escolherCorArco(int c){
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

    public boolean adicionarNodeSubGraph(String noID, String nameSubGraph){
        try {
            return graph.adicionarNo(noID, nameSubGraph);
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

    public boolean adicionarPropriedadesNode(String noID, int fsize, int c){
        try {
            return graph.propriedadesNo(noID, fsize, c);
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
            return arquivo.SalvarGrafoDot(nomeDoArquivo, graph);
        }catch (Exception e) {
            return false;
        }
    }

}
