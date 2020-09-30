Team name: Moot Floating Point

Team members: Natalie Boardway, Jon Griesen, Nick Reitz, Nate Stern

# Introduction

The concept for the project is based on the design of two-dimensional arcade-style games of the 1980-90s.  Specifically, this game will consist of a static maze through which players will be able to move a character.  The character will only be able to traverse only within the confines of the maze at a single speed and in one of four discrete directions -- up, down, left, and right.  Movement of the character is constant until a maze barrier it hit, and only changes direction or resumes movement upon player input.
 
The goal of the game is for a player to move the character through the maze and remove all of the dots it contains, while also avoiding occupying the same space as any of the enemy non-player characters (NPCs).  Each space in the maze contains a dot that is removed once the player has moved through it.  Most spaces in the maze contain a small dot that only counts for points and the win condition, while a few contain a large dot that signifies a special power-up.  This power-up has two simultaneous functions:  1) it causes enemy NPCs to flee the player character and 2) it allows the player's character to temporarily disable enemy NPCs once they make contact with them.  
 
There are 4 total enemy NPCs, with each maze beginning with only 1 chasing the character followed by more enemy NPCs being released to join the chase over time.  After successfully completing a maze, the maze will refresh as new and the enemy NPCs will now move slightly more quickly and be released in slightly shorter increments.  Enemy NPCs move randomly throughout the maze until they get within a fixed distance to the player's character.  Once within that distance, they will begin to chase the player's character by following it.  Players will have the advantage against enemy NPCs in that the NPCs will be required to randomly choose a direction to go at each intersection within the maze, allowing players to temporarily escape.  
 
Points accumulate toward a total score for each space the character occupies, for collecting specific bonus point treasures that randomly appear, and for each maze successfully completed.  At the beginning of each game, players will only have three "lives" for their character.  Each time an enemy NPC shares the same space as the player's character -- also known as eating the character -- the player will lose one of their character's lives and the game will reset the number of enemy NPCs back to 1.  Once all lives are exhausted, the game ends and the player's total score will be displayed.  If the player's score is in the top 10 scores for the system, the player will be able to enter their initials and their score will be saved.


# Anticipated Technologies

In order to complete this project, there are a few technologies that we will need in order to be successful. The game will be programed in Java and utilize object-oriented concepts in order to model the NPC's and player. The code will need to consist of a classes that will control how the NPC's move and refreshing the objects on the screen. In order to learn proper ways to do this we will be utilizing GitHub and online forms for proper game development examples and tutorials. We will also be utilizing Git for source control and host our code repository. 

We anticipate on having to utilize photo editing software like photoshop in order to develop our graphics. We will also need to use an audio editing software to work on the audio that will be placed in the game.


# Method/Approach

Depending on what comes to light throughout class in the coming weeks, the following is our intended course of action.

We want to start by reviewing tutorials for java games, specifically pacman. This will help inform our requirements gathering as we see how those who came before have approached development of this type of game.

The initial work- establishing the maps, collision detection and the ability to move- will all be done as a group. 

Once the foundation is in place, we will split into pairs to complete the remainder of the development work. 

Any investigations into enhancements such as audio/graphics will be completed as individual spikes.

# Estimated Timeline

11 WEEKS TOTAL (9/29/20 – 12/15/20) – Project Presentations on 12/16/20

**Phase One – Requirements Gathering (2 Weeks)**

1. Flesh out desired scope of game (similarity to real Pac Man; features to add/remove)

2. Java related software needs (libraries, development frameworks)

3. Supplemental software needs (Sprite graphics, game audio effects)
   * Graphics (paint.net, GIMP, Photoshop)
   * Audio (StudioOne, GarageBand) - Consider availability of public domain game music

4. Review tutorials to establish plan for implementation 

END OF PHASE (10/13/20): Initial research completed, desired scope of game determined, necessary Java technologies determined, supplemental technologies and resources determined.

**Phase Two – Implementation (5 Weeks)**

1. Java GUI window created, player actor exists, can move around square map in four cardinal directions

2. Traditional PacMan style map created, collision detection implemented for player actor, movement restricted to available hallways on map

3. Creation of collectable objects in appropriate map locations (small dots, large dots, fruit)

4. Enemy actors created, semi-random pathing around map, player death mechanic

5. “Attack mode” mechanics, where player actor can go on offensive and eat enemy actors. Likely some overlap with step 3 (large dots serve as consumable “trigger” for attack mode)

END OF PHASE (11/17/20): Working product exists with majority of base mechanics implemented. (Not polished, but mostly functional)

**Phase Three – Refinement (4 Weeks)**

1. Sprite integration (map, player, enemies, collectables). Note that the development of basic sprites will need to coincide with phase two for implementation of game code

2. Audio integration (themes, player actors, enemy actors, collectables, etc.)

3. Multiple levels / adjustable difficulty setting

4. Player score tracking & leaderboard

5. Title screen

* Phase Three is still very tentative. Adjustments will follow upon completion of requirements gathering process in Phase One.

END OF PHASE (12/15/20): Fully functional and polished final product that is suitable for hand in.


# Anticipated Problems

The biggest anticipated problem may be designing and executing the interactive GUI that players will use.  By and large our team has limited experience designing games or creating GUIs through the java programming language.  Java has been used in the past by individuals or teams to create java games (e.g. Minecraft), but is by no means a prominent language used to create games.  Furthermore, our team consists of some members with limited java experience meaning there will be some potential roadblocks as they learn how to properly implement it in this context.  
 
Another problem we foresee is the lack of time for this project.  This is both in the upcoming deadline at the end of the Fall 2020 semester as well as the availability of time for each project team member.  The uncertainty and social distancing required by Covid-19 alone may be a problem, but it may also have unpredictable impacts on the project schedule.  We will continuously evaluate our deliverables against our proposed schedule, but nevertheless there may be impacts to system functionality if time constraints change.  

