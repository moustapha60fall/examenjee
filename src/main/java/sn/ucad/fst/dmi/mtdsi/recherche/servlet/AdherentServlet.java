package sn.ucad.fst.dmi.mtdsi.recherche.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Adherent;
import sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.AdherentHome;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AdherentServlet
 */
public class AdherentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdherentHome adherentHome;

    @Override
    public void init() throws ServletException {
        super.init();
        adherentHome = new AdherentHome(); // Initialisation de adherentHome
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdherentServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    insertAdherent(request, response);
                    break;
                case "delete":
                    deleteAdherent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateAdherent(request, response);
                    break;
                default:
                    listAdherent(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listAdherent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (adherentHome == null) {
            throw new ServletException("AdherentHome is not initialized.");
        }
        List<Adherent> adherents = adherentHome.getAllAdherents();
        request.setAttribute("listAdherent", adherents);
        request.getRequestDispatcher("adherent-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("adherent-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
        Adherent existingAdherent = adherentHome.getAdherentById(idAdherent);
        request.setAttribute("adherent", existingAdherent);
        request.getRequestDispatcher("adherent-form.jsp").forward(request, response);
    }

    private void insertAdherent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String emailetudiant = request.getParameter("emailetudiant");
        String numerocarteetudiant = request.getParameter("numerocarteetudiant");
        Adherent newAdherent = new Adherent(0, emailetudiant, numerocarteetudiant);
        adherentHome.addAdherent(newAdherent);
        response.sendRedirect("AdherentServlet?action=list");
    }

    private void updateAdherent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
        String emailetudiant = request.getParameter("emailetudiant");
        String numerocarteetudiant = request.getParameter("numerocarteetudiant");

        Adherent adherent = new Adherent();
        adherent.setIdAdherent(idAdherent);
        adherent.setEmailetudiant(emailetudiant);
        adherent.setNumerocarteetudiant(numerocarteetudiant);

        adherentHome.updateAdherent(adherent);
        response.sendRedirect("AdherentServlet?action=list");
    }

    private void deleteAdherent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idAdherentParam = request.getParameter("idAdherent");
        if (idAdherentParam != null && !idAdherentParam.isEmpty()) {
            int idAdherent = Integer.parseInt(idAdherentParam);
            adherentHome.deleteAdherent(idAdherent);
        } else {
            // Gérer le cas où idAdherent est nul ou vide
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de l'adhérent manquant ou invalide.");
            return;
        }
        response.sendRedirect("AdherentServlet?action=list");
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
