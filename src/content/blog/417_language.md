---
title: '417 Programming Language'
description: 'A simple expression-based programming language parser and interpreter.'
pubDate: 'December 23 2024'
tags: ['rust']
demo: https://sgshea.github.io/417lang/
source: https://github.com/sgshea/417lang
---

This is a simple expression-based programming langauge parser and interpreter implementation in Rust.

This project was created as part of a class "Theory of Programming Languages" where the "417 Language" was specified in a grammar.
We were provided a reference implementation in Scheme, and a parser for the language in C.
The abstract syntax tree (AST) of the language was in JSON, to make it simple for everyone to parser for the interpreter, as we could choose different languages for implementation.

I, in addition to the class requirements, created:
- A parser in Rust, which can output the JSON AST or be used as a library for the interpreter (though it still uses a JSON value as intermediate AST)
- A WebAssembly compilation of the my project, which I presented and can be seen at https://sgshea.github.io/417lang/
