---
title: 'Implementing Neuroevolution with Rust: The NEAT Algorithm'
description: 'Neuroevolution of Augmenting Topologies implementation.'
pubDate: 'Aug 18 2023'
tags: ['rust', 'ai']
source: https://github.com/sgshea/neat
---

Implementation of [Neuroevolution of Augmenting Topologies (NEAT)](https://nn.cs.utexas.edu/downloads/papers/stanley.ec02.pdf) in Rust.

## NEAT Overview
NEAT is a genetic algorithm for the generation of evolving artificial neural networks by altering both the weights and structures through mutation and crossover.
The core functionality of the NEAT algorithm is implemented within this library, including genome repesentation with connection and node genes, mutation
to alter weights and add connections or nodes, speciation based on a compatibility distance metric, fitness sharing to encourage speciation and genetic operations such as crossover to create improved genomes for the next generation of networks.

## Key Features
- **Genome Representation**: NEAT uses a genome representation with connection and node genes that can be mutated to alter weights or add new connections/nodes.
- **Mutation**: The algorithm includes mutation operators to alter weights, add new connections, and create new nodes.
- **Speciation**: Genomes are grouped into species based on their compatibility distance metric which allows for the preservation of genetic diversity.
- **Fitness Sharing**: Fitness sharing is used to encourage speciation by ensuring that genomes within a species have similar fitness values. Genomes with low fitness relative to others in the same species will be penalized, while those with high fitness relative to their peers are rewarded.
- **Crossover**: Genetic operations such as crossover can create improved genomes for the next generation of networks by combining features from parent genomes.

