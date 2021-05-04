package com.github.rinatisk.txtclanguage.language

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon


class TXTCLanguage : Language("TXTC") {
    companion object {
        val INSTANCE = TXTCLanguage()
    }
}


class TxtcFileType private constructor() : LanguageFileType(TXTCLanguage.INSTANCE) {
    override fun getName(): String {
        return "Txtc File"
    }

    override fun getDescription(): String {
        return "TXTC language file"
    }

    override fun getDefaultExtension(): String {
        return "TXTC"
    }

    override fun getIcon(): Icon {
        return TxtcIcons.FILE
    }

    companion object {
        val INSTANCE = TxtcFileType()
    }
}


class TxtcIcons {
    companion object {
        @JvmField
        val FILE = IconLoader.getIcon("/icons/icon.svg")
    }
}