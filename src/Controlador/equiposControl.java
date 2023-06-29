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
    equiposDAO eqDAO ;
    
    public equiposControl(){//equiposDAO eqDAO1
//        this.eqDAO = new equiposDAO(); //= eqDAO1;
    }
    
    public int addEquipoo(int id, String nombre, String pais, int codigo, int puntos, int partidosGanados){
        int val = 1;
        try {
            equiposDAO eqDAO1 = new equiposDAO();            
            Equipo eq = new Equipo();
            eq.setNombre(nombre);
            eq.setCodigo(codigo);
            eq.setPais(pais);
            eq.setPartidosGanados(partidosGanados);
            eq.setPuntos(puntos);
            val = eqDAO1.addEquipo(eq);
        }catch (Exception error){
            System.out.println("Error controlador equipo "+ error);
        }
        return val;
        
    }

    
    public boolean deleteEquipo(Equipo team){
       equiposDAO eqDAO1 = new equiposDAO();            
       boolean filAfc    = eqDAO1.deleteEquipo(team);
       return filAfc;
    }
    
    public List listEquipo(){
       List <Equipo> equipos = null;    
       equiposDAO eqDAO1 = new equiposDAO();  
        try {
            List <String> eqs        = new ArrayList();            
            equipos = eqDAO1.listEquipo();
//            for(Equipo eq:equipos){
//                eqs.add(eq.toString());
//                System.out.println("---->"+eq.getNombre());
//            }
       }catch (Exception error){
            System.out.println("Error controlador equipo listar  "+ error);
        }
       
       return equipos;
    }
    
    public int updateEquipo(Equipo team){
        equiposDAO eqDAO1 = new equiposDAO();            
       int filAfc = eqDAO1.updateEquipo(team);
       return filAfc;
    }
    
    
    
    
}
