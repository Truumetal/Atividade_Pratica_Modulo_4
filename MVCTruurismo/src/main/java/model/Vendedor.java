package empresa;

public class Vendedor {
	protected int ID_Vendedor;
	protected int matricula;
	public String nome;

	public int getIdVendedor() {
		return ID_Vendedor;
		}

	public void setIdVendedor(int id) {
		this.ID_Vendedor = id;
		}

	public int getMatricula() {
			return matricula; 
			}

	public void setMatricula(int matricula) {
			this.matricula = matricula;
			}

	public String getNome() {
				return nome; 
				}

	public void setNome(String nome) {
				this.nome = nome;
				}

	public void status() {
		System.out.println("VENDEDOR");
		System.out.println("Nome do Funcionário: " + this.nome);
		System.out.println("Matrícula n.: " + this.matricula);
		System.out.println("Identificador n.: " + this.ID_Vendedor);
	}

	public void divulgarProduto() {

	}

	public void cadastrarPedido() {

	}

	public void venderProduto() {

	}

}
