package HibernateUtil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Category;
import model.Manufacturer;
import model.Product;

public class HibernateUtil {
	private final static SessionFactory FACTORY;
	static {
		Configuration cfg = new Configuration();
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		prop.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "");
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put("hibernate.connection.charSet", "UTF-8");

		prop.put(Environment.SHOW_SQL, "true");
//		prop.put(Environment.FORMAT_SQL, "true");
		cfg.setProperties(prop);
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Manufacturer.class);
		cfg.addAnnotatedClass(Product.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		FACTORY = cfg.buildSessionFactory(registry);
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}

}
