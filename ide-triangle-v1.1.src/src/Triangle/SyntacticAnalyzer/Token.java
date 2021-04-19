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
    BEGIN = 5,
    CHOOSE              = 6,      
    CONST		= 7,
    DO			= 8,
    ELSE		= 9,
    ELSEIF              =10,
    END			= 11,
    FUNC		= 12,
    FOR = 13,
    FROM = 14,
    IF			= 15,
    IN			= 16,
    LET			= 17,
    LOOP = 18,
    NOTHING = 19,
    OF			= 20,
    PACKAGE = 21,
    PRIVATE = 22,
    PROC		= 23,
    RECORD		= 24,
    RECURSIVE = 25,
    THEN		= 26,
    TO = 27,
    TYPE		= 28,
    UNTIL = 29,
    VAR			= 30,
    WHEN = 31,
    WHILE		= 32,

    // punctuation...
    DOT			= 33,
    COLON		= 34,
    SEMICOLON	= 35,
    COMMA		= 36,
    BECOMES		= 37,
    IS			= 38,
    STICK = 39,
    DOLAR = 40,
    DOUBLEDOT = 41,
    

    // brackets...
    LPAREN		= 42,
    RPAREN		= 43,
    LBRACKET	= 44,
    RBRACKET	= 45,
    LCURLY		= 46,
    RCURLY		= 47,

    // special tokens...
    EOT			= 48,
    ERROR		= 49;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "begin",
    "choose",
    "const",
    "do",
    "else",
    "elseif",
    "end",
    "func",
    "for",
    "from",
    "if",
    "in",
    "let",
    "loop",
    "nothing",
    "of",
    "package",
    "private",
    "proc",
    "record",
    "recursive",
    "then",
    "to",
    "type",
    "until",
    "var",
    "when",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",
    "$",
    "..",//preguntar por el doble punto al profe
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
