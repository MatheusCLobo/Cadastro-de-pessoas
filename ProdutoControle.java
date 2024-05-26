import java.util.ArrayList;
import java.util.List;

public class ProdutoControle {
    private List<Produto> produtos;

    public ProdutoControle() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto pesquisarProduto(String descricao) {
        for (Produto produto : produtos) {
            if (produto.getDescricao().equalsIgnoreCase(descricao)) {
                return produto;
            }
        }
        return null;
    }

    public boolean alterarProduto(String descricao, Produto novoProduto) {
        Produto produto = pesquisarProduto(descricao);
        if (produto != null) {
            produto.setTipo(novoProduto.getTipo());
            produto.setDescricao(novoProduto.getDescricao());
            produto.setPeso(novoProduto.getPeso());
            produto.setQuantidade(novoProduto.getQuantidade());
            produto.setUnidadeDeMedida(novoProduto.getUnidadeDeMedida());
            return true;
        }
        return false;
    }

    public boolean excluirProduto(String descricao) {
        Produto produto = pesquisarProduto(descricao);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }
}
