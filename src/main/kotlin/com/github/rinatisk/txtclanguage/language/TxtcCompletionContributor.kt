@file:Suppress("ParameterListWrapping", "MagicNumber")

package com.github.rinatisk.txtclanguage.language

import com.beust.klaxon.Klaxon
import com.github.rinatisk.txtclanguage.language.psi.TxtcTypes
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

object Util {
    fun resource(name: String) = this.javaClass.getResource(name).readText()
}

fun main() {
    println(Util.resource("dictionary.json"))
}

class TxtcCompletionContributor : CompletionContributor() {

    private val suffixToDrop = 20

    // because frequency is too big for toDouble
    private val dividedNumber = 100

    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(TxtcTypes.VALUE),
            object : CompletionProvider<CompletionParameters?>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val wordsWithFreq = parseWords("dictionary.json")
                    val completionWords =
                        wordsWithFreq?.filter {
                            (it.toSet().last().startsWith(parameters.position.text.dropLast(suffixToDrop)))
                        }
                            ?.map { it.toSet() }?.sortedByDescending { it.first() }

                    completionWords?.map {
                        PrioritizedLookupElement.withPriority(
                            LookupElementBuilder.create(it.last()).appendTailText(it.first(), false),
                            it.first().toInt().div(dividedNumber).toDouble()
                        )
                    }
                        ?.let { result.addAllElements(it) }
                }
            }
        )
    }

    private fun parseWords(name: String): List<Collection<String>>? {
        val wordsFile = Util.resource(name)
        val wordsWithUses = Klaxon().parseArray<Map<String, String>>(wordsFile)
        return wordsWithUses?.map { it.values }
    }
}
