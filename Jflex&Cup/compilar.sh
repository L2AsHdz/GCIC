#!/bin/bash

echo Compilando Lexer...
jflex lexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser Parser -symbols Sym parser.cup

mv Lexer.java /home/asael/NetBeansProjects/TestAnalizadores/src/main/java/analizadores/lexico/
mv Parser.java Sym.java /home/asael/NetBeansProjects/TestAnalizadores/src/main/java/analizadores/sintactico/