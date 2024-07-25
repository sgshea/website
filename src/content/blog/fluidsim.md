---
title: 'Eulerian Fluid Simulator'
description: 'Grid-based Eulerian fluid simulation in Rust.'
pubDate: 'July 22 2024'
heroImage: '/fluid_rs.png'
tags: ['rust', 'bevy', 'physics']
demo: https://sgshea.github.io/fluid-rs/
source: https://github.com/sgshea/fluid-rs
---

Eulerian fluid simulator written in Rust ontop of the Bevy engine.

The code is based upon the [Matthias Müller's 10 Minute Physics demo](https://matthias-research.github.io/pages/tenMinutePhysics/index.html). 

Writing the simulator in Rust allows for running the simulator as a native application, as well as the ability to [run on the web](https://sgshea.github.io/fluid-rs/) by compiling to webassembly. Using webassembly allows the application to perform better than the original JavaScript demo.

