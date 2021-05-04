package analizadores.lexico;

import java.util.ArrayList;
import java.util.List;
import model.Token;
import model.errores.ErrorAnalisis;
import model.errores.TipoError;
import static analizadores.sintactico.Sym.*;

import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{
    private List<ErrorAnalisis> errores = new ArrayList();
    private StringBuilder literal = new StringBuilder();

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }

    private void addLexicError(){
        String descripcion = "El simbolo no pertenece al lenguaje";
        errores.add(new ErrorAnalisis(yytext(), yyline+1, yycolumn+1, TipoError.LEXICO, descripcion));
    }

%}

%eofval{
    return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

ENTERO = (0|([1-9][0-9]*))
ENTERO2 = (0|(-)?([1-9][0-9]*))
DECIMAL = (0|(-)?([1-9][0-9]*)(\.(0|([0-9]*[1-9]){1,4})))
CHAR = ("\'"[^"\'"]"\'")

//* Regexs for comments
LINE_COMMENT = "!!"[^\n]*
BLOCK_COMMENT = "<!--"[^EOF]*"-->"

//* Regexs for parameters
URL = (https?:\/\/)?([\da-z\.-]+)\.([\/\w \.-]*)*\/?
COLOR = #([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
SIZE = {ENTERO}(px)
WH_VAL = {ENTERO}("%")
IDPARAM = [_$-][\w$-]*
NAMEPARAM = [:letter:][\w]*

PROCESS_NAME = "PROCESS_"[\w]*
IDVAR = [:letter:][\w]*

%state TAG
%state PARAMETER
%state VALUE
%state SCRIPTING
%state LITERALS
%state OTHER

%%

//* Etiquetas
<TAG> [cC]_[gG][cC][iI][cC]                       { return symbol(C_GCIC); }
<TAG> [cC]_[hH][eE][aA][dD]                       { return symbol(C_HEAD); }
<TAG> [cC]_[tT][iI][tT][lL][eE]                   { return symbol(C_TITLE); }
<TAG> [cC]_[lL][iI][nN][kK]                       { return symbol(C_LINK); }
<TAG> [cC]_[bB][oO][dD][yY]                       { return symbol(C_BODY); }
<TAG> [cC]_[sS][pP][aA][mM]                       { return symbol(C_SPAM); }
<TAG> [cC]_[iI][nN][pP][uU][tT]                   { return symbol(C_INPUT); }
<TAG> [cC]_[tT][eE][xX][tT][aA][rR][eE][aA]       { return symbol(C_TEXTAREA); }
<TAG> [cC]_[sS][eE][lL][eE][cC][tT]               { return symbol(C_SELECT); }
<TAG> [cC]_[oO][pP][tT][iI][oO][nN]               { return symbol(C_OPTION); }
<TAG> [cC]_[dD][iI][vV]                           { return symbol(C_DIV); }
<TAG> [cC]_[iI][mM][gG]                           { return symbol(C_IMG); }
<TAG> [cC]_[bB][rR]                               { return symbol(C_BR); }
<TAG> [cC]_[bB][uU][tT][tT][oO][nN]               { return symbol(C_BUTTON); }
<TAG> [cC]_[hH]1                                  { return symbol(C_H1); }
<TAG> [cC]_[pP]                                   { return symbol(C_P); }
<TAG> [cC]_[sS][cC][rR][iI][pP][tT][iI][nN][gG]   { yybegin(SCRIPTING); return symbol(C_SCRIPTING); }
<SCRIPTING> [cC]_[sS][cC][rR][iI][pP][tT][iI][nN][gG]   { yybegin(TAG); return symbol(C_SCRIPTING); }

//* Name parameters
<PARAMETER> "href"          { return symbol(HREF); }
<PARAMETER> "background"    { return symbol(BACKGROUND); }
<PARAMETER> "color"         { return symbol(COLOR); }
<PARAMETER> "font-size"     { return symbol(FONT_SIZE); }
<PARAMETER> "font-family"   { return symbol(FONT_FAMILY); }
<PARAMETER> "text-align"    { return symbol(TEXT_ALIGN); }
<PARAMETER> "type"          { return symbol(TYPE); }
<PARAMETER> "id"            { return symbol(ID); }
<PARAMETER> "name"          { return symbol(NAME); }
<PARAMETER> "cols"          { return symbol(COLS); }
<PARAMETER> "rows"          { return symbol(ROWS); }
<PARAMETER> "class"         { return symbol(CLASS); }
<PARAMETER> "src"           { return symbol(SRC); }
<PARAMETER> "width"         { return symbol(WIDTH); }
<PARAMETER> "height"        { return symbol(HEIGHT); }
<PARAMETER> "alt"           { return symbol(ALT); }
<PARAMETER> "onclick"       { return symbol(ONCLICK); }

//* Color constants
<VALUE> "black"         { return symbol(BLACK); }
<VALUE> "olive"         { return symbol(OLIVE); }
<VALUE> "teal"          { return symbol(TEAL); }
<VALUE> "red"           { return symbol(RED); }
<VALUE> "blue"          { return symbol(BLUE); }
<VALUE> "marron"        { return symbol(MARRON); }
<VALUE> "navy"          { return symbol(NAVY); }
<VALUE> "gray"          { return symbol(GRAY); }
<VALUE> "lime"          { return symbol(LIME); }
<VALUE> "fuchsia"       { return symbol(FUCHSIA); }
<VALUE> "green"         { return symbol(GREEN); }
<VALUE> "purple"        { return symbol(PURPLE); }
<VALUE> "silver"        { return symbol(SILVER); }
<VALUE> "yellow"        { return symbol(YELLOW); }
<VALUE> "aqua"          { return symbol(AQUA); }

//* Fonts
<VALUE> "Courier"       { return symbol(COURIER); }
<VALUE> "Verdana"       { return symbol(VERDANA); }
<VALUE> "Arial"         { return symbol(ARIAL); }
<VALUE> "Geneva"        { return symbol(GENEVA); }
<VALUE> "sans-serif"    { return symbol(SANS_SERIF); }

//* Aligns
<VALUE> "left"          { return symbol(LEFT); }
<VALUE> "center"        { return symbol(CENTER); }
<VALUE> "right"         { return symbol(RIGHT); }
<VALUE> "justify"       { return symbol(JUSTIFY); }

//* Input types
<VALUE> "text"          { return symbol(TEXT); }
<VALUE> "number"        { return symbol(NUMBER); }
<VALUE> "radio"         { return symbol(RADIO); }
<VALUE> "checkbox"      { return symbol(CHECKBOX); }

//* Div classes
<VALUE> "column"        { return symbol(COLUMN); }
<VALUE> "row"           { return symbol(ROW); }

//* CLC
<SCRIPTING> "ON_LOAD"       { return symbol(ON_LOAD); }
<SCRIPTING> "@global"       { return symbol(GLOBAL_MODE); }

//* Tipos de datos
<SCRIPTING> "integer"       { return symbol(INTEGER); }
<SCRIPTING> "decimal"       { return symbol(DECIMAL); }
<SCRIPTING> "boolean"       { return symbol(BOOLEAN); }
<SCRIPTING> "char"          { return symbol(CHAR); }
<SCRIPTING> "string"        { return symbol(STRING); }
<SCRIPTING> "true"          { return symbol(TRUE); }
<SCRIPTING> "false"         { return symbol(FALSE); }

//* Funciones especiales
<SCRIPTING> "ASC"                   { return symbol(ASC); }
<SCRIPTING> "DESC"                  { return symbol(DESC); }
<SCRIPTING> "LETPAR_NUM"            { return symbol(LETPAR_NUM); }
<SCRIPTING> "LETIMPAR_NUM"          { return symbol(LETIMPAR_NUM); }
<SCRIPTING> "REVERSE"               { return symbol(REVERSE); }
<SCRIPTING> "CARACTER_ALEATORIO"    { return symbol(CARACTER_ALEATORIO); }
<SCRIPTING> "NUM_ALEATORIO"         { return symbol(NUM_ALEATORIO); }
<SCRIPTING> "ALERT_INFO"            { return symbol(ALERT_INFO); }
<SCRIPTING> "EXIT"                  { return symbol(EXIT); }
<SCRIPTING> "getElementById"        { return symbol(ELEMENT_BY_ID); }

//* Bloques y estructuras de control
<SCRIPTING> "INIT"          { return symbol(INIT); }
<SCRIPTING> "END"           { return symbol(END); }
<SCRIPTING> "IF"            { return symbol(IF); }
<SCRIPTING> "THEN"          { return symbol(THEN); }
<SCRIPTING> "ELSE"          { return symbol(ELSE); }
<SCRIPTING> "REPEAT"        { return symbol(REPEAT); }
<SCRIPTING> "HUNTIL"        { return symbol(HUNTIL); }
<SCRIPTING> "WHILE"         { return symbol(WHILE); }
<SCRIPTING> "THENWHILE"     { return symbol(THENWHILE); }
<SCRIPTING> "INSERT"        { return symbol(INSERT);}

<YYINITIAL, TAG, PARAMETER, VALUE, SCRIPTING> {
    {LINE_COMMENT}          { /**Ignorar*/ }
    {BLOCK_COMMENT}         { /**Ignorar*/ }
    (\s)+                   { /**Ignorar*/ }
}

<YYINITIAL> {
    "<"             { yybegin(TAG); return symbol(LESS_THAN); }
    [^<]+           { return symbol(TEXT_TAG); }
}

<TAG> {
    ">"             { yybegin(YYINITIAL); return symbol(GREATER_THAN); }
    "["             { yybegin(PARAMETER); return symbol(OPEN_BRACKET); }
    "/"             { return symbol(SLASH); }
}

<PARAMETER> {
    "]"             { yybegin(TAG); return symbol(CLOSE_BRACKET); }
    "\""            { yybegin(VALUE); return symbol(QOUTE_MARK); }
    "="             { return symbol(ASSIGN); }
}

<VALUE> {
    "\""            { yybegin(PARAMETER); return symbol(QOUTE_MARK); }
}

<SCRIPTING> {
    "("             { return symbol(OPEN_ROUND_BRACKET); }
    ")"             { return symbol(CLOSE_ROUND_BRACKET); }
    "["             { return symbol(OPEN_BRACKET); }
    "]"             { return symbol(CLOSE_BRACKET); }
    "{"             { return symbol(OPEN_BRACE); }
    "}"             { return symbol(CLOSE_BRACE); }
    "="             { return symbol(ASSIGN); }
    ","             { return symbol(COMMA); }
    ":"             { return symbol(COLON); }
    ";"             { return symbol(SEMI); }
    "\""            { yybegin(LITERALS); }

    //* Operadores relacionales
    "=="            { return symbol(EQUAL_TO); }
    "!="            { return symbol(NOT_EQTUAL_TO); }
    "<"             { return symbol(LESS_THAN); }
    ">"             { return symbol(GREATER_THAN); }
    "<="            { return symbol(LESS_THAN_OR_EQUAL_TO); }
    ">="            { return symbol(GREATER_THAN_OR_EQUAL_TO); }

    //* Operadores logicos
    "||"            { return symbol(OR); }
    "&&"            { return symbol(AND); }
    "!"             { return symbol(NOT); }

    //* Operadores aritmeticos
    "+"             { return symbol(PLUS); }
    "-"             { return symbol(MINUS); }
    "*"             { return symbol(TIMES); }
    "/"             { return symbol(DIVIDE); }
}

<LITERALS> {
    "\""            { yybegin(SCRIPTING); }
    [^'\"']+        { System.out.println("Se encontro literal: " + yytext()); return symbol(LITERAL); }
}

<VALUE> {URL}                       { return symbol(URL); }
<VALUE> {COLOR}                     { return symbol(COLOR_VALUE); }
<VALUE> {SIZE}                      { return symbol(SIZE); }
<VALUE> {WH_VAL}                    { return symbol(WH_VAL); }
<VALUE> {IDPARAM}                   { return symbol(ID_PARAM); }
<VALUE> {NAMEPARAM}                 { return symbol(NAME_PARAM); }
<VALUE> {ENTERO}                    { return symbol(ENTERO); }

<SCRIPTING> {PROCESS_NAME}              { return symbol(PROCESS_NAME); }
<SCRIPTING> {IDVAR}                     { return symbol(ID_VAR); }
<SCRIPTING> {ENTERO2}                   { return symbol(ENTERO); }
<SCRIPTING> {DECIMAL}                   { return symbol(DECIMAL_VAL); }
<SCRIPTING> {CHAR}                      { return symbol(CHAR_VAL); }
//<SCRIPTING> {LITERAL}                   { return symbol(LITERAL); }

[^]                                     { addLexicError(); }