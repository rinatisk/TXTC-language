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
    val words = File("/home/rinatisk/Downloads/data(2).txt").readText()
    val wordsWithUses = Klaxon().parseArray<Map<String, String>>(words)
    val wordsMap = wordsWithUses?.map { it.values }
    println(wordsMap?.last()?.toSet()?.last())
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
                    println(parameters.position.text.dropLast(20))
                  //  setOf(File("/usr/share/dict/american-english").readLines().filter { it.startsWith("He") }))
                    val wordsFile = File("/home/rinatisk/Downloads/data(2).txt").readText()
                    val wordsWithUses = Klaxon().parseArray<Map<String, String>>(wordsFile)
                    val wordsMap = wordsWithUses?.map { it.values }
                    val words = wordsMap?.filter { (it.toSet().last().startsWith(parameters.position.text.dropLast(20))) }?.map { it.toSet() }?.sortedByDescending { it.first() }
                    println(words)
                    words?.map { PrioritizedLookupElement.withPriority(LookupElementBuilder.create(it.last()).appendTailText(it.first(), false), it.first().toDouble()) }
                        ?.let { result.addAllElements(it) }


                }

            }
        )
    }
}

