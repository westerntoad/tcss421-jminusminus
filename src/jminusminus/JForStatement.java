// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import java.util.ArrayList;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a for-statement.
 *  @version 2.0
 *  @author Corey Young
 */
class JForStatement extends JStatement {
    // Initialization.
    private ArrayList<JStatement> init;

    // Test expression
    private JExpression condition;

    // Update.
    private ArrayList<JStatement> update;

    // The body.
    private JStatement body;

    /**
     * Constructs an AST node for a for-statement.
     *
     * @param line      line in which the for-statement occurs in the source file.
     * @param init      the initialization.
     * @param condition the test expression.
     * @param update    the update.
     * @param body      the body.
     */
    public JForStatement(int line, ArrayList<JStatement> init, JExpression condition,
                         ArrayList<JStatement> update, JStatement body) {
        super(line);
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }

    //Assignment 5.7
    //Check inits (can be multiple seperated by commas)
    //check condition (there can be only one)
    //check updates (can be multiple seperated by commas)
    //check body & return
    /**
     * {@inheritDoc}
     */
    public JForStatement analyze(Context context) {
        for(JStatement initStatement : init) {
            initStatement = (JStatement) initStatement.analyze(context);
        }
        condition = condition.analyze(context);
        condition.type().mustMatchExpected(line, Type.BOOLEAN);
        for(JStatement updateStatement : update) {
            updateStatement = (JStatement) updateStatement.analyze(context);
        }
        body = (JStatement) body.analyze(context);
        return this;
    }

    //generate initializers
    //generate condition check
    //generate body
    //Afterwards generate updates
    //Jump back to condition check
    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        String conditionCheck = output.createLabel();
        String exitLoop = output.createLabel();
        for (JStatement initStatement : init) {
            initStatement.codegen(output);
        }
        output.addLabel(conditionCheck);
        condition.codegen(output, exitLoop, false);
        body.codegen(output);
        for (JStatement updateStatement : update) {
            updateStatement.codegen(output);
        }
        output.addBranchInstruction(GOTO, conditionCheck);
        output.addLabel(exitLoop);
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JForStatement:" + line, e);
        if (init != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Init", e1);
            for (JStatement stmt : init) {
                stmt.toJSON(e1);
            }
        }
        if (condition != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Condition", e1);
            condition.toJSON(e1);
        }
        if (update != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Update", e1);
            for (JStatement stmt : update) {
                stmt.toJSON(e1);
            }
        }
        if (body != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Body", e1);
            body.toJSON(e1);
        }
    }
}
