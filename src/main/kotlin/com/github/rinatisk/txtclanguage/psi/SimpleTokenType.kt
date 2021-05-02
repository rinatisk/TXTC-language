package com.github.rinatisk.txtclanguage.psi

import com.github.rinatisk.txtclanguage.language.SimpleLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull


class SimpleTokenType(@NonNls debugName: String) : IElementType(debugName, SimpleLanguage.INSTANCE) {
    override fun toString(): String {
        return "SimpleTokenType." + super.toString()
    }
}

class SimpleElementType(@NotNull @NonNls debugName: String?) :
    IElementType(debugName!!, SimpleLanguage.INSTANCE)
