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
    
    public int addEquipo(int id, String nombre, String pais, int codigo, int puntos, int partidosGanados){
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
            // Validar > 3 equipos para crear torneo
            List <Equipo> equipos = eqDAO1.listEquipo();
            
            if (equipos.size() > 3) {
                String equipo1 = "" , equipo2 = "";
                
                for(Equipo it:equipos){
                    for(Equipo it2:equipos){
                        if(!it.getNombre().equals(it2.getNombre())){
                            equipo1 = it.getNombre();
                            equipo2 = it2.getNombre();                       
                            partidosControlador pt = new partidosControlador();
                            pt.addPartido(0, equipo1, equipo2, 0, 0, 0, 0, 0, 0);                
                            System.out.println(equipo1 + " vs " + equipo2);
                        }
                    }                    
                }
                System.out.println("Torneo creado");
            }
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
