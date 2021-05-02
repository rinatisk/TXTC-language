package com.github.rinatisk.txtclanguage.language

import com.intellij.lexer.FlexAdapter


class SimpleLexerAdapter : FlexAdapter(SimpleLexer(null))