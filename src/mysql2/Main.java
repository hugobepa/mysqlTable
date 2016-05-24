/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql2;

/**
 *https://www.youtube.com/watch?v=lGVriqnxysU&list=PLMTiAh6qhda2-RucubaToZXaIJL2vOC4l&index=5
 * @author hugo
 */
public class Main {

    /**
     * @param args the command line arguments
     * newo
     * ConectoToDB
     */
    public static void main(String[] args) {
         ConectToDB ctb = new ConectToDB();
         
         //conectToDB.consulta();
        //ctb.cambiarValor();
        //ctb.crearTabla();
         //ctb.Disparador();
         //ctb.Procedimiento();
            ctb.CallProdecimiento();
    }
    
}
