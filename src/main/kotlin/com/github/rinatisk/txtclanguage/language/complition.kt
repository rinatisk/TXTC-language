package com.github.rinatisk.txtclanguage.language

import com.esotericsoftware.kryo.NotNull
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.intellij.sdk.language.psi.SimpleTypes


class SimpleCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(SimpleTypes.VALUE),
            object : CompletionProvider<CompletionParameters?>() {
                override fun addCompletions(
                     parameters: CompletionParameters,
                     context: ProcessingContext,
                     result: CompletionResultSet
                ) {
                    result.addElement(LookupElementBuilder.create("Hello"))
                }

            }
        )
    }
}
