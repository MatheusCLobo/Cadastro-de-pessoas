import java.util.Scanner;

public class Main {
    private static ProdutoControle controle = new ProdutoControle();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Pesquisar produto");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("5 - Listar todos os produtos");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarProduto() {
        System.out.println("Cadastro de Produto:");
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Unidade de Medida (metro, metro quadrado, litro, kg): ");
        String unidadeDeMedida = scanner.nextLine();

        Produto produto = new Produto(tipo, descricao, peso, quantidade, unidadeDeMedida);
        controle.cadastrarProduto(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void pesquisarProduto() {
        System.out.print("Digite a descrição do produto a ser pesquisado: ");
        String descricao = scanner.nextLine();
        Produto produto = controle.pesquisarProduto(descricao);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void alterarProduto() {
        System.out.print("Digite a descrição do produto a ser alterado: ");
        String descricao = scanner.nextLine();
        System.out.println("Novos dados do Produto:");
        System.out.print("Novo Tipo: ");
        String novoTipo = scanner.nextLine();
        System.out.print("Nova Descrição: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Novo Peso (kg): ");
        double novoPeso = scanner.nextDouble();
        System.out.print("Nova Quantidade: ");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Nova Unidade de Medida (metro, metro quadrado, litro, kg): ");
        String novaUnidadeDeMedida = scanner.nextLine();

        Produto novoProduto = new Produto(novoTipo, novaDescricao, novoPeso, novaQuantidade, novaUnidadeDeMedida);
        if (controle.alterarProduto(descricao, novoProduto)) {
            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void excluirProduto() {
        System.out.print("Digite a descrição do produto a ser excluído: ");
        String descricao = scanner.nextLine();
        if (controle.excluirProduto(descricao)) {
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listarProdutos() {
        System.out.println("Lista de Produtos:");
        for (Produto produto : controle.listarProdutos()) {
            System.out.println(produto);
        }
    }
}
