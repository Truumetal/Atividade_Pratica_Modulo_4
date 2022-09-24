package empresa;

public class Cliente {
	protected int ID_Cliente;
	protected String nome;
	protected String contato;
	protected String endereco;
	
	public void status() {
		System.out.println("CLIENTE");
		System.out.println("Nome do Cliente: " + this.nome);
		System.out.println("Contato: " + this.contato);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("Identificador n.: " + this.ID_Cliente);
	}
	
	void contatar() {
		
	}
	
	void comprar() {
		
	}

}
