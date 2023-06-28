/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Modelos.Equipo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author chaya
 */
public class equiposDAO {
    
    public void addEquipo (Equipo eq){
         
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        
        Session session = sesion.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(eq);

        tx.commit();
        
        session.close();
    }
    
    public int deleteEquipo(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "delete FROM equipo WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }
    
    public List listEquipo (){
         
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();	
        List<Equipo> eq = session.createQuery("from equipo").list();      
        session.close();
        return eq;
    }
    
    public int updateEquipo(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "update FROM equipo SET nombre=?, pais=?, codigo=?, puntos=?, partidosGanados=? WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }
}
