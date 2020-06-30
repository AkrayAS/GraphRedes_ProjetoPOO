package app;

import java.util.Scanner;

public class Principal {
    public static void menu() {
        App app = new App();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o Título do Datagrama: ");
        String label = teclado.nextLine();

        if (app.iniciarPrograma(label)) System.out.println("Programa Iniciado com sucesso.");
        else System.out.println("Houve um erro ao Iniciar.");

        while (true) {
            int opçao = Integer.parseInt(teclado.nextLine());

            switch (opçao) {
                case 1:
                    System.out.print("Digite a posição do Título: ");
                    String pos1 = teclado.nextLine();
                    if (app.escolherPosLabel(pos1)) System.out.println("Posição adicionada com sucesso.");
                    else System.out.println("Houve um erro ao adicionar a posição.");
                case 2:
                    System.out.print("Digite o tamanho da fonte do Título: ");
                    int fs1 = Integer.parseInt(teclado.nextLine());
                    if(app.escolherFontSizeLabel(fs1)) System.out.println("Tamanho do Título adicionado com sucesso.");
                else System.out.println("Houve um erro ao adicionar o tamanho do título");
                case 3:
                    System.out.print("Digite o estilo do agrupamento do Grafo: ");
                    String stly = teclado.nextLine();
                    if (app.escolherEstilo(stly)) System.out.println("Estilo do Grafo foi adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adicionar o estilo do Grafo.");
                case 4:
                    System.out.print("Digite a cor do background do grafo: ");
                    String cor1 = teclado.nextLine();
                    if (app.escolherCor(cor1)) System.out.println("Background adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adiconar o background.");
                case 5:
                    System.out.print("Digite a shape geral dos nodos: ");
                    String shape1 = teclado.nextLine();
                    if(app.escolherFormatoNode(shape1)) System.out.println("Shape adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adicionar o shape.");
                case 6:
                    System.out.print("Digite a posição geral do título dos nodos: ");
                    String pos2 = teclado.nextLine();
                    if(app.escolherPosLabelNode(pos2)) System.out.println("Posição adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adicionar a posição.");
                case 7:
                    System.out.print("Digite o tamanho geral da fonte do título dos nodos: ");
                    int fs2 = Integer.parseInt(teclado.nextLine());
                    if(app.escolherFontSizeNode(fs2)) System.out.println("Tamanho do Título adicionado com sucesso");
                    else System.out.println("Houve um erro ao adicionar o tamanho do título");
                case 8:
                    System.out.print("Digite a cor geral dos Nodos: ");
                    String cor2 = teclado.nextLine();
                    if (app.escolherCorNode(cor2)) System.out.println("Cor dos nodos adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adicionar a cor dos nodos.");
                case 9:
                    System.out.print("Digite a cor geral dos arcos: ");
                    String cor3 = teclado.nextLine();
                    if (app.escolherCorArco(cor3)) System.out.println("Cor dos arcos adicionado com sucesso.");
                    else System.out.println("Houve um erro ao adicionar a cor dos arcos.");
                case 10:
//                    System.out.print("Digite o ID do nodo a ser criado: ");
//                    if(app.adicionarNodeDatagrama()) System.out.println("Nodo adicionado ao grafo com sucesso.");
//                    else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");grafo
                case 11:
//                    System.out.print("Digite o ID do nodo a ser criado para o subgrafo: ");
//                    if (app.adicionarNodeSubGraphDatagrama()) System.out.println("Nodo adicionado ao grafo com sucesso.");
//                    else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");
                case 12:
                    System.out.print("");
                case 13:
                default:
            }
        }
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
