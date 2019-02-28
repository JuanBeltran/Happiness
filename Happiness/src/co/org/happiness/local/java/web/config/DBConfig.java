package co.gov.igac.ciaf.especializacion.poo.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}

	@Bean
	public SessionFactory sessionFactory() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "create");
		prop.put("hibernate.show_sql", "true"); // optional

		LocalSessionFactoryBuilder session = new LocalSessionFactoryBuilder(getDataSource());
		session.addProperties(prop);
		return session.scanPackages("co.gov.igac.ciaf.especializacion.poo.cbo").buildSessionFactory();
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3311/poo?createDatabaseIfNotExist=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager hibTransMan() {
		return new HibernateTransactionManager(sessionFactory());
	}
}
