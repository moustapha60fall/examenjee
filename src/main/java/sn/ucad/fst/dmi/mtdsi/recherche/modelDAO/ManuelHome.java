package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sn.ucad.fst.dmi.mtdsi.recherche.util.HibernateUtil;

/**
 * Home object for domain model class Manuel.
 * @see sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Manuel
 * @author Hibernate Tools
 */
public class ManuelHome {





    public void addManuel(Manuel manuel) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.persist(manuel);
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

    public void deleteManuel(int idDocument) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            Manuel manuel = session.find(Manuel.class, idDocument);
            if (manuel != null) {
                session.remove(manuel);
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

    public void updateManuel(Manuel manuel) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.merge(manuel);
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

    public List<Manuel> getAllManuels() {
        List<Manuel> bibliotheques = new ArrayList<>();
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query<Manuel> query = session.createQuery("from Manuel", Manuel.class);
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

    public Manuel getManuelById(int idDocument) {
        Manuel manuel = null;
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            manuel = session.find(Manuel.class, idDocument);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return manuel;
    }

}

