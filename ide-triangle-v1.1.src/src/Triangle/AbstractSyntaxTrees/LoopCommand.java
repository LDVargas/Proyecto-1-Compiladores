/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopCommand extends Command{

    public LoopCommand(Expression eAST, Command c1AST, SourcePosition thePosition) {
        super(thePosition);
        E1 = eAST;
        C = c1AST;
    }
    public LoopCommand(Command c1AST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        E1 = eAST;
        C = c1AST;
    }

    public LoopCommand(Expression E, Expression E2, Command C, Identifier I, SourcePosition thePosition) {
        super(thePosition);
        this.E1 = E;
        this.E2 = E2;
        this.C = C;
        this.I = I;
    }

    public LoopCommand(Expression E1, Expression E2, Expression E3, Command C, Identifier I, SourcePosition thePosition) {
        super(thePosition);
        this.E1 = E1;
        this.E2 = E2;
        this.E3 = E3;
        this.C = C;
        this.I = I;
    }

    
    public Object visit2(Visitor v, Object o){
        return v.visitLoopCommand2(this, o);
    }
    
    public Object visit4(Visitor v, Object o){
        return v.visitLoopCommand4(this, o);
    }
    
    public Object visit5(Visitor v, Object o){
        return v.visitLoopCommand5(this, o);
    }
    
    public Expression E1,E2,E3;
    public Command C;
    public Identifier I;

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
