package truurismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO usuario(nome, email, senha)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, usuario.getEmail());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, usuario.getSenha());

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

		String sql = "DELETE FROM usuario WHERE Id = ?";

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

	public void update(Usuario usuario) {

		String sql = "UPDATE usuario SET Nome = ?,  email = ?, senha = ? WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, usuario.getEmail());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, usuario.getSenha());
			// Executa a sql para inserção dos dados
			
			pstm.setInt(4, usuario.getId());
			
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

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNome(rset.getString("nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("email"));
				
				usuario.setSenha(rset.getString("senha"));
				
				// Adiciono o contato recuperado, a lista de contatos
				usuarios.add(usuario);
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

		return usuarios;
	}

	public Usuario getUsuarioById(int id) {

		String sql = "SELECT * FROM usuario where id = ?";
		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			usuario.setId(rset.getInt("id"));

			// Recupera o nome do banco e atribui ele ao objeto
			usuario.setNome(rset.getString("Nome"));

			// Recupera a idade do banco e atribui ele ao objeto
			usuario.setEmail(rset.getString("Email"));
			
			usuario.setSenha(rset.getString("Senha"));

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
		return usuario;
	}

	
}
