package com.github.rinatisk.txtclanguage.language.psi


import com.github.rinatisk.txtclanguage.language.TxtcFileType
import com.github.rinatisk.txtclanguage.language.TXTCLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider


class TxtcFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TXTCLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return TxtcFileType.INSTANCE
    }

    override fun toString(): String {
        return "Txtc File"
    }
}