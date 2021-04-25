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

//* Regexs for comments
LINE_COMMENT = "!!"[^\n]*
BLOCK_COMMENT = "<!--"[^EOF]*"-->"

//* Regexs for parameters
URL = (https?:\/\/)?([\da-z\.-]+)\.([\/\w \.-]*)*\/?
COLOR = #([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
SIZE = {ENTERO}(px)
WIDTH_VAL = ({ENTERO}(px) | {ENTERO}("%"))
HEIGHT_VAL = ({ENTERO}(px) | {ENTERO}("%"))
IDPARAM = [_$-][\w$-]*
NAMEPARAM = [:letter:][\w]*

PROCESS_NAME = "PROCESS_"[\w]*
IDVAR = [:letter:][\w]*

%state TAG
%state PARAMETER
%state VALUE
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
<TAG> [cC]-[sS][cC][rR][iI][pP][tT][iI][nN][gG]   { return symbol(C_SCRIPTING); }

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
<OTHER> "ON_LOAD"       { return symbol(ON_LOAD); }
<OTHER> "@global"       { return symbol(GLOBAL_MODE); }

//* Tipos de datos
<OTHER> "integer"       { return symbol(INTEGER); }
<OTHER> "decimal"       { return symbol(DECIMAL); }
<OTHER> "boolean"       { return symbol(BOOLEAN); }
<OTHER> "char"          { return symbol(CHAR); }
<OTHER> "string"        { return symbol(STRING); }
<OTHER> "true"          { return symbol(TRUE); }
<OTHER> "false"         { return symbol(FALSE); }

//* Funciones especiales
<OTHER> "ASC"                   { return symbol(ASC); }
<OTHER> "DESC"                  { return symbol(DESC); }
<OTHER> "LETPAR_NUM"            { return symbol(LETPAR_NUM); }
<OTHER> "LETIMPAR_NUM"          { return symbol(LETIMPAR_NUM); }
<OTHER> "REVERSE"               { return symbol(REVERSE); }
<OTHER> "CARACTER_ALEATORIO"    { return symbol(CARACTER_ALEATORIO); }
<OTHER> "NUM_ALEATORIO"         { return symbol(NUM_ALEATORIO); }
<OTHER> "ALERT_INFO"            { return symbol(ALERT_INFO); }
<OTHER> "EXIT"                  { return symbol(EXIT); }
<OTHER> "getElementById"        { return symbol(ELEMENT_BY_ID); }

//* Bloques y estructuras de control
<OTHER> "INIT"          { return symbol(INIT); }
<OTHER> "END"           { return symbol(END); }
<OTHER> "IF"            { return symbol(IF); }
<OTHER> "THEN"          { return symbol(THEN); }
<OTHER> "ELSE"          { return symbol(ELSE); }
<OTHER> "REPEAT"        { return symbol(REPEAT); }
<OTHER> "HUNTIL"        { return symbol(HUNTIL); }
<OTHER> "WHILE"         { return symbol(WHILE); }
<OTHER> "THENWHILE"     { return symbol(THENWHILE); }
<OTHER> "INSERT"        { return symbol(INSERT);}

<YYINITIAL> {
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

<OTHER> {
    "("             { return symbol(OPEN_ROUND_BRACKET); }
    ")"             { return symbol(CLOSE_ROUND_BRACKET); }
    "{"             { return symbol(OPEN_BRACE); }
    "}"             { return symbol(CLOSE_BRACE); }
    "/"             { return symbol(SLASH); }
    "\'"            { return symbol(SINGLE_QUOTES); }
    ":"             { return symbol(COLON); }
    ";"             { return symbol(SEMI); }

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
}

<VALUE> {URL}                       { return symbol(URL); }
<VALUE> {COLOR}                     { return symbol(COLOR_VALUE); }
<VALUE> {SIZE}                      { return symbol(SIZE); }
<VALUE> {WIDTH_VAL}                 { return symbol(WIDTH_VAL); }
<VALUE> {HEIGHT_VAL}                { return symbol(HEIGHT_VAL); }
<VALUE> {IDPARAM}                   { return symbol(ID_PARAM); }
<VALUE> {NAMEPARAM}                 { return symbol(NAME_PARAM); }

<OTHER> {PROCESS_NAME}              { return symbol(PROCESS_NAME); }
<OTHER> {IDVAR}                     { return symbol(ID_VAR); }

[^]                                     { addLexicError(); }