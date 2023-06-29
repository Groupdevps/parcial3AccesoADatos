/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelos.Jugador;
import Modelos.jugadorDAO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chaya
 */
public class jugadoresControlador {
    jugadorDAO jgDAO;
    
    public jugadoresControlador(){
//        this.jgDAO = jgDAO;
    }
    
    public int addJugador(int id, String nombre, String cedula, String equipo,int numeroAmarillas, int numeroRojas, int numeroGoles){
        
        Jugador jg = new Jugador();
        jg.setNombre(nombre);
        jg.setCedula(cedula);
        jg.setEquipo(equipo);
        jg.setNumeroAmarillas(numeroAmarillas);
        jg.setNumeroRojas(numeroRojas);
        jg.setNumeroGoles(numeroGoles);   
        jugadorDAO jgDAO1 = new jugadorDAO();
        return jgDAO1.addJugador(jg);
        
    }
    
    public int deleteJugador(int id){
       int filAfc= jgDAO.deleteJugador(id);
       return filAfc;
    }
    
    public List listJugador(){
       jugadorDAO jgDAO1 = new jugadorDAO();
       List <String> jgs = new ArrayList();
       List <Jugador> jugadores= jgDAO1.listJugador();
//       for(Jugador jg:jugadores){
//           jgs.add(jg.toString());
//           System.out.println("---->"+jg.toString());
//       }
       
       return jugadores;
    }
    
    public int updateJugador(Jugador player){
       jugadorDAO jgDAO1 = new jugadorDAO();
       int filAfc= jgDAO1.updateJugador(player);
       return filAfc;
    }
}
