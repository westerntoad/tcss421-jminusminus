package jminusminus;

import java.util.ArrayList;

import static jminusminus.CLConstants.*;

/**
 * The AST node for an enhanced for-statement.
 * @author Corey Young
 * @version 1.0
 */
class JEnhancedForStatement extends JStatement {
    // Data to be used.
    private JStatement data;

    // Source of data
    private JExpression source;

    // The body.
    private JStatement body;


    /**
     * Constructs an AST node for a for-statement.
     *
     * @param line      line in which the for-statement occurs in the source file.
     * @param data      the data.
     * @param source the spource of the data.
     * @param body      the body.
     */
    public JEnhancedForStatement(int line, JStatement data, JExpression source, JStatement body) {
        super(line);
        this.data = data;
        this.source = source;
        this.body = body;
    }

    /**
     * {@inheritDoc}
     */
    public JEnhancedForStatement analyze(Context context) {
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
        json.addChild("JForStatement:" + line, e);
        if (data != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Data", e1);
            data.toJSON(e1);
        }
        if (source != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Condition", e1);
            source.toJSON(e1);
        }
        if (body != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Body", e1);
            body.toJSON(e1);
        }
    }
}
