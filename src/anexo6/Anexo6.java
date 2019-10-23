/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anexo6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Anexo6 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
          Scanner teclado = new Scanner(System.in);
        Persona persona;
       // Persona notas2;
       // String cad;
        int op;
       
        
         File fichero=new File("./src/anexo6/Personas.dat");
         
         FileOutputStream fileout;
        fileout =new FileOutputStream(fichero);
        ObjectOutputStream dataOS;
        dataOS=new ObjectOutputStream(fileout);
         
        
         String DNIs[]={"31456879F","15462879H","65428741L"};
         String nombres[]={"Antonio","Maite","Pepa"};
        
         for(int i=0;i<DNIs.length;i++)
         {
             
            
                 persona=new Persona(DNIs[i],nombres[i]);
                dataOS.writeObject(persona);
     
         }
            dataOS.close();
            
            leer(fichero);
            System.out.println("");
            System.out.print("1-Añadir registros || 2-Recuperar || 3-Modificar: ");
            op=teclado.nextInt();
            System.out.println("");
            
            switch(op){
                case 1:
                    añadir(fichero);
                    leer(fichero);
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                default:
                    break;
                    
            }
            
       
       
         
    }
    public static String comprobar(File fichero) throws IOException, ClassNotFoundException{
          FileInputStream filein=new FileInputStream(fichero);
      String dni="";
    Persona per;
    ObjectInputStream dataIS=new ObjectInputStream(filein);
     try{
        while(true){
           
            per=(Persona)dataIS.readObject();
            dni=per.getDni();
        }
        
       
    }catch (EOFException eo)
    {
        //System.out.println("Fin de lectura");
        
    }
    
    
   
    dataIS.close();
    return dni;
    }
    public static void añadir(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
                Scanner teclado = new Scanner(System.in);
                Persona persona;
         String DNI,nombre;
         FileOutputStream fileout;
        fileout =new FileOutputStream(fichero);
        ObjectOutputStream dataOS;
        dataOS=new ObjectOutputStream(fileout);     
         
        
        
             System.out.print("Introduzca el dni: ");
             DNI=teclado.next();
             System.out.println("");
             
             if(DNI.compareTo(comprobar(fichero))==1)
             {
                 System.out.println("Error ya existe ese dni");
             }
             else{
                 System.out.print("Nombre:");
                 nombre=teclado.next();
                 persona=new Persona(DNI,nombre);
                 dataOS.writeObject(persona);
               
                
             }   
                          
                     
    dataOS.close();
    }
    public static void recuperar(){
        
    }
    public static void modificar(){
        
    }
    public static void leer(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream filein=new FileInputStream(fichero);
      String dni="",nombre="";
    Persona per;
    ObjectInputStream dataIS=new ObjectInputStream(filein);
     try{
        while(true){
           
            per=(Persona)dataIS.readObject();
            dni=per.getDni();
            nombre=per.getNombre();
            
            System.out.println("Dni: "+dni+" Nombre: "+nombre);
            
        }
        
         
        
       
    }catch (EOFException eo)
    {
        //System.out.println("Fin de lectura");
        
    }
    
    
   
    dataIS.close();
    }
    
}
