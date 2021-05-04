package com.github.rinatisk.txtclanguage.language

import com.intellij.lexer.FlexAdapter


class TxtcLexerAdapter : FlexAdapter(TxtcLexer(null))