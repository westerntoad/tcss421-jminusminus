// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham & Jeremiah

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * An AST node for a throw-statement.
 */
class JThrowStatement extends JStatement {
    // The thrown exception.
    private JExpression expr;

    /*
     * TODO:
     * (Bonus) Exercise 5.15. Add the throw-statement to j--, adding it to your
     * compiler and testing
     * it thoroughly (provide short example programs to test it). The
     * throw-statement is
     * straightforwardly compiled to JVM code using the athrow instruction;
     */
    /**
     * Constructs an AST node for a throw-statement.
     *
     * @param line line in which the throw-statement appears in the source file.
     * @param expr the returned expression.
     */
    public JThrowStatement(int line, JExpression expr) {
        super(line);
        this.expr = expr;
    }

    /**
     * {@inheritDoc}
     */
    public JStatement analyze(Context context) {
        // TODO
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JThrowStatement:" + line, e);
        JSONElement e1 = new JSONElement();
        e.addChild("Expression", e1);
        expr.toJSON(e1);
    }
}
