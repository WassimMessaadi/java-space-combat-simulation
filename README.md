# Space Combat Simulation System

A Java-based turn-based space combat simulation developed as an Object-Oriented Programming project. The system models battles between different types of spaceships using weapons, defensive actions, energy management, special abilities, environmental events, obstacles, bonuses, and rule-based behaviors.

## Overview

The Space Combat Simulation System simulates battles between teams of spaceships in a turn-based environment. Each spaceship has its own characteristics and can perform different actions depending on its type, available energy, weapons, defensive capabilities, and current state.

The simulation is designed with a modular and extensible architecture, allowing new spaceship types, weapons, environmental events, obstacles, bonuses, and behavioral rules to be added without changing the core simulation logic.

## Features

- Turn-based space combat simulation
- Multiple spaceship types with different characteristics
- Team-based battles
- Weapon system with different weapon types
- Energy management
- Offensive and defensive actions
- Special abilities
- Environmental events and dynamic battlefield conditions
- Obstacles and environmental hazards
- Bonuses and temporary effects
- Rule-based and conditional behaviors
- Custom exception handling
- Dynamic state changes including damage, destruction, and temporary effects
- Modular object-oriented architecture

## Technologies

- Java
- Object-Oriented Programming (OOP)
- IntelliJ IDEA
- Git / GitHub

## Object-Oriented Programming Concepts

The project demonstrates several core OOP principles:

- **Encapsulation** — managing object state through classes and controlled access to attributes and behaviors.
- **Inheritance** — specialized spaceship types extend the common `SpaceShip` abstraction.
- **Polymorphism** — different spaceship, weapon, rule, and event implementations can be handled through common types.
- **Abstraction** — common behavior is defined through abstract classes and interfaces.
- **Interfaces** — used to define common contracts for different system components.
- **Exception Handling** — custom exceptions are used to handle invalid actions and game-state conditions.

## Main Components

### Spaceships

The simulation includes different spaceship classes such as:

- Fighter
- Cruiser
- Battleship

Each type has different characteristics and capabilities.

### Weapons

The system supports multiple weapon types, including:

- Laser
- Missile
- Plasma Cannon

### Environmental Events

The battlefield can be affected by different environmental events, such as:

- Asteroid Fields
- Nebula
- Solar Storms

### Obstacles

The simulation also includes environmental obstacles and hazards such as:

- Black Holes
- Mine Fields
- Radiation Zones

### Bonuses

Ships can interact with different bonuses, including:

- Energy Capsules
- Repair Drones
- Shield Boosts

### Rules and Behaviors

The project includes rule-based components for controlling and adapting system behavior, including conditional and event-triggered rules.

## Project Structure

```text
src/
└── com/
    └── spacecombat/
        ├── bonuses/
        ├── controller/
        ├── entities/
        ├── environment/
        ├── exceptions/
        ├── interfaces/
        ├── obstacle/
        ├── rules/
        ├── simulator/
        └── weapons/
```
## How to Run
Clone the repository.
Open the project in IntelliJ IDEA or another Java IDE.
Make sure a compatible Java Development Kit (JDK) is installed.
Compile the project.
Run the main simulation class.
Purpose

This project was developed to apply Object-Oriented Programming principles to a non-trivial simulation system while focusing on modularity, extensibility, and interaction between multiple components.

Author

Wassim Messaadi

Computer Science – Data Analysis Student
University of Messina, Italy
