import java.util.Date;

public class Usuario {
    
    private String nome;
    private String email;
    private String documento;
    private String dataNascimento;
    private boolean temMulta;
    public Emprestimo emprestimo; 
    public Pagamento pgto;

    public Usuario (String nome, String email, String documento, String dataNascimento, boolean temMulta){
        this.setNome(nome);
        this.setEmail(email);
        this.setDocumento(documento);
        this.setDataNascimento(dataNascimento);
        this.setTemMulta(temMulta);
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDocumento(String documento){
        this.documento = documento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public void setTemMulta(boolean novoValor){
        this.temMulta = novoValor;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
   

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getDocumento(){
        return this.documento;
    }
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    public boolean getTemMulta(){
        return this.temMulta;
    }
    /* 
    public void receberPagamento(float valor, int formaPgto){

    }
    
    public float verificarMulta(){
        
    }

    public void registrarDevolucao(Obra obras[], Date data){
        
    }*/

    @Override
    public String toString() {
        return "Usuário:" + '\n' +
                "Nome: " + this.getNome() + '\n' +
                "Email: " + this.getEmail();
    }
}
