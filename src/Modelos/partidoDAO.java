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
    
    public partidoDAO(){
        
    }
    /*public void addPartido (Partido pt){
         
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        
        Session session = sesion.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(pt);

        tx.commit();
        
        session.close();
    }*/
    
    public int addPartido (Partido pt){
        int val = 1;
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();        
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            val = (int)session.save(pt);            
            tx.commit();                        
            session.close();    
        }catch (Exception error){
            System.out.println("Error Creando equipo "+ error);
        }      
        return val;     
    }
    
    /*public int deletePartido(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "delete FROM partido WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }*/
    
    public boolean deletePartido(Partido match){
        boolean filasAfectadas = false;
        try {
            SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
            Session session = sessFact.openSession();      
            Transaction tx = session.beginTransaction();       
    //	String query = "delete FROM equipo WHERE id = ?";      
    //        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
            session.delete(match);
            filasAfectadas = !session.contains(match);
            tx.commit();
            session.close();
        }catch (Exception error){
            System.out.println("Error eliminar equipo "+ error);            
        }  
        return filasAfectadas;
    }
    
    /*public List listPartido (){
         
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();	
        List<Partido> pt = session.createQuery("from partido").list();      
        session.close();
        return pt;
    }*/
    
    public List listPartido (){
        List<Partido> pt = null;
        try {
            SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
            Session  session = sessFact.openSession();	
            Transaction tx = session.beginTransaction();
            pt = session.createQuery("from Partido").list();      
//            System.out.println("LIST "+ eq);
            tx.commit();
            session.close();         
        }catch (Exception error){
            System.out.println("Error listar partido "+ error);
        }
        return pt;
    }
    
    /*public int updatePartido(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "update FROM partido SET equipo_1=?, equipo_2=?, goles_equipo_1=?, goles_equipo_2=?, tarjetas_rojas_equipo_1=?, tarjetas_rojas_equipo_2=?, tarjetas_amarillas_equipo_1=?, tarjetas_amarillas_equipo_2=? WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }*/
    
    public int updatePartido(Partido match){
        int filasAfectadas = 1;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
//	String query = "update FROM equipo SET nombre=?, pais=?, codigo=?, puntos=?, partidosGanados=? WHERE id = ?";      
//        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate(); 
        System.out.println("update " + session.getStatistics());
        session.update(match);        
        tx.commit();
        session.close();
        return filasAfectadas = 0;
    }
}
