package challenge;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDao {

	public Quote getQuote() throws SQLException {
		String sql = "SELECT actor, detail FROM scripts " +
				" WHERE \"actor\" IS NOT NULL ORDER BY RANDOM() LIMIT 1";
		Quote quote = null;
		try (Connection conn = ConnectionFactory.createConnection();
			 Statement stmt  = conn.createStatement();
			 ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				quote = new Quote(rs.getString(1), rs.getString(2));
//				System.out.println(quote.toJson());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		String sql = "SELECT actor, detail FROM scripts " +
				" WHERE \"actor\" IS '" + actor + "' ORDER BY RANDOM() LIMIT 1";
		Quote quote = null;
		try (Connection conn = ConnectionFactory.createConnection();
			 Statement stmt  = conn.createStatement();
			 ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {
				quote = new Quote(rs.getString(1), rs.getString(2));
				System.out.println(quote.toJson());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return quote;
	}

}
