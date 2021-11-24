package mapav1;
    
import java.util.Scanner;

public class Principal {
    
    public int tamanho = 10; 
    Produto produtoList[] = new Produto[tamanho];
    
    
    public static void main(String[] args) {
        
        Principal produto = new Principal();
        produto.populaArray();
        produto.menuPrincipal();
        
    }
    
    public void populaArray(){
        
        for (int i = 0; i < tamanho; i++) {
            produtoList[i] = new Produto(null, null, 0, 0);
        }
    }
public void menuPrincipal(){
    Scanner input = new Scanner(System.in);
    int opcao;
    do{    
    System.out.println("\n\nInsira a opção desejada"
            +"\n1- CADASTRO DE PRODUTOS"
            +"\n2- MOVIMENTAÇÃO"
            +"\n3- REAJUSTE DE PREÇO"
            +"\n4- RELATÓRIOS"
            +"\n5- FINALIZAR");
            System.out.print("\nOpção:");
            
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    //CADASTRO DE PRODUTOS
                    do{
                    System.out.println("\n--CADASTRO DE PRODUTOS--");
                    System.out.println("\nInsira a opção desejada"
                    +"\n1- INCLUSÃO"
                    +"\n2- ALTERAÇÃO"
                    +"\n3- CONSULTA"
                    +"\n4- EXCLUSÃO"
                    +"\n5- RETORNAR");
                    System.out.print("\nOpção:");
                    opcao = input.nextInt();
                        switch(opcao){
                            case 1:
                                //inclusão
                                System.out.println("\nInserir novo produto");
                                System.out.println("Insira o Nome");
                                input.nextLine();
                                String nome = input.nextLine().toUpperCase();
                                System.out.println("Insira a unidade de medida deste produto");
                                String unMedida = input.nextLine().toUpperCase();
                                System.out.println("Insira o preço do produto");
                                double preco = input.nextDouble();
                                if(preco <= 0){
                                    System.out.println("\nPreço não pode ser menor ou igual a zero");
                                    return;
                                }
                                System.out.println("Insira a quantidade de estoque desse produto");
                                double qntEstoque = input.nextDouble();
                                input.nextLine();
                                if(qntEstoque <= 0){
                                    System.out.println("\nA quantidade não pode ser menor ou igual a zero");
                                    return;
                                }
                                System.out.println("\n----CONFIRMAÇÃO----");
                                System.out.println("\nProduto: "+nome
                                    +"\nUnidade de medida: "+unMedida
                                    +"\nPreço: "+preco
                                    +"\nQuantidade: "+qntEstoque);
                                System.out.println("Confirmar cadastro? (S/N)");
                                String opcaoS=input.next().toUpperCase();
                                if ("S".equals(opcaoS)){
                                    for (int i = 0; i < tamanho; i++) {
                                        if (nome.equals(produtoList[i].getNome())){
                                            System.out.println("Produto " + nome + " Ja cadastrado");
                                            break;
                                        }else if(produtoList[i].getNome() == null){
                                            produtoList[i].setNome(nome);
                                            produtoList[i].setUnMedida(unMedida);
                                            produtoList[i].setQntEstoque(qntEstoque);
                                            produtoList[i].setPreco(preco);
                                            System.out.println("\nProduto "+ nome + " cadastrado!\n");
                                            break;
                                        }                                        
                                    }
                                break;
                                }else 
                                    System.out.println("--Cadastro não realizado--");
                                break;                                
                            case 2:
                                //alteracao
                                System.out.println("--ALTERAÇÃO--");
                                System.out.println("Insira o nome do produto a ser alterado");
                                input.nextLine();
                                nome = input.nextLine().toUpperCase();
                                boolean bool = false;
                                for (int i = 0; i < produtoList.length; i++) {
                                    if (produtoList[i].getNome() == null){
                                        System.out.println("Produto não encontrado");
                                        break;
                                    }else if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].imprime();
                                        bool = true;
                                        break;}
                                    }
                                if (bool == false)
                                    break;
                                //definindo alteração somente preço e quantidade                             
                                input.nextLine();
                                System.out.println("Insira o novo preço do produto");
                                double precoAlterar = input.nextDouble();
                                if(precoAlterar <= 0){
                                    System.out.println("\nPreço não pode ser menor ou igual a zero");
                                    break;
                                }
                                System.out.println("Insira a nova quantidade de estoque desse produto");
                                double qntEstoqueAlterar = input.nextDouble();
                                input.nextLine();
                                if(qntEstoqueAlterar <= 0){
                                    System.out.println("\nA quantidade não pode ser menor ou igual a zero");
                                    break;
                                }
                                //confirma alteração
                                System.out.println("\n----CONFIRMAÇÃO----");
                                System.out.println("\nProduto: "+nome
                                    +"\nPreço: "+precoAlterar
                                    +"\nQuantidade: "+qntEstoqueAlterar);
                                System.out.println("Confirmar alteração? (S/N)");
                                opcaoS=input.next().toUpperCase();
                                if ("S".equals(opcaoS)){
                                    for (int i = 0; i < tamanho; i++) {
                                    if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].setPreco(precoAlterar);
                                        produtoList[i].setQntEstoque(qntEstoqueAlterar);
                                        System.out.println("\nProduto "+nome+" Alterado!");
                                        break;}
                                    }      
                                }
                                break;
                            case 3:
                                //consulta
                                System.out.println("\n--CONSULTA DE PRODUTOS--");
                                System.out.println("INSIRA O NOME DO PRODUTO A SER CONSULTADO");
                                input.nextLine();
                                nome = input.nextLine().toUpperCase();
                                bool = false;
                                for (int i = 0; i < produtoList.length; i++) {
                                    if (produtoList[i].getNome() == null){
                                        System.out.println("Produto não encontrado");
                                        break;
                                    }else if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].imprime();
                                        bool = true;
                                        break;}
                                    }
                                if (bool == false)
                                    break;
                                break;
                            case 4:
                                //exclusao
                                System.out.println("\n--EXCLUSÃO DE PRODUTOS--");
                                System.out.println("Insira o nome do produto a ser excluído");
                                input.nextLine();
                                nome = input.nextLine().toUpperCase();
                                bool = false;
                                for (int i = 0; i < produtoList.length; i++) {
                                    if (produtoList[i].getNome() == null){
                                        System.out.println("Produto não encontrado");
                                        break;
                                    }else if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].imprime();
                                        bool = true;
                                        break;}
                                    }
                                if (bool == false)
                                    break;
                                System.out.println("Confirmar exclusão (S/N)?");
                                opcaoS = input.next().toUpperCase();
                                if (opcaoS.equals("S")){
                                    for (int i = 0; i < tamanho; i++) {
                                    if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].setNome(null);
                                        produtoList[i].setUnMedida(null);
                                        produtoList[i].setPreco(0);
                                        produtoList[i].setQntEstoque(0);
                                        System.out.println("Produto excluído!");
                                        arrastaLista();
                                        break;}
                                    }
                                }else{   
                                System.out.println("Produto não excluído!");}
                                break;
                            case 5:
                                System.out.println("Retornando");
                                break;
                            default:
                                System.out.println("Saindo do sistema");
                        }break;
                }while(opcao != 0);
                    break;        
                case 2:
                    //movimentacao
                    do{
                    System.out.println("--MOVIMENTAÇÃO---");
                    System.out.println("O que deseja fazer?"
                        +"\n1 - ENTRADA"
                        +"\n2 - SAÍDA"
                        +"\n3 - RETORNAR");
                    //input.nextInt();
                    opcao = input.nextInt();
                        switch(opcao){
                            case 1:
                                //ENTRADA
                                System.out.println("--ENTRADA DE PRODUTOS--");
                                System.out.println("Insira o nome do produto");
                                input.nextLine();
                                String nome = input.nextLine().toUpperCase();
                                boolean bool = false;
                                for (int i = 0; i < produtoList.length; i++) {
                                    if (produtoList[i].getNome() == null){
                                        System.out.println("Produto não encontrado");
                                        break;
                                    }else if (produtoList[i].getNome().equals(nome)){
                                        produtoList[i].imprime();
                                        bool = true;
                                        break;}
                                    }
                                if (bool == false)
                                    break;
                                System.out.println("Insira a entrada");
                                double qntEntradaAtt = input.nextDouble();
                                for (int i = 0; i < tamanho; i++) {
                                    if (produtoList[i].getNome().equals(nome)){
                                    produtoList[i].setQntEstoque(produtoList[i].getQntEstoque()+qntEntradaAtt);
                                        System.out.println("Novo saldo de estoque de: " + produtoList[i].getQntEstoque());
                                    break;}
                                }
                                break;

                            case 2:
                                //SAÍDA
                                System.out.println("--SAÍDA DE PRODUTOS--");
                                System.out.println("Insira o nome do produto");
                                input.nextLine();
                                nome = input.nextLine().toUpperCase();
                                bool = false;
                                for (int i = 0; i < produtoList.length; i++) {
                                     if (produtoList[i].getNome() == null){
                                         System.out.println("Produto não encontrado");
                                         break;
                                     }else if (produtoList[i].getNome().equals(nome)){
                                         produtoList[i].imprime();
                                         bool = true;
                                         break;}
                                     }
                                 if (bool == false)
                                     break;
                                System.out.println("Insira a saída");
                                double qntSaidaAtt = input.nextDouble();
                                for (int i = 0; i < tamanho; i++) {
                                    if (produtoList[i].getNome().equals(nome)){
                                    produtoList[i].setQntEstoque(produtoList[i].getQntEstoque()-qntSaidaAtt);
                                        System.out.println("Novo saldo de estoque: "+produtoList[i].getQntEstoque());
                                    break;}
                                }
                                break;
                            case 3:
                                //RETORNAR
                                System.out.println("Retornando ao menu");
                                break;
                            default:
                        
                        }break;
                    }while(opcao != 0); //sub menu
                    break; //case 2
                case 3:
                    //reajuste de preco
                    System.out.println("\nDigite o nome do produto");
                    input.nextLine();
                    String nome = input.nextLine().toUpperCase();
                    boolean bool = false;
                    for (int i = 0; i < produtoList.length; i++) {
                        if (produtoList[i].getNome() == null){
                            System.out.println("Produto não encontrado");
                            break;
                        }else if (produtoList[i].getNome().equals(nome)){
                            produtoList[i].imprime();
                            bool = true;
                            break;}
                        }
                    if (bool == false)
                        break;
                    System.out.println("Insira o preço");
                    double newPreco = input.nextDouble();
                    System.out.println("Novo Preço: "+newPreco);
                    System.out.println("Confirmar novo preço? [S/N]");
                    String opcaoS = input.next().toUpperCase();
                    if (opcaoS.equals("S")){
                        for (int j = 0; j < tamanho; j++) {
                            if (produtoList[j].getNome().equals(nome)){
                            produtoList[j].setPreco(newPreco);
                        break;}
                        }
                    }else
                        System.out.println("Retornando ao menu");
                    break;
                case 4:
                    //relatorio
                    System.out.println("\n --RELATÓRIO--");
                    System.out.println("\n1- Produto específico"
                        +"\n2- Todos os produtos");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        System.out.println("Insira o nome do produto");
                        input.nextLine();
                        nome = input.nextLine().toUpperCase();
                        bool = false;
                        for (int i = 0; i < produtoList.length; i++) {
                            if (produtoList[i].getNome() == null){
                                System.out.println("Produto não encontrado");
                                break;
                            }else if (produtoList[i].getNome().equals(nome)){
                                produtoList[i].imprime();
                                bool = true;
                                break;}
                            }
                        break;
                    }else if(opcao == 2){
                        for (int i = 0; i < produtoList.length; i++) {
                            produtoList[i].imprime();
                        }
                    }else
                        System.out.println("\nOpção inválida");
                    break;
                case 5:
                    System.out.println("Encerrando sistema");
                    //encerrar
                    return;
                default :
            }
        }while(opcao != 0); //menu principal
    }
   
   public void arrastaLista(){
        int marcador = 0;
        for (int i = 0; i < produtoList.length; i++) {
            if(produtoList[i].getNome() == null){
                marcador = i;
                break;
            }
        }
        for (int i = marcador; i < produtoList.length; i++) {
            if(i == produtoList.length-1){
                produtoList[i].setNome(null);
                produtoList[i].setUnMedida(null);
                produtoList[i].setPreco(0);
                produtoList[i].setQntEstoque(0);
                break;
            }else {
            produtoList[i].setNome(produtoList[i+1].getNome());
            produtoList[i].setUnMedida(produtoList[i+1].getUnMedida());
            produtoList[i].setPreco(produtoList[i+1].getPreco());
            produtoList[i].setQntEstoque(produtoList[i+1].getQntEstoque());
            }
        }
    }
}


