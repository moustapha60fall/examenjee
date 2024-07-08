package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sn.ucad.fst.dmi.mtdsi.recherche.util.HibernateUtil;


/**
 * Home object for domain model class Adherent.
 * @see sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Adherent
 * @author Hibernate Tools
 */
public class AdherentHome {
	
    private static final Logger logger = Logger.getLogger(AdherentHome.class.getName());


    public void addAdherent(Adherent adherent) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.persist(adherent);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void deleteAdherent(int idAdherent) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            Adherent adherent = session.find(Adherent.class, idAdherent);
            if (adherent != null) {
                session.remove(adherent);
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void updateAdherent(Adherent adherent) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.merge(adherent);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<Adherent> getAllAdherents() {
        List<Adherent> adherents = new ArrayList<>();
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query<Adherent> query = session.createQuery("from Adherent", Adherent.class);
            adherents = query.list();
            session.getTransaction().commit();
            logger.log(Level.INFO, "Fetched {0} adherents from the database.", adherents.size());
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            logger.log(Level.SEVERE, "Error fetching adherents", e);
        } finally {
            HibernateUtil.closeSession();
        }
        return adherents;
    }


    public Adherent getAdherentById(int idAdherent) {
        Adherent adherent = null;
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            adherent = session.find(Adherent.class, idAdherent);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return adherent;
    }

}
