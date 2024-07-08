package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sn.ucad.fst.dmi.mtdsi.recherche.util.HibernateUtil;

/**
 * Home object for domain model class Bibliotheque.
 * @see sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Bibliotheque
 * @author Hibernate Tools
 */
public class BibliothequeHome {



    public void addBibliotheque(Bibliotheque bibliotheque) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.persist(bibliotheque);
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

    public void deleteBibliotheque(int idBibliotheque) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            Bibliotheque bibliotheque = session.find(Bibliotheque.class, idBibliotheque);
            if (bibliotheque != null) {
                session.remove(bibliotheque);
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

    public void updateBibliotheque(Bibliotheque bibliotheque) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.merge(bibliotheque);
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

    public List<Bibliotheque> getAllBibliotheques() {
        List<Bibliotheque> bibliotheques = new ArrayList<>();
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query<Bibliotheque> query = session.createQuery("from Bibliotheque", Bibliotheque.class);
            bibliotheques = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return bibliotheques;
    }

    public Bibliotheque getBibliothequeById(int idBibliotheque) {
        Bibliotheque bibliotheque = null;
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            bibliotheque = session.find(Bibliotheque.class, idBibliotheque);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return bibliotheque;
    }

}
