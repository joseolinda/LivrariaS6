package sistema.livraria.e.papelaria;

/**
 *
 * @author Usuario
 */
public class Produto {
    
    //atributos da classe
    String id;
    float preço_da_compra;
    String marca;
    int quantidade_em_estoque;
    String setor;
    String nome;

    public Produto() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    // getter e setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    public double getPreço_da_compra() {
        return preço_da_compra;
    }

    public void setPreço_da_compra(float preço_da_compra) {
        this.preço_da_compra = preço_da_compra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade_em_estoque() {
        return quantidade_em_estoque;
    }

    public void setQuantidade_em_estoque(int quantidade_em_estoque) {
        this.quantidade_em_estoque = quantidade_em_estoque;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //construtor 
    public Produto(String nome, double preço_da_compra, int quantidade_em_estoque){
	this.nome = nome;
	this.preço_da_compra = (float) preço_da_compra;
	this.quantidade_em_estoque = quantidade_em_estoque;
	}
    
    // métodos da classe
    public void vende(int quantidade){
	if(this.quantidade_em_estoque == quantidade){
		this.quantidade_em_estoque-=quantidade;
	}
        else{
        System.out.println("Quantidade requerida indisponivel no estoque");
        }
    
}
    public double definePrecoDeVenda(double porcentagem){
	return preço_da_compra += preço_da_compra*(porcentagem/100.0);
	}

    public void setPreço_da_compra(double aDouble) {
        this.preço_da_compra = (float) aDouble;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
