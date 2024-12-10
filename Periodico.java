public class Periodico extends Obra{
    
    private int volume;
    private int ano;
    private int mes;

    public Periodico (boolean disponivel, int qteExistentes, int qteDisponiveis, String titulo, int volume, int ano, int mes){
        super(disponivel, qteExistentes, qteDisponiveis, titulo);
        this.setAno(ano);
        this.setMes(mes);
        this.setVolume(volume);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }
    public int getMes() {
        return mes;
    }
    public int getVolume() {
        return volume;
    }
}
