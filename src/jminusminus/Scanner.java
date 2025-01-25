// Copyright 2012- Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

// Modified 2025 - Abraham, Corey, Jeremiah
package jminusminus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Hashtable;

import static jminusminus.TokenKind.*;

/**
 * A lexical analyzer for j--, that has no backtracking mechanism.
 */
class Scanner {
    // End of file character.
    public final static char EOFCH = CharReader.EOFCH;

    // Keywords in j--.
    private Hashtable<String, TokenKind> reserved;

    // Source characters.
    private CharReader input;

    // Next unscanned character.
    private char ch;

    // Whether a scanner error has been found.
    private boolean isInError;

    // Source file name.
    private String fileName;

    // Line number of current token.
    private int line;

    /**
     * Constructs a Scanner from a file name.
     *
     * @param fileName name of the source file.
     * @throws FileNotFoundException when the named file cannot be found.
     */
    public Scanner(String fileName) throws FileNotFoundException {
        this.input = new CharReader(fileName);
        this.fileName = fileName;
        isInError = false;

        // Keywords in j--
        reserved = new Hashtable<String, TokenKind>();
        reserved.put(ABSTRACT.image(), ABSTRACT);
        reserved.put(BOOLEAN.image(), BOOLEAN);
        reserved.put(CHAR.image(), CHAR);
        reserved.put(CLASS.image(), CLASS);
        reserved.put(ELSE.image(), ELSE);
        reserved.put(EXTENDS.image(), EXTENDS);
        reserved.put(FALSE.image(), FALSE);
        reserved.put(IF.image(), IF);
        reserved.put(IMPORT.image(), IMPORT);
        reserved.put(INSTANCEOF.image(), INSTANCEOF);
        reserved.put(INT.image(), INT);
        reserved.put(NEW.image(), NEW);
        reserved.put(NULL.image(), NULL);
        reserved.put(PACKAGE.image(), PACKAGE);
        reserved.put(PRIVATE.image(), PRIVATE);
        reserved.put(PROTECTED.image(), PROTECTED);
        reserved.put(PUBLIC.image(), PUBLIC);
        reserved.put(RETURN.image(), RETURN);
        reserved.put(STATIC.image(), STATIC);
        reserved.put(SUPER.image(), SUPER);
        reserved.put(THIS.image(), THIS);
        reserved.put(TRUE.image(), TRUE);
        reserved.put(VOID.image(), VOID);
        reserved.put(WHILE.image(), WHILE);

        // Adding the new 28 reserved keywords
        reserved.put(CONTINUE.image(), CONTINUE);
        reserved.put(FOR.image(), FOR);
        reserved.put(SWITCH.image(), SWITCH);
        reserved.put(ASSERT.image(), ASSERT);
        reserved.put(DEFAULT.image(), DEFAULT);
        reserved.put(SYNCHRONIZED.image(), SYNCHRONIZED);
        reserved.put(DO.image(), DO);
        reserved.put(GOTO.image(), GOTO);
        reserved.put(BREAK.image(), BREAK);
        reserved.put(DOUBLE.image(), DOUBLE);
        reserved.put(IMPLEMENTS.image(), IMPLEMENTS);
        reserved.put(THROW.image(), THROW);
        reserved.put(BYTE.image(), BYTE);
        reserved.put(THROWS.image(), THROWS);
        reserved.put(CASE.image(), CASE);
        reserved.put(ENUM.image(), ENUM);
        reserved.put(TRANSIENT.image(), TRANSIENT);
        reserved.put(CATCH.image(), CATCH);
        reserved.put(SHORT.image(), SHORT);
        reserved.put(TRY.image(), TRY);
        reserved.put(FINAL.image(), FINAL);
        reserved.put(INTERFACE.image(), INTERFACE);
        reserved.put(FINALLY.image(), FINALLY);
        reserved.put(LONG.image(), LONG);
        reserved.put(VOLATILE.image(), VOLATILE);
        reserved.put(CONST.image(), CONST);
        reserved.put(FLOAT.image(), FLOAT);
        reserved.put(NATIVE.image(), NATIVE);

        // Prime the pump.
        nextCh();
    }

