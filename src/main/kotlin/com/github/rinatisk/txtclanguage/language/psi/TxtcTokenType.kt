package com.github.rinatisk.txtclanguage.language.psi

import com.github.rinatisk.txtclanguage.language.TXTCLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

class TxtcTokenType(@NonNls debugName: String) : IElementType(debugName, TXTCLanguage.INSTANCE) {
    override fun toString(): String {
        return "TxtcTokenType." + super.toString()
    }
}

class TxtcElementType(@NotNull @NonNls debugName: String?) :
    IElementType(debugName!!, TXTCLanguage.INSTANCE)
