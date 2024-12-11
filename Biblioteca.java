import java.time.LocalDate;

public class Biblioteca {
    private BancoDeUsuarios bancoUsuarios;
    private CatalogoDeObras catalogoObras;

    public Biblioteca(){
        this.bancoUsuarios = new BancoDeUsuarios();
        this.catalogoObras = new CatalogoDeObras();
    }
    public Biblioteca (BancoDeUsuarios bancoUsuarios, CatalogoDeObras catalogoObras){
        this.setBancoUsuarios(bancoUsuarios);
        this.setCatalogoObras(catalogoObras);
    }

    public void setBancoUsuarios(BancoDeUsuarios bancoUsuarios) {
        this.bancoUsuarios = bancoUsuarios;
    }
    public void setCatalogoObras(CatalogoDeObras catalogoObras) {
        this.catalogoObras = catalogoObras;
    }

    public BancoDeUsuarios getBancoUsuarios() {
        return bancoUsuarios;
    }
    public CatalogoDeObras getCatalogoObras() {
        return catalogoObras;
    }

    //--------------------CADASTRAR OBRAS----------------------------------------------------------

    public void cadastrarObraLivro( int qte, String titulo, String autor, int ano, String editora){
        Obra novoLivro = catalogoObras.criarObraLivro(qte, titulo, autor, ano, editora);
        if (novoLivro == null){
            System.out.println("Erro ao cadastrar livro\n");
        }else{
            System.out.println("Livro cadastrado com sucesso!\n");
        }
    }

    public void cadastrarObraPeriodico( int qte, String titulo, int mes, int ano, int volume){
        Obra novoPeriodico = catalogoObras.criarObraPeriodico(qte, titulo, mes, ano, volume);
        if (novoPeriodico == null){
            System.out.println("Erro ao cadastrar periódico\n");
        }else{
            System.out.println("Periódico cadastrado com sucesso!\n");
        }
    }

    //--------------------REGISTRAR DEVOLUÇÃO----------------------------------------------------------

    public float registrarDevolucao(String documento, String[] obrasDevolvidas, String dataDevolucaoReal){
        float multa = bancoUsuarios.atualizarEmprestimo(documento, obrasDevolvidas, dataDevolucaoReal);
        if (multa == 0){
            catalogoObras.mudarStatusObras(obrasDevolvidas, true);
            System.out.println("Devolução realizada com sucesso!\n");
        }
        return multa;
    }

    public void receberPagamento(String documento, float valor, int formaPgto, String data, String[] obras){
        if(bancoUsuarios.registrarPagamento(documento, valor, formaPgto) == 0){
            System.out.println("Pagamento realizado com sucesso!\n");
        }
    }

    //--------------------REGISTRAR EMPRÉSTIMO----------------------------------------------------------

    public void realizarEmprestimo(int qteObras, String[] obrasEmprestadas, String documento, String dataEmprestimo){
        if (verificarDisponibilidadeObras(obrasEmprestadas) == true){
            if (bancoUsuarios.getMultaUsuario(documento) == 0){
                Emprestimo novoEmprestimo = bancoUsuarios.adicionarEmprestimo(qteObras, obrasEmprestadas, documento, dataEmprestimo);
                catalogoObras.mudarStatusObras(obrasEmprestadas, false);
                if (novoEmprestimo != null){
                    System.out.println("Emprésimo realizado com sucesso!\n" + novoEmprestimo.toString());
                }
            }else
                System.out.println("Usuário não pode fazer empréstimo pois tem multa para pagar.");                
        }else{
            System.out.println("Algumas obras não estão disponíveis para empréstimo.\n");
        }
    }

    private boolean verificarDisponibilidadeObras(String[] obras){
        boolean disponiveis = false;
        Obra obraAux;
        for (int i = 0; i < obras.length; i++){
            String[] dados = new String[2];
            dados[0] = obras[i];
            if ((obraAux = catalogoObras.pesquisarObra(1, 1, dados)) == null){
                if (catalogoObras.pesquisarObra(2, 1, dados).isDisponivel())
                    disponiveis = true;
                else
                    disponiveis = false;
            }else{
                if (catalogoObras.pesquisarObra(1, 1, dados).isDisponivel())
                    disponiveis = true;
                else
                    disponiveis = false;
            }

        }
        return disponiveis;
    }

    public void cadastrarUsuario(String nome, String documento, String email, String dataNascimento){
        String novoUsuario = this.bancoUsuarios.cadastrarUsuario(nome, documento, email, dataNascimento);
        System.out.println("\nUsuario cadastrado com sucesso!\n" + novoUsuario);
    }

    public boolean verificarExistenciaUsuario(String documento){
        return this.bancoUsuarios.buscarUsuario(documento);
    }


    //--------------------PESQUISAR OBRA----------------------------------------------------------------

    public void PesquisarObra(int tipo, int opcaoPesquisa, String[] dados){
        Obra obraPesquisado = catalogoObras.pesquisarObra(tipo, opcaoPesquisa, dados);
        if (obraPesquisado == null){
            System.out.println("Obra não encontrada.");
        }else{
            System.out.println("Obra encontrada!\n" +
                                "Número de exemplares existentes: " + obraPesquisado.getQteExistentes() +
                                "\nNúmero de exemplares disponíveis: " + obraPesquisado.getQteDisponiveis() + "\n");
        }
    }
}
