---
title: 'sandengine'
description: 'Falling Sand physics engine integrated with traditional rigid body physics.'
pubDate: 'Feb 11 2024'
stillActive: true
heroImage: '/sandengine.png'
tags: ['rust', 'performance', 'bevy', 'physics', 'multithreading']
demo: https://sgshea.github.io/sandengine/
source: https://github.com/sgshea/sandengine
---

> This project is still under development.
>
> Note that the demo in the web browser may not perform as well as the native version due to performance constraints listed below. The demo will also not work on mobile devices due to the nature of the application and limitations on mobile browsers.
>
> However if you encounter lots of stuttering when starting the web demo, try opening in a new browser window or different browser.
>
> There are also native builds created by the CI for each release on the releases page that have better performance than the web demo.

# Overview
Sandengine is a falling sand simulation/game created in the Rust and using the Bevy game engine. The project aims to integrate traditional rigid body physics with the cellular automaton model of falling sand. This will allow for complex interactions between particles, such as bouncing off each other or being pushed around by external forces like gravity.

## Current State
The engine is currently split into two modules:

- **Falling Sand Simulation**: Handles the simulation of individual cell behaviors and interactions.
This system uses a cellular automaton model to simulate sand, water, and other materials falling under gravity.

- **Physics Engine**: Integration with the [rapier](https://rapier.rs/) physics library for rigid body dynamics. 
The physics engine runs on its own and for now handles spawning in objects from outside the simulation such as boxes or a player controller.

There is currently only 1-way interaction between these modules: Colliders in the physics engine are created for the falling sand simulation's terrain,
which allows the rigid bodies to collide and bounce off of the terrain.

## Performance
A big part of the challenge with this project is with the goal to make it performant. With more features and a larger world size, the simulation will become increasingly complex and performance will degrade quickly.

To mitigate this, I've implemented several optimizations:
## Falling Sand Simulation Optimizations
The falling sand "world" is managed separately from the Bevy engine's gameplay loop in order to more efficently manage the data structures used for simulation.
The world is split into multiple chunks in order to update the simulation only on a per-chunk basis, reducing the number of particles that need to be processed at once and allowing for parallelization.

### Chunks, multithreading, and unsafe
However, all chunks cannot be updated at the same time due to dependencies between them (e.g., water flowing from one chunk into another). To handle this, the chunks are updated in a "checkerboard" pattern where even and odd chunks are updated alternately. This allows for parallel updates while still maintaining dependencies between chunks. Still, this can cause undefined behavior if the chunk in between two updating chunks is updated at the same time as both its neighbors (which would be a rare edge case), this can be prevented by not moving a particle past the midpoint of the middle chunk (so that the adjacent chunks only update "their" half), but the Rust borrow checker cannot know this limitation and so some unsafe code is required to implement this system.

### Dirty Rectangles
Another trick to achieve more performance (and this has given the most performance of any single optimization) is to utilize "dirty rectanlges" where only the part of the chunk that changed last frame should be checked for updates, rather than checking every particle in the entire chunk each frame. This reduces the number of particles that need to be processed by a large amount and allows for more efficient processing even without multithreading. For example in my (crude) performance profiling this opimization alone reduced the time spent updating sand from 330us to 35us (~9.4 times improvement) when there is no sand being updated anywhere, as the simulation can check then skip every chunk.

> Image of the program running with the chunk debug rendering mode enabled:
> The grey outline indicate chunk boundaries while the green boundaries are the processing dirty rectangles for each chunk
![image of chunked simulation](/sandengine_chunks.png)

### Future Optimizations
With the chunk system there is already some framework to use this to improve performance to further optimize the program in the two least performing areas: rendering and collision generation
- Collider generation currently takes over 2ms each frame because colliders are generated for every chunk even if no particles have moved out of them since last frame (this is because I didn't implement dirty rectangles here yet).
- "Rendering" is done by copying color information from each cell to a pixel in an image which Bevy then renders. This is done each frame as well.

Both of these should be able to be improved by only updating colliders/areas of the image where the dirty rectangle has changed in the frame and can be easily multithreaded because the chunks in these cases do not depend on each other's results.

## Future Plans
Future expansions to the simulation features include:
- A particle system that is seperate from the falling sand simulation and rigid body simulation, where particles can have velocities and forces applied to them.

- Two-way interaction between the two systems (e.g. a block of sand could push on a falling sand cell, this would then turn it into a particle that could be thrown across the map by gravity or other forces).

- Simple gameplay mechanics along with the character controller such as placing blocks and destroying terrain.