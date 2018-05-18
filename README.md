# indentation [![Build Status](https://travis-ci.org/trubitsyn/indentation.svg?branch=master)](https://travis-ci.org/trubitsyn/indentation)
This program detects used indentation symbol and size in a given source code.

# Running
`java -jar indentation.jar [FILENAME]`

# Features
* Detects TAB and SPACE indents
* Detects arbitrary indentation symbols (e.g. all indents replaced to `#`, or 8 spaces used instead of 4 - an edge case)
* Detects mixed cases and outputs the most widely used indentation symbol and size

# Sample output
Output format is `SYMBOL:SIZE`. For the sake of better user experience there are comments in output.

## Tabs
```java
public static void main(String[] args) {
	System.out.println("Hello, indent!")
 // end
		flush();
	cleanup
}
```
```
Standard indent: TAB:1
Arbitrary indent: TAB:1
```

## Spaces
```
public static void main(String[] args) {
    System.out.println("Hello, indent!")
    if (x) return false;
        return true;
}
```
```
Standard indent: SPACE:4
Arbitrary indent: SPACE:8
```
## Arbitrary symbols
```
public static void main(String[] args) {
if (setUp) return false;
_rename;
____System.out.println("Hello, indent!")
foo();
}
```
```
Standard indent: null
Arbitrary indent: _:4
```

## Tabs and arbitrary symbols
```java
###
###
###void foo() {}
###
	System.out.print("Bar") // Tab on this line
###
###
```
```
Standard indent: TAB:1
Arbitrary indent: #:3
```

# Building from source
The program is written in Kotlin and uses Gradle build system.
Run `./gradlew jar` to get a fat JAR with all dependencies bundled.

# Testing
Run `./gradlew test` to run a test suite.

# LICENSE

```
Copyright 2018 Nikola Trubitsyn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
