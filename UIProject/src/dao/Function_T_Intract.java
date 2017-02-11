package dao;

import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import web.CreateScreenCode;
import web.CreateText;

public class Function_T_Intract {
	public Configuration cfg;
	public SessionFactory sf;
	public Session s;
	
	//To create session factory
	public static Function_T_Intract getModel(){
		System.out.println("In side the Function calss");
		Function_T_Intract model = new Function_T_Intract();
		model.cfg = new Configuration();
		model.cfg.configure("resources/hibernate.cfg.xml");
		model.sf = model.cfg.buildSessionFactory();
		return model;
	}
	
	//To save Text_T object
	public void saveOrUpdateCode(CreateScreenCode o ){
		
		s = sf.openSession();
		
		//CreateScreenCode t = (CreateScreenCode) o;
		
		//int id=t.getId();
		
		//CreateText test = (CreateText) s.get(CreateText.class, id);
		
		/*if(test == null){
			
		}
		else{
			s.save(t);
		}
		//s.save(t);
*/
		s.saveOrUpdate(o);
		
		s.beginTransaction().commit();
		
		s.evict(o);
		
		s.close();
	}
	//To load Text_T table records
		public List<CreateScreenCode> loadFunctionTRecords(){
			
			s = sf.openSession();
			
			String hql = "from CreateScreenCode C";
			
			Query q=s.createQuery(hql);
			
			List<CreateScreenCode> records=q.list();
			
			s.close();
			
			return records;
		}
		//To search based on the label given
		public List<CreateScreenCode> searchFunctionTRecords(String screenCode){
			
			s = sf.openSession();
			
			String hql = "from CreateScreenCode C where screenCode='"+screenCode+"'";
			
			Query q=s.createQuery(hql);
			
			List<CreateScreenCode> records=q.list();
			
			s.close();

			return records;
		}
		public void deleteFunctionTRecord(CreateScreenCode ctr){
			s = sf.openSession();
			/*String hql = "from CreateScreenCode C where screenCode='"+screenCode+"'";
			Query q=s.createQuery(hql);*/
			s.delete(ctr);
			s.beginTransaction().commit();
			s.close();
		}
		//To load Text_T table Active records
				public List<CreateScreenCode> loadFunctionTActiveRecords(){
					
					s = sf.openSession();
					
					//String hql = "from CreateScreenCode C"; 

					Criteria cr = s.createCriteria(CreateScreenCode.class);
					Criterion crn=Restrictions.eq("isActive", "A");
					cr.add(crn);
					//Query q=s.createQuery(hql);
					
					List<CreateScreenCode> records=cr.list();
					
					s.close();
					
					return records;
				}
}
