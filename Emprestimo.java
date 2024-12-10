import java.time.LocalDate;


public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private int qteObras;
    private Obra[] obras;
    private String status;

    public Emprestimo(LocalDate dataEmprestimo, int qteObras, Obra[] obras, String status){
        this.setDataEmprestimo(dataEmprestimo);
        this.setDataDevolucao();
        this.setQteObras(qteObras);
        this.setObras(obras);
        this.setStatus(status);
    }

    public void setDataDevolucao() {
        this.dataDevolucao = this.dataEmprestimo.plusDays(20);
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setObras(Obra[] obras) {
        this.obras = obras;
    }
    public void setQteObras(int qteObras) {
        this.qteObras = qteObras;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }
    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }
    public Obra[] getObras() {
        return this.obras;
    }
    public int getQteObras() {
        return this.qteObras;
    }
    public String getStatus() {
        return this.status;
    }
/* 
    public float calcularTotal(){

    }

    public void devolverObras(Obra[] obrasDevolvidas, LocalDate data){

    }

    public boolean verificarMulta(){
        
    }
*/
    @Override
    public String toString() {
        return "Empréstimo:" + '\n' +
                "Data de empréstimo: " + this.getDataEmprestimo() + '\n' +
                "Data para devolução: " + this.getDataDevolucao();
    }

}
