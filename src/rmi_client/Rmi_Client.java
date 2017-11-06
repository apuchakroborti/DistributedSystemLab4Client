/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_client;

import Rmi_Interface.MethodInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author apu
 */
public class Rmi_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try{
        //Getting the registry
        Registry registry=LocateRegistry.getRegistry("localhost");
        //Looking up the registry for the remote object 
        MethodInterface stub=(MethodInterface) registry.lookup("Hello");
        Scanner input=new Scanner(System.in);
        
        System.out.println("1.CaesarCipher\n2.VigenereCipher\n");
        int choice=input.nextInt();
        if(choice==1)
        {
            String result2=stub.CaesarCipher();
            System.out.println("Result from server:"+result2);
        }
        else if(choice==2){
            String result=stub.VigenereCipher();
            System.out.println("Result from server:"+result);
        
        }
        //calling the remote method using the obtained object
        
        System.out.println("Remote method invoked");
        
        }catch(Exception e){
            System.err.println("Client exception: "+e.toString());
            e.printStackTrace();
        }
    }
    
}
