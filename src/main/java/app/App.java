package app;

/**
 * Classe Onde os metodos para a iteração do usuario estao encapsulados.
 *
 * @author Arthur Anastopulos dos Santos
 */

public class App {
    Graph graph = new Graph();
    Arquivo arquivo = new Arquivo();

    /**
     *Função que Inicia um Grafo junto ao Programa
     *
     * @param label Titulo do Grafo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean iniciarPrograma(String label) {
        try {
            graph.setLabel(label);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Escolhe a cor dos Arcos do Grafo.
     *
     * @param c codigo da Enum das Cores
     * @return boolean dependendo se houve sucesso.
     */
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

    /**
     * Adiciona um nodo com herança do seu tipo de Rede, apartir de seu codigo.
     *
     * @param noID ID do nodo
     * @param c codigo do Datagrama de Rede
     * @return boolean dependendo se houve sucesso.
     */
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

    /**
     * Adiciona um nodo com herança do seu tipo de Rede, apartir de seu codigo e subgrafo que pertence.
     *
     * @param noID ID do nodo
     * @param c codigo do Datagrama de Rede
     * @param nameSubGraph nome do Subgrafo
     * @return boolean dependendo se houve sucesso.
     */
    public boolean adicionarNodeSubGraphDatagrama(String noID, int c, String nameSubGraph){
        try {
            return graph.adicionarNo(noID, c ,nameSubGraph);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Cria um SubGrafo.
     * @param label titulo do subgrafo
     * @return boolean dependendo se houve sucesso.
     */
    public boolean criarSubGraph(String label) {
        try {
            return graph.criaSubgraph(label);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Remove um nodo apartir de seu id.
     *
     * @param noID Id de um nodo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean removeNode(String noID){
        try {
            return graph.removeNo(noID);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Deleta um subgrafo.
     *
     * @param label titulo de um Subgrafo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean removeSubGraph(String label) {
        try {
            return graph.removeSubgraph(label);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Atualiza o id de um nodo por outro novo Id.
     *
     * @param noID id original.
     * @param novoID novo id.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean atualizarNode(String noID, String novoID){
        try {
            return graph.atualizaNo(noID, novoID);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Adiciona Propriedades gerais de todos os nodos do Grafo.
     *
     * @param shape forma do nodo.
     * @param color cor do nodo.
     * @param labelloc posiçao da titulo do nodo.
     * @param labelFsizeNode tamanho da fonte do nodo.
     * @return boolean dependendo se houve sucesso.
     */
    public  boolean adicionarPropriedadesGeralNode(String shape,String color, String labelloc, int labelFsizeNode){
        try {
            graph.propriedadesGeraisNode(shape, color, labelloc, labelFsizeNode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Propriedades de um Grafo.
     *
     * @param labelloc posiçao do titulo do grafo.
     * @param labelFsize tamanho da fonte.
     * @return boolean dependendo se houve sucesso.
     */
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

    /**
     * Adiciona propriedades a um nodo especifico.
     *
     * @param noID id do nodo a ser escolhido.
     * @param label titulo do nodo.
     * @param fsize tamanho da fonte do titulo.
     * @param c posiçao do titulo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean adicionarPropriedadesNode(String noID, String label ,int fsize, String c){
        try {
            return graph.propriedadesNo(noID, label ,fsize, c);
        } catch (Exception e){
            return false;
        }
    }

    /**
     *Adiciona propriedades a um nodo especifico de um Subgrafo.
     *
     * @param SubGraph nome do Subgrafo a ser escolhido.
     * @param noID id do nodo a ser escolhido
     * @param label titulo do nodo.
     * @param fsize tamanho da fonte do titulo.
     * @param c posiçao do titulo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean adicionarPropriedadesNodeSubGraph(String SubGraph, String noID, String label ,int fsize, String c){
        try {
            return graph.propriedadesNoSubGraph(SubGraph, noID, label, fsize, c);
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Assoscia nodos entre si.
     *
     * @param paiNoID nodo principal
     * @param filhaNoID nodo a ser associado ao principal
     * @return boolean dependendo se houve sucesso.
     */
    public boolean associarNodes(String paiNoID, String filhaNoID) {
        try {
            return graph.associacar(paiNoID, filhaNoID);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Associa nodos entre si dentro de um subgrafo.
     *
     * @param paiNoID nodo principal.
     * @param filhaNoID nodo a ser associado ao principal.
     * @param label titulo do subgrafo a ser escolhido.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean associarNodesSubGraph(String paiNoID, String filhaNoID, String label) {
        try {
            return graph.associacar(paiNoID, filhaNoID, label);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Associar Subgrafo com o grafo.
     *
     * @param paiNoID nodo do grafo que associa com o nodo do subgrafo.
     * @param filhaNoID nodo do subgrafo que associa com o nodo do grafo.
     * @param label titulo do subgrafo que sera usado.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean associarSubGraph(String paiNoID, String filhaNoID, String label) {
        try {
            return graph.associarSubgraph(paiNoID, filhaNoID, label);
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Salva um arquivo no formato .dot
     *
     * @param nomeDoArquivo nome do arquivo.
     * @return boolean dependendo se houve sucesso.
     */
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

    /**
     * Grava a classe Grafo em disco para que possa ser utulizada novamente.
     *
     * @param nomeDoArquivo nome do arquivo.
     * @return boolean dependendo se houve sucesso.
     */
    public boolean salvarArquivoEmDisco(String nomeDoArquivo) {
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
            return arquivo.SalvarGrafoEmDisco(nomeDoArquivo, graph);
        }catch (Exception e) {
            return false;
        }
    }
}
