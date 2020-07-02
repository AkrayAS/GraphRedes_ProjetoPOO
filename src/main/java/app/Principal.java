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
                    System.out.print("Digite o ID do nodo a ser criado: ");
                    String id1 = teclado.nextLine();
                    System.out.print("Digite o codigo do objeto do datagram: ");
                    int cod1 = Integer.parseInt(teclado.nextLine());
                    if(app.adicionarNodeDatagrama(id1, cod1)) System.out.println("Nodo adicionado ao grafo com sucesso.");
                    else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");
                case 11:
                    System.out.print("Digite o ID do nodo a ser criado para o subgrafo: ");
                    String id2 = teclado.nextLine();
                    System.out.print("Digite o codigo do objeto do datagram: ");
                    int cod2 = Integer.parseInt(teclado.nextLine());
                    System.out.print("Digite o nome do SubGrafo a ser acessado: ");
                    String sub1 = teclado.nextLine();
                    if (app.adicionarNodeSubGraphDatagrama(id2, cod2, sub1)) System.out.println("Nodo adicionado ao grafo com sucesso.");
                    else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");
                case 12:
                    System.out.print("Digite o nome do SubGrafo a ser criado: ");
                    String sub2 = teclado.nextLine();
                    if (app.criarSubGraph(sub2)) System.out.println("SubGrafo Criado com sucesso.");
                    else System.out.println("Houve um erro ao criar o subgrafo.");
                case 13:
                    System.out.print("Digite o nome do nodo do Grafo principal a ser removido: ");
                    String node = teclado.nextLine();
                    if(app.removeNode(node)) System.out.println("Nodo removido com sucesso.");
                    else System.out.println("Houve um erro ao remover o nodo.");
                case 14:
                    System.out.print("Digite o nome do SubGrafo a ser deletado: ");
                    String sub3 = teclado.nextLine();
                    if(app.removeSubGraph(sub3)) System.out.println("SubGrafo removido com sucesso.");
                    else System.out.println("Houve um erro ao remover o SubGrafo.");
                case 15:
                    System.out.println("Digite o ID do nodo a ser alterado: ");
                    String id3 = teclado.nextLine();
                    System.out.print("Digite o novo ID para o nodo: ");
                    String newID = teclado.nextLine();
                    if(app.atualizarNode(id3,newID)) System.out.println("Alteração do nodo com sucesso.");
                    else System.out.println("Houve um erro ao alterar o nodo.");
                case 16:
                    System.out.print("Digite o ID do nodo que deseja adicionar propriedades: ");
                    String id4 = teclado.nextLine();
                    System.out.print("Digite qual sera o título do nodo: ");
                    String label2 = teclado.nextLine();
                    System.out.print("Digite o tamanho da fonte do título: ");
                    int fs3 = Integer.parseInt(teclado.nextLine());
                    System.out.print("Digite a posição do título no nodo: ");
                    String pos3 = teclado.nextLine();
                    if(app.adicionarPropriedadesNode(id4,label2,fs3,pos3)) System.out.println("Propriedades do nodo adicionadas com sucesso.");
                    else System.out.println("Houve um erro ao adicionar as propriedades.");
                case 17:
                    System.out.print("Digite o ID do nodo \"pai\" a ser associado: ");
                    String pai1 = teclado.nextLine();
                    System.out.print("Digite o ID do nodo \"filho\" a ser associdao: ");
                    String filha1 = teclado.nextLine();
                    if(app.associarNodes(pai1,filha1)) System.out.println("Associação ocorreu com sucesso.");
                    else System.out.println("Houve um erro durante a associação.");
                case 18:
                    System.out.print("Digite o nome do SubGrafo a ser usado na associação: ");
                    String subs = teclado.nextLine();
                    System.out.print("Digite o ID do nodo \"pai\" a ser associado: ");
                    String pai2 = teclado.nextLine();
                    System.out.print("Digite o ID do nodo \"filho\" a ser associdao: ");
                    String filha2 = teclado.nextLine();
                    if(app.associarNodesSubGraph(pai2,filha2,subs)) System.out.println("Associação ocorreu com sucesso.");
                    else System.out.println("Houve um erro durante a associação.");
                case 19:
                    System.out.print("Digite o nome do SubGrafo a ser usado na associação com o nodo do Grafo: ");
                    String subs2 = teclado.nextLine();
                    System.out.print("Digite o ID do nodo \"pai\" do Grafo a ser associado: ");
                    String pai3 = teclado.nextLine();
                    System.out.print("Digite o ID do nodo \"filho\" do SubGrafo a ser associdao: ");
                    String filha4 = teclado.nextLine();
                    if(app.associarSubGraph(pai3,filha4,subs2)) System.out.println("Associação ocorreu com sucesso.");
                    else System.out.println("Houve um erro durante a associação.");
                case 20:
                default:
            }
        }
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph("teste");
        graph.propriedadesGraph("t",14);
        graph.propriedadesGeraisNode("oval", "blue","c",10);
        graph.setEdgeColor("red");
        graph.adicionarNo("a");
        graph.adicionarNo("b");

        graph.associacar("a","b");
        graph.propriedadesNo("a","rede",10,"c");
        graph.propriedadesNo("b", "internet", 10, "c");
        graph.criaSubgraph("oi");
        graph.propriedadesSubGraph("oi","b", 12, "dotted", "green");
        graph.adicionarNo("c", "oi");
        graph.propriedadesNoSubGraph("oi","c","cloud",10,"c");
        graph.associarSubgraph("b","c","oi");

        Arquivo arquivo = new Arquivo();

        arquivo.SalvarGrafoDot("test.dot", graph);

        System.out.println(arquivo.lerGrafoDot("test.dot"));
    }
}
