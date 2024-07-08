package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sn.ucad.fst.dmi.mtdsi.recherche.util.HibernateUtil;

/**
 * Home object for domain model class Bibliothecaire.
 * @see sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Bibliothecaire
 * @author Hibernate Tools
 */
public class BibliothecaireHome {

    public void addBibliothecaire(Bibliothecaire bibliothecaire) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.persist(bibliothecaire);
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

    public void deleteBibliothecaire(int idBibliothecaire) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            Bibliothecaire bibliothecaire = session.find(Bibliothecaire.class, idBibliothecaire);
            if (bibliothecaire != null) {
                session.remove(bibliothecaire);
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

    public void updateBibliothecaire(Bibliothecaire bibliothecaire) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.merge(bibliothecaire);
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

    public List<Bibliothecaire> getAllBibliothecaires() {
        List<Bibliothecaire> bibliothecaires = new ArrayList<>();
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query<Bibliothecaire> query = session.createQuery("from Bibliothecaire", Bibliothecaire.class);
            bibliothecaires = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return bibliothecaires;
    }

    public Bibliothecaire getBibliothecaireById(int idBibliothecaire) {
        Bibliothecaire bibliothecaire = null;
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            bibliothecaire = session.find(Bibliothecaire.class, idBibliothecaire);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return bibliothecaire;
    }

}
