---
title: 'Implementing Neuroevolution with Rust: The NEAT Algorithm'
description: 'Neuroevolution of Augmenting Topologies implementation.'
pubDate: 'Aug 18 2023'
tags: ['rust', 'ai']
source: https://github.com/sgshea/neat
---

A Rust implementation of the [Neuroevolution of Augmenting Topologies (NEAT)](https://nn.cs.utexas.edu/downloads/papers/stanley.ec02.pdf) algorithm.

## NEAT Overview
NEAT is a genetic algorithm which evolves the entire artificial neural network, including the network's weights and structure.

## Key Features
- **Genome Representation**: NEAT uses a genome representation with connection and node genes that can be mutated to alter weights or add new connections/nodes.
- **Mutation**: The algorithm includes mutation operators to alter weights, add new connections, and create new nodes.
- **Speciation**: Genomes are grouped into species based on their compatibility distance metric which allows for the preservation of genetic diversity.
- **Fitness Sharing**: Fitness sharing is used to encourage speciation by ensuring that genomes within a species have similar fitness values. Genomes with low fitness relative to others in the same species will be penalized, while those with high fitness relative to their peers are rewarded.
- **Crossover**: Genetic operations such as crossover can create improved genomes for the next generation of networks by combining features from parent genomes.

