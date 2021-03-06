/*
 * @(#)Token.java                        2.1 2003/10/07
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


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    CHOOSE              = 5,      
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    ELSIF              =9,//cambiar a elsif, abajo igual
    END			= 10,
    FOR = 11,
    FROM = 12,
    FUNC		= 13,
    
    
    IF			= 14,
    IN			= 15,
    LET			= 16,
    LOOP = 17,
    NOTHING = 18,
    OF			= 19,
    PACKAGE = 20,
    PRIVATE = 21,
    PROC		= 22,
    RECORD		= 23,
    RECURSIVE = 24,
    THEN		= 25,
    TO = 26,
    TYPE		= 27,
    UNTIL = 28,
    VAR			= 29,
    WHEN = 30,
    WHILE		= 31,

    // punctuation...
    DOT			= 32,
    COLON		= 33,
    SEMICOLON	= 34,
    COMMA		= 35,
    BECOMES		= 36,
    IS			= 37,
    STICK = 38,
    DOLAR = 39,
    DOUBLEDOT = 40,
    

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET	= 43,
    RBRACKET	= 44,
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  public static String[] tokenTable = new String[] {
    "<int>",    //0
    "<char>",//1
    "<identifier>",//2
    "<operator>",//3
    "array",//4
    //"begin",//quitar
    "choose",//5
    "const",//6
    "do",//7
    "else",//8
    "elsif",//9
    "end",//10
    "for",//11
    "from",//12
    "func",    //13
    "if",//14
    "in",//15
    "let",//16
    "loop",//17
    "nothing",//18
    "of",//19
    "package",//20
    "private",//21
    "proc",//22
    "record",//23
    "recursive",//24
    "then",//25
    "to",//26
    "type",//27
    "until",//28
    "var",//29
    "when",//30
    "while",//31
    ".",//32
    ":",//33
    ";",//34
    ",",//35
    ":=",//36
    "~",//37
    "|",//38
    "$",//39
    "..",//40
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
