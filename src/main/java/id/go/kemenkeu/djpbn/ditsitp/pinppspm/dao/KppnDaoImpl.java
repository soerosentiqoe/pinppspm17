package id.go.kemenkeu.djpbn.ditsitp.pinppspm.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;


@Repository
public class KppnDaoImpl implements KppnDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Kppn kppn) {
		// TODO Auto-generated method stub
		kppn.setId_kppn(UUID.randomUUID().toString());
		Session session = sessionFactory.openSession();
		 Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(kppn);
			transaction.commit();
		}catch (Exception e) {
			  if (transaction != null) {
		             transaction.rollback();
		             System.out.println(e);
		           }
		}
		
		//session.flush();
		session.close();
		
	}

	@Override
	public List<Kppn> read() {
		Session session = sessionFactory.openSession();
		String hql = "from Kppn";
		Query q = session.createQuery(hql);
		return q.list();
	}

	@Override
	public Kppn getByKdkppn(String kdkppn) {
		Session session = sessionFactory.openSession();
		String hql = "from Kppn where kdkppn = :xxx";
		Query q = session.createQuery(hql);
		q.setParameter("xxx", kdkppn);
		
		List<Kppn> l = q.list();
		return (Kppn) (l.size() > 0 ? l.get(0) : null);
	}

}
