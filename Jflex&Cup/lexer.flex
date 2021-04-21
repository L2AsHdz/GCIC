

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{

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

ENTERO = "\""(0|([1-9][0-9]*))"\""
LINE_COMMENT = "!!"[^\n]*
BLOCK_COMMENT = "<!--"[^EOF]*"-->"
PROCESS_NAME = "PROCESS_"[^\s]*
ID = [:letter:][\w]*


%%

//Etiquetas

<YYINITIAL> [cC]_[gG][cC][iI][cC]                       return { symbol(C_GCIC); }
<YYINITIAL> [cC]_[hH][eE][aA][dD]                       return { symbol(C_HEAD); }
<YYINITIAL> [cC]_[tT][iI][tT][lL][eE]                   return { symbol(C_TITLE); }
<YYINITIAL> [cC]_[lL][iI][nN][kk}                       return { symbol(C_LINK); }
<YYINITIAL> [cC]_[bB][oO][dD][yY]                       return { symbol(C_BODY); }
<YYINITIAL> [cC]_[sS][pP][aA][mM]                       return { symbol(C_SPAM); }
<YYINITIAL> [cC]_[iI][nN][pP][uU][tT]                   return { symbol(C_INPUT): }
<YYINITIAL> [cC]_[tT][eE][xX][tT][aA][rR][eE][aA]       return { symbol(C_TEXTAREA): }
<YYINITIAL> [cC]_[sS][eE][lL][eE][cC][tT]               return { symbol(C_SELECT): }
<YYINITIAL> [cC]_[oO][pP][tT][iI][oO][nN]               return { symbol(C_OPTION); }
<YYINITIAL> [cC]_[dD][iI][vV]                           return { symbol(C_DIV); }
<YYINITIAL> [cC]_[iI][mM][gG]                           return { symbol(C_IMG); }
<YYINITIAL> [cC]_[bB][rR]                               return { symbol(C_BR); }
<YYINITIAL> [cC]_[bB][uU][tT][tT][oO][nN]               return { symbol(C_BUTTON); }
<YYINITIAL> [cC]_[hH]1                                  return { symbol(C_H1); }
<YYINITIAL> [cC]_[pP]                                   return { symbol(C_P); }
<YYINITIAL> [cC]-[sS][cC][rR][iI][pP][tT][iI][nN][gG]   return { symbol(C_SCRIPTING); }

//Parametros

<YYINITIAL> "href"          return { symbol(HREF); }
<YYINITIAL> "background"    return { symbol(BACKGROUND); }
<YYINITIAL> "color"         return { symbol(COLOR); }
<YYINITIAL> "font-size"     return { symbol(FONT-SIZE); }
<YYINITIAL> "font-family"   return { symbol(FONT-FAMILY); }
<YYINITIAL> "text-align"    return { symbol(TEXT_ALIGN); }
<YYINITIAL> "type"          return { symbol(TYPE); }
<YYINITIAL> "id"            return { symbol(ID); }
<YYINITIAL> "name"          return { symbol(NAME); }
<YYINITIAL> "cols"          return { symbol(COLS); }
<YYINITIAL> "rows"          return { symbol(ROWS); }
<YYINITIAL> "class"         return { symbol(CLASS); }
<YYINITIAL> "src"           return { symbol(SRC); }
<YYINITIAL> "width"         return { symbol(WIDTH); }
<YYINITIAL> "height"        return { symbol(HEIGHT); }
<YYINITIAL> "alt"           return { symbol(ALT); }
<YYINITIAL> "onclick"       return { symbol(ONCLICK); }

//CLC
<YYINITIAL> "ON_LOAD"       return { symbol(ON_LOAD); }
<YYINITIAL> "@global"       return { symbol(GLOBAL_MODE); }

//Tipos de datos
<YYINITIAL> "integer"       return { symbol(INTEGER); }
<YYINITIAL> "decimal"       return { symbol(DECIMAL); }
<YYINITIAL> "boolean"       return { symbol(BOOLEAN); }
<YYINITIAL> "char"          return { symbol(CHAR); }
<YYINITIAL> "string"        return { symbol(STRING); }

//Funciones especiales
<YYINITIAL> "ASC"                   return { symbol(ASC); }
<YYINITIAL> "DESC"                  return { symbol(DESC); }
<YYINITIAL> "LETPAR_NUM"            return { symbol(LETPAR_NUM); }
<YYINITIAL> "LETIMPAR_NUM"          return { symbol(LETIMPAR_NUM); }
<YYINITIAL> "REVERSE"               return { symbol(REVERSE); }
<YYINITIAL> "CARACTER_ALEATORIO"    return { symbol(CARACTER_ALEATORIO): }
<YYINITIAL> "NUM_ALEATORIO"         return { symbol(NUM_ALEATORIO); }
<YYINITIAL> "ALERT_INFO"            return { symbol(ALERT_INFO); }
<YYINITIAL> "EXIT"                  return { symbol(EXIT); }

