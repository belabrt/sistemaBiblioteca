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

    public String cadastrarUsuario(String nome, String documento, String email, String dataNasc){
        Usuario novoUsuario = new Usuario(nome, email, documento, dataNasc, false);
        this.usuariosCadastrados.add(novoUsuario);
        return novoUsuario.toString();
    }
}