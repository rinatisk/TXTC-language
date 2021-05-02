package com.github.rinatisk.txtclanguage.language

import com.intellij.icons.AllIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class SimpleLanguage : Language("Simple") {
    companion object {
        val INSTANCE = SimpleLanguage()
    }
}


class SimpleFileType private constructor() : LanguageFileType(SimpleLanguage.INSTANCE) {
    override fun getName(): String {
        return "Simple File"
    }

    override fun getDescription(): String {
        return "Simple language file"
    }

    override fun getDefaultExtension(): String {
        return "simple"
    }

    override fun getIcon(): Icon {
        return SimpleIcons.FILE
    }

    companion object {
        val INSTANCE = SimpleFileType()
    }
}


class SimpleIcons {
    companion object {
        @JvmField
        val FILE = AllIcons.Actions.QuickfixOffBulb
    }
}