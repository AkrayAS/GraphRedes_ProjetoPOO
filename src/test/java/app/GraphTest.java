package app;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

    public void testAdicionarNo() {
        Graph graph = new Graph("test");
        graph.adicionarNo("a");
        assertTrue(graph.adicionarNo("b"));
        assertFalse(graph.adicionarNo("a"));
    }

    public void testTestAdicionarNo() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("subtest");
        graph.adicionarNo("a","subtest");
        assertFalse(graph.adicionarNo("a","subtest"));
        assertTrue(graph.adicionarNo("b","subtest"));
        assertFalse(graph.adicionarNo("c","banana"));
    }

    public void testCriaSubgraph() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("falha");
        assertFalse(graph.criaSubgraph("falha"));
        assertTrue(graph.criaSubgraph("true"));
    }

    public void testRemoveNo() {
        Graph graph = new Graph("test");
        graph.adicionarNo("a");
        assertTrue(graph.removeNo("a"));
        assertFalse(graph.removeNo("b"));
    }

    public void testRemoveSubgraph() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("subtest");
        graph.adicionarNo("a","subtest");
        assertFalse(graph.removeSubgraph("subbtest"));
        assertTrue(graph.removeSubgraph("subtest"));
    }

    public void testAtualizaNo() {
        Graph graph = new Graph("test");
        graph.adicionarNo("a");
        graph.adicionarNo("b");
        assertTrue(graph.atualizaNo("a", "c"));
        assertFalse(graph.atualizaNo("a","b"));
    }

    public void testExiste() {
        Graph graph = new Graph("test");
        graph.adicionarNo("a");

        assertFalse(graph.existe("b"));
        assertTrue(graph.existe("a"));
    }

    public void testExisteSubgraph() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("banana");

        assertTrue(graph.existeSubgraph("banana"));
        assertFalse(graph.existeSubgraph("subtest"));
    }

    public void testAssociacar() {
        Graph graph = new Graph("test");
        graph.adicionarNo("a");
        graph.adicionarNo("b");
        graph.adicionarNo("c");

        graph.associacar("a","c");
        assertTrue(graph.associacar("a","b"));
        assertFalse(graph.associacar("a","d"));
    }

    public void testTestAssociacar() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("subtest");
        graph.adicionarNo("a","subtest");
        graph.adicionarNo("b","subtest");
        graph.adicionarNo("c","subtest");

        graph.associacar("a","c","subtest");
        assertFalse(graph.associacar("a","b","banana"));
        assertTrue(graph.associacar("a","b","subtest"));
    }

    public void testAssociarSubgraph() {
        Graph graph = new Graph("test");
        graph.criaSubgraph("subtest");
        graph.adicionarNo("a");
        graph.adicionarNo("b","subtest");
        assertFalse(graph.associarSubgraph("b","a","subtest"));
        assertFalse(graph.associarSubgraph("a","b","banana"));
        assertTrue(graph.associarSubgraph("a","b","subtest"));
    }
}