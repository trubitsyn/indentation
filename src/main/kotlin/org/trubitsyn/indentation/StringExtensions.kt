/*
 * Copyright 2018 Nikola Trubitsyn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.trubitsyn.indentation

data class Indent(val symbol: Char, private val size: Int?) {

    override fun toString(): String {
        val humanReadable = when (symbol) {
            SPACE -> "SPACE"
            TAB -> "TAB"
            else -> symbol.toString()
        }
        return "$humanReadable:$size"
    }
}

fun String.getIndent(): Indent? {
    if (this.isEmpty()) {
        return null
    }
    return Indent(this[0], indexOfFirst { it != this[0] }.let { if (it == -1) length else it })
}

fun String.mostCommonIndent(): Indent? {
    return lineSequence()
            .filter { it.isNotBlank() }
            .mapNotNull { it.getIndent() }
            .filter { it.symbol == SPACE || it.symbol == TAB }
            .mostRepeatedElement()
}

fun String.mostCommonArbitraryIndent(): Indent? {
    val start = mostCommonLineStart() ?: return null
    return lineSequence()
            .filter { it.startsWith(start) }
            .reduce { common, s -> s.commonPrefixWith(common).let { if (it.isNotEmpty()) s else it } }
            .getIndent()
}

fun String.mostCommonLineStart(): Char? {
    return lineSequence()
            .filter { it.isNotBlank() }
            .mapNotNull { it[0] }
            .mostRepeatedElement()
}

fun <T> Sequence<T>.mostRepeatedElement(): T? {
    return maxBy { e -> filter { it == e }.count() }
}
