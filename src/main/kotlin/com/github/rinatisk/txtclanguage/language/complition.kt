package com.github.rinatisk.txtclanguage.language

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.esotericsoftware.kryo.NotNull
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.intellij.util.withNotNullBackup
import com.jetbrains.rd.util.first
import org.intellij.sdk.language.psi.SimpleTypes
import java.io.File
import java.math.BigInteger


fun main() {
    val words = File("/home/rinatisk/Downloads/data(2).json").readText()
    val wordsWithUses = Klaxon().parseArray<Map<String, String>>(words)
    val wordsMap = wordsWithUses?.map { it.values }
    println("50003612".toInt())
    //print(wordsWithUses?.map { it.values })
}

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

