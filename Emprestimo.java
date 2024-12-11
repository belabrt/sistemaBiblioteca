import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.zip.DataFormatException;

import javax.swing.text.DateFormatter;


public class Emprestimo {
    private String dataEmprestimo;
    private String dataParaDevolucao;
    private String dataDevolvido;
    private int qteObras;
    private String[] obras;
    private String status;

    public Emprestimo(String dataEmprestimo, int qteObras, String[] obras, String status){
        this.setDataEmprestimo(dataEmprestimo);
        this.setdataParaDevolucao();
        this.setQteObras(qteObras);
        this.setObras(obras);
        this.setStatus(status);
    }

    public void setdataParaDevolucao() {
        String[] data = this.dataEmprestimo.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        if ((mes == 01) || (mes == 03) || (mes == 05) || (mes == 07) || (mes == 8) || (mes == 10) || (mes ==12))
            if (dia <= 11)
                this.dataParaDevolucao = (dia + 20) + "/" + mes + "/" + ano;
            else
                this.dataParaDevolucao = ((dia + 20) - 31) + "/" + (mes + 1) + "/" + ano;
        else if (mes == 02){
            if (dia <= 9)
                this.dataParaDevolucao = (dia + 20) + "/" + mes + "/" + ano;
            else{
                this.dataParaDevolucao = ((dia + 20) - 29) + "/" + (mes + 1) + "/" + ano;
            }
        }
        else{
            if (dia <= 10)
                this.dataParaDevolucao = (dia + 20) + "/" + mes + "/" + ano;
            else
                this.dataParaDevolucao = ((dia + 20) - 30) + "/" + (mes + 1) + "/" + ano;
        }
        
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setObras(String[] obras) {
        this.obras = obras;
    }
    public void setQteObras(int qteObras) {
        this.qteObras = qteObras;
    }

    public void setDataDevolvido(String dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

    public String getDataDevolvido() {
        return dataDevolvido;
    }
    public String getdataParaDevolucao() {
        return this.dataParaDevolucao;
    }
    public String getDataEmprestimo() {
        return this.dataEmprestimo;
    }
    public String[] getObras() {
        return this.obras;
    }
    public int getQteObras() {
        return this.qteObras;
    }
    public String getStatus() {
        return this.status;
    }
    public float calcularTotal(){
        if (temAtraso()){
            int diasAtrasados = 0;
            String[] dataDevolvido = this.dataDevolvido.split("/");
            int diaDevolvido = Integer.parseInt(dataDevolvido[0]);
            int mesDevolvido = Integer.parseInt(dataDevolvido[1]);
            int anoDevolvido = Integer.parseInt(dataDevolvido[2]);

            String[] prazoDevolucao = this.dataParaDevolucao.split("/");
            int diaPrazo = Integer.parseInt(prazoDevolucao[0]);
            int mesPrazo = Integer.parseInt(prazoDevolucao[1]);
            int anoPrazo = Integer.parseInt(prazoDevolucao[2]);

            if (mesDevolvido > mesPrazo){
                if ((mesPrazo == 01) || (mesPrazo == 03) || (mesPrazo == 05) || (mesPrazo == 07) || (mesPrazo == 8) || (mesPrazo == 10) || (mesPrazo ==12))
                    diasAtrasados = (31 - diaPrazo) + diaDevolvido;
                else if (mesPrazo == 02)
                    diasAtrasados = (29 - diaPrazo) + diaDevolvido;
                else 
                    diasAtrasados = (30 - diaPrazo) + diaDevolvido;
            }
            else if (mesDevolvido == mesPrazo) 
                diasAtrasados = diaDevolvido - diaPrazo;
            return diasAtrasados * 10;
        }else{
            return 0;
        }
    }

    public void devolverObras(String[] obrasDevolvidas, String data){
        this.setDataDevolvido(data);
        this.setStatus("finalizado");
    }

    public boolean temAtraso(){
        if (this.dataDevolvido == null) 
            return false;
        else{
            String[] dataDevolvido = this.dataDevolvido.split("/");
            int diaDevolvido = Integer.parseInt(dataDevolvido[0]);
            int mesDevolvido = Integer.parseInt(dataDevolvido[1]);
            int anoDevolvido = Integer.parseInt(dataDevolvido[2]);

            String[] prazoDevolucao = this.dataParaDevolucao.split("/");
            int diaPrazo = Integer.parseInt(prazoDevolucao[0]);
            int mesPrazo = Integer.parseInt(prazoDevolucao[1]);
            int anoPrazo = Integer.parseInt(prazoDevolucao[2]);

            if (mesDevolvido < mesPrazo)
                return false;
            else if (mesDevolvido > mesPrazo)
                return true;
            else if (mesDevolvido == mesPrazo) {
                if (diaDevolvido <= diaPrazo)
                    return false;
                else
                    return true;
            }
            return false;
        }
          
    }
    

    @Override
    public String toString() {
        return "Empréstimo:" + '\n' +
                "Data de empréstimo: " + this.getDataEmprestimo() + '\n' +
                "Data para devolução: " + this.getdataParaDevolucao();
    }
}


