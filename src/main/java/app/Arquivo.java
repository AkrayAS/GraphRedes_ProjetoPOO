package app;

import java.io.*;

public class Arquivo implements ArquivoDisco, ArquivoDot {

    @Override
    public boolean SalvarGrafoEmDisco(String nomeDoArquivo, Graph graph) {
        try (FileOutputStream fout = new FileOutputStream(new File(nomeDoArquivo));
             ObjectOutputStream oos = new ObjectOutputStream(fout);
        ) {
            oos.writeObject(graph);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean lerGrafoDoDisco(String nomeDoArquivo) {
        try (FileInputStream fin = new FileInputStream(new File(nomeDoArquivo));
             ObjectInputStream ois = new ObjectInputStream(fin);
        ) {
           Graph nova = (Graph) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean SalvarGrafoDot(String nomeDoArquivo, Graph graph) {
        return false;
    }

    @Override
    public boolean lerGrafoDot(String nomeDoArquivo) {
        return false;
    }
}
