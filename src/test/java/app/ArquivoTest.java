package app;

import junit.framework.TestCase;

public class ArquivoTest extends TestCase {

    public void testSalvarGrafoEmDisco() {
        Graph graph = new Graph("Datagrama de Redes");
        graph.propriedadesGraph("t",14);
        graph.propriedadesGeraisNode("none","black","c",10);
        graph.setEdgeColor("red");
        graph.adicionarNo("internet", 1);
        graph.adicionarNo("roteador",0);
        graph.adicionarNo("firewall", 3);
        graph.criaSubgraph("desktop");
        graph.adicionarNo("desktop1", 2 , "desktop");
        graph.adicionarNo("desktop2", 2 , "desktop");
        graph.criaSubgraph("server");
        graph.adicionarNo("server", 6, "server");
        graph.propriedadesNo("internet","Cloud",10,"c");
        graph.propriedadesNo("roteador","Roteador",10,"c");
        graph.propriedadesNo("firewall","Firewall",10,"c");
        graph.propriedadesNoSubGraph("desktop","desktop1","Desktop",10,"c");
        graph.propriedadesNoSubGraph("desktop","desktop2","Desktop",10,"c");
        graph.propriedadesNoSubGraph("server", "server","Servidor", 10, "c");
        graph.propriedadesSubGraph("desktop","c",12,"dotted","yellow");
        graph.propriedadesSubGraph("server","c",12,"solid","green");
        graph.associacar("internet","roteador");
        graph.associacar("roteador", "firewall");
        graph.associarSubgraph("firewall","desktop1", "desktop");
        graph.associarSubgraph("firewall","desktop2", "desktop");
        graph.associarSubgraph("firewall","server","server");

        Arquivo arquivo = new Arquivo();
        arquivo.SalvarGrafoDot("teste.dot", graph);
        String load = arquivo.lerGrafoDot("teste.dot");

        if(load.equals(graph.toString())) assertTrue(true);
        else assertFalse(false);
    }
}