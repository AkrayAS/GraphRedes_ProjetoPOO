package app;

public class Principal {
    public static void menu() {

    }
    
    public static void main(String[] args) {
        Graph graph = new Graph("teste");
        graph.adicionarNo("a");
        graph.adicionarNo("b");

        graph.associacar("a","b");
        graph.criaSubgraph("cluster_oi");
        graph.adicionarNo("c", "cluster_oi");
        graph.associarSubgraph("b","c","cluster_oi");

        Arquivo arquivo = new Arquivo();

        arquivo.SalvarGrafoDot("test.dot", graph);

        System.out.println(arquivo.lerGrafoDot("test.dot"));
    }
}
