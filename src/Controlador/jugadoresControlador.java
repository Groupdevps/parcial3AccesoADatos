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
    
    public jugadoresControlador(jugadorDAO jgDAO){
        this.jgDAO = jgDAO;
    }
    
    public void addJugador(int id, String nombre, String cedula, String equipo,int numeroAmarillas, int numeroRojas, int numeroGoles){
        Jugador jg = new Jugador(id, nombre, cedula, equipo, numeroAmarillas, numeroRojas, numeroGoles);
        jgDAO.addJugador(jg);
    }
    
    public int deleteJugador(int id){
       int filAfc= jgDAO.deleteJugador(id);
       return filAfc;
    }
    
    public List listJugador(){
       List <String> jgs = new ArrayList();
       List <Jugador> jugadores= jgDAO.listJugador();
       for(Jugador jg:jugadores){
           jgs.add(jg.toString());
           System.out.println("---->"+jg.toString());
       }
       
       return jgs;
    }
    
    public int updateJugador(int id){
       int filAfc= jgDAO.updateJugador(id);
       return filAfc;
    }
}
