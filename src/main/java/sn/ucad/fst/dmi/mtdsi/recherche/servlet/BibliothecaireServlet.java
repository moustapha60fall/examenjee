package sn.ucad.fst.dmi.mtdsi.recherche.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Bibliothecaire;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.BibliothecaireHome;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BibliothecaireServlet
 */
public class BibliothecaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BibliothecaireHome bibliothecaireHome;

    @Override
    public void init() throws ServletException {
        super.init();
        bibliothecaireHome = new BibliothecaireHome(); // Initialisation de bibliothecaireHome
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliothecaireServlet() {
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
                    insertBibliothecaire(request, response);
                    break;
                case "delete":
                    deleteBibliothecaire(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateBibliothecaire(request, response);
                    break;
                default:
                    listBibliothecaire(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listBibliothecaire(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Bibliothecaire> bibliothecaires = bibliothecaireHome.getAllBibliothecaires();
        request.setAttribute("listBibliothecaire", bibliothecaires);
        request.getRequestDispatcher("bibliothecaire-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("bibliothecaire-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBibliothecaire = Integer.parseInt(request.getParameter("idBibliothecaire"));
        Bibliothecaire existingBibliothecaire = bibliothecaireHome.getBibliothecaireById(idBibliothecaire);
        request.setAttribute("bibliothecaire", existingBibliothecaire);
        request.getRequestDispatcher("bibliothecaire-form.jsp").forward(request, response);
    }

    private void insertBibliothecaire(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        Bibliothecaire newBibliothecaire = new Bibliothecaire(nom, prenom, email, telephone);
        bibliothecaireHome.addBibliothecaire(newBibliothecaire);
        response.sendRedirect("BibliothecaireServlet?action=list");
    }

    private void updateBibliothecaire(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idBibliothecaire = Integer.parseInt(request.getParameter("idBibliothecaire"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

        Bibliothecaire bibliothecaire = new Bibliothecaire();
        bibliothecaire.setIdBibliothecaire(idBibliothecaire);
        bibliothecaire.setNom(nom);
        bibliothecaire.setPrenom(prenom);
        bibliothecaire.setEmail(email);
        bibliothecaire.setTelephone(telephone);

        bibliothecaireHome.updateBibliothecaire(bibliothecaire);
        response.sendRedirect("BibliothecaireServlet?action=list");
    }

    private void deleteBibliothecaire(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idBibliothecaireParam = request.getParameter("idBibliothecaire");
        if (idBibliothecaireParam != null && !idBibliothecaireParam.isEmpty()) {
            int idBibliothecaire = Integer.parseInt(idBibliothecaireParam);
            bibliothecaireHome.deleteBibliothecaire(idBibliothecaire);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID du bibliothécaire manquant ou invalide.");
            return;
        }
        response.sendRedirect("BibliothecaireServlet?action=list");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
