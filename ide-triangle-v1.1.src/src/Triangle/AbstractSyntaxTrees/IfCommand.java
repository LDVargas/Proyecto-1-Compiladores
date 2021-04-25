/*
 * @(#)IfCommand.java                        2.1 2003/10/07
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

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class IfCommand extends Command {

  public IfCommand (Expression eAST, Command c1AST, Command c2AST,
                    SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    C1 = c1AST;
    C2 = c2AST;
  }

    public IfCommand(Expression E, Command C1, SourcePosition thePosition) {
        super(thePosition);
        this.E = E;
        this.C1 = C1;
    }

    public IfCommand(Expression E, Command C1, Command C2, Command C3, SourcePosition thePosition) {
        super(thePosition);
        this.E = E;
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
    }

    
  
  public Object visit(Visitor v, Object o) {
    return v.visitIfCommand(this, o);
  }

  public Expression E;
  public Command C1, C2,C3;
}
