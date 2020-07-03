package app;

import junit.framework.TestCase;

public class NoTest extends TestCase {

    public void testVerificarAssociacoesCorretas() {
        Graph graph = new Graph("test");
        graph.adicionarNo("internet", 1);
        graph.adicionarNo("roteador1", 0);
        graph.adicionarNo("roteador2", 4);
        graph.associacar("internet", "roteador1");
        graph.associacar("internet", "roteador2");
        graph.adicionarNo("firewall", 3);
        graph.adicionarNo("switch1", 8);
        graph.associacar("roteador1", "firewall");
        graph.associacar("roteador2", "firewall");
        graph.associacar("firewall", "switch1");
        graph.adicionarNo("desktop", 2);
        graph.associacar("switch1", "desktop");

        for (No no : graph.getNos()) {
            if (no instanceof Endpoint) {
                if (no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Firewall) {
                if (no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Internet) {
                if (no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Roteador) {
                if (no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Switch) {
                if (no.verificarAssociacoes()) assertTrue(true);
            }
        }
    }

    public void testVerificarAssociacoesErradas() {
        Graph graph = new Graph("test");
        graph.adicionarNo("internet", 1);
        graph.adicionarNo("roteador1", 0);
        graph.adicionarNo("roteador2", 4);
        graph.adicionarNo("firewall", 3);
        graph.adicionarNo("switch1", 8);
        graph.adicionarNo("desktop", 2);
        graph.associacar("desktop","firewall");
        graph.associacar("desktop", "switch2");

        for (No no : graph.getNos()) {
            if (no instanceof Endpoint) {
                if (! no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Firewall) {
                if (! no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Internet) {
                if (! no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Roteador) {
                if (! no.verificarAssociacoes()) assertTrue(true);
            }
            if (no instanceof Switch) {
                if (! no.verificarAssociacoes()) assertTrue(true);
            }
        }
    }
}