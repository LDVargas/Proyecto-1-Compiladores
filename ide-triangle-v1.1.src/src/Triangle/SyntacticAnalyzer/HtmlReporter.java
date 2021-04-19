/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;
import javax.swing.*;
import java.io.*;

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
            
            
            if(kind >= 4 || kind <= 32){
                bfWriter.write("<b>" + currentSpelling.toString() + "</b>");
                //pWriter.println("<b>" + currentSpelling + "</b>");
            }
            if(kind == 0 || kind == 1){
                bfWriter.write("<font style='padding-left:1em'><font color='#0000cd'>" + 
                        currentSpelling + "</font>");
                //pWriter.println("<font style='padding-left:1em'><font color='#0000cd'>" + 
                //        currentSpelling + "</font>");
            }/*else{
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



/*private int scanToken() {

    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      return Token.IDENTIFIER;

    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
      return Token.INTLITERAL;

    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      while (isOperator(currentChar))
        takeIt();
      return Token.OPERATOR;

    case '\'':
      takeIt();
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        return Token.CHARLITERAL;
      } else
        return Token.ERROR;

    case '.':
      takeIt();
      return Token.DOT;

    case ':':
      takeIt();
      if (currentChar == '=') {
        takeIt();
        return Token.BECOMES;
      } else
        return Token.COLON;

    case ';':
      takeIt();
      return Token.SEMICOLON;

    case ',':
      takeIt();
      return Token.COMMA;

    case '~':
      takeIt();
      return Token.IS;

    case '|':
        takeIt();
        return Token.STICK;
        
    case '$':
        takeIt();
        return Token.DOLAR;        
      
    case '(':
      takeIt();
      return Token.LPAREN;

    case ')':
      takeIt();
      return Token.RPAREN;

    case '[':
      takeIt();
      return Token.LBRACKET;

    case ']':
      takeIt();
      return Token.RBRACKET;

    case '{':
      takeIt();
      return Token.LCURLY;

    case '}':
      takeIt();
      return Token.RCURLY;

    case SourceFile.EOT:
      return Token.EOT;

    default:
      takeIt();
      return Token.ERROR;
    }
  }*/
