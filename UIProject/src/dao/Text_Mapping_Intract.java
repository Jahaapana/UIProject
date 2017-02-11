package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import web.CreateScreenCode;
import web.ScreenTextMapping;

public class Text_Mapping_Intract {
	public Configuration cfg;
	public SessionFactory sf;
	public Session s;
	
	//To create session factory
	public static Text_Mapping_Intract getModel(){
		System.out.println("In side the Function calss");
		Text_Mapping_Intract model = new Text_Mapping_Intract();
		model.cfg = new Configuration();
		model.cfg.configure("resources/hibernate.cfg.xml");
		model.sf = model.cfg.buildSessionFactory();
		return model;
	}
	//To save Text_T object
		public void saveOrUpdateScreen(ScreenTextMapping o ){
			
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
				public List<ScreenTextMapping> loadScreenTextRecords(){
					
					s = sf.openSession();
					
					String hql = "from ScreenTextMapping C";
					
					Query q=s.createQuery(hql);
					
					List<ScreenTextMapping> records=q.list();
					
					s.close();
					
					return records;
				}
				//To search based on the label given
				public List<ScreenTextMapping> searchScreenTextRecords(String screenCode){
					
					s = sf.openSession();
					
					String hql = "from ScreenTextMapping C where screenCode='"+screenCode+"'";
					
					Query q=s.createQuery(hql);
					
					List<ScreenTextMapping> records=q.list();
					
					s.close();

					return records;
				}
				public void deleteFunctionTRecord(ScreenTextMapping ctr){
					s = sf.openSession();
					/*String hql = "from CreateScreenCode C where screenCode='"+screenCode+"'";
					Query q=s.createQuery(hql);*/
					s.delete(ctr);
					s.beginTransaction().commit();
					s.close();
				}
}
