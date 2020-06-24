package app;

public class Principal {
    public static void main(String[] args) {
        Graph graph = new Graph("teste");
        graph.adicionarNo("a");
        graph.adicionarNo("b");

        graph.associacar("a","b");
        graph.criaSubgraph("oi");
        graph.adicionarNo("c", "oi");
        graph.adicionarNo("d", "oi");
        graph.associacar("c","d","oi");
        graph.associarSubgraph("b","c","oi");

        System.out.println(graph.toString());
    }
}
