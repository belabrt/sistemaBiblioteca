/*
 * Trabalho realizado para a disciplina de Design de Software 
 * Aluna: Isabela da Silva Barata GRR20213395
 * Data: 11/12/2024
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("\n********* SISTEMA DA BIBLIOTECA ********\n");
        while (opcao != 5){
            System.out.println("\nSelecione o que deseja fazer:\n" +
                                "1 - Cadastrar ou adicionar uma obra\n" + 
                                "2 - Registrar uma devolução\n" +
                                "3 - Registrar um empréstimo\n" +
                                "4 - Pesquisar uma obra\n" +
                                "5 - Finalizar o sistema\n");

            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {

                //CADASTRAR OBRA -----------------------------------------------------------------------------------------------------------
                case 1:
                    System.out.println("Informe o tipo da obra a ser cadastrada:\n" +
                                        "1 - Livro\n" + 
                                        "2 - Periódico\n");
                    int tipoObra = input.nextInt();
                    input.nextLine();

                    if (tipoObra == 1){
                        System.out.println("Informe o título do livro: ");
                        String titulo = input.nextLine();
                        System.out.println("Informa o autor do livro: ");
                        String autor = input.nextLine();
                        System.out.println("Informe a editora do livro: ");
                        String editora = input.nextLine();
                        System.out.println("Informe o ano de publicação do livro: ");
                        int anoPublicacao = input.nextInt();
                        input.nextLine();
                        System.out.println("Informe a quantidade de unidades que deseja adicionar: ");
                        int quantidade = input.nextInt();
                        input.nextLine();
                        biblioteca.cadastrarObraLivro(quantidade, titulo, autor, anoPublicacao, editora);

                    }else if (tipoObra == 2){
                        System.out.println("Informe o título do periódico: ");
                        String titulo = input.nextLine();
                        System.out.println("Informa o numero do volume do periódico: ");
                        int volume = input.nextInt();
                        input.nextLine();
                        System.out.println("Informe o mês do periódico, em números: ");
                        int mes = input.nextInt();
                        input.nextLine();
                        System.out.println("Informe o ano de publicação do periódico: ");
                        int ano = input.nextInt();
                        input.nextLine();
                        System.out.println("Informe a quantidade de unidades que deseja adicionar: ");
                        int quantidade = input.nextInt();
                        input.nextLine();
                        biblioteca.cadastrarObraPeriodico(quantidade, titulo, mes, ano, volume);
        
                    }else{
                        System.out.println("\nOpção inválida!\n");
                    }
                    break;
                
                //REGISTRAR DEVOLUÇÃO -----------------------------------------------------------------------------------------------------
                case 2:
                    System.out.println("Informe o CPF do usuário: ");
                    String documentoDevolucao = input.nextLine();
                    System.out.println("Informe a quantidade de obras a serem devolvidas: ");
                    int qteDevolvidas = input.nextInt();
                    input.nextLine();
                    System.out.println("Informe o nome das obras a serem devolvidas: ");
                    String[] obrasDevolucao = new String[qteDevolvidas];
                    for (int i = 0; i < qteDevolvidas; i++)
                        obrasDevolucao[i] = input.nextLine();
                    System.out.println("Informe a data da devolução, no formato dd/mm/aaaa: ");
                    String dataDevolucao = input.nextLine();

                    float multa = biblioteca.registrarDevolucao(documentoDevolucao, obrasDevolucao, dataDevolucao);
                    if(multa > 0){
                        System.out.println("O usuário possui multa de R$" + multa);
                        System.out.println("\nInforme a forma de pagamento: \n" +
                                            "1 - para cartão\n" +
                                            "2 - para dinheiro ou pix\n");
                        int formaPgto = input.nextInt();
                        biblioteca.receberPagamento(documentoDevolucao, multa, formaPgto, dataDevolucao, obrasDevolucao);
                    }
                    break;

                //REGISTRAR EMPRÉSTIMO -------------------------------------------------------------------------------------------------------
                case 3:
                    System.out.println("Informe o CPF do usuário, apenas números:");
                    String documentoEmprestimo = input.nextLine();
                    if (biblioteca.verificarExistenciaUsuario(documentoEmprestimo))
                        System.out.println("Usuário já cadastrado!");
                    else{
                        System.out.println("Informe o nome do usuário:");
                        String nome = input.nextLine();
                        System.out.println("Informe o email do usuário:");
                        String email = input.nextLine();
                        System.out.println("Informe a data de nascimento do usuário, no formato dd/mm/aaaa:");
                        String dataNascimento = input.nextLine();
                        biblioteca.cadastrarUsuario(nome, documentoEmprestimo, email, dataNascimento);
                    }
                    System.out.println("\nInforme a quantidade de obras a serem emprestadas: ");
                    int qteObrasEmprestadas = input.nextInt();
                    input.nextLine();
                    if (qteObrasEmprestadas > 3){
                        System.out.println("Não é possível emprestar mais que 3 obras por vez.\n");
                        break;
                    }
                    System.out.println("Informe o nome das obras a serem emprestadas: ");
                    String[] obrasEmprestimo = new String[qteObrasEmprestadas];
                    for (int i = 0; i < qteObrasEmprestadas; i++)
                        obrasEmprestimo[i] = input.nextLine();
                    System.out.println("Informe a data do empréstimo, no formato dd/mm/aaaa: ");
                    String dataEmprestimo = input.nextLine();
                    
                    biblioteca.realizarEmprestimo(qteObrasEmprestadas, obrasEmprestimo, documentoEmprestimo, dataEmprestimo);

                    break;

                //PESQUISAR OBRA ---------------------------------------------------------------------------------------------------------
                case 4:
                    System.out.println("Informe o tipo da obra que deseja pesquisar: ");
                    System.out.println("1 - Livro\n" + 
                                        "2 - Periódico\n");
                    int tipoPesquisa = input.nextInt();
                    input.nextLine();
                    String[] dados = new String[2];
                    if (tipoPesquisa == 1){
                        System.out.println("Digite:\n" +
                                            "1 - para pesquisar livro por título\n" +
                                            "2 - para pesquisar livro por autor\n");
                        int opcaoLivro = input.nextInt();
                        input.nextLine();
                        if (opcaoLivro == 1){
                            System.out.println("Digite o título do livro: ");
                            dados[0] = input.nextLine();
                        }else{
                            System.out.println("Digite o nome do autor do livro: ");
                            dados[0] = input.nextLine();
                        }
                        biblioteca.PesquisarObra(tipoPesquisa, opcaoLivro, dados);
                    }else if (tipoPesquisa == 2){
                        System.out.println("Digite:\n" +
                                            "1 - para pesquisar periódico por título\n" +
                                            "2 - para pesquisar periódico por título e ano\n");
                        int opcaoPeriodico = input.nextInt();
                        input.nextLine();
                        if (opcaoPeriodico == 1){
                            System.out.println("Digite o título do periódico: ");
                            dados[0] = input.nextLine();
                        }else{
                            System.out.println("Digite o título do periódico: ");
                            dados[0] = input.nextLine();
                            System.out.println("Digite o ano do periódico: ");
                            dados[1] = input.nextLine();
                        }
                        biblioteca.PesquisarObra(tipoPesquisa, opcaoPeriodico, dados);
                    }else{
                        System.out.println("Tipo de obra inválido!");
                    }
                    break;
                    
                //FINALIZAR O SISTEMA ----------------------------------------------------------------------------------------------
                case 5:
                    System.out.println("Obrigada por usar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
        }

    }
}