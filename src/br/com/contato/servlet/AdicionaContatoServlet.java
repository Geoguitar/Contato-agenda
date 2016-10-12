package br.com.contato.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contato.jdbc.dao.ContatoDao;
import br.com.contato.jdbc.modelo.Contato;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//busca o writer
		PrintWriter out = response.getWriter();
		
		//buscando os parâmetros no request
		String nome =  request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		//fazendo a conversão da data.
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			
		} catch (ParseException | java.text.ParseException e) {
			out.println("Erro de conversão da data !");
			return; //para a execução do método.
		}
		
		//monta um objeto contato.
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		//salva o contato.
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//imprime o nome do contato que foi adicionado.
		out.println("<html>");
		out.println("<body>");
		out.println("Contato" +" "+ contato.getNome() + " "+ "adicionado com sucesso!");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
	}
}
