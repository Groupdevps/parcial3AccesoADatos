/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Modelos.Jugador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author chaya
 */
public class jugadorDAO {
    
    public int addJugador (Jugador jg){
        int val = 1;
        try {
            SessionFactory sesion = NewHibernateUtil.getSessionFactory();        
            Session session = sesion.openSession();        
            Transaction tx = session.beginTransaction();        
            val = (int) session.save(jg);
            tx.commit();        
            session.close();
        }catch (Exception error){
            System.out.println("Error Creando equipo "+ error);
        }
        return val;
    }
    
    public int deleteJugador(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "delete FROM jugador WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }
    
    public List listJugador (){
         
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();	
        List<Jugador> jg = session.createQuery("from jugador").list();      
        session.close();
        return jg;
    }
    
    public int updateJugador(int id){
        int filasAfectadas = 0;
        SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
        Session session = sessFact.openSession();      
        Transaction tx = session.beginTransaction();       
	String query = "update FROM jugador SET nombre=?, cedula=?, equipo=?, numeroAmarillas=?, numeroRojas=?, numeroGoles=? WHERE id = ?";      
        filasAfectadas = session.createSQLQuery(query).setInteger(0,id).executeUpdate();         
        tx.commit();
        session.close();
        return filasAfectadas;
    }
}
