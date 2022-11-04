
import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context = super.getServletContext();
		String catalogFileName = context.getInitParameter("catalogFileName");
		InputStream is = null;
		BufferedReader catReader = null;
		try {
			is = context.getResourceAsStream(catalogFileName);
			catReader = new BufferedReader(new InputStreamReader(is,"utf-8"));
			String ProductString;
			ArrayList<Product> catalog = new ArrayList<>();
			while ((ProductString = catReader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(ProductString, "|");
				String code = tokens.nextToken();
				String price = tokens.nextToken();
				String quantityStr = tokens.nextToken();
				int quantity = Integer.parseInt(quantityStr);
				String description = tokens.nextToken();
				Product p = new Product(code, price, quantity, description);
				catalog.add(p);
			}
			context.setAttribute("catalog", catalog);
			context.log("The product list was initialized.");
			response.getWriter().append("Catalog Data created in application Var...");
		} catch (Exception e) {
			context.log("Parsing catalog.txt error!");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (catReader != null) {
				try {
					catReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
