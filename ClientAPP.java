import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class ClientAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration cfg=new Configuration();
		cfg.configure();
		
		Product p=new Product();
		p.setPid("xyz1");
		p.setPname("ddd");
		p.setPcost(800);
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(p);
		tx.commit();
		System.out.println("Product Insertion Success");
		s.close();

		

	}

}
