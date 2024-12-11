public class Livro extends Obra{
    private String autor;
    private String editora;
    private int anoPublicacao;

    public Livro( int qteExistentes, int qteDisponiveis, String titulo, String autor, String editora, int anoPublicacao){
        super( qteExistentes, qteDisponiveis, titulo);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setAnoPublicacao(anoPublicacao);
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
}
