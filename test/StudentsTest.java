
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @author zy007
* 
*/
public class StudentsTest {

	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;

	@After
	public void destory() {
		if(transaction!=null){
			transaction.commit();
		}
		if(session!=null){
			session.close();
		}
		if (sessionFactory != null) {

			sessionFactory.close();

		}
	}

	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();

		sessionFactory = configuration.buildSessionFactory();

		session = sessionFactory.openSession();

		transaction = session.beginTransaction();
	}

	@Test
	public void testSaveStudents() {
		Students s = new Students(1, "zy", "man", new Date(), "zhangzhou");
		Students s1 = new Students(2, "hf", "man", new Date(), "hangzhou");
		if(session!=null){
			session.save(s);
			session.save(s1);
		}
		

	}

}
