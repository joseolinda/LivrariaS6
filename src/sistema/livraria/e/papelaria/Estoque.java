package sistema.livraria.e.papelaria;

/**
 *
 * @author Usuario
 */
public class Estoque {
    // atributos
    int quantidade;
    String produto_nome;
    int produto_codigo;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String nome) {
        this.produto_nome = produto_nome;
    }

    public int getProduto_codigo() {
        return produto_codigo;
    }

    public void setProduto_codigo(int produto_codigo) {
        this.produto_codigo = produto_codigo;
    }
    // construtor
    public Estoque(int produto_codigo, String produto_nome, int quantidade) {
        this.produto_codigo = produto_codigo;
        this.produto_nome = produto_nome;
        this.quantidade = quantidade;
    }
    // métodos da classe
    
    public void AddProduto (Produto Produto){
    
}
    
    public void RemoverProduto (Produto Produto){
}
}

