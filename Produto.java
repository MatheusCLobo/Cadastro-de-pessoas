public class Produto {
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private String unidadeDeMedida;

    public Produto(String tipo, String descricao, double peso, int quantidade, String unidadeDeMedida) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        setUnidadeDeMedida(unidadeDeMedida);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        if (unidadeDeMedida.equals("metro") || unidadeDeMedida.equals("metro quadrado") || 
            unidadeDeMedida.equals("litro") || unidadeDeMedida.equals("kg")) {
            this.unidadeDeMedida = unidadeDeMedida;
        } else {
            throw new IllegalArgumentException("Unidade de medida inválida.");
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", quantidade=" + quantidade +
                ", unidadeDeMedida='" + unidadeDeMedida + '\'' +
                '}';
    }
}
