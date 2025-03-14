// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham & Jeremiah

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a conditional expression.
 */
class JConditionalExpression extends JExpression {
    // Test expression.
    private JExpression condition;

    // Then part.
    private JExpression thenPart;

    // Else part.
    private JExpression elsePart;

    /*
     * TODO:
     * Exercise 5.11. Add conditional expressions to j--, adding them to your
     * compiler and testing
     * them thoroughly (provide short example programs to test them). Conditional
     * expressions are
     * compiled in a manner identical to if-else statements. The only difference is
     * that in this case,
     * both the consequent and the alternative are expressions.
     */
    /**
     * Constructs an AST node for a conditional expression.
     *
     * @param line      line in which the conditional expression occurs in the
     *                  source file.
     * @param condition test expression.
     * @param thenPart  then part.
     * @param elsePart  else part.
     */
    public JConditionalExpression(int line, JExpression condition, JExpression thenPart,
            JExpression elsePart) {
        super(line);
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        condition = condition.analyze(context);
        //condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        thenPart = thenPart.analyze(context);
        elsePart = elsePart.analyze(context);
        type = thenPart.type();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        String elseLabel = output.createLabel();
        String endLabel = output.createLabel();
        condition.codegen(output, elseLabel, false);
        thenPart.codegen(output);
        output.addBranchInstruction(GOTO, endLabel);
        output.addLabel(elseLabel);
        elsePart.codegen(output);
        output.addLabel(endLabel);
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JConditionalExpression:" + line, e);
        JSONElement e1 = new JSONElement();
        e.addChild("Condition", e1);
        condition.toJSON(e1);
        JSONElement e2 = new JSONElement();
        e.addChild("ThenPart", e2);
        thenPart.toJSON(e2);
        JSONElement e3 = new JSONElement();
        e.addChild("ElsePart", e3);
        elsePart.toJSON(e3);
    }
}
