package jdbc.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.agenda.model.Agenda;

public class AgendaDAO extends DAO{
	
	public void alterar(Agenda agenda){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstmt = conexao.prepareStatement("Update agenda SET nome = ?, datanascimento = ?, telefone = ?, email = ?" + " WHERE id = ? ");
			pstmt.setString(1, agenda.getNome());
			pstmt.setString(2, agenda.getDatanascimento());
			pstmt.setString(3, agenda.getTelefone());
			pstmt.setString(4, agenda.getEmail());
			pstmt.setInt(5, agenda.getId());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluir (Agenda agenda){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstmt = conexao.prepareStatement("Delete from agenda where id = ? ");
			pstmt.setInt(1, agenda.getId());
			pstmt.execute();
			pstmt.close();
			conexao.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void inserir (Agenda agenda){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstmt = conexao.prepareStatement("Insert into agenda (id, nome, datanascimento, telefone, email) values(?,?,?,?,?)");
			pstmt.setInt(1, agenda.getId());
			pstmt.setString(2, agenda.getNome());
			pstmt.setString(3, agenda.getDatanascimento());
			pstmt.setString(4, agenda.getTelefone());
			pstmt.setString(5, agenda.getEmail());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean existe(Agenda agenda){
		boolean achou = false;
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from agenda where id =	?");
			pstm.setInt(1, agenda.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
		
	}
	
	public Agenda consultar (Agenda agenda){
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Select * from agenda where id =	?");
			pstm.setInt(1, agenda.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				agenda.setId(rs.getInt("id"));
				agenda.setNome(rs.getString("nome"));
				agenda.setDatanascimento(rs.getString("datanascimento"));
				agenda.setTelefone(rs.getString("telefone"));
				agenda.setEmail(rs.getString("email"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agenda;
	}
	
	public List<Agenda> listar(){
		List<Agenda> lista = new ArrayList<>();
		try{
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from agenda");
			while(rs.next()){
				Agenda agenda = new Agenda();
				agenda.setId(rs.getInt("id"));
				agenda.setNome(rs.getString("nome"));
				agenda.setDatanascimento(rs.getString("datanascimento"));
				agenda.setTelefone(rs.getString("telefone"));
				agenda.setEmail(rs.getString("email"));
				lista.add(agenda);
			}
			stm.close();
			conexao.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}

}
