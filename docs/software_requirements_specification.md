# Overview

*This document lists and describes assorted functional and non-functional software requirement specifications for the Pac-Meme game.  These requirements cover various game systems including menus, sprites, user input with corresponding movement, ghost-player interactions, etc.*    

## Functional Requirements

1. Menu Features
	1. FR1:  The high-score menu shall display the best 10 scores.
	1. FR2: Formal gameplay shall begin when “start game” option within title screen is selected.
	1. FR3: The player shall view the high scores list after they click the high scores button on the start menu.
1. Score Features
	1. FR4:  The game shall increment the score when the player character interacts with consumables.
	1. FR5: Contact with game collectable shall increment logged total score per assigned point values.
	1. FR6: The player shall receive 10 points for collecting a dot.
	1. FR7: Score shall increment as Meme-Man consumes a collectable or ghost. 
1.  Ghost - Player Interaction Features
	1. FR8:  The game shall finish once the player character has died 3 times.
	1. FR9: Player shall immediately lose life upon contact with ghost during “normal” gameplay mode.
	1. FR10: The player shall lose a life when they collide with a ghost.
	1. FR11: The game shall end when the player loses three lives.
	1. FR12: The user shell not have less than zero lives and no more than three. 
	1. FR13: The game shall automatically check and make sure the ghost has not caught up with Meme-Man.
	1. FR14: Ghosts shall de-spawn immediately upon contact with “powered up” player character.
1. Movement Features
	1. FR15: Mem-Man Shall stays in bounds of the map and will not go outside the walls.
	1. FR16:  The user shall move the player character using the arrow keys on the keyboard.

## Non-Functional Requirements

1. Menu Features
	1. NFR1:  The menu system for the game shall be simple and intuitive for users.
	1. NFR2: The title screen options shall be simple and intuitive.
	1. NFR3: Navigating the game from the start menu to either the high scores or the game shall be pleasing and easy to use. 
1. Score Features
	1. NFR4:  The system shall prevent unauthorized access to high score leaderboard data.
	1. NFR5: The player’s score shall be clearly visible throughout game play.
1. Ghost - Player Interaction Features
	1. NFR6:  The ghost movement speed shall give players an appropriate amount of difficulty.
	1. NFR7: The ghost shall move around the map chasing Meme-Man accurately and in a difficult manner for the user.
1. Maze Features
	1. NFR8:  The maze shall be easy for the player to navigate.
1. Sprite Features
	1. NFR9:  The game shall use high quality sprites as models for characters and consumables.
	1. NFR10: Pac-Meme game shall feature high quality pixel art for characters and consumables.
1. Movement Features
	1. NFR11: The player character shall immediately respond to all keyboard inputs.
	1. NFR12: The player shall move smoothly between locations.
	1. NFR13: Meme-Man shall run around the map smoothly and not have any glitches. 
	1. NFR14: Collision detection between Meme-Man and the collectables shall be accurate and look like they are being removed when they should be.
1. Sound Features
	1. NFR15: Appropriate sound effects shall be linked to in game occurrences and player actions.
1. Implementation Features
1. NFR16: The game shall feature maintainable Java code broken into logical and consistent classes.