/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author danie
 */
public class PrivateDeclaration extends Declaration{
    public Declaration D1,D2;

    public PrivateDeclaration(Declaration D1, Declaration D2, SourcePosition thePosition) {
        super(thePosition);
        this.D1 = D1;
        this.D2 = D2;
    }
    
    public Object visit(Visitor v, Object o){
        return v.visitPrivateDeclaration(this, o);
    }
}
