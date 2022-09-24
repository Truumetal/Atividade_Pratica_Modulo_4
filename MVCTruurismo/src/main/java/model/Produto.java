package empresa;

public class Produto {
	protected int ID_Produto;
	protected String destino;
	protected String promocao;
	
	public void status() {
		System.out.println("PRODUTO");
		System.out.println("Identificador n.: " + this.ID_Produto);
		System.out.println("Digite o destino desejado: " + this.destino);
		System.out.println("Digite a promoção desejada: " + this.promocao);
		
	}
	
	void compraDestino() {
		
	}
	
	void compraPromocao() {
		
	}

}
