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

import org.junit.Assert.assertEquals
import org.junit.Test

class IndentTest {

    @Test
    fun noIndent() {
        assertEquals(null, "".getIndent())
    }

    @Test
    fun spaceIndent() {
        assertEquals(Indent(' ', 3), "   foo()".getIndent())
    }

    @Test
    fun tabIndent() {
        assertEquals(Indent('	', 2), "\t\t".getIndent())
    }

    @Test
    fun testToString() {
        assertEquals("SPACE:4", Indent(' ', 4).toString())
        assertEquals("TAB:1", Indent('\t', 1).toString())
        assertEquals("#:3", Indent('#', 3).toString())
    }
}