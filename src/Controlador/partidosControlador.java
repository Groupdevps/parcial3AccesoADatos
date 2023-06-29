/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelos.Partido;
import Modelos.partidoDAO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chaya
 */
public class partidosControlador {
    partidoDAO ptDAO;
    
    public partidosControlador(){
        //this.ptDAO = ptDAO; ()partidoDAO ptDAO
    }
    
    /*public void addPartido(int id, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int tarjetasRojasEquipo1, int tarjetasRojasEquipo2, int tarjetasAmarillasEquipo1, int tarjetasAmarillasEquipo2){
        Partido pt = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2, tarjetasRojasEquipo1, tarjetasRojasEquipo2, tarjetasAmarillasEquipo1, tarjetasAmarillasEquipo2);
        ptDAO.addPartido(pt);
    }*/
    
    public int addPartido(int id, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int tarjetasRojasEquipo1, int tarjetasRojasEquipo2, int tarjetasAmarillasEquipo1, int tarjetasAmarillasEquipo2){
        int val = 1;
        try {
            partidoDAO ptDAO = new partidoDAO();            
            Partido pt = new Partido();
            pt.setEquipo1(equipo1);
            pt.setEquipo2(equipo2);
            pt.setGolesEquipo1(golesEquipo1);
            pt.setGolesEquipo2(golesEquipo2);
            pt.setTarjetasAmarillasEquipo1(tarjetasAmarillasEquipo1);
            pt.setTarjetasAmarillasEquipo2(tarjetasAmarillasEquipo2);
            pt.setTarjetasRojasEquipo1(tarjetasRojasEquipo1);
            pt.setTarjetasRojasEquipo2(tarjetasRojasEquipo2);
            val = ptDAO.addPartido(pt);
        }catch (Exception error){
            System.out.println("Error controlador equipo "+ error);
        }
        return val;
        
    }
    
    /*public int deletePartido(int id){
       int filAfc= ptDAO.deletePartido(id);
       return filAfc;
    }*/
    
    public boolean deleteEquipo(Partido match){
       partidoDAO ptDAO = new partidoDAO();            
       boolean filAfc    = ptDAO.deletePartido(match);
       return filAfc;
    }
    
    /*public List listEquipo(){
       List <String> pts = new ArrayList();
       List <Partido> partidos= ptDAO.listPartido();
       for(Partido pt: partidos){
           pts.add(pt.toString());
           System.out.println("---->"+pt.toString());
       }
       
       return pts;
    }*/
    
    public List listPartido(){
       List <Partido> partidos = null;    
       partidoDAO ptDAO = new partidoDAO();  
        try {
            List <String> eqs        = new ArrayList();            
            partidos = ptDAO.listPartido();
//            for(Equipo eq:equipos){
//                eqs.add(eq.toString());
//                System.out.println("---->"+eq.getNombre());
//            }
       }catch (Exception error){
            System.out.println("Error controlador equipo listar  "+ error);
        }
       
       return partidos;
    }
    
    /*public int updatePartido(int id){
       int filAfc= ptDAO.updatePartido(id);
       return filAfc;
    }*/
    
    public int updatePartido(Partido match){
        partidoDAO ptDAO = new partidoDAO();            
       int filAfc = ptDAO.updatePartido(match);
       return filAfc;
    }
}
