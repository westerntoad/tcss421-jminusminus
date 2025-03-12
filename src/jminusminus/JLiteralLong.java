// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham & Jeremiah

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a long literal.
 */
class JLiteralLong extends JExpression {
    // String representation of the literal.
    private String text;

    /*
     * (Bonus) Exercise 5.21. Add the primitive type long to j--, adding it to your
     * compiler and
     * testing it thoroughly (provide short example programs to test it).
     */
    /**
     * Constructs an AST node for a long literal given its line number and string
     * representation.
     *
     * @param line line in which the literal occurs in the source file.
     * @param text string representation of the literal.
     */
    public JLiteralLong(int line, String text) {
        super(line);
        this.text = text;
    }

    /**
     * Returns the literal as a long.
     *
     * @return the literal as a long.
     */
    public long toLong() {
        return Long.parseLong(text.substring(0, text.length() - 1));
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        type = Type.LONG;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        long i = toLong();
        if (i == 0L) {
            output.addNoArgInstruction(LCONST_0);
        } else if (i == 1L) {
            output.addNoArgInstruction(LCONST_1);
        } else {
            output.addLDCInstruction(i);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JLiteralLong:" + line, e);
        e.addAttribute("type", type == null ? "" : type.toString());
        e.addAttribute("value", text);
    }
}
