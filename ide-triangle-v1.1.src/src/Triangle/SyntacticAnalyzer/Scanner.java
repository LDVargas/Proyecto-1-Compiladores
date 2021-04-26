/*
 * @(#)Scanner.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


public final class Scanner {

  private SourceFile sourceFile;
  private boolean debug;

  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;
  private HtmlReporter htmlReporter = new HtmlReporter();

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////

  public Scanner(SourceFile source) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    debug = false;
  }

  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.

  private void takeIt() {
//    System.out.println("estado del token "+currentlyScanningToken);
//    System.out.println("char: " + currentChar);
      
    if(currentlyScanningToken == false){
        //System.err.println("entra al if");
        //htmlReporter.prueba();
        htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar);
    }
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
//    System.err.println("char: " + currentChar);
//    System.err.println("spelling: " + currentSpelling);

    
    currentChar = sourceFile.getSource();
  }

  // scanSeparator skips a single separator.

  private void scanSeparator() {    
    switch (currentChar) {
    case '!':
      {
        takeIt();
        System.out.println("entra al separador   " + currentChar);
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT)){
            takeIt();
            //System.out.println("entra al separador   " + currentChar);
//            if(currentSpelling == null){
//                System.err.println("entra al if");
//                htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar, currentSpelling);
//            }
        }
        if (currentChar == SourceFile.EOL){
            takeIt();
            //System.out.println("entra al separador   " + currentChar);
//            if(currentSpelling == null){
//                System.err.println("entra al if");
//                htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar, currentSpelling);
//            }
        }
      }
      
      break;

    case ' ': case '\n': case '\r': case '\t':
        takeIt();
        if(currentSpelling == null){
            //System.err.println("entra al if");
            htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar);
        }
      break;
    }
    
//    if(currentSpelling == null){
//        System.err.println("entra al if");
//        htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar, currentSpelling);
//    }
    
    //
    
    //currentSpelling = new StringBuffer("");
    
    
  }

  /*private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT))
          takeIt();
        if (currentChar == SourceFile.EOL)
          takeIt();
      }
      break;
    case ' ': case '\n': case '\r': case '\t':
      takeIt();
      break;
    }
  }*/
  
  private int scanToken() {

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
      if(currentChar == '.'){
          takeIt();
          return Token.DOUBLEDOT;
      }else
        return Token.DOT;

    case ':'://------------------------------------ ejemplo para el DOUBLEDOT
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
  }

  /*public Token scan() {
    Token tok;
    SourcePosition pos;
    int kind;
      
    
    System.out.println("Scan");
    currentlyScanningToken = false;
    
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();
    if(currentlyScanningToken == false ){
    }
        
    //System.out.println("2");
    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();
    //System.out.println("3");
    kind = scanToken();
    pos.finish = sourceFile.getCurrentLine();
    //System.out.println("5");
    //System.out.println(sourceFile.sourceFile.getName());
    
    tok = new Token(kind, currentSpelling.toString(), pos);
    //System.out.println("6");
    //htmlReporter.generarHTMLToken(sourceFile.sourceFile.getName(),currentSpelling, tok.kind);
    
    if (debug)
      System.out.println(tok);
    //System.out.println("7");
    return tok;
    
  }*/
  
  public Token scan() {
    Token tok;
    SourcePosition pos;
    //HtmlReporter htmlReporter = new HtmlReporter();
    int kind;
      
    
    System.out.println("scan for html");

    currentlyScanningToken = false;
    
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();
    if(currentlyScanningToken == false ){
        //htmlReporter.generarHTMLChar(sourceFile.sourceFile.getName(), currentChar,currentSpelling);
        //System.err.println("Cuando es false "+currentSpelling);
    }
        
    //System.out.println("2");

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();

    //System.out.println("3");
    kind = scanToken();
    pos.finish = sourceFile.getCurrentLine();
    //System.out.println("5");
    //System.out.println(sourceFile.sourceFile.getName());
    
    tok = new Token(kind, currentSpelling.toString(), pos);
    htmlReporter.generarHTMLToken(sourceFile.sourceFile.getName(),currentSpelling, tok.kind);
    
    if (debug)
      System.out.println(tok);
    //System.out.println("7");
    return tok;

    }
}