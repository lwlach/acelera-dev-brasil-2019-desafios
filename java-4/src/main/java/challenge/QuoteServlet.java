package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/v1/quote/*"})
public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Quote quote;
			String path = req.getPathInfo();
			if (path == null || path.equals("/")) {
				quote = new QuoteDao().getQuote();
			} else {
				quote = new QuoteDao().getQuoteByActor(path.split("/")[1]);
			}
			resp.getWriter().print(quote.toJson());
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
