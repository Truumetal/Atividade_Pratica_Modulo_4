package empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Vendedor vendedor) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO vendedor(ID_Funcionario,Nome,Matricula)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, vendedor.getIdVendedor());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, vendedor.getNome());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setInt(3, vendedor.getMatricula());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM contato WHERE ID_Funcionario = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Vendedor vendedor) {

		String sql = "UPDATE contato SET ID_Funcionario = ?, Nome = ?, Matricula = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, vendedor.getIdVendedor());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, vendedor.getNome());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setInt(3, vendedor.getMatricula());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Vendedor> getVendedores() {

		String sql = "SELECT * FROM vendedor";

		List<Vendedor> vendedores = new ArrayList<Vendedor>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Vendedor vendedor = new Vendedor();

				// Recupera o id do banco e atribui ele ao objeto
				vendedor.setIdVendedor(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				vendedor.setNome(rset.getString("Nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				vendedor.setMatricula(rset.getInt("Matricula"));
				
				// Adiciono o contato recuperado, a lista de contatos
				vendedores.add(vendedor);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return vendedores;
	}

	public Vendedor getVendedorById(int id) {

		String sql = "SELECT * FROM vendedor where id = ?";
		Vendedor vendedor = new Vendedor();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			vendedor.setIdVendedor(rset.getInt("Id"));
			vendedor.setNome(rset.getString("Nome"));
			vendedor.setMatricula(rset.getInt("Matricula"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vendedor;
	}

}
