/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql2;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.CallableStatement;

/**
 *insert into Java.Tabla1(nombre,edad) values ("hugo", 19),("lluis",30),("pere",15);
 * 
 * CREATE TABLE new_table LIKE old_table;     

To copy the data across, if required, use

INSERT INTO new_table SELECT * FROM old_table;  
 * @author hugo
 */
public class ConectToDB {
    
    //declarar Objetos coenxion
    Connection miConexion;
    PreparedStatement  consulta;
     Statement  percutor;
    ResultSet datos;
    private Object con;
    
    //clase crear obtenerConexion
    public Connection getConnection(String BBDD, String usuario, String contraseña)
    {
        try {
            //llamar a al clase drive de jdbc
            Class.forName("com.mysql.jdbc.Driver");
            //despes // iria dirrecion si es web pues web y la BBDD especifica
            String servidor = "jdbc:mysql://localhost:3306/"+BBDD;
            
            miConexion = (Connection) DriverManager.getConnection(servidor, usuario, contraseña);
        } catch (ClassNotFoundException e  ) {
            JOptionPane.showMessageDialog(null,"No se encontroDriver");
                miConexion=null;
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo conectar BBDD"+ex);
                miConexion=null;
             }
        return miConexion;
    }
    
    
    
    public void insertar()
    {
        try {
            //conexion BBDD especifica
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            String insertTableSQL = "insert into Tabla1(nombre,edad) values"
		+ "(?,?)";
            // enviar consulta
            consulta=miConexion.prepareStatement(insertTableSQL);
            consulta.setInt(2, 11);
            consulta.setString(1, "mkyong");
            
            //ejecutar consulta y guardar consulta executeUpdate();
            //datos= consulta.executeQuery();
            consulta.executeUpdate();
            //mostrar los datos siguiente en siguiente
         
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo hacer insertar " +ex);
        }finally{
            //para descoenctar todo
            this.desconectar();
            consulta();
        }
    }
    
    
    
    
    
    public void consulta()
    {
        try {
            //conexion BBDD especifica
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            // enviar consulta
            consulta=miConexion.prepareStatement("SELECT nombre,edad FROM Java.Tabla1");
            //ejecutar consulta y guardar consulta
            datos= consulta.executeQuery();
            //mostrar los datos siguiente en siguiente
            while(datos.next())
            {
                System.out.println("nombre: "+ datos.getString("nombre")+"  --- edad: "+datos.getInt("edad"));
            }  
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo hacer consulta " +ex);
        }finally{
            //para descoenctar todo
            this.desconectar();
        }
    }
    
