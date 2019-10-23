/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anexo6;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Persona implements Serializable{
      private String dni;
    private String nombre;
    
    public Persona(String dni,String nombre){
        this.dni=dni;
        this.nombre=nombre;
        
    }
    
    public void setDni(String dni){this.dni=dni;}
     public void setNombre(String nombre){this.nombre=nombre;}
     
     public String getDni(){return this.dni;}
     public String getNombre(){return this.nombre;}
}
