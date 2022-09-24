package empresa;

public class Empresa{
	public String cnpj;
	public String nome;
	public String endereco;
	public String contato;
	protected String funcionarios;
	
	public void status() { 
		System.out.println("EMPRESA");
		System.out.println("Nome empresarial: " + this.nome);
		System.out.println("CNPJ. n: " + this.cnpj);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Contato: " + this.contato);
		System.out.println("Número de funcionários: " + this.funcionarios);
	}
	
	public void contratar() {

	} 
	
	void demitir() {
		
	}
	
	void divulgarProduto() {
		
	}
	
	void venderProduto() {
		
	}
		
}
