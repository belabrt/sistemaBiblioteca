import java.util.ArrayList;

public class CatalogoDeObras{
    private ArrayList<Livro> livrosCadastrados;
    private ArrayList<Periodico> periodicosCadastrados;

    public CatalogoDeObras(){
        this.livrosCadastrados = new ArrayList<Livro>();
        this.periodicosCadastrados = new ArrayList<Periodico>();
    }
    public CatalogoDeObras(ArrayList<Livro> livros, ArrayList<Periodico> periodicos){
        this.setLivrosCadastrados(livros);
        this.setPeriodicosCadastrados(periodicos);
    }

    public void setLivrosCadastrados(ArrayList<Livro> livrosCadastrados) {
        this.livrosCadastrados = livrosCadastrados;
    }

    public void setPeriodicosCadastrados(ArrayList<Periodico> periodicosCadastrados) {
        this.periodicosCadastrados = periodicosCadastrados;
    }

    public ArrayList<Livro> getLivrosCadastrados() {
        return livrosCadastrados;
    }

    public Obra pesquisarObra(int tipo, int opcao, String[] dados){
        if (!(livrosCadastrados.isEmpty())){
            if (tipo == 1){
                if (opcao == 1){
                    for (Livro livro : livrosCadastrados)
                        if (livro.getTitulo().equals(dados[0]))
                            return livro;
                }else{
                    for (Livro livro : livrosCadastrados)
                        if (livro.getAutor().equals(dados[0]))
                            return livro;
                }
            }else{
                if (opcao == 1){
                    for (Periodico periodico : periodicosCadastrados)
                        if (periodico.getTitulo().equals(dados[0]))
                            return periodico;
                }else{
                    int anoProcurado = Integer.parseInt(dados[1]);
                    for (Periodico periodico : periodicosCadastrados)
                        if (periodico.getTitulo().equals(dados[0]) && (periodico.getAno() == anoProcurado))
                            return periodico;
                } 
            }
            return null;
        }
        return null;
    }

    public void mudarStatusObras(String[] obras, boolean disponivel){
        for (int i = 0; i < obras.length; i++){
            for (Livro livro : livrosCadastrados)
                if (livro.getTitulo().equals(obras[i])){
                    if (!disponivel){
                        livro.setQteDisponiveis(livro.getQteDisponiveis() - 1);
                        livro.setDisponivel();
                    }else{
                        livro.setQteDisponiveis(livro.getQteDisponiveis() + 1);
                        livro.setDisponivel();
                    }
                }
            for (Periodico periodico : periodicosCadastrados)
                if (periodico.getTitulo().equals(obras[i])){
                    if (!disponivel){
                        periodico.setQteDisponiveis(periodico.getQteDisponiveis() - 1);
                        periodico.setDisponivel();
                    }else{
                        periodico.setQteDisponiveis(periodico.getQteDisponiveis() + 1);
                        periodico.setDisponivel();
                    }
                }
        }
    }

    public Obra criarObraLivro(int qte, String titulo, String autor, int ano, String editora){
        String[] dados = new String[2];
        dados[0] = titulo;
        Livro novoLivro = (Livro) pesquisarObra(1, 1, dados);
        if (novoLivro == null){
            novoLivro = new Livro( qte, qte, titulo, autor, editora, ano);
            this.livrosCadastrados.add(novoLivro);
        }else{
            if (novoLivro.getQteExistentes() < qte)
                novoLivro.setQteExistentes(novoLivro.getQteExistentes() + qte);
        }
        return novoLivro;
    }

    public Obra criarObraPeriodico(int qte, String titulo, int mes, int ano, int volume){
        String[] dados = new String[2];
        dados[0] = titulo;
        dados[1] = Integer.toString(ano);
        Periodico novoPeriodico = (Periodico) pesquisarObra(2, 2, dados);
        if (novoPeriodico == null){
            novoPeriodico = new Periodico( qte, qte, titulo, volume, ano, mes);
            this.periodicosCadastrados.add(novoPeriodico);
        }else{
            if (novoPeriodico.getQteExistentes() < qte)
                novoPeriodico.setQteExistentes(novoPeriodico.getQteExistentes() + qte);
        }
        return novoPeriodico;
    }

}