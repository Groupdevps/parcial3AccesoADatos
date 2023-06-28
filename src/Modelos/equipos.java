/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author chaya
 */
public class equipos implements java.io.Serializable{
    private int id;
    private String nombre;
    private String pais;
    private int codigo;
    private int puntos;
    private int partidos_ganados;
    
    public equipos(){
    
}

    public equipos(int id, String nombre, String pais, int codigo, int puntos, int partidos_ganados) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.codigo = codigo;
        this.puntos = puntos;
        this.partidos_ganados = partidos_ganados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    @Override
    public String toString() {
        return "equipos{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", codigo=" + codigo + ", puntos=" + puntos + ", partidos_ganados=" + partidos_ganados + '}';
    }
    
    
}
