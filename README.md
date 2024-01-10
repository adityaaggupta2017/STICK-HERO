# Stick Hero Game Clone

This project is a recreation of the Stick Hero game, allowing users to control a character with an extending stick to navigate between platforms, collect cherries, and set high scores.

## Overview

Developed by:
- Aditya Gupta (2022031)
- Debjit Banerji (2022146)

## Features

### Game Mechanics

- **Stick Extension**: Extend the stick's length by holding the left mouse click. Releasing the click will cause the stick to fall and join pillars if appropriate.
- **Pillar Generation**: Randomly generated pillars stored in an ArrayList of Rectangles.
- **Character Controls**: Collect cherries by flipping (using the "S" key) and move between platforms by extending the stick.
- **Scoring System**: Earn 1 point for each pillar reached to set high scores.

### Game Over Screen

- Displays Highest Score, Current Score, and offers options to:
  - Return to Home Screen
  - Revive (costs 10 cherries, if available)
  - Restart the game

### Additional Features

- **Sound Effects**: Dying, cherry collection, high score celebration, platform reach.
- **Thread Implementation**: Runnable objects handle character and pillar movement.
- **Design Patterns**: Decorator (for score and cherries) and Iterator (for cherry iteration).
- **File I/O**: Serializable Interface for storing user progress.
- **OOPs Concepts**: Decorator, Iterator, Inheritance, Composition.
- **Interactive Menus**: Home Screen, Pause Menu, Ending Screen.
- **Background Music and Graphics**: Aesthetic design for a pleasant gaming experience.

## How to Play

1. Run the game by clicking the green "Play" button in IntelliJ Idea in the "StartApplication.java" file.
2. Control the stick-hero character using the left mouse click to extend the stick and the "S" key to flip and collect cherries.

## Home Screen

- Clicking "Exit" prompts a dialog box for confirmation before exiting the game.

## References

- [Fortnite Song](https://downloads.khinsider.com/game-soundtracks/album/fortnite-battle-royale-soundtrack)
- Background Image and Stick-hero images sourced from Google.
- Sound Effects obtained from the internet.


