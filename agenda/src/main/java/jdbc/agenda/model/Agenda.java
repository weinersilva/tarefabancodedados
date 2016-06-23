package jdbc.agenda.model;

import java.io.Serializable;

public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String datanascimento;
	private String telefone;
	private String email;
	
	public Agenda(){
		
	}
	
	public Agenda(int id){
		super();
		this.id=id;
	}
	
	public Agenda(int id, String nome){
		super();
		this.id = id;
		this.nome=nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "Agenda [id=" + id +", nome=" +nome+", datanascimento=" +datanascimento+", telefone="+telefone+", email="+email+"]";
	}

}
