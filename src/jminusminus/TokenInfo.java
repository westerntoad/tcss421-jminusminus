// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham, Corey, Jeremiah
package jminusminus;

/**
 * An enum of token kinds. Each entry in this enum represents the kind of a
 * token along with its
 * image (string representation).
 */
enum TokenKind {
    // End of file.
    EOF(""),

    // Reserved words.
    /*
     * 51 tokens:
     * abstract continue for new switch
     * assert default if package synchronized
     * boolean do goto private this
     * break double implements protected throw
     * byte else import public throws
     * case enum instanceof return transient
     * catch extends int short try
     * char final interface static void
     * class finally long strictfp volatile
     * const float native super while
     * _ (underscore)
     */
    ABSTRACT("abstract"), BOOLEAN("boolean"), CHAR("char"), CLASS("class"), ELSE("else"),
    EXTENDS("extends"), IF("if"), IMPORT("import"), INSTANCEOF("instanceof"), INT("int"),
    NEW("new"), PACKAGE("package"), PRIVATE("private"), PROTECTED("protected"),
    PUBLIC("public"), RETURN("return"), STATIC("static"), SUPER("super"), THIS("this"),
    VOID("void"), WHILE("while"),

    /*
     * missing 28* tokens: *strictfp is obsolete, _ (underscore) for future use
     * continue for switch assert default
     * synchronized do goto break double
     * implements throw byte throws case
     * enum transient catch short try
     * final interface finally long volatile
     * const float native
     */
    // ADDED 28 KEYWORDS
    CONTINUE("continue"), FOR("for"), SWITCH("switch"), ASSERT("assert"), DEFAULT("default"),
    SYNCHRONIZED("synchronized"), DO("do"), GOTO("goto"), BREAK("break"), DOUBLE("double"),
    IMPLEMENTS("implements"), THROW("throw"), BYTE("byte"), THROWS("throws"), CASE("case"),
    ENUM("enum"), TRANSIENT("transient"), CATCH("catch"), SHORT("short"), TRY("try"),
    FINAL("final"), INTERFACE("interface"), FINALLY("finally"), LONG("long"), VOLATILE("volatile"),
    CONST("const"), FLOAT("float"), NATIVE("native"),

    // Operators.
    /*
     * 38 tokens:
     * = > < ! ~ ? : ->
     * == >= <= != && || ++ --
     * + - * / & | ^ % << >> >>>
     * += -= *= /= &= |= ^= %= <<= >>= >>>=
     */
    ASSIGN("="), DEC("--"), EQUAL("=="), GT(">"), INC("++"), LAND("&&"), LE("<="), LNOT("!"),
    MINUS("-"), PLUS("+"), PLUS_ASSIGN("+="), STAR("*"), // L = Logical
    /*
     * missing 26 tokens:
     * < ~ ? : ->
     * >= != ||
     * / & | ^ % << >> >>>
     * -= *= /= &= |= ^= %= <<= >>= >>>=
     */
    // ADDED 26 OPERATORS
    // TODO: Assign better names.
    LT("<"), BCOMP("~"), TERN_TRUE("?"), TERN_FALSE(":"),
    LAMBDA("->"), GE(">="), NOT_EQUAL("!="), LOR("||"),
    DIV("/"), BAND("&"), BOR("|"), BXOR("^"), MOD("%"),
    BSHIFTL("<<"), BSHIFTR(">>"), BSSHIFTR(">>>"),
    MINUS_ASSIGN("-="), MUL_ASSIGN("*="), DIV_ASSIGN("/="),
    BAND_ASSIGN("&="), BOR_ASSIGN("|="), BXOR_ASSIGN("^="),
    MOD_ASSIGN("%="), BSHIFTL_ASSIGN("<<="), BSHIFTR_ASSIGN(">>="),
    BSSHIFTR_ASSIGN(">>>="),

    // Separators. 12 Tokens, missing 3 tokens: '...', '@', '::'
    COMMA(","), DOT("."), LBRACK("["), LCURLY("{"), LPAREN("("), RBRACK("]"), RCURLY("}"),
    RPAREN(")"), SEMI(";"),

    // Identifiers.
    IDENTIFIER("<IDENTIFIER>"),

    // Literals.
    CHAR_LITERAL("<CHAR_LITERAL>"), FALSE("false"), INT_LITERAL("<INT_LITERAL>"), NULL("null"),
    STRING_LITERAL("<STRING_LITERAL>"), TRUE("true"),
    /*
     * DecimalIntegerLiteral
     * HexIntegerLiteral
     * OctalIntegerLiteral
     * BinaryIntegerLiteral
     * 
     * DecimalFloatingPointLiteral
     * HexadecimalFloatingPointLiteral
     * 
     * 
     */
    // ADDED LITERALS
    DOUBLE_LITERAL("<DOUBLE_LITERAL>"), FLOAT_LITERAL("<FLOAT_LITERAL>"), LONG_LITERAL("<LONG_LITERAL>");

    // The token kind's string representation.
    private String image;

    /**
     * Constructs an instance of TokenKind given its string representation.
     *
     * @param image string representation of the token kind.
     */
    private TokenKind(String image) {
        this.image = image;
    }

    /**
     * Returns the token kind's string representation.
     *
     * @return the token kind's string representation.
     */
    public String tokenRep() {
        if (this == EOF) {
            return "<EOF>";
        }
        if (image.startsWith("<") && image.endsWith(">")) {
            return image;
        }
        return "\"" + image + "\"";
    }

    /**
     * Returns the token kind's image.
     *
     * @return the token kind's image.
     */
    public String image() {
        return image;
    }
}

/**
 * A representation of tokens returned by the Scanner method getNextToken(). A
 * token has a kind
 * identifying what kind of token it is, an image for providing any semantic
 * text, and the line in
 * which it occurred in the source file.
 */
public class TokenInfo {
    // Token kind.
    private TokenKind kind;

    // Semantic text (if any). For example, the identifier name when the token kind
    // is IDENTIFIER
    // . For tokens without a semantic text, it is simply its string representation.
    // For example,
    // "+=" when the token kind is PLUS_ASSIGN.
    private String image;

    // Line in which the token occurs in the source file.
    private int line;

    /**
     * Constructs a TokenInfo object given its kind, the semantic text forming the
     * token, and its
     * line number.
     *
     * @param kind  the token's kind.
     * @param image the semantic text forming the token.
     * @param line  the line in which the token occurs in the source file.
     */
    public TokenInfo(TokenKind kind, String image, int line) {
        this.kind = kind;
        this.image = image;
        this.line = line;
    }

    /**
     * Constructs a TokenInfo object given its kind and its line number. Its image
     * is simply the
     * token kind's string representation.
     *
     * @param kind the token's identifying number.
     * @param line the line in which the token occurs in the source file.
     */
    public TokenInfo(TokenKind kind, int line) {
        this(kind, kind.image(), line);
    }

    /**
     * Returns the token's kind.
     *
     * @return the token's kind.
     */
    public TokenKind kind() {
        return kind;
    }

    /**
     * Returns the line number associated with the token.
     *
     * @return the line number associated with the token.
     */
    public int line() {
        return line;
    }

    /**
     * Returns the token's string representation.
     *
     * @return the token's string representation.
     */
    public String tokenRep() {
        return kind.tokenRep();
    }

    /**
     * Returns the token's image.
     *
     * @return the token's image.
     */
    public String image() {
        return image;
    }
}
