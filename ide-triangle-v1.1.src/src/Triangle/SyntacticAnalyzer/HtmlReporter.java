/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;
import javax.swing.*;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author daniel
 */
public class HtmlReporter {
    public void generarHTMLToken(String nombreArchivo, StringBuffer currentSpelling, int kind) {
        String x = null;
        x = nombreArchivo.substring(0, nombreArchivo.length()-3);
        
        
        
        File archivo = new File("\\" + x + ".html");
        if(archivo.exists() == false){
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                System.err.println("error" + e);
            }
        }
        
        //System.out.println("nombre archivo" + archivo.getName());
                
        FileWriter flWriter = null;
        try {
            
            flWriter = new FileWriter(nombreArchivo,true);
            BufferedWriter bfWriter  = new BufferedWriter(flWriter);
            //System.out.println("current " + currentSpelling);
            //System.out.println("kind " + kind);
            
            
            if(kind >= 4 && kind <= 32){
                System.err.println("kind en html " + kind);
                bfWriter.write("<b>" + currentSpelling.toString() + "</b>");
                //pWriter.println("<b>" + currentSpelling + "</b>");
            }
            if(kind == 0 || kind == 1){
                bfWriter.write("<font style='padding-left:1em'><font color='#0000cd'>" + 
                        currentSpelling + "</font>");
                //pWriter.println("<font style='padding-left:1em'><font color='#0000cd'>" + 
                //        currentSpelling + "</font>");
            }
            if( kind >= 33){
                bfWriter.write(currentSpelling.toString());
            }
            
            if(kind == 2){
                System.err.println("current spelling no es un token " + currentSpelling);
                bfWriter.write(currentSpelling.toString());
            }
            /*else{    
                bfWriter.write(currentSpelling.toString());
                //pWriter.println(currentSpelling);
            }*/
            
            

            
            
            
            bfWriter.close();
            flWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(flWriter != null){
                try {
                    flWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public void generarHTMLChar(String nombreArchivo, char currentChar){
        //System.out.println("entra al generar char");
        String x = null;
        x = nombreArchivo.substring(0, nombreArchivo.length()-3);      
        
        
        File archivo = new File("\\" + x + ".html");
        if(archivo.exists() == false){
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                System.err.println("error" + e);
            }
        }
        
        //System.out.println("nombre archivo" + archivo.getName());
                
        FileWriter flWriter = null;
        try {
            
            flWriter = new FileWriter(nombreArchivo,true);
            BufferedWriter bfWriter  = new BufferedWriter(flWriter);
            
            //bfWriter.write("<p style="+"font-family: 'DejaVu Sans', monospace;"+"><font color='#00b300'>" +currentChar + "</font>\\");
            
            if(currentChar == '\n' || currentChar == '\r'){
                bfWriter.write("<br>");
            }
            if(currentChar == '\t'){
                System.out.println("tabulacion");
                bfWriter.write("&nbsp;");
            }
            else{
                bfWriter.write(currentChar);
            }
            //System.out.println(currentChar);
            //bfWriter.write("escribe en el html");
            /*switch (currentChar) {
                case '!':{
                    bfWriter.write(currentChar);
                    while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT))
                      //bfWriter.write("<p style="+"font-family: 'DejaVu Sans', monospace;"+"><font color='#00b300'>" +currentChar + "\</font>\");
                      bfWriter.write(currentChar);
                    if (currentChar == SourceFile.EOL)
                        bfWriter.write("<br>");
                        //bfWriter.write(" +\"</font>\"  <br>");
                    break;
                  }

                case '\r':{
                    bfWriter.write("<br>");
                }
                case ' ':{ 
                    bfWriter.write(" ");
                    break;
                }
                case '\n': {
                  bfWriter.write("<br>");
                  break;
                }

                case '\t':{
                    bfWriter.write("    ");
                }
            }*/
            bfWriter.close();
            flWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(flWriter != null){
                try {
                    flWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void prueba(){
        System.out.println("prueba de htmlReporter");
    }
    
}
