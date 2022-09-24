package empresa;

public class empresaPrincipal {

	public static void main(String[] args) {
		Empresa e1 = new Empresa();
		e1.nome = "Truurismo/LTDA.";
		e1.cnpj = "66.666.666/6666-66.";
		e1.endereco = "Av. Principal do Inferno, n. 666.";
		e1.contato = "(66)6.6666-6666.";
		e1.funcionarios = "1";
		e1.status();
		e1.contratar();
		e1.demitir();
		e1.divulgarProduto();
		e1.venderProduto();
		
		Vendedor v1 = new Vendedor();
		v1.matricula = 666;
		v1.nome = "Tio Lu";
		v1.ID_Vendedor = 1;
		v1.status();
		v1.cadastrarPedido();
		v1.divulgarProduto();
		v1.venderProduto();
		
		Cliente c1 = new Cliente();
		c1.ID_Cliente = 999;
		c1.nome = "Truzao";
		c1.contato = "fromhell@hellmail.com";
		c1.endereco = "Rua Gêiser Flamejante, n.999.";
		c1.status();
		c1.contatar();
		c1.comprar();
		
		Pedido p1 = new Pedido();
		p1.ID_Pedido = 666;
		p1.numeroPedido = 999;
		p1.status();
		p1.organizarPedido();
		p1.registrarPedido();
		
		Produto p2 = new Produto();
		p2.ID_Produto = 667;
		p2.destino = "Clisson France.";
		p2.promocao = "HellFest 2023. ";
		p2.status();
		p2.compraDestino();
		p2.compraPromocao();
		
		
	
	}
}

