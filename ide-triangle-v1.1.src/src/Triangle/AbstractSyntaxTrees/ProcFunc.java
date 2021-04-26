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
public abstract class ProcFunc extends AST{

    public ProcFunc(SourcePosition thePosition) {
        super(thePosition);
    }
    
}
