/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Equipo;
import Modelos.equiposDAO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chaya
 */
public class equiposControl {
    equiposDAO eqDAO;
    
    public equiposControl(equiposDAO eqDAO){
        this.eqDAO = eqDAO;
    }
    
    public void addEquipo(int id, String nombre, String pais, int codigo, int puntos, int partidosGanados){
        Equipo eq = new Equipo(id, nombre, pais, codigo, puntos, partidosGanados);
        eqDAO.addEquipo(eq);
    }
    
    public int deleteEquipo(int id){
       int filAfc= eqDAO.deleteEquipo(id);
       return filAfc;
    }
    
    public List listEquipo(){
       List <String> eqs = new ArrayList();
       List <Equipo> equipos= eqDAO.listEquipo();
       for(Equipo eq:equipos){
           eqs.add(eq.toString());
           System.out.println("---->"+eq.toString());
       }
       
       return eqs;
    }
    
    public int updateEquipo(int id){
       int filAfc= eqDAO.updateEquipo(id);
       return filAfc;
    }
    
    
    
    
}
