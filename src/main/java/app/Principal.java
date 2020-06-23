package app;

public class Principal {
    public static void main(String[] args) {
        Graph graph = new Graph("teste");
        graph.adicionarNo("a");
        graph.adicionarNo("b");

        graph.associacar("a","b");

        System.out.println(graph.toString());
    }
}
