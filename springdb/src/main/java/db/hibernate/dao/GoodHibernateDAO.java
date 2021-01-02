package db.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import db.hibernate.domain.Good;

@Repository
public class GoodHibernateDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertGood(Good good) {
		Session session = sessionFactory.getCurrentSession();
		session.save(good);
	}

	@SuppressWarnings("unchecked")
	public List<Good> listGood() {
		//CriteriaQuery<Good> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Good.class);
		//criteriaQuery.from(Good.class);
		//List<Good> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();


		List<Good> list = sessionFactory.getCurrentSession().createSQLQuery("select * from goods").addEntity(Good.class).list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public Good getGood(int code) {
		//Good item = (Good)sessionFactory.getCurrentSession().get(Good.class, code);
		//return item;

		
		List<Good> list = sessionFactory.getCurrentSession().createSQLQuery("select * from Goods where code=:code").addEntity(Good.class)
				.setParameter("code", code).list();
		if(list == null || list.size() < 1)
			return null;
		return list.get(0);
		
	}
	
	public int maxCode() {
		int maxCode = (Integer)sessionFactory.getCurrentSession().createSQLQuery("select max(code) as maxcode from Goods").addScalar("maxcode", new IntegerType()).uniqueResult();
		return maxCode;
	}

	public void updateGood(Good good) {
		Session session = sessionFactory.getCurrentSession();
		session.update(good);
	}	

	public void deleteGood(int code) {
		Session session = sessionFactory.getCurrentSession();
		Good vo = new Good();
		vo.setCode(code);
		session.delete(vo);
	}

}
