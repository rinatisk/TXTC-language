package com.github.rinatisk.txtclanguage.language

import com.beust.klaxon.Klaxon
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.github.rinatisk.txtclanguage.language.psi.TxtcTypes
import java.io.File


fun main() {
    val words = File("/home/rinatisk/Downloads/data(2).json").readText()
    val wordsWithUses = Klaxon().parseArray<Map<String, String>>(words)
    val wordsMap = wordsWithUses?.map { it.values }
    println("50003612".toInt())
    //print(wordsWithUses?.map { it.values })
}

class TxtcCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(TxtcTypes.VALUE),
            object : CompletionProvider<CompletionParameters?>() {
                override fun addCompletions(
                     parameters: CompletionParameters,
                     context: ProcessingContext,
                     result: CompletionResultSet
                ) {
                    val wordsFile = File("/home/rinatisk/Downloads/data(2).json").readText()
                    val wordsWithUses = Klaxon().parseArray<Map<String, String>>(wordsFile)
                    val wordsMap = wordsWithUses?.map { it.values }
                    val words = wordsMap?.filter { (it.toSet().last().startsWith(parameters.position.text.dropLast(20))) }?.map { it.toSet() }?.sortedByDescending { it.first() }
                    words?.map { PrioritizedLookupElement.withPriority(LookupElementBuilder.create(it.last()).appendTailText(it.first(), false), it.first().toInt().div(100).toDouble()) }
                        ?.let { result.addAllElements(it) }

                }

            }
        )
    }
}

