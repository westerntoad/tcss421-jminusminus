// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham and Jeremiah

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a float literal.
 */
class JLiteralFloat extends JExpression {
    // String representation of the literal.
    private String text;

    /**
     * Constructs an AST node for a float literal given its line number and string
     * representation.
     *
     * @param line line in which the literal occurs in the source file.
     * @param text string representation of the literal.
     */
    public JLiteralFloat(int line, String text) {
        super(line);
        this.text = text;
    }

    // TODO: Exercise 3.21. Modify the Parser to parse and return nodes for the
    // double literal and the float literal.
    /**
     * Returns the literal as a float.
     *
     * @return the literal as a float.
     */
    public float toFloat() {
        return Float.parseFloat(text.substring(0, text.length() - 1));
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
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
        json.addChild("JLiteralfloat:" + line, e);
        e.addAttribute("type", type == null ? "" : type.toString());
        e.addAttribute("value", text);
    }
}
