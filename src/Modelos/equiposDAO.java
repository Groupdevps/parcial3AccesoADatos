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
    public equiposDAO(){
        
    }
    
    public int addEquipo (Equipo eq){
        int val = 1;
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();        
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            val = (int)session.save(eq);            
            tx.commit();                        
            session.close();
            
            
        }catch (Exception error){
            System.out.println("Error Creando equipo "+ error);
        }
        
        return val;
        
        
    }
    
    public boolean deleteEquipo(Equipo team){
        boolean filasAfectadas = false;
        try {
            SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
            Session session = sessFact.openSession();      
            Transaction tx = session.beginTransaction();       
    //	String query = "delete FROM equipo WHERE id = ?";      
    //        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
            session.delete(team);
            filasAfectadas = !session.contains(team);
            tx.commit();
            session.close();
        }catch (Exception error){
            System.out.println("Error eliminar equipo "+ error);            
        }  
        return filasAfectadas;
    }
    
    public List listEquipo (){
        List<Equipo> eq = null;
        try {
            SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
            Session  session = sessFact.openSession();	
            Transaction tx = session.beginTransaction();
            eq = session.createQuery("from Equipo").list();      
//            System.out.println("LIST "+ eq);
            tx.commit();
            session.close();
            
        }catch (Exception error){
            System.out.println("Error listar equipo "+ error);
        }
        return eq;
    }
    
    public int updateEquipo(Equipo team){
        int filasAfectadas = 1;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
//	String query = "update FROM equipo SET nombre=?, pais=?, codigo=?, puntos=?, partidosGanados=? WHERE id = ?";      
//        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate(); 
        System.out.println("update " + session.getStatistics());
        session.update(team);        
        tx.commit();
        session.close();
        return filasAfectadas = 0;
    }
}
