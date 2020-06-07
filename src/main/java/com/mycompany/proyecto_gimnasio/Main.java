/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_gimnasio;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        /*Variables que nos permiten almacenar los valores de cada clase hasta 10 veces*/
        Socio[] socio = new Socio[10];
        Invitado[] invitado = new Invitado[10];
        Entrenador[] entrenador = new Entrenador[10];
        Actividad[] actividad = new Actividad[10];
        Horario[] horario = new Horario[10];
       
       
       
       /*Variables de la superclase trabajador*/
       
        String dni = "";
        String nombre = "";
        String apellido = "";
        String email = "";
        int telefono = 0;
        
        /*Variable de la clase invitado*/
        int nInvitado = 0;

        /*Variables de la clase socio*/
        boolean prueba = false;
        String prueba2 = "";
        int nSocio = 0;

        /*Variables de la clase entrenador*/
        int nclientes = 0;
        String nombreCliente = "";

        /*Variable de la clase actividad*/
        String tipoActividad = "";

        /*Variables de la clase horario*/
        int año = 0;
        byte mes = 0;
        byte dia = 0;
        String hora = "";
        String actividadhorario = "";

        /*EMPIEZA EL PROGRAMA*/
        
        frameGimnasio window=new frameGimnasio();
        window.setTitle("Editor de Gimnasios");
        window.setVisible(false);
        
        System.out.println("BIENVENID@ AL GESTOR DE GIMNASIOS");
        System.out.println("---------------------------------");
        System.out.println("¿Desea insertar un registro? (S/N)");
        String registro=sc.nextLine();
        
        /*While que engloba el programa y permite insertar datos en las clases*/
        
        /*Si presionamos cualquier letra que no sea N accedemos a insertar los datos*/
         
        while(!registro.equalsIgnoreCase("N")){
        
            System.out.println("Elija una de las siguientes opciones: "
                    + "\n [1]--> Insertar un nuevo usuario."
                    + "\n [2]--> Insertar un nuevo socio."
                    + "\n [3]--> Insertar un nuevo entrenador."
                    + "\n [4]--> Insertar una nueva actividad."
                    + "\n [5]--> Insertar un nuevo horario.");
            
        byte operacion=Byte.parseByte(sc.nextLine());
        
         /*Switch que permite elegir a qué clase vamos a insertar los datos*/
            
       switch(operacion) {
           
  /*CASO 1: INSERTAMOS DATOS EN LA CLASE INVITADO.*/ 
           
  case 1:
   
  int i=0;
  
  
  System.out.println("¿Es usted un cliente nuevo? (S/N)");
  String r1=sc.nextLine();    
 
  while(!r1.equalsIgnoreCase("N") && i<invitado.length){
           
            /*Dentro de la variable invitado insertamos las creadas al principio del programa*/
           
            Invitado inv=new Invitado(dni, nombre, apellido, email, telefono, nInvitado, prueba);
            
            /*Pedimos los datos por pantalla*/
            System.out.println("Introduce el DNI del invitado:");
            inv.setDni(sc.nextLine());
            System.out.println("Introduce el nombre del invitado:");
            inv.setNombre(sc.nextLine());
            System.out.println("Introduce el apellido del invitado:");
            inv.setApellido(sc.nextLine());
            System.out.println("Introduce el email del invitado");
            inv.setEmail(sc.nextLine());
            System.out.println("Introduce el teléfono del invitado");
            inv.setTelefono(Integer.parseInt(sc.nextLine()));
            System.out.println("Introduce el número identificador del invitado");
            inv.setnInvitado(Integer.parseInt(sc.nextLine()));
            System.out.println("¿Ha probado de forma gratuita anteriormente? (S/N)");
            prueba2=sc.nextLine();
            
            /*If para cambiar el valor de la variable booleana dependiendo 
            de la opción que elija el usuario*/
            
            if (prueba2.equalsIgnoreCase("S")) {
               
                inv.setPrueba(true);
                
           }else{
            
                inv.setPrueba(false);
            }
            
            invitado[i]=inv;
            
            System.out.println("DATOS DEL USUARIO INTRODUCIDO: ");
            
            /*Llamamos al to string para ver que los datos han sido introducidos correctamente*/
        
            System.out.println(inv.toString());
            
            System.out.println("¿Quieres introducir más invitados? (S/N)");
            r1=sc.nextLine();
            
            i++;
        }
            /*PASAMOS LOS DATOS GUARDADOS EN LA VARIABLE INVITADO A LA BASE DE DATOS*/
            
            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
            Statement smt=con.createStatement();
            i=0;
            
            /*Con el while que tenemos justo debajo, verificamos si hay datos introducidos en la variable invitado,
            si no hay datos, nada se guardadrá en la base de datos.*/
            
            while(i<invitado.length && invitado[i]!=null){
                smt.executeUpdate("insert into invitados values('"+invitado[i].getDni()+"','"+invitado[i].getNombre()+"','"+invitado[i].getApellido()+"','"+invitado[i].getEmail()+"',"+invitado[i].getTelefono()+","+invitado[i].getnInvitado()+","+invitado[i].isPrueba()+")");
                i++;
            }
            
            ResultSet rs=smt.executeQuery("select * from invitados");
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n DNI: "+rs.getString("Dni")+"\n Nombre: "+rs.getString("Nombre")+"\n Apellido: "+rs.getString("Apellido")+"\n Email: "+rs.getString("Email")+"\n Telefono: "+rs.getInt("Telefono")+"\n Numero del invitado: "+rs.getInt("NumeroInvitado")+"\n Prueba: "+rs.getBoolean("Prueba"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
            
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            registro=sc.nextLine();
      
    break;
    
 /*CASO 2: INSERTAMOS DATOS EN LA CLASE SOCIO.*/   
    
  case 2:
    
      int j=0;
      
      System.out.println("¿Desea insertar los datos de un socio? (S/N)");
        
        String r2=sc.nextLine();
            
                
             while(!r2.equalsIgnoreCase("N") && j<socio.length){
               
            /*Dentro de la variable socio insertamos las creadas al principio del programa*/
            
            Socio s=new Socio(dni, nombre, apellido, email, telefono, nSocio);
            
            /*Pedimos los datos por pantalla*/
            try{
            System.out.println("Introduce el DNI del socio:");
            s.setDni(sc.nextLine());
            System.out.println("Introduce el nombre del socio:");
            s.setNombre(sc.nextLine());
            System.out.println("Introduce el apellido del socio:");
            s.setApellido(sc.nextLine());
            System.out.println("Introduce el email del socio");
            s.setEmail(sc.nextLine());
            System.out.println("Introduce el teléfono del socio");
            s.setTelefono(Integer.parseInt(sc.nextLine()));
            System.out.println("Introduce el número identificador del socio");
            s.setNsocio(Integer.parseInt(sc.nextLine()));
            }catch(Exception ex){
                System.out.println(ex+"No se han introducido los valores correctos");
            }
            socio[j]=s;
            
            System.out.println("DATOS DEL SOCIO INTRODUCIDO: ");
            
            /*Llamamos al to string para ver que los datos han sido introducidos correctamente*/
        
            System.out.println(s.toString());
            
            System.out.println("¿Quieres introducir más socios? (S/N)");
            r2=sc.nextLine();
            
            j++;
        }
             /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE SOCIO A LA BASE DE DATOS*/
             
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
            smt=con.createStatement();
            j=0;
            
            /*Con el while que tenemos justo debajo, verificamos si hay datos introducidos en la variable socio,
            si no hay datos, nada se guardadrá en la base de datos.*/
            
            while(j<socio.length && socio[j]!=null){
                smt.executeUpdate("insert into socios values('"+socio[j].getDni()+"','"+socio[j].getNombre()+"','"+socio[j].getApellido()+"','"+socio[j].getEmail()+"',"+socio[j].getTelefono()+","+socio[j].getNsocio()+")");
                j++;
            }
            
            rs=smt.executeQuery("select * from socios");
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n DNI: "+rs.getString("Dni")+"\n Nombre: "+rs.getString("Nombre")+"\n Apellido: "+rs.getString("Apellido")+"\n Email: "+rs.getString("Email")+"\n Telefono: "+rs.getInt("Telefono")+"\n Numero del socio: "+rs.getInt("NumeroSocio"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            registro=sc.nextLine();
        
    break;
    
    /*CASO 3: INSERTAMOS DATOS EN LA CLASE ENTRENADOR.*/ 
    
  case 3:
      
      int k=0;
      
      System.out.println("¿Desea insertar los datos de un entrenador? (S/N)");
        
        String r3=sc.nextLine();
            
                
             while(!r3.equalsIgnoreCase("N") && k<entrenador.length){
                 
             /*Dentro de la variable entrenador insertamos las creadas al principio del programa*/
            
            Entrenador e=new Entrenador(dni, nombre, apellido, email, telefono, nclientes, nombreCliente);
            
            /*Pedimos los datos por pantalla*/
            
            System.out.println("Introduce el DNI del entrenador:");
            e.setDni(sc.nextLine());
            System.out.println("Introduce el nombre del entrenador:");
            e.setNombre(sc.nextLine());
            System.out.println("Introduce el apellido del entrenador:");
            e.setApellido(sc.nextLine());
            System.out.println("Introduce el email del entrenador");
            e.setEmail(sc.nextLine());
            System.out.println("Introduce el teléfono del entrenador");
            e.setTelefono(Integer.parseInt(sc.nextLine()));
            System.out.println("Introduce el número de clientes del entrenador");
            e.setNclientes(Integer.parseInt(sc.nextLine()));
            System.out.println("Introduce el nombre del cliente");
            e.setNombreCliente(sc.nextLine());
            
            entrenador[k]=e;
            
            System.out.println("DATOS DEL ENTRENADOR INTRODUCIDO: ");
        
            System.out.println(e.toString());
            
            System.out.println("¿Quieres introducir más entrenadores? (S/N)");
            r3=sc.nextLine();
            
            k++;
        }
             /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE ENTRENADOR A LA BASE DE DATOS*/
             
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
            smt=con.createStatement();
            k=0;
            while(k<entrenador.length && entrenador[k]!=null){
                smt.executeUpdate("insert into entrenador values('"+entrenador[k].getDni()+"','"+entrenador[k].getNombre()+"','"+entrenador[k].getApellido()+"','"+entrenador[k].getEmail()+"',"+entrenador[k].getTelefono()+","+entrenador[k].getNclientes()+",'"+entrenador[k].getNombreCliente()+"'"+")");
                k++;
            }
            
            rs=smt.executeQuery("select * from entrenador");
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n DNI: "+rs.getString("Dni")+"\n Nombre: "+rs.getString("Nombre")+"\n Apellido: "+rs.getString("Apellido")+"\n Email: "+rs.getString("Email")+"\n Telefono: "+rs.getInt("Telefono")+"\n Numero de clientes: "+rs.getInt("nClientes")+"\n Nombre de los clientes: "+rs.getString("nombreClientes"));
           
            }
            
            
                        
            rs.close();
            smt.close();
            con.close();
            
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            registro=sc.nextLine();
      
    break;
    
    /*CASO 4: INSERTAMOS DATOS EN LA CLASE ACTIVIDAD.*/ 
   
  case 4:
      
      int l=0;
      
      System.out.println("¿Desea insertar una nueva actividad? (S/N)");
        
        String r4=sc.nextLine();
            
                
            while(!r4.equalsIgnoreCase("N") && l<actividad.length){
                
            /*Dentro de la variable actividad insertamos las creadas al principio del programa*/
            
            Actividad a=new Actividad(tipoActividad);
            
            /*Pedimos datos por pantalla*/
            
            System.out.println("Introduce el tipo de actividad:");
            a.setTipoActividad(sc.nextLine());

            
            actividad[l]=a;
            
            System.out.println("DATOS DE LA ACTIVIDAD INTRODUCIDA: ");
        
            System.out.println(a.toString());
            
            System.out.println("¿Quieres introducir más actividades? (S/N)");
            r4=sc.nextLine();
            
            l++;
        }
            /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE ACTIVIDAD A LA BASE DE DATOS*/
            
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
            smt=con.createStatement();
            l=0;
            while(l<actividad.length && actividad[l]!=null){
                smt.executeUpdate("insert into actividad values('"+actividad[l].getTipoActividad()+"'"+")");
                l++;
            }
            
            rs=smt.executeQuery("select * from actividad");
            
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n Tipo de actividad: "+rs.getString("tipoActividad"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            registro=sc.nextLine();
             
      
    break;
    
    /*CASO 5: INSERTAMOS DATOS EN LA CLASE HORARIO.*/ 
   
  case 5:   
            int m=0;
      
      System.out.println("¿Desea insertar un nuevo horario? (S/N)");
        
        String r5=sc.nextLine();
            
                
            while(!r5.equalsIgnoreCase("N") && m<horario.length){
                 
            /*Dentro de la variable horario insertamos las creadas al principio del programa*/
                
            Horario h=new Horario(año, mes, dia, hora, actividadhorario);
            
            /*Pedimos datos por pantalla*/
            
            System.out.println("Introduce un año: ");
            h.setAño(Integer.parseInt(sc.nextLine()));
            
            System.out.println("Introduce un mes: ");
            h.setMes(Byte.parseByte(sc.nextLine()));
            
            System.out.println("Introduce un dia: ");
            h.setDia(Byte.parseByte(sc.nextLine()));
            
            System.out.println("Introduce una hora: ");
            h.setHora(sc.nextLine());
            
            System.out.println("Introduce una actividad: ");
            h.setActividad(sc.nextLine());

            
            horario[m]=h;
            
            System.out.println("DATOS DEL HORARIO INTRODUCIDO: ");
        
            System.out.println(h.toString());
            
            System.out.println("¿Quieres introducir más horarios? (S/N)");
            r5=sc.nextLine();
            
            m++;
        }
            /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE HORARIO A LA BASE DE DATOS*/
          
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
            smt=con.createStatement();
            m=0;
            while(m<horario.length && horario[m]!=null){
                smt.executeUpdate("insert into horario values("+horario[m].getAño()+","+horario[m].getMes()+","+horario[m].getDia()+",'"+horario[m].getHora()+"','"+horario[m].getActividad()+"'"+")");
                m++;
            }
            
            rs=smt.executeQuery("select * from horario");
            
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n Año: "+rs.getInt("Año")+"\n Mes: "+rs.getInt("Mes")+"\n Dia: "+rs.getInt("Dia")+"\n Hora: "+rs.getString("Hora")+"\n Actividad: "+rs.getString("Actividad"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            registro=sc.nextLine();
      
      break;
   
  default:
   
      System.exit(0);
}   
       
         }
        
        
        /*
         * Estos registros están a parte ya que únicamente se pueden insertar una o dos veces,
         * ya que en el gimnasio sólo hay un trabajador de mantenimiento y uno o dos recepcionistas.
         */
        
        
        Mantenimiento[] mantenimiento=new Mantenimiento[1];
        Recepcionista[] recepcionista=new Recepcionista[1];
        
        System.out.println("¿Desea cambiar otros datos? (S/N)");
        String r6=sc.nextLine();
        
        
         while(!r6.equalsIgnoreCase("N")){
        
        int n=0;
        System.out.println("¿Desea insertar un trabajador de Mantenimiento? (S/N)");
        
        String r7=sc.nextLine();
        
        if(!r7.equalsIgnoreCase("N") && n<mantenimiento.length){
            
         int aServicio=0;
         
         /*Dentro de la variable Mantenimiento insertamos las creadas al principio del programa*/
         
         Mantenimiento m=new Mantenimiento(dni, nombre, apellido, email, telefono, aServicio);   
         
            /*Pedimos los datos por pantalla*/
         
            System.out.println("Introduce el DNI de mantenimiento:");
            m.setDni(sc2.nextLine());
            System.out.println("Introduce el nombre de mantenimiento:");
            m.setNombre(sc2.nextLine());
            System.out.println("Introduce el apellido de mantenimiento:");
            m.setApellido(sc2.nextLine());
            System.out.println("Introduce el email de mantenimiento");
            m.setEmail(sc2.nextLine());
            System.out.println("Introduce el teléfono de mantenimiento");
            m.setTelefono(Integer.parseInt(sc2.nextLine()));
            System.out.println("Introduce los años de servicio");
            m.setaServicio(Integer.parseInt(sc2.nextLine()));
            
            mantenimiento[n]=m;
            
            System.out.println("DATOS DEL TRABAJADOR INTRODUCIDO: ");
        
            System.out.println(m.toString());
            
            n++;   
        
        }
        
        /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE MANTENIMIENTO A LA BASE DE DATOS*/
        
        Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
        Statement smt=con.createStatement();
        n=0;
        while(n<mantenimiento.length && mantenimiento[n]!=null){
        smt.executeUpdate("insert into mantenimiento values('"+mantenimiento[n].getDni()+"','"+mantenimiento[n].getNombre()+"','"+mantenimiento[n].getApellido()+"','"+mantenimiento[n].getEmail()+"',"+mantenimiento[n].getTelefono()+","+mantenimiento[n].getaServicio()+")");
        n++;
        
        }
            
            ResultSet rs=smt.executeQuery("select * from mantenimiento");
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n DNI: "+rs.getString("Dni")+"\n Nombre: "+rs.getString("Nombre")+"\n Apellido: "+rs.getString("Apellido")+"\n Email: "+rs.getString("Email")+"\n Telefono: "+rs.getInt("Telefono")+"\n Años de Servicio: "+rs.getInt("aServicio"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
        int o=0;    
        System.out.println("¿Desea insertar un trabajador de Recepcionista? (S/N)");
        String r8=sc.nextLine();
        
        if(!r8.equalsIgnoreCase("N") && o<recepcionista.length){
            
         String turno="";
         
         /*Dentro de la variable recepcionista insertamos las creadas al principio del programa*/
         
         Recepcionista r=new Recepcionista(dni, nombre, apellido, email, telefono, turno);   
         
            /*Pedimos datos por pantalla*/
         
            System.out.println("Introduce el DNI de recepcionista:");
            r.setDni(sc.nextLine());
            System.out.println("Introduce el nombre de recepcionista:");
            r.setNombre(sc.nextLine());
            System.out.println("Introduce el apellido de recepcionista:");
            r.setApellido(sc.nextLine());
            System.out.println("Introduce el email de recepcionista");
            r.setEmail(sc.nextLine());
            System.out.println("Introduce el teléfono de recepcionista");
            r.setTelefono(Integer.parseInt(sc.nextLine()));
            System.out.println("Introduce el turno de trabajo");
            r.setTurno(sc.nextLine());
            
            recepcionista[o]=r;
            
            System.out.println("DATOS DEL TRABAJADOR INTRODUCIDO: ");
        
            System.out.println(r.toString());
            
            o++;
        }
        
        /*PASAMOS LOS DATOS INTRODUCIDOS EN LA VARIABLE RECEPCIONISTA A LA BASE DE DATOS*/
        try{
        con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/gimnasio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "proyectojava", "java");
        smt=con.createStatement();
        o=0;
        while(o<recepcionista.length && recepcionista[o]!=null){
        smt.executeUpdate("insert into recepcionista values('"+recepcionista[o].getDni()+"','"+recepcionista[o].getNombre()+"','"+recepcionista[o].getApellido()+"','"+recepcionista[o].getEmail()+"',"+recepcionista[o].getTelefono()+",'"+recepcionista[o].getTurno()+"'"+")");
        o++;
        
        }
            
            rs=smt.executeQuery("select * from recepcionista");
            
            System.out.println("DATOS INTRODUCIDOS EN LA BASE DE DATOS");
            System.out.println("--------------------------------------");
            while(rs.next()){
            System.out.println("\n DNI: "+rs.getString("Dni")+"\n Nombre: "+rs.getString("Nombre")+"\n Apellido: "+rs.getString("Apellido")+"\n Email: "+rs.getString("Email")+"\n Telefono: "+rs.getInt("Telefono")+"\n Años de Servicio: "+rs.getString("Turno"));
           
            }
            
                        
            rs.close();
            smt.close();
            con.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex+"Ha habido un error en la introducción o vista de datos, por favor verifique los datos introducidos.");
            }
            System.out.println("¿Desea insertar otro tipo de registro? (S/N)");
            r6=sc.nextLine();
            
            
        
        
        
        
        
         }
        
        
    }
    
}
