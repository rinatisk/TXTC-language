package com.github.rinatisk.txtclanguage.language

import com.esotericsoftware.kryo.NotNull
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.intellij.sdk.language.psi.SimpleTypes
import java.io.File


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
                    println(parameters.position.text.dropLast(20))
                  //  setOf(File("/usr/share/dict/american-english").readLines().filter { it.startsWith("He") }))
                    val words = File("/usr/share/dict/american-english").readLines().filter { (it.startsWith(parameters.position.text.dropLast(20))) }
                  //  result.addElement(LookupElementBuilder.create(parameters.position.text.dropLast(20)))
                    result.addAllElements(words.map { LookupElementBuilder.create(it) } )


                }

            }
        )
    }
}

