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

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (!argsValid(args)) {
        println("Please specify exactly one required argument: [FILENAME]")
        exitProcess(-1)
    }

    val source = try {
        File(args[0]).readText()
    } catch (e: Exception) {
        println("Please specify a path to a valid text file")
        exitProcess(-1)
    }

    println("Standard indent: ${source.mostCommonIndent()}")
    println("Arbitrary indent: ${source.mostCommonArbitraryIndent()}")
}

fun argsValid(args: Array<String>) = args.size == 1