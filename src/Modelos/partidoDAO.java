/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Modelos.Partido;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author chaya
 */
public class partidoDAO {
    
    public void addPartido (Partido pt){
         
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        
        Session session = sesion.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(pt);

        tx.commit();
        
        session.close();
    }
    
    public int deletePartido(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "delete FROM partido WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }
    
    public List listPartido (){
         
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();	
        List<Partido> pt = session.createQuery("from partido").list();      
        session.close();
        return pt;
    }
}
