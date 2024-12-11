import java.time.LocalDate;
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
    public void setEmprestimo(String dataEmprestimo, int qteObras, String[] obras, String status) {
        this.emprestimo = new Emprestimo(dataEmprestimo, qteObras, obras, status);
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
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    
    public void receberPagamento(float valor, int formaPgto){
        this.pgto = new Pagamento(valor, formaPgto);
        emprestimo.setStatus("finalizado");
        this.setTemMulta(false);
        emprestimo.setDataDevolvido(null);
    }
    
    public float verificarMulta(){
        if (emprestimo.temAtraso()){
            this.setTemMulta(true);
            return emprestimo.calcularTotal();
        }
        else
            return 0;
        
    }

    public void registrarDevolucao(String[] obras, String data){
        if (emprestimo.getStatus() == "ativo"){
            emprestimo.devolverObras(obras, data);
        }
    }

    @Override
    public String toString() {
        return "Usuário:" + '\n' +
                "Nome: " + this.getNome() + '\n' +
                "Email: " + this.getEmail();
    }
}