    /**
     * Scans and returns the next token from input.
     *
     * @return the next scanned token.
     */
    public TokenInfo getNextToken() {
        StringBuffer buffer;
        boolean moreWhiteSpace = true;
        while (moreWhiteSpace) {
            while (isWhitespace(ch)) {
                nextCh();
            }
            // TODO: Scan (and ignore) Java multi-line comments.
            if (ch == '/') {
                nextCh();
                if (ch == '*') { // multi-line comment support
                    multiLineCommentSupport();
                    while (ch != '\n' && ch != EOFCH) {
                        nextCh();
                    }
                } else if (ch == '/') {
                    // CharReader maps all new lines to '\n'.
                    while (ch != '\n' && ch != EOFCH) {
                        nextCh();
                    }
                    // /, /=
                } else if (ch == '=') { // /=
                    nextCh();
                    return new TokenInfo(DIV_ASSIGN, line);
                } else { // /
                    return new TokenInfo(DIV, line);
                }
            } else {
                moreWhiteSpace = false;
            }
        }
        line = input.line();
        // TODO: recognize and return all Java operators that are not reserved words.
        switch (ch) {
            case ',':
                nextCh();
                return new TokenInfo(COMMA, line);
            case '.':
                buffer = new StringBuffer();
                // we know that if we start with a '.' it's either a decimal float or double
                TokenInfo potentialFlouble = decimalFloubleLiteralAfterPeriod(buffer);
                if (potentialFlouble != null)
                    return potentialFlouble;
                else
                    // or just a dot
                    return new TokenInfo(DOT, line);
            case '[':
                nextCh();
                return new TokenInfo(LBRACK, line);
            case '{':
                nextCh();
                return new TokenInfo(LCURLY, line);
            case '(':
                nextCh();
                return new TokenInfo(LPAREN, line);
            case ']':
                nextCh();
                return new TokenInfo(RBRACK, line);
            case '}':
                nextCh();
                return new TokenInfo(RCURLY, line);
            case ')':
                nextCh();
                return new TokenInfo(RPAREN, line);
            case ';':
                nextCh();
                return new TokenInfo(SEMI, line);
            case '*': // *, *=
                nextCh();
                if (ch == '=') { // *=
                    nextCh();
                    return new TokenInfo(MUL_ASSIGN, line);
                } else { // *
                    return new TokenInfo(STAR, line);
                }
            case '+': // +, ++, +=
                nextCh();
                if (ch == '=') {
                    nextCh();
                    return new TokenInfo(PLUS_ASSIGN, line);
                } else if (ch == '+') {
                    nextCh();
                    return new TokenInfo(INC, line);
                } else {
                    return new TokenInfo(PLUS, line);
                }
            case '-': // -, --, -=, ->
                nextCh();
                if (ch == '-') { // --
                    nextCh();
                    return new TokenInfo(DEC, line);
                } else if (ch == '=') { // -=
                    nextCh();
                    return new TokenInfo(MINUS_ASSIGN, line);
                } else if (ch == '>') { // ->
                    nextCh();
                    return new TokenInfo(LAMBDA, line);
                } else { // -
                    return new TokenInfo(MINUS, line);
                }
            case '=': // =, ==
                nextCh();
                if (ch == '=') { // ==
                    nextCh();
                    return new TokenInfo(EQUAL, line);
                } else { // =
                    return new TokenInfo(ASSIGN, line);
                }
            case '>': // >, >>, >>>, >>>=, >=, >>=
                nextCh();
                if (ch == '>') {
                    nextCh();
                    if (ch == '>') {
                        nextCh();
                        if (ch == '=') { // >>>=
                            nextCh();
                            return new TokenInfo(BSSHIFTR_ASSIGN, line);
                        } else { // >>>
                            return new TokenInfo(BSSHIFTR, line);
                        }
                    } else if (ch == '=') { // >>=
                        nextCh();
                        return new TokenInfo(BSHIFTR_ASSIGN, line);
                    } else { // >>
                        return new TokenInfo(BSHIFTR, line);
                    }
                } else if (ch == '=') { // >=
                    nextCh();
                    return new TokenInfo(GE, line);
                } else { // >
                    return new TokenInfo(GT, line);
                }
            case '<': // <, <<, <=, <<=
                nextCh();
                if (ch == '=') { // <=
                    nextCh();
                    return new TokenInfo(LE, line);
                } else if (ch == '<') {
                    nextCh();
                    if (ch == '=') { // <<=
                        nextCh();
                        return new TokenInfo(BSHIFTL_ASSIGN, line);
                    } else { // <<
                        return new TokenInfo(BSHIFTL, line);
                    }
                } else { // <
                    return new TokenInfo(LT, line);
                }
            case '!': // !, !=
                nextCh();
                if (ch == '=') { // !=
                    nextCh();
                    return new TokenInfo(NOT_EQUAL, line);
                } else { // !
                    return new TokenInfo(LNOT, line);
                }
            case '&': // &, &&, &=
                nextCh();
                if (ch == '&') { // &&
                    nextCh();
                    return new TokenInfo(LAND, line);
                } else if (ch == '=') { // &=
                    nextCh();
                    return new TokenInfo(BAND_ASSIGN, line);
                } else { // &
                    return new TokenInfo(BAND, line);
                }
            case '~': // ~
                nextCh();
                return new TokenInfo(BCOMP, line);
            case '?': // ?
                nextCh();
                return new TokenInfo(TERN_TRUE, line);
            case ':': // :
                nextCh();
                return new TokenInfo(TERN_FALSE, line);
            case '|': // |, |=, ||
                nextCh();
                if (ch == '=') { // |=
                    nextCh();
                    return new TokenInfo(BOR_ASSIGN, line);
                } else if (ch == '|') { // ||
                    nextCh();
                    return new TokenInfo(LOR, line);
                } else { // |
                    return new TokenInfo(BOR, line);
                }
            case '%': // %, %=
                nextCh();
                if (ch == '=') { // %=
                    nextCh();
                    return new TokenInfo(MOD_ASSIGN, line);
                } else { // %
                    return new TokenInfo(MOD, line);
                }
            case '^': // ^, ^=
                nextCh();
                if (ch == '=') {
                    nextCh();
                    return new TokenInfo(BXOR_ASSIGN, line);
                } else {
                    return new TokenInfo(BXOR, line);
                }
            case '\'':
                buffer = new StringBuffer();
                buffer.append('\'');
                nextCh();
                if (ch == '\\') {
                    nextCh();
                    buffer.append(escape());
                } else {
                    buffer.append(ch);
                    nextCh();
                }
                if (ch == '\'') {
                    buffer.append('\'');
                    nextCh();
                    return new TokenInfo(CHAR_LITERAL, buffer.toString(), line);
                } else {
                    // Expected a ' ; report error and try to recover.
                    reportScannerError(ch + " found by scanner where closing ' was expected");
                    while (ch != '\'' && ch != ';' && ch != '\n') {
                        nextCh();
                    }
                    return new TokenInfo(CHAR_LITERAL, buffer.toString(), line);
                }
            case '"':
                buffer = new StringBuffer();
                buffer.append("\"");
                nextCh();
                while (ch != '"' && ch != '\n' && ch != EOFCH) {
                    if (ch == '\\') {
                        nextCh();
                        buffer.append(escape());
                    } else {
                        buffer.append(ch);
                        nextCh();
                    }
                }
                if (ch == '\n') {
                    reportScannerError("Unexpected end of line found in string");
                } else if (ch == EOFCH) {
                    reportScannerError("Unexpected end of file found in string");
                } else {
                    // Scan the closing "
                    nextCh();
                    buffer.append("\"");
                }
                return new TokenInfo(STRING_LITERAL, buffer.toString(), line);
            case EOFCH:
                return new TokenInfo(EOF, line);
            // TODO: recognize and return all Java reserved words.
            // TODO: recognize and return Java doubleprecision literals (returned as
            // DOUBLE_LITERAL).
            // TODO: recognize and return all other literals in Java, for example,
            // FLOAT_LITERAL, LONG_LITERAL, etc
            // TODO: Bonus, recognize and return all other representations of integers
            // (hexadecimal, octal, etc.).
            case '0':
                // Octal, Hex, Binary check
                buffer = new StringBuffer();
                buffer.append(ch);
                nextCh();
                switch (ch) {
                    case '.':
                        TokenInfo flouble = decimalFloubleLiteralAfterPeriod(buffer);
                        if (flouble != null)
                            return flouble;
                        else {
                            reportScannerError("Invalid FLOAT or DOUBLE LITERAL\nBuffer: " + buffer.toString());
                            return getNextToken();
                        }
                    case 'x': // hex
                    case 'X':
                        TokenInfo hex = hexRepresentation(buffer);
                        if (hex != null)
                            return hex;
                        else {
                            reportScannerError("Invalid HEX REPRESENTATION\nBuffer: " + buffer.toString());
                            return getNextToken();
                        }
                    case 'b': // binary
                    case 'B':
                        TokenInfo binary = binaryRepresentation(buffer);
                        if (binary != null)
                            return binary;
                        else {
                            reportScannerError("Invalid BINARY REPRESENTATION\nBuffer: " + buffer.toString());
                            return getNextToken();
                        }
                    case 'l':
                    case 'L':
                        buffer.append(ch);
                        nextCh();
                        return new TokenInfo(LONG_LITERAL, buffer.toString(), line);
                    case 'f':
                    case 'F':
                        buffer.append(ch);
                        nextCh();
                        return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);
                    case 'd':
                    case 'D':
                        buffer.append(ch);
                        nextCh();
                        return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);
                    default:
                }
                if (isOctal(ch)) {
                    TokenInfo octal = octalRepresentation(buffer);
                    if (octal != null)
                        return octal;
                    else {
                        reportScannerError("Invalid OCTAL REPRESENTATION\nBuffer: " + buffer.toString());
                        return getNextToken();
                    }
                } else if (endOfLiteral(ch)) { // just a 0
                    return new TokenInfo(INT_LITERAL, buffer.toString(), line);
                } else {
                    nextCh();
                    return getNextToken();
                }
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                buffer = new StringBuffer();
                TokenInfo decimal = decimalRepresentation(buffer);
                if (decimal != null)
                    return decimal;
                else {
                    reportScannerError("Invalid DECIMAL REPRESENTATION\nBuffer: " + buffer.toString());
                    return getNextToken();
                }
            default: // for reserved keywords
                if (isIdentifierStart(ch)) {
                    buffer = new StringBuffer();
                    while (isIdentifierPart(ch)) {
                        buffer.append(ch);
                        nextCh();
                    }
                    String identifier = buffer.toString();
                    if (reserved.containsKey(identifier)) {
                        return new TokenInfo(reserved.get(identifier), line);
                    } else {
                        return new TokenInfo(IDENTIFIER, identifier, line);
                    }
                } else {
                    reportScannerError("Unidentified input token: '%c'", ch);
                    nextCh();
                    return getNextToken();
                }
        }
    }

    /**
     * Returns true if an error has occurred, and false otherwise.
     *
     * @return true if an error has occurred, and false otherwise.
     */
    public boolean errorHasOccurred() {
        return isInError;
    }

    /**
     * Returns the name of the source file.
     *
     * @return the name of the source file.
     */
    public String fileName() {
        return fileName;
    }

    // Scans and returns an escaped character.
    private String escape() {
        switch (ch) {
            case 'b':
                nextCh();
                return "\\b";
            case 't':
                nextCh();
                return "\\t";
            case 'n':
                nextCh();
                return "\\n";
            case 'f':
                nextCh();
                return "\\f";
            case 'r':
                nextCh();
                return "\\r";
            case '"':
                nextCh();
                return "\\\"";
            case '\'':
                nextCh();
                return "\\'";
            case '\\':
                nextCh();
                return "\\\\";
            default:
                reportScannerError("Badly formed escape: \\%c", ch);
                nextCh();
                return "";
        }
    }

    /**
     * Advances ch to the next character from input, and updates the line number.
     */
    private void nextCh() {
        line = input.line();
        try {
            ch = input.nextChar();
        } catch (Exception e) {
            reportScannerError("Unable to read characters from input");
        }
    }

    /**
     * Reports a lexical error and records the fact that an error has occurred. This
     * fact can be
     * ascertained from the Scanner by sending it an errorHasOccurred message.
     */
    private void reportScannerError(String message, Object... args) {
        isInError = true;
        System.err.printf("%s:%d: error: ", fileName, line);
        System.err.printf(message, args);
        System.err.println();
    }

    /**
     * Returns true if the specified character is a digit (0-9), and false
     * otherwise.
     */
    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    /*
     * Returns true if the specified character is a whitespace, and false otherwise.
     */
    private boolean isWhitespace(char c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\f');
    }

    /*
     * Returns true if the specified character can start an identifier name, and
     * false otherwise.
     */
    private boolean isIdentifierStart(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '_' || c == '$');
    }

    /*
     * Returns true if the specified character can be part of an identifier name,
     * and false
     * otherwise.
     */
    private boolean isIdentifierPart(char c) {
        return (isIdentifierStart(c) || isDigit(c));
    }

    /**
     * Find '* /' termination and
     * Ignore rest
     */
    private void multiLineCommentSupport() {
        while (ch != EOFCH) {
            if (ch == '*') {
                nextCh();
                if (ch == '/')
                    return;
            }
            nextCh();
        }
        reportScannerError("Malformed Multiline comment");
        return;
    }

    /**
     * Determines if the decimal value is a Int, Long, Float, or Double literal.
     */
    private TokenInfo decimalRepresentation(StringBuffer buffer) {
        buffer.append(ch);
        nextCh();
        while (true) {
            if (isDecimal(ch)) {
                buffer.append(ch);
                nextCh();
            } else if (isUnderscore(ch)) {
                scanUnderscoreAndDecimal(buffer);

            } else if (ch == '.') {
                decimalFloubleLiteralAfterPeriod(buffer);

            } else if (ch == 'e' || ch == 'E') {
                scientificNotationOrBinaryExponentiation(buffer);

            } else if (ch == 'd' || ch == 'D') {
                return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);
            } else if (ch == '.') {
                decimalFloubleLiteralAfterPeriod(buffer);
            } else if (ch == 'f' || ch == 'F') {
                return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);
            } else if (ch == 'l' || ch == 'L') {
                return new TokenInfo(LONG_LITERAL, buffer.toString(), line);
            } else {
                return null;
            }
        }
    }

    /**
     * Determines if the binary value is a Int or Long literal.
     */
    private TokenInfo binaryRepresentation(StringBuffer buffer) {
        buffer.append(ch); // capture 'b'/'B'
        nextCh();
        boolean illegalUnderscore = true;
        while (true) {
            if (isBinary(ch)) {
                illegalUnderscore = false;
                buffer.append(ch);
                nextCh();

            } else if (isUnderscore(ch) && illegalUnderscore) {
                reportScannerError("Illegal Underscore after b/B");
                return null; // i.e. binary 0b_1 or 0b____1

            } else if (isUnderscore(ch) && !illegalUnderscore) {
                scanUnderscoreAndBinary(buffer);

            } else if (isLongSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(LONG_LITERAL, buffer.toString(), line);

            } else if (ch == '.') {
                reportScannerError("BINARY MISREPRESENETATION: '.' in binary literal.");
                return null;

            } else if (endOfLiteral(ch)) {
                nextCh();
                return new TokenInfo(INT_LITERAL, buffer.toString(), line);

            } else {
                return null; // We encounter malformed Binary i.e. 0b or 0b!
            }
        }
    }

    /**
     * Determines if the octal value is a Int or Long literal.
     */
    private TokenInfo octalRepresentation(StringBuffer buffer) {
        buffer.append(ch); // capture 0-7 after 0 i.e 01 or 07
        nextCh();
        while (true) {
            if (isOctal(ch)) {
                buffer.append(ch);
                nextCh();
            } else if (isUnderscore(ch)) {
                scanUnderscoreAndOctal(buffer);

            } else if (ch == '.') { // Potentially a float/double...
                TokenInfo potentialFlouble = decimalFloubleLiteralAfterPeriod(buffer);
                if (potentialFlouble != null)
                    return potentialFlouble;
                reportScannerError("OCTAL MISREPRESENETATION: '.' in octal literal.");
                return null;
            } else if ((ch == 'e' || ch == 'E')) {
                // e or E indicates Float or Double Literals
                buffer.append(ch);
                scientificNotationOrBinaryExponentiation(buffer);
                if (isDoubleSuffix(ch)) {
                    buffer.append(ch);
                    nextCh();
                    return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

                } else if (endOfLiteral(ch)) {
                    nextCh();
                    return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

                } else if (isFloatSuffix(ch)) {
                    buffer.append(ch);
                    nextCh();
                    return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);
                } else {
                    return null; // We have an octal that has an invalid form of scientific notation
                }
            } else if (isLongSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(LONG_LITERAL, buffer.toString(), line);

            } else if (isFloatSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);

            } else if (isDoubleSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

            } else if (endOfLiteral(ch)) {
                nextCh();
                return new TokenInfo(INT_LITERAL, buffer.toString(), line);

            } else if (isDecimal(ch) && !isOctal(ch)) { // This is potentially a float if 'f' suffix
                while (isDecimal(ch)) {
                    buffer.append(ch);
                    nextCh();
                }
                if (isFloatSuffix(ch))
                    return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);
                else {
                    reportScannerError("OCTAL MISREPRESENETATION: 8 or 9 in octal literal.");
                    return null;
                }
            } else {
                return null; // We encounter malformed Octal i.e. 0f or 0thisisillegal
            }
        }
    }

    /**
     * Determines if the hex value is a Int, Long, Double, or Float literal.
     */
    private TokenInfo hexRepresentation(StringBuffer buffer) {
        buffer.append(ch); // capture 'x'/'X'
        nextCh();
        boolean illegalUnderscore = true;
        boolean potentialFlouble = false;
        boolean floubleCheck = false;
        while (true) {
            if (isHex(ch)) {
                illegalUnderscore = false;
                buffer.append(ch);
                nextCh();

            } else if (isUnderscore(ch) && illegalUnderscore) {
                reportScannerError("Illegal Underscore after x/X");
                return null; // i.e. hex 0x_A or 0x____A
            } else if (isUnderscore(ch) && !illegalUnderscore) {
                scanUnderscoreAndHex(buffer);

            } else if (isLongSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(LONG_LITERAL, buffer.toString(), line);

            } else if (ch == '.') {
                potentialFlouble = true;
                buffer.append(ch);
                nextCh();
            } else if ((ch == 'p' || ch == 'P')) {
                // p or P indicates Float or Double Literals
                if (potentialFlouble)
                    floubleCheck = true;
                else
                    floubleCheck = false;
                buffer.append(ch);
                scientificNotationOrBinaryExponentiation(buffer);
                if (isDoubleSuffix(ch)) {
                    buffer.append(ch);
                    nextCh();
                    return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

                } else if (endOfLiteral(ch)) {
                    nextCh();
                    return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

                } else if (isFloatSuffix(ch)) {
                    buffer.append(ch);
                    nextCh();
                    return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);
                } else {
                    if (floubleCheck || !potentialFlouble)
                        return null; // We have a hex that has an invalid form of exponentiation
                }
            } else if (endOfLiteral(ch)) {
                if (!floubleCheck && potentialFlouble) {
                    reportScannerError("HEX MISREPRESENTATION: '.' with no binary exponentation (p)/(P).");
                    return null; // we have a hex that has a . but no exponentiation i.e. 0xA.A;
                }
                nextCh();
                return new TokenInfo(INT_LITERAL, buffer.toString(), line);
            } else {
                return null; // We encounter malformed Hex i.e. 0x& or 0xThisshouldn'thappen
            }
        }
    }

    /**
     * Returns float or double literals ONLY AFTER PERIODS i.e.
     * floats: .1e1f .0f .3f .0f .14f .022137e+23f
     * doubles: .1e1 .2 .3 .0 .14 .1e-9d .1e137
     */
    private TokenInfo decimalFloubleLiteralAfterPeriod(StringBuffer buffer) {
        buffer.append(ch); // append period
        nextCh();
        while (true) {
            if (isDecimal(ch)) {
                buffer.append(ch);
                nextCh();
            } else if (isUnderscore(ch)) {
                scanUnderscoreAndDecimal(buffer);

            } else if (isDoubleSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

            } else if (isFloatSuffix(ch)) {
                buffer.append(ch);
                nextCh();
                return new TokenInfo(FLOAT_LITERAL, buffer.toString(), line);

            } else if (ch == 'e' || ch == 'E') {
                buffer.append(ch);
                scientificNotationOrBinaryExponentiation(buffer);

            } else if (endOfLiteral(ch)) {
                nextCh();
                return new TokenInfo(DOUBLE_LITERAL, buffer.toString(), line);

            } else {
                break;
            }
        }
        return null;
    }

    private void scanUnderscoreAndDecimal(StringBuffer buffer) {
        boolean digitLast = false;
        while (isUnderscore(ch) || isDecimal(ch)) {
            if (isDecimal(ch))
                digitLast = true;
            else
                digitLast = false;
            buffer.append(ch);
            nextCh();
        }
        if (!digitLast) {
            reportScannerError("Decimal 0-9 expected after underscore\ncurrent buffer: " + buffer.toString());
            getNextToken();
        }
        return;
    }

    private void scanUnderscoreAndHex(StringBuffer buffer) {
        boolean hexLast = false;
        while (isUnderscore(ch) || isHex(ch)) {
            if (isHex(ch))
                hexLast = true;
            else
                hexLast = false;
            buffer.append(ch);
            nextCh();
        }
        if (!hexLast)
            reportScannerError("Hex numeral expected after underscore\ncurrent buffer: " + buffer.toString());
        return;
    }

    private void scanUnderscoreAndBinary(StringBuffer buffer) {
        boolean binaryLast = false;
        while (isUnderscore(ch) || isBinary(ch)) {
            if (isBinary(ch))
                binaryLast = true;
            else
                binaryLast = false;
            buffer.append(ch);
            nextCh();
        }
        if (!binaryLast)
            reportScannerError("Binary 0 or 1 expected after underscore\ncurrent buffer: " + buffer.toString());
        return;
    }

    private void scanUnderscoreAndOctal(StringBuffer buffer) {
        boolean binaryLast = false;
        while (isUnderscore(ch) || isOctal(ch)) {
            if (isOctal(ch))
                binaryLast = true;
            else
                binaryLast = false;
            buffer.append(ch);
            nextCh();
        }
        if (!binaryLast)
            reportScannerError("Octal 0-7 expected after underscore\ncurrent buffer: " + buffer.toString());
        return;
    }

    private boolean isDecimal(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isHex(char c) {
        return (c >= '0' && c <= '9')
                || (c >= 'A' && c <= 'F')
                || (c >= 'a' && c <= 'f');
    }

    private boolean isOctal(char c) {
        return (c >= '0' && c <= '7');
    }

    private boolean isBinary(char c) {
        return c == '0' || c == '1';
    }

    private boolean isUnderscore(char c) {
        return c == '_';
    }

    private boolean isSemiColon(char c) {
        return c == ';';
    }

    private void scientificNotationOrBinaryExponentiation(StringBuffer buffer) {
        if (ch == 'e' || ch == 'E' || ch == 'p' || ch == 'P') {
            nextCh();
            switch (ch) {
                case '-':
                case '+':
                    buffer.append(ch);
                    nextCh();
                    if (isDecimal(ch)) {
                        while (isDecimal(ch)) {
                            buffer.append(ch);
                            nextCh();
                        }
                        return;
                    } else {
                        reportScannerError("Illegal Exponentiation should have number after\ncurrent buffer: "
                                + buffer.toString());
                        getNextToken();
                    }
                    return;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    while (isDecimal(ch)) {
                        buffer.append(ch);
                        nextCh();
                    }
                    return;
                default:
                    reportScannerError("Illegal Exponentiation should have number after\ncurrent buffer: "
                            + buffer.toString());
                    getNextToken();
                    return;
            }
        }
        reportScannerError("Illegal trigger of Exponentiation on " + ch + "\ncurrent buffer: " + buffer.toString());
        getNextToken();
    }

    private boolean isFloatSuffix(char c) {
        return c == 'f' || c == 'F';
    }

    private boolean isDoubleSuffix(char c) {
        return c == 'd' || c == 'D';
    }

    private boolean isLongSuffix(char c) {
        return c == 'l' || c == 'L';
    }

    /**
     * Return true if current character is whitespace ' ' or semicolon ';'
     */
    private boolean endOfLiteral(char c) {
        return isWhitespace(c) || isSemiColon(c);
    }
}

