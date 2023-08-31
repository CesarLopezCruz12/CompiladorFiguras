/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import Entity.Token;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author rasec
 */
public class Tokens {
    
    private File archivo= new File("Tokens.dat");
    private static ObjectInputStream entrada;
    private static ObjectOutputStream salida;
    int pos = 0;
    private static ArrayList<Token> listtk = new ArrayList();
  
    public void Escribir () throws FileNotFoundException, IOException{
        ObjectOutputStream salida;
        try (FileOutputStream fileoutput = new FileOutputStream(archivo)) {
            salida = new ObjectOutputStream(fileoutput);
            salida.writeObject(listtk);
            System.out.println("Token areggado");
        }
        salida.close();
    }
    
    
    public void guardarToken(String palabra, int estado) throws IOException{
            //System.out.println(palabra + " " + estado);
            
        switch (estado) {
            case 1 -> {
                pos++;
                Token tk = new Token(pos, palabra, "ID");
                listtk.add(tk);
            }
            case 2 -> {
                pos++;
                Token tk = new Token(pos, palabra, "#");
                listtk.add(tk);
                
            }
            case 3 -> {
                pos++;
                Token tk = new Token(pos, palabra, "O");
                listtk.add(tk);
            }
            default -> {
                
                pos++;
                Token tk = new Token(pos, palabra, "NULL");
                listtk.add(tk);
            }
        }
    }
    public void Leer(){        
                for(Token tkn: listtk){
                    System.out.println(tkn.getPos() + " " +
                                    tkn.getToken() + " " + 
                                    tkn.getLexema());
                }
    }
    
    
    public void obtenerDatos() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileinput = new FileInputStream(archivo);
        try (ObjectInputStream entrada = new ObjectInputStream(fileinput)) {
            listtk = (ArrayList) entrada.readObject();
            for(Token tkn: listtk){
                System.out.println(tkn.getPos() + " " +
                                    tkn.getToken() + " " + 
                                    tkn.getLexema());
            }
        }
    }
}