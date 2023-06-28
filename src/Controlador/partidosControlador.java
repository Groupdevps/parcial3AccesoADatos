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
    
    public partidosControlador(partidoDAO ptDAO){
        this.ptDAO = ptDAO;
    }
    
    public void addPartido(int id, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int tarjetasRojasEquipo1, int tarjetasRojasEquipo2, int tarjetasAmarillasEquipo1, int tarjetasAmarillasEquipo2){
        Partido pt = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2, tarjetasRojasEquipo1, tarjetasRojasEquipo2, tarjetasAmarillasEquipo1, tarjetasAmarillasEquipo2);
        ptDAO.addPartido(pt);
    }
    
    public int deletePartido(int id){
       int filAfc= ptDAO.deletePartido(id);
       return filAfc;
    }
    
    public List listEquipo(){
       List <String> pts = new ArrayList();
       List <Partido> partidos= ptDAO.listPartido();
       for(Partido pt: partidos){
           pts.add(pt.toString());
           System.out.println("---->"+pt.toString());
       }
       
       return pts;
    }
    
    public int updatePartido(int id){
       int filAfc= ptDAO.updatePartido(id);
       return filAfc;
    }
}
