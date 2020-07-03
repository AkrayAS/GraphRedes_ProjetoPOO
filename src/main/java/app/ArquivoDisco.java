package app;

import java.io.*;

public interface ArquivoDisco {

    boolean SalvarGrafoEmDisco(String nomeDoArquivo, Graph graph);

    Graph lerGrafoDoDisco(String nomeDoArquivo);
}
