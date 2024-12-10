public abstract class Obra {

    protected String titulo;
    protected boolean disponivel;
    protected int qteExistentes;
    protected int qteDisponiveis;

    public Obra(boolean disponivel, int qteExistentes, int qteDisponiveis, String titulo){
        this.setDisponivel(disponivel);
        this.setQteExistentes(qteExistentes);
        this.setQteDisponiveis(qteDisponiveis);
        this.setTitulo(titulo);
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public void setQteExistentes(int qteExistentes) {
        this.qteExistentes = qteExistentes;
    }
    public void setQteDisponiveis(int qteDisponiveis) {
        this.qteDisponiveis = qteDisponiveis;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
    public int getQteDisponiveis() {
        return qteDisponiveis;
    }
    public int getQteExistentes() {
        return qteExistentes;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

}
