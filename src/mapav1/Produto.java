package mapav1;

public class Produto {
    
    private String nome;
    private String unMedida;
    private double preco;
    private double qntEstoque;

    public Produto(String nome, String unMedida, double preco, double qntEstoque){
        this.nome=nome;
        this.unMedida=unMedida;
        this.preco=preco;
        this.qntEstoque=qntEstoque;
    }
    public Produto(){
        
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUnMedida() {
        return unMedida;
    }
    public void setUnMedida(String unMedida) {
        this.unMedida = unMedida;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getQntEstoque() {
        return qntEstoque;
    }
    public void setQntEstoque(double qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
    
    
   public void imprime(){
       System.out.println("\nProduto: " + this.nome + "\n" +
                "Unidade: " + this.unMedida+ "\n" +
                "Estoque: " + this.qntEstoque + "\n" +
                "Preço: " + this.preco + "\n");
   }
    @Override
    public String toString(){
        return "Produto: " + this.nome + "\n" +
                "Unidade: " + this.unMedida+ "\n" +
                "Estoque: " + this.qntEstoque + "\n" +
                "Preço: " + this.preco;
    }
}
