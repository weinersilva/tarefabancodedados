package jdbc.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.agenda.dao.AgendaDAO;
import jdbc.agenda.model.Agenda;

@WebServlet("/agenda")
public class AgendaServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AgendaServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		
		List<Agenda> lista = new ArrayList<>();
		
		Agenda agenda = new Agenda();
		AgendaDAO dao = new AgendaDAO();

		
		try{
			if (!acao.equalsIgnoreCase("Listar")) {
				agenda.setId(Integer.parseInt(request.getParameter("id")));
				agenda.setNome(request.getParameter("nome"));
				agenda.setDatanascimento(request.getParameter("datanascimento"));
				agenda.setTelefone(request.getParameter("telefone"));
				agenda.setEmail(request.getParameter("email"));
			}
 
			if (acao.equalsIgnoreCase("Incluir")) {
				if (dao.existe(agenda)) {
					mensagem = "Id já existe!";
				} else {
					dao.inserir(agenda);
				}
			} else if (acao.equalsIgnoreCase("Alterar")) {
				dao.alterar(agenda);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(agenda);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("agenda", agenda);
				agenda = dao.consultar(agenda);
				destino = "agendaView.jsp";
			}
		}catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
		if (mensagem.length() == 0) {
			mensagem = "Contato Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("listaagenda", lista);
		request.setAttribute("mensagem", mensagem);
 
 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
		
	}

}
