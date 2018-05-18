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

package io.github.trubitsyn.indentation

import org.junit.Assert.assertEquals
import org.junit.Test

class MultilineStringTest {

    @Test
    fun firstOccurrenceLineStart() {
        assertEquals('a', "abc\ndef\nghi\njkl".mostCommonLineStart())
    }

    @Test
    fun commonLineStart() {
        assertEquals('b', "a\nab\nbde\ncdf\nbhj\nbge".mostCommonLineStart())
    }

    @Test
    fun whitespace_4() {
        readFileTextFromResources("Whitespace.java").let {
            assertEquals(Indent(SPACE, 4), it.mostCommonIndent())
        }
    }

    @Test
    fun tab_1() {
        readFileTextFromResources("Tab.java").let {
            assertEquals(Indent(TAB, 1), it.mostCommonIndent())
        }
    }

    @Test
    fun underscore_4() {
        readFileTextFromResources("Arbitrary.java").let {
            assertEquals(Indent('_', 4), it.mostCommonArbitraryIndent())
        }
    }

    @Test
    fun mixed() {
        readFileTextFromResources("Mixed.java").let {
            assertEquals(Indent(TAB, 1), it.mostCommonIndent())
            assertEquals(Indent('`', 3), it.mostCommonArbitraryIndent())
        }
    }

    private fun readFileTextFromResources(filename: String) = javaClass.getResource("/$filename").readText()
}