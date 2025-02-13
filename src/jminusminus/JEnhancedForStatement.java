
package jminusminus;

import java.util.ArrayList;

import static jminusminus.CLConstants.*;

class JEnhancedForStatement extends JStatement {
    private ArrayList<JStatement> init;

    private JStatement elem;

    private JExpression collection;

    private JStatement body;

    public JEnhancedForStatement(int line, JStatement elem, JExpression collection, JStatement body) {
        super(line);
        this.elem = elem;
        this.collection = collection;
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
        json.addChild("JEnhancedForStatement:" + line, e);
        if (elem != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Element", e1);
            elem.toJSON(e1);
        }
        if (collection != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Collection", e1);
            collection.toJSON(e1);
        }
        if (body != null) {
            JSONElement e1 = new JSONElement();
            e.addChild("Body", e1);
            body.toJSON(e1);
        }
    }
}
