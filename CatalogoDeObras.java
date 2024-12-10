import java.util.ArrayList;

public class CatalogoDeObras{
    private ArrayList<Obra> obrasCadastradas;

    public CatalogoDeObras(){}
    public CatalogoDeObras(ArrayList<Obra> obras){
        this.setObrasCadastradas(obras);
    }

    public void setObrasCadastradas(ArrayList<Obra> obrasCadastradas) {
        this.obrasCadastradas = obrasCadastradas;
    }

    public ArrayList<Obra> getObrasCadastradas() {
        return obrasCadastradas;
    }

    //public Obra pesquisarObra(int tipo, int opcao, String[] dados){

    //}

    public void mudarStatusObras(String[] obras, boolean disponivel){

    }

    public void criarObra(int tipo, int qte){

    }

}