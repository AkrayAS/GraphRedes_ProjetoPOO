package app;

import java.io.*;
import java.util.Scanner;

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
    public Graph lerGrafoDoDisco(String nomeDoArquivo) {
        try (FileInputStream fin = new FileInputStream(new File(nomeDoArquivo));
             ObjectInputStream ois = new ObjectInputStream(fin);
        ) {
           Graph nova = (Graph) ois.readObject();
           return nova;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    @Override
    public boolean SalvarGrafoDot(String nomeDoArquivo, Graph graph) {
        File arquivo = new File(nomeDoArquivo);
        try (FileWriter fwArquivo = new FileWriter(arquivo);
             BufferedWriter bwArquivo = new BufferedWriter(fwArquivo);
        ) {
            bwArquivo.write(graph.toString() + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String lerGrafoDot(String nomeDoArquivo) {
        File arquivo = new File(nomeDoArquivo);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                stringBuilder.append(linha + "\n");
            }
            leitor.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