/**
 * A buffered character reader, which abstracts out differences between
 * platforms, mapping all new
 * lines to '\n', and also keeps track of line numbers.
 */
class CharReader {
    // Representation of the end of file as a character.
    public final static char EOFCH = (char) -1;

    // The underlying reader records line numbers.
    private LineNumberReader lineNumberReader;

    // Name of the file that is being read.
    private String fileName;

    /**
     * Constructs a CharReader from a file name.
     *
     * @param fileName the name of the input file.
     * @throws FileNotFoundException if the file is not found.
     */
    public CharReader(String fileName) throws FileNotFoundException {
        lineNumberReader = new LineNumberReader(new FileReader(fileName));
        this.fileName = fileName;
    }

    /**
     * Scans and returns the next character.
     *
     * @return the character scanned.
     * @throws IOException if an I/O error occurs.
     */
    public char nextChar() throws IOException {
        return (char) lineNumberReader.read();
    }

    /**
     * Returns the current line number in the source file.
     *
     * @return the current line number in the source file.
     */
    public int line() {
        return lineNumberReader.getLineNumber() + 1; // LineNumberReader counts lines from 0
    }

    /**
     * Returns the file name.
     *
     * @return the file name.
     */
    public String fileName() {
        return fileName;
    }

    /**
     * Closes the file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void close() throws IOException {
        lineNumberReader.close();
    }
}
