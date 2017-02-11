package dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import web.CreateScreenCode;
import web.CreateText;

public class Text_T_Intract {
	public Configuration cfg;
	public SessionFactory sf;
	public Session s;
	
	//To create session factory
	public static Text_T_Intract getModel(){
		System.out.println("Inside the text class");
		Text_T_Intract model = new Text_T_Intract();
		model.cfg = new Configuration();
		model.cfg.configure("resources/hibernate.cfg.xml");
		model.sf = model.cfg.buildSessionFactory();
		return model;
	}
	
	//To save Text_T object
	public void saveOrUpdateTxt(Object o ){
		
		s = sf.openSession();
		
		CreateText t = (CreateText) o;
		
		int id=t.getId();
		
		//CreateText test = (CreateText) s.get(CreateText.class, id);
		
		/*if(test == null){
			
		}
		else{
			s.save(t);
		}
		//s.save(t);
*/
		s.saveOrUpdate(t);
		s.beginTransaction().commit();
		
		s.evict(t);
		
		s.close();
	}
	
	//To load Text_T table records
	public List<CreateText> loadTextTRecords(){
		
		s = sf.openSession();
		
		String hql = "from CreateText T ORDER BY T.id";
		
		Query q=s.createQuery(hql);
		
		List<CreateText> records=q.list();
		
		s.close();
		
		return records;
	}
	
	//To search based on the label given
	public List<CreateText> searchTextTRecords(String label){
		
		s = sf.openSession();
		
		String hql = "from CreateText T where label='"+label+"'";
		
		Query q=s.createQuery(hql);
		
		List<CreateText> records=q.list();
		
		s.close();

		return records;
	}
	
	
	public void update(Object o ){
		
		s = sf.openSession();
System.out.println("started type cast");
		CreateText t = (CreateText) o;
		System.out.println("ended type cast");
		System.out.println("**********"+t.getId());
		String hql = "update CreateText set label='"+t.getLabel()+"', description='"+t.getDescription()+"', id='"+t.getId() +"', language='"+t.getLanguage() +"' where TXT_ID='"+t.getId()+"'";
		Query q=s.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println(i + "rows were updsted");
		s.close();
		//sf.close();
	}
}
