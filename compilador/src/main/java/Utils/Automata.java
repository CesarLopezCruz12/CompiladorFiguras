/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import Utils.Tokens;
import java.io.IOException;
/**
 *
 * @author rasec
 */
public class Automata {
        
        Tokens token = new Tokens();
        String palabra = "";
        int p;
        
        
        public int automata (int estado, char letra) throws IOException {
            p = letra;
            
            if(p >= 97 && p <= 122){
                
                if(estado == 1){
                    palabra = palabra + letra;
                }else{
                    if(estado != 0){
                        token.guardarToken(palabra, estado);
                        palabra = "" + letra;
                        estado = 1;
                        //token.guardarToken(palabra, estado);
                    }else{
                        estado = 1;
                        palabra = "" + letra;
                    }
                }
            }else if(p >= 48 && p <= 57){
                if(estado == 2){
                    palabra = palabra + letra;
                }else{
                    //token.guardarToken(palabra, estado);
                    if(estado != 0){
                        
                        token.guardarToken(palabra, estado);
                        palabra = "" + letra;
                        estado = 2;
                    }else{
                        estado = 2;
                        palabra = "" + letra;
                    }  
                }
            }else if(p == 123 || letra == 125 || p == 58 || p == 59 || p == 44){
                 if(estado == 3){
                    token.guardarToken(palabra, estado);
                    palabra = "" + letra;
                }else{
                    //token.guardarToken(palabra, estado);
                    if(estado != 0){    
                        token.guardarToken(palabra, estado);
                        estado = 3;
                        palabra = "" + letra;
                        
                    }else{
                        palabra = "" + letra;
                        
                        estado = 3;
                    }
                }  
            }else if(p == 32 || p == 10 || p == 13){
                
                    if(estado == 0){
                        palabra = "";
                    }else{
                        token.guardarToken(palabra, estado); 
                        estado = 0;
                        palabra = "";
                        //token.guardarToken(palabra, estado);
                    }
                    
                    
            }
            
            /*
            
            circulo: area, perimetro {
                radio: 2323,
                color: azul
            },
            
            
            triangulo: area, perimetro{
                lado: 323,
                color: rojo
            }
            */
            
        return estado;
    }
}


