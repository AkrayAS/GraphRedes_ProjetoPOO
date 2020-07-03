package app;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Principal {
    public static void menu() {
        App app = new App();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o Título do Datagrama: ");
        String label = teclado.nextLine();

        if (app.iniciarPrograma(label)) System.out.println("Programa Iniciado com sucesso.");
        else System.out.println("Houve um erro ao Iniciar.");

        try {
            while (true) {
                int opçao = Integer.parseInt(teclado.nextLine());

                switch (opçao) {
                    case 1:
                        System.out.print("Digite a posição do Título: ");
                        String loc1 = teclado.nextLine();
                        System.out.print("Digite o tamanho da fonte: ");
                        int fs1 = Integer.parseInt(teclado.nextLine());
                        if (app.adicinarPropriedadesGraph(loc1, fs1)) System.out.println("Propriedades adicionadas com sucesso.");
                        else System.out.println("Houve um erro ao adicionar as propriedades.");
                        break;
                    case 2:
                        System.out.print("Digite a forma dos nodos: ");
                        String shape = teclado.nextLine();
                        System.out.print("Digite a cor dos Nodos: ");
                        String cor1 = teclado.nextLine();
                        System.out.print("Digite a posição do título dos nodos: ");
                        String loc = teclado.nextLine();
                        System.out.print("Digite o tamanho geral da fonte para os nodos: ");
                        int fs2 = Integer.parseInt(teclado.nextLine());
                        if (app.adicionarPropriedadesGeralNode(shape, cor1, loc, fs2)) System.out.println("Propriedades adicionadas com sucesso.");
                        else System.out.println("ouve um erro ao adicionar as propriedades.");
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.print("Digite a cor geral dos arcos: ");
                        String cor3 = teclado.nextLine();
                        if (app.escolherCorArco(cor3)) System.out.println("Cor dos arcos adicionado com sucesso.");
                        else System.out.println("Houve um erro ao adicionar a cor dos arcos.");
                        break;
                    case 5:
                        System.out.print("Digite o ID do nodo a ser criado: ");
                        String id1 = teclado.nextLine();
                        System.out.print("Digite o codigo do objeto do datagram: ");
                        int cod1 = Integer.parseInt(teclado.nextLine());
                        if (app.adicionarNodeDatagrama(id1, cod1))
                            System.out.println("Nodo adicionado ao grafo com sucesso.");
                        else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");
                        break;
                    case 6:
                        System.out.print("Digite o ID do nodo a ser criado para o subgrafo: ");
                        String id2 = teclado.nextLine();
                        System.out.print("Digite o codigo do objeto do datagrama: ");
                        int cod2 = Integer.parseInt(teclado.nextLine());
                        System.out.print("Digite o nome do SubGrafo a ser acessado: ");
                        String sub1 = teclado.nextLine();
                        if (app.adicionarNodeSubGraphDatagrama(id2, cod2, sub1))
                            System.out.println("Nodo adicionado ao grafo com sucesso.");
                        else System.out.println("Houve um erro ao adicionar o nodo ao grafo.");
                        break;
                    case 7:
                        System.out.print("Digite o nome do SubGrafo a ser criado: ");
                        String sub2 = teclado.nextLine();
                        if (app.criarSubGraph(sub2)) System.out.println("SubGrafo Criado com sucesso.");
                        else System.out.println("Houve um erro ao criar o subgrafo.");
                        break;
                    case 8:
                        System.out.print("Digite o nome do nodo do Grafo principal a ser removido: ");
                        String node = teclado.nextLine();
                        if (app.removeNode(node)) System.out.println("Nodo removido com sucesso.");
                        else System.out.println("Houve um erro ao remover o nodo.");
                        break;
                    case 9:
                        System.out.print("Digite o nome do SubGrafo a ser deletado: ");
                        String sub3 = teclado.nextLine();
                        if (app.removeSubGraph(sub3)) System.out.println("SubGrafo removido com sucesso.");
                        else System.out.println("Houve um erro ao remover o SubGrafo.");
                        break;
                    case 10:
                        System.out.println("Digite o ID do nodo a ser alterado: ");
                        String id3 = teclado.nextLine();
                        System.out.print("Digite o novo ID para o nodo: ");
                        String newID = teclado.nextLine();
                        if (app.atualizarNode(id3, newID)) System.out.println("Alteração do nodo com sucesso.");
                        else System.out.println("Houve um erro ao alterar o nodo.");
                        break;
                    case 11:
                        System.out.print("Digite o ID do nodo que deseja adicionar propriedades: ");
                        String id4 = teclado.nextLine();
                        System.out.print("Digite qual sera o título do nodo: ");
                        String label2 = teclado.nextLine();
                        System.out.print("Digite o tamanho da fonte do título: ");
                        int fs3 = Integer.parseInt(teclado.nextLine());
                        System.out.print("Digite a posição do título no nodo: ");
                        String pos3 = teclado.nextLine();
                        if (app.adicionarPropriedadesNode(id4, label2, fs3, pos3))
                            System.out.println("Propriedades do nodo adicionadas com sucesso.");
                        else System.out.println("Houve um erro ao adicionar as propriedades.");
                        break;
                    case 12:
                        System.out.print("Digite o nome do SubGrafo a ser acessado: ");
                        String subs1 = teclado.nextLine();
                        System.out.print("Digite o ID do nodo que deseja adicionar propriedades: ");
                        String id5 = teclado.nextLine();
                        System.out.print("Digite qual sera o título do nodo: ");
                        String label3 = teclado.nextLine();
                        System.out.print("Digite o tamanho da fonte do título: ");
                        int fs4 = Integer.parseInt(teclado.nextLine());
                        System.out.print("Digite a posição do título no nodo: ");
                        String pos5 = teclado.nextLine();
                        if (app.adicionarPropriedadesNodeSubGraph(subs1, id5, label3, fs4, pos5))
                            System.out.println("Propriedades do nodo adicionadas com sucesso.");
                        else System.out.println("Houve um erro ao adicionar as propriedades.");
                        break;
                    case 13:
                        System.out.print("Digite o ID do nodo \"pai\" a ser associado: ");
                        String pai1 = teclado.nextLine();
                        System.out.print("Digite o ID do nodo \"filho\" a ser associdao: ");
                        String filha1 = teclado.nextLine();
                        if (app.associarNodes(pai1, filha1)) System.out.println("Associação ocorreu com sucesso.");
                        else System.out.println("Houve um erro durante a associação.");
                        break;
                    case 14:
                        System.out.print("Digite o nome do SubGrafo a ser usado na associação: ");
                        String subs = teclado.nextLine();
                        System.out.print("Digite o ID do nodo \"pai\" a ser associado: ");
                        String pai2 = teclado.nextLine();
                        System.out.print("Digite o ID do nodo \"filho\" a ser associdao: ");
                        String filha2 = teclado.nextLine();
                        if (app.associarNodesSubGraph(pai2, filha2, subs))
                            System.out.println("Associação ocorreu com sucesso.");
                        else System.out.println("Houve um erro durante a associação.");
                        break;
                    case 15:
                        System.out.print("Digite o nome do SubGrafo a ser usado na associação com o nodo do Grafo: ");
                        String subs2 = teclado.nextLine();
                        System.out.print("Digite o ID do nodo \"pai\" do Grafo a ser associado: ");
                        String pai3 = teclado.nextLine();
                        System.out.print("Digite o ID do nodo \"filho\" do SubGrafo a ser associdao: ");
                        String filha4 = teclado.nextLine();
                        if (app.associarSubGraph(pai3, filha4, subs2))
                            System.out.println("Associação ocorreu com sucesso.");
                        else System.out.println("Houve um erro durante a associação.");
                        break;
                    case 16:
                        System.out.print("Digite o nome do arquivo para ser salvo: ");
                        String nomeArq1 = teclado.nextLine();
                        if(app.salvarArquivo(nomeArq1)) System.out.println("Arquivo dot salvo com sucesso.");
                        else System.out.println("Erro ao Salvar.");
                        break;
                    case 17:
                        System.out.print("Digite o nome para a persistencia em disco: ");
                        String nomeArq2 = teclado.nextLine();
                        if(app.salvarArquivoEmDisco(nomeArq2)) System.out.println("Arquivo gravado em disco com sucesso.");
                        else System.out.println("Erro ao Gravar em Disco.");
                    default:
                        System.out.println("Programa Concluindo. Fechando");
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println("Houve um erro na entrada de dados, por favor selecionar novamente sua opção desejada: ");
        }
    }
    
    public static void main(String[] args) {
        menu();
//
//        Graph graph = new Graph("Datagrama de Redes");
//        graph.propriedadesGraph("t",14);
//        graph.propriedadesGeraisNode("none","black","c",10);
//        graph.setEdgeColor("red");
//        graph.adicionarNo("internet", 1);
//        graph.adicionarNo("roteador",0);
//        graph.adicionarNo("firewall", 3);
//        graph.criaSubgraph("desktop");
//        graph.adicionarNo("desktop1", 2 , "desktop");
//        graph.adicionarNo("desktop2", 2 , "desktop");
//        graph.criaSubgraph("server");
//        graph.adicionarNo("server", 6, "server");
//        graph.propriedadesNo("internet","Cloud",10,"c");
//        graph.propriedadesNo("roteador","Roteador",10,"c");
//        graph.propriedadesNo("firewall","Firewall",10,"c");
//        graph.propriedadesNoSubGraph("desktop","desktop1","Desktop",10,"c");
//        graph.propriedadesNoSubGraph("desktop","desktop2","Desktop",10,"c");
//        graph.propriedadesNoSubGraph("server", "server","Servidor", 10, "c");
//        graph.propriedadesSubGraph("desktop","c",12,"dotted","yellow");
//        graph.propriedadesSubGraph("server","c",12,"solid","green");
//        graph.associacar("internet","roteador");
//        graph.associacar("roteador", "firewall");
//        graph.associarSubgraph("firewall","desktop1", "desktop");
//        graph.associarSubgraph("firewall","desktop2", "desktop");
//        graph.associarSubgraph("firewall","server","server");
//
//        Arquivo arquivo = new Arquivo();
//        arquivo.SalvarGrafoDot("teste.dot", graph);
//        arquivo.SalvarGrafoEmDisco("img/graph.ser", graph);
    }
}