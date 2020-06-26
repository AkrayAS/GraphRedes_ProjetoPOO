package app;

public interface ArquivoDot {

    boolean SalvarGrafoDot(String nomeDoArquivo, Graph graph);

    String lerGrafoDot(String nomeDoArquivo);
}
