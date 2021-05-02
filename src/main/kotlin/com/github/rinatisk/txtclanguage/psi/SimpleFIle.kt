package com.github.rinatisk.txtclanguage.language


import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider


class SimpleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimpleLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return SimpleFileType.INSTANCE
    }

    override fun toString(): String {
        return "Simple File"
    }
}