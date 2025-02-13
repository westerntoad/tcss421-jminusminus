// Created 2025 - Abraham and Jeremiah

package jminusminus;

import static jminusminus.CLConstants.*;

public class JTernaryExpression extends JExpression {
    protected JExpression lhs;

    protected JExpression mid;

    protected JExpression rhs;

    protected JTernaryExpression(int line, JExpression lhs, JExpression mid, JExpression rhs) {
        super(line);
        this.lhs = lhs;
        this.mid = mid;
        this.rhs = rhs;
    }

    /** {@inheritDoc} */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JTernaryExpression:" + line, e);
        e.addAttribute("type", type == null ? "" : type.toString());
        JSONElement e1 = new JSONElement();
        e.addChild("Operand1", e1);
        lhs.toJSON(e1);
        JSONElement e2 = new JSONElement();
        e.addChild("Operand2", e2);
        mid.toJSON(e2);
        JSONElement e3 = new JSONElement();
        e.addChild("Operand3", e3);
        rhs.toJSON(e3);
    }

    public JExpression analyze(Context context) {
        // TODO
        return null;
    }

    public void codegen(CLEmitter output) {
        // TODO
    }
}
