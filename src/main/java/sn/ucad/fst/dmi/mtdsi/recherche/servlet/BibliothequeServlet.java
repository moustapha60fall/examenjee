package sn.ucad.fst.dmi.mtdsi.recherche.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Bibliotheque;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.BibliothequeHome;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BibliothequeServlet
 */
public class BibliothequeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BibliothequeHome bibliothequeHome;

    @Override
    public void init() throws ServletException {
        super.init();
        bibliothequeHome = new BibliothequeHome(); // Initialisation de bibliothequeHome
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliothequeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertBibliotheque(request, response);
                    break;
                case "delete":
                    deleteBibliotheque(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateBibliotheque(request, response);
                    break;
                default:
                    listBibliotheque(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listBibliotheque(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Bibliotheque> bibliotheques = bibliothequeHome.getAllBibliotheques();
        request.setAttribute("listBibliotheque", bibliotheques);
        request.getRequestDispatcher("bibliotheque-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("bibliotheque-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBibliotheque = Integer.parseInt(request.getParameter("idBibliotheque"));
        Bibliotheque existingBibliotheque = bibliothequeHome.getBibliothequeById(idBibliotheque);
        request.setAttribute("bibliotheque", existingBibliotheque);
        request.getRequestDispatcher("bibliotheque-form.jsp").forward(request, response);
    }

    private void insertBibliotheque(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idPret = Integer.parseInt(request.getParameter("idPret"));
        int idBibliothecaire = Integer.parseInt(request.getParameter("idBibliothecaire"));
        int idDocument = Integer.parseInt(request.getParameter("idDocument"));
        String nombu = request.getParameter("nombu");
        String emailbu = request.getParameter("emailbu");

        Bibliotheque newBibliotheque = new Bibliotheque(idPret, idBibliothecaire, idDocument, nombu, emailbu);
        bibliothequeHome.addBibliotheque(newBibliotheque);
        response.sendRedirect("BibliothequeServlet?action=list");
    }

    private void updateBibliotheque(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idBibliotheque = Integer.parseInt(request.getParameter("idBibliotheque"));
        int idPret = Integer.parseInt(request.getParameter("idPret"));
        int idBibliothecaire = Integer.parseInt(request.getParameter("idBibliothecaire"));
        int idDocument = Integer.parseInt(request.getParameter("idDocument"));
        String nombu = request.getParameter("nombu");
        String emailbu = request.getParameter("emailbu");

        Bibliotheque bibliotheque = new Bibliotheque(idPret, idBibliothecaire, idDocument, nombu, emailbu);
        bibliotheque.setIdBibliotheque(idBibliotheque);

        bibliothequeHome.updateBibliotheque(bibliotheque);
        response.sendRedirect("BibliothequeServlet?action=list");
    }

    private void deleteBibliotheque(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idBibliothequeParam = request.getParameter("idBibliotheque");
        if (idBibliothequeParam != null && !idBibliothequeParam.isEmpty()) {
            int idBibliotheque = Integer.parseInt(idBibliothequeParam);
            bibliothequeHome.deleteBibliotheque(idBibliotheque);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de la bibliothèque manquant ou invalide.");
            return;
        }
        response.sendRedirect("BibliothequeServlet?action=list");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
