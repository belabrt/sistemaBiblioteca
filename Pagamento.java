public class Pagamento {
    private float valor;
    private int formaPgto;

    public Pagamento (float valor, int formaPgto){
        this.setFormaPgto(formaPgto);
        this.setValor(valor);
    }

    public void setFormaPgto(int formaPgto) {
        this.formaPgto = formaPgto;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getFormaPgto() {
        return formaPgto;
    }
    public float getValor() {
        return valor;
    }
}
