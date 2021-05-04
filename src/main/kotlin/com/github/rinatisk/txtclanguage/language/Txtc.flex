package com.github.rinatisk.txtclanguage.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.com.github.rinatisk.txtclanguage.language.psi.tree.IElementType;
import com.github.rinatisk.txtclanguage.com.github.rinatisk.txtclanguage.language.psi.SimpleTypes;
import com.intellij.com.github.rinatisk.txtclanguage.language.psi.TokenType;

%%

%class TxtcLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
VALUE_CHARACTER=[^\ \ | \t \n\f\\] | "\\"{CRLF} | "\\".

%state WAITING_VALUE

%%

<YYINITIAL> {VALUE_CHARACTER}+                                { yybegin(YYINITIAL); return TxtcTypes.VALUE; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SimpleTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }