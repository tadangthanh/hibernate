package test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;
import model.Category;
import model.Product;

public class Test {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
			Root<Category> root = criteriaQuery.from(Category.class);
			Join<Category, Product> a = root.join("product", JoinType.INNER);
			criteriaQuery = criteriaQuery.select(root);

			Query query = session.createQuery(criteriaQuery);
			query.getResultList().forEach(t -> {
				System.out.println(t.toString());
			});
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
