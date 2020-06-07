/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_gimnasio;

/**
 *
 * @author Daniel
 */
public class Horario{

    
private int año;
private byte mes;
private byte dia;
private String hora;
private String actividad;

/**
 * Variables de la clase Horario.
 * @param año
 * @param mes
 * @param dia
 * @param hora
 * @param actividad 
 */

    public Horario(int año, byte mes, byte dia, String hora, String actividad) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.actividad = actividad;
    }

    /*Getters y Setters*/

    public int getAño() {
        return año;
    }
    
    /**
     * 
     * @param año 
     */

    public void setAño(int año) {
        this.año = año;
    }

    public byte getMes() {
        return mes;
    }
    
    /**
     * 
     * @param mes 
     */

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public byte getDia() {
        return dia;
    }
    
    /**
     * 
     * @param dia 
     */

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }
    
    /**
     * 
     * @param hora 
     */

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getActividad() {
        return actividad;
    }
    
    /**
     * 
     * @param actividad 
     */

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /*To String de la clase Horario*/
    
    @Override
    public String toString() {
        return " Año: " + this.año + "\n Mes: " +  this.mes + "\n Dia: " +  this.dia + "\n Hora: " +  this.hora + "\n Actividad: " + this.actividad;
    }



    
}
