package empresa;

public class Pedido {
	protected int ID_Pedido;
	protected int numeroPedido;
	
	public void status() {
		System.out.println("PEDIDO");
		System.out.println("Identificador n.: " + this.ID_Pedido);
		System.out.println("Número do pedido: " + this.numeroPedido);
		
	}
	
	void organizarPedido() {
		
	} 
	
	void registrarPedido() {
		
	}

}