    public void desconectar()
    {
        try {
            this.miConexion.close();
            this.consulta.close();
            this.datos= null;
            
        } catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo cerrar");
        }
    }
    
    
     public void crearTablaCopia(String s )
    {
        try {
            //conexion BBDD especifica
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            
           //CREATE TABLE clone_like LIKE tabla_origen
            String copia = "CREATE TABLE "+s +" LIKE Tabla1";
            // enviar consulta
            consulta=miConexion.prepareStatement(copia);           
            //consulta.setString(1,s);
            
            //ejecutar consulta y guardar consulta executeUpdate();
            //datos= consulta.executeQuery();
            consulta.executeUpdate();
            //mostrar los datos siguiente en siguiente
         
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo hacer insertar " +ex);
                System.out.println("ex: "+ ex);
        }finally{
            //para descoenctar todo
            this.desconectar();
            //consulta();
        }
    }
    
     
     public void crearTabla()
    {
        try {
            //conexion BBDD especifica
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            String taula = "CREATE TABLE nota" +
                   "(id INTEGER not NULL  AUTO_INCREMENT, " +
                   " plato VARCHAR(30), " + 
                   " cantidad INTEGER, " + 
                   " camarero INTEGER, " +
                   " tiempo  TIME, " + 
                      " PRIMARY KEY ( id ) )"; 
            //String insertTableSQL = "CREATE TABLE ? LIKE Tabla1";
            // enviar consulta
            consulta=miConexion.prepareStatement(taula);           
            //consulta.setString(1,s);
            
            //ejecutar consulta y guardar consulta executeUpdate();
            //datos= consulta.executeQuery();
            consulta.executeUpdate();
            //mostrar los datos siguiente en siguiente
         
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo hacer insertar " +ex);
                System.out.println("ex: "+ ex);
        }finally{
            //para descoenctar todo
            this.desconectar();
            //consulta();
        }
    }
     
      
    public void cambiarValor()
    {
        try {
            //conexion BBDD especifica
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            //UPDATE refranero SET fecha="2003-06-01" WHERE ID=1
            //UPDATE refranero SET refran="Más vale pájaro en mano que ciento volando" WHERE refran LIKE "%párajo%";
            // DELETE FROM refranero where id =1;
            //DELETE FROM refranero WHERE LIKE "%amor%";
            //DELETE FROM refranero;  //borrar todo los datos
            //DROP TABLE refranero; // eliminar tabla
            //DROP DATABASE refranes;
            //DELETE FROM reservation_seats WHERE reservation_id NOT IN ( SELECT id FROM reservation)
            String insertTableSQL = "UPDATE Tabla1 SET nombre=\"Ursuolapapap\" WHERE idTabla1=2";
            // "insert into Tabla1(nombre,edad) values+ "(?,?)";
            // enviar consulta
            consulta=miConexion.prepareStatement(insertTableSQL);
            //consulta.setInt(2, 11);
            //consulta.setString(1, "mkyong");
            
            //ejecutar consulta y guardar consulta executeUpdate();
            //datos= consulta.executeQuery();
            consulta.executeUpdate();
            //mostrar los datos siguiente en siguiente
         
        }catch ( SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo hacer insertar " +ex);
        }finally{
            //para descoenctar todo
            this.desconectar();
            consulta();
        }
    }
     
    
    /*
            CREATE [DEFINER={usuario|CURRENT_USER}]
            TRIGGER nombre_del_trigger {BEFORE|AFTER} {UPDATE|INSERT|DELETE}
            ON nombre_de_la_tabla
            FOR EACH ROW
    */
    
     public void Disparador()         
     {   
         
        try {
            miConexion= (Connection) this.getConnection("Java","root","antonia");
            Statement  percutor = miConexion.createStatement();
            percutor.execute("CREATE TRIGGER Java.SegundaBala BEFORE UPDATE ON Java.Tabla1 "
            + "FOR EACH ROW "
            + "BEGIN "
            + "insert into Tabla1(nombre,edad) values ('sex',99);"
            + "END;");  
            
           //percutor.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }  
     }  
     
     
     
     public void Procedimiento() 
     {
         miConexion= (Connection) this.getConnection("Java","root","antonia");
            
        try {
            percutor = miConexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            percutor.execute(
                    "CREATE PROCEDURE procedimiento()\n "
                            +"BEGIN \n"
                            + "insert into Tabla1(nombre,edad) values (\"sex\",199);\n "
                            + "END \n");
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            percutor.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        
         
     }
     /*
                CREATE PROCEDURE demoSp(IN inputParam VARCHAR(255), \
                        INOUT inOutParam INT)
                BEGIN
                DECLARE z INT;
            SET z = inOutParam + 1;
                SET inOutParam = z;
                
                SELECT inputParam;

                SELECT CONCAT('zyxw', inputParam);
                END
                  //CallableStatement cStmt = miConexion.prepareCall("{call demoSp(?, ?)}");
            //cStmt.setString(1, "abcdefg");
     
     
     */
     public void Disparo()
     {
          miConexion= (Connection) this.getConnection("Java","root","antonia");
        try {
            CallableStatement llamada= miConexion.prepareCall("{call Tabla1.PrimeraBala()}");
            //CallableStatement cStmt = miConexion.prepareCall("{call demoSp(?, ?)}");
            //cStmt.setString(1, "abcdefg");
            llamada.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
     }
     
     public void CallProdecimiento()
     {
          miConexion= (Connection) this.getConnection("Java","root","antonia");
        try {
            CallableStatement llamada= miConexion.prepareCall("{call procedimiento()}");
            //CallableStatement cStmt = miConexion.prepareCall("{call demoSp(?, ?)}");
            //cStmt.setString(1, "abcdefg");
            llamada.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConectToDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
     }
     
     
     /*
     
            mysql> CREATE USER 'guacamole_user'@'localhost' IDENTIFIED BY 'some_password';

            mysql> GRANT SELECT,INSERT,UPDATE,DELETE ON guacamole_db.* TO 'guacamole_user'@'localhost';

            mysql> FLUSH PRIVILEGES;
     */
}
