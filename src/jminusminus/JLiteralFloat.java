package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a float literal.
 * @author Corey Young
 * @version 1.0
 */
class JLiteralFloat extends JExpression {
    // String representation of the literal.
    private String text;

    /**
     * Constructs an AST node for a float literal given its line number and string representation.
     *
     * @param line line in which the literal occurs in the source file.
     * @param text string representation of the literal.
     */
    public JLiteralFloat(int line, String text) {
        super(line);
        this.text = text;
    }

    /**
     * Returns the literal as a float.
     *
     * @return the literal as a float.
     */
    public double toFloat() {
        return Float.parseFloat(text);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        type = Type.FLOAT;
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
        json.addChild("JLiteralFloat:" + line, e);
        e.addAttribute("type", type == null ? "" : type.toString());
        e.addAttribute("value", text);
    }
}
