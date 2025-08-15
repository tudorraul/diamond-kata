# Diamond Kata

## Overview

This project solves the [Diamond Kata](https://github.com/davidwhitney/CodeDojos/tree/master/Diamond%20Kata), a programming challenge designed to generate a diamond-shaped pattern of uppercase letters.


## Implementation approach

1. Validates input: only accepts uppercase letters A–Z
1. Fully symmetrical output (horizontally and vertically)
1. Clean, test-driven implementation
1. Uses Java 21, JUnit 5, Maven 3
1. The implementation avoids string concatenation in loops, using `StringBuilder` instead.


## How to build and run tests

From the project root:

```bash
mvn clean test
```

