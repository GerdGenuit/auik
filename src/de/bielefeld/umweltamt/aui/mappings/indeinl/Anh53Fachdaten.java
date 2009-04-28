package de.bielefeld.umweltamt.aui.mappings.indeinl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import de.bielefeld.umweltamt.aui.AUIKataster;
import de.bielefeld.umweltamt.aui.HibernateSessionFactory;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;

/**
 * A class that represents a row in the 'ANH_56_FACHDATEN' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Anh53Fachdaten
    extends AbstractAnh53Fachdaten
    implements Serializable
{
    /**
     * Simple constructor of Anh52Fachdaten instances.
     */
    public Anh53Fachdaten()
    {
    }

    /**
     * Constructor of Anh52Fachdaten instances given a simple primary key.
     * @param id
     */
    public Anh53Fachdaten(java.lang.Integer objektid)
    {
        super(objektid);
    }

    public String toString() {
		return "[ID:" + this.getObjektid() + "]";
	}

    public static Anh53Fachdaten getAnh53ByObjekt(BasisObjekt objekt, Session session) {
    	Anh53Fachdaten fachdaten = null;
    	if (objekt.getBasisObjektarten().isAnh52()) {
    		try {
				List anhang52 = session.createQuery(
					    "from Anh53Fachdaten as anhang53 where " +
					    "anhang53.basisObjekt = ?")
					    .setEntity(0, objekt)
					    .list();
				
				if (anhang52.size() > 0) {
					fachdaten = (Anh53Fachdaten) anhang52.get(0);
				}
			} catch (HibernateException e) {
			}
    	}
    	
    	return fachdaten;
    }

    public static Anh53Fachdaten getAnh53ByObjekt(BasisObjekt objekt) {
    	Anh53Fachdaten fachdaten;
    	try {
    		Session session = HibernateSessionFactory.currentSession();
    		fachdaten = getAnh53ByObjekt(objekt, session);
    		HibernateSessionFactory.closeSession();
    	} catch (HibernateException e) {
    		fachdaten = null;
    	}
    	
    	return fachdaten;
    }

    public static boolean saveFachdaten(Anh53Fachdaten fachdaten) {
    	boolean saved;
		
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(fachdaten);
			tx.commit();
			saved = true;
		} catch (HibernateException e) {
			saved = false;
			e.printStackTrace();
			if (tx != null) {
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					AUIKataster.handleDBException(e1, "Anh53Fachdaten.save", false);
				}
			}
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return saved;
    }

	/**
	 * Liefert eine Liste mit allen Anhang52 Objekten.
	 * @return Eine Liste aus Anh52Fachdaten.
	 */
	public static List getAuswertungsListe() {
		List liste;
		
		String query = "from Anh53Fachdaten as anh53 " +
				"order by anh53.id";
		
		try {
			Session session = HibernateSessionFactory.currentSession();
			liste = session.createQuery(query).list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return liste;
	}
}