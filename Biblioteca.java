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

    public void receberPagamento(Usuario usuario, float valor, int formaPgto){

    }

    public void realizarEmprestimo(int qteObras, String[] obrasEmprestadas, String documento, LocalDate dataEmprestimo){

    }

    public void cadastrarObraLivro( int qte, String titulo, String autor, int ano, String editora){

    }

    public void cadastrarObraPeriodico( int qte, String titulo, int mes, int ano, int volume){
        
    }

    public void registrarDevolucao(String documento, String[] obrasDevolvidas, LocalDate dataDevolucaoReal){

    }

    public void PesquisarObraLivro(int opcaoPesquisa, String nomePesquisa ){

    }

    public void PesquisarObraPeriodico(int opcaoPesquisa, String[] dados){
        
    }

    public void cadastrarUsuario(String nome, String documento, String email, String dataNascimento){
        String novoUsuario = this.bancoUsuarios.cadastrarUsuario(nome, documento, email, dataNascimento);
        System.out.println("\nUsuario cadastrado com sucesso!\n" + novoUsuario);
    }

    public boolean verificarExistenciaUsuario(String documento){
        return this.bancoUsuarios.buscarUsuario(documento);
    }

}
