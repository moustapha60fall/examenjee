package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sn.ucad.fst.dmi.mtdsi.recherche.util.HibernateUtil;

/**
 * Home object for domain model class Roman.
 * @see sn.ucad.fst.dmi.mtdsi.recherche.modelDAO.Roman
 * @author Hibernate Tools
 */
public class RomanHome {



    public void addRoman(Roman revue) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.persist(revue);
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

    public void deleteRoman(int idDocument) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            Roman revue = session.find(Roman.class, idDocument);
            if (revue != null) {
                session.remove(revue);
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

    public void updateRoman(Roman revue) {
        Transaction trns = null;
        Session session = HibernateUtil.currentSession();
        try {
            trns = session.beginTransaction();
            session.merge(revue);
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

    public List<Roman> getAllRomans() {
        List<Roman> bibliotheques = new ArrayList<>();
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query<Roman> query = session.createQuery("from Roman", Roman.class);
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

    public Roman getRomanById(int idDocument) {
        Roman revue = null;
        Session session = HibernateUtil.currentSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            revue = session.find(Roman.class, idDocument);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession();
        }
        return revue;
    }

}
