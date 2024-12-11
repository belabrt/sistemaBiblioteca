import java.time.LocalDate;
import java.util.ArrayList;

public class BancoDeUsuarios{
    private ArrayList<Usuario> usuariosCadastrados;

    public BancoDeUsuarios(){
        this.usuariosCadastrados = new ArrayList<>();
    }
    public BancoDeUsuarios(ArrayList<Usuario> usuarios){
        this.setUsuariosCadastrados(usuarios);
    }

    public void setUsuariosCadastrados(ArrayList<Usuario> usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

    public boolean buscarUsuario (String documento){
        for (Usuario usuario : usuariosCadastrados)
            if (usuario.getDocumento().equals(documento))
                return true;
        return false;
    }

    public Usuario retornarUsuario(String documento){
        for (Usuario usuario : usuariosCadastrados)
            if (usuario.getDocumento().equals(documento))
                return usuario;
        return null;

    }

    public String cadastrarUsuario(String nome, String documento, String email, String dataNasc){
        Usuario novoUsuario = new Usuario(nome, email, documento, dataNasc, false);
        this.usuariosCadastrados.add(novoUsuario);
        return novoUsuario.toString();
    }

    public float getMultaUsuario(String documento){
        Usuario usuario = this.retornarUsuario(documento);
        if (usuario != null){
            if (usuario.getTemMulta()){
                return usuario.verificarMulta();
            }else
                return 0;
        }else
            return 0;
    }

    public Emprestimo adicionarEmprestimo(int qteObras, String[] obrasEmprestadas, String documento, String dataEmprestimo){
        Usuario usuario = this.retornarUsuario(documento);
        if (usuario != null){
            usuario.setEmprestimo(dataEmprestimo, qteObras, obrasEmprestadas, "ativo");
            return usuario.getEmprestimo();
        }
        return null;
    }

    public float atualizarEmprestimo (String documento, String[] obrasDevolvidas, String dataDevolucaoReal){
        Usuario usuario = this.retornarUsuario(documento);
        if (usuario != null){
            usuario.registrarDevolucao(obrasDevolvidas, dataDevolucaoReal);
            return usuario.verificarMulta();
        }
        else
            return 0;
    }

    public int registrarPagamento(String documento, float valor, int formaPgto){
        Usuario usuario = retornarUsuario(documento);
        if (usuario != null){
            usuario.receberPagamento(valor, formaPgto);
            return 0;
        }
        return -1;
    }

    public void atualizarMultaFinalizada (String documento){
        Usuario usuario = retornarUsuario(documento);
        if (usuario != null){
            
        }
    }
}