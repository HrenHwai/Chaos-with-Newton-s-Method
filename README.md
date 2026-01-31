## Overview 
The project implements Newton-Raphson method in complex plane to visualize the 
region convergence for the polynomial $f(z) = z^4 - 1$ 
The program generates a color-coded image showing how different roots. 

## Problem Description 
Newton's method is a root finding algorithm can exhibit sensitive dependence on
initial condition when applied in the complex plane. For $f(z) = z^4 - 1$,
there are four roots: 1, -1 , i, -i

the objective is to classify convergence behavior across a 2D region and visualize
the resulting structure. 

## Approach 
- each pixel in an n x n grid is mapped to a complex number within in a square of side
  centered at the origin.
- Newton's method is applied iteratively:


  $$z_{k+1} = z_k - \frac{z_k^4 - 1}{4 z_k^3}$$

 
- iteration stop when the point converges to one of the roots within a fixed tolerance,
  or a maximum of 100 iterations is reached.

## Convergence Classification 
pixels are coloured based on the root they converge to:
- white -> 1
- red -> - 1
- green -> i
- blue -> -i
- black -> no convergence within 100 iterations

this reveals fractal-like boundary regions where convergence is highly sensitive 
to initial conditions 

## Tools 
- java
- 'Complex' data type for complex arithmetic
- 'Picture' data type (Princeton Java Standard Library)
- 'java.awt.Color' for RGB handling

## How to run
1. compile
   '''bash
   javac NewtonChaos.java

2. run
   java NewtonChaos
