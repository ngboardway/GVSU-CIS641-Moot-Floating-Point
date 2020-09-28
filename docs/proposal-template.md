Team name:

Team members:

# Introduction

The concept for the project is based on the design of two-dimensional arcade-style games of the 1980-90s.  Specifically, this game will consist of a static maze through which players will be able to move a character.  The character will only be able to traverse only within the confines of the maze at a single speed and in one of four discrete directions -- up, down, left, and right.  Movement of the character is constant until a maze barrier it hit, and only changes direction or resumes movement upon player input.
 
The goal of the game is for a player to move the character through the maze and remove all of the dots it contains, while also avoiding occupying the same space as any of the enemy non-player characters (NPCs).  Each space in the maze contains a dot that is removed once the player has moved through it.  Most spaces in the maze contain a small dot that only counts for points and the win condition, while a few contain a large dot that signifies a special power-up.  This power-up has two simultaneous functions:  1) it causes enemy NPCs to flee the player character and 2) it allows the player's character to temporarily disable enemy NPCs once they make contact with them.  
 
There are 4 total enemy NPCs, with each maze beginning with only 1 chasing the character followed by more enemy NPCs being released to join the chase over time.  After successfully completing a maze, the maze will refresh as new and the enemy NPCs will now move slightly more quickly and be released in slightly shorter increments.  Enemy NPCs move randomly throughout the maze until they get within a fixed distance to the player's character.  Once within that distance, they will begin to chase the player's character by following it.  Players will have the advantage against enemy NPCs in that the NPCs will be required to randomly choose a direction to go at each intersection within the maze, allowing players to temporarily escape.  
 
Points accumulate toward a total score for each space the character occupies, for collecting specific bonus point treasures that randomly appear, and for each maze successfully completed.  At the beginning of each game, players will only have three "lives" for their character.  Each time an enemy NPC shares the same space as the player's character -- also known as eating the character -- the player will lose one of their character's lives and the game will reset the number of enemy NPCs back to 1.  Once all lives are exhausted, the game ends and the player's total score will be displayed.  If the player's score is in the top 10 scores for the system, the player will be able to enter their initials and their score will be saved.


# Anticipated Technologies

In order to complete this project, there are a few technologies that we will need in order to be successful. The game will be programed in Java and utilize object-oriented concepts in order to model the NPC's and player. The code will need to consist of a classes that will control how the NPC's move and refreshing the objects on the screen. In order to learn proper ways to do this we will be utilizing GitHub and online forms for proper game development examples and tutorials. We will also be utilizing Git for source control and host our code repository. 

We anticipate on having to utilize photo editing software like photoshop in order to develop our graphics. We will also need to use an audio editing software to work on the audio that will be placed in the game.


# Method/Approach

(What is your estimated "plan of attack" for developing this project)

# Estimated Timeline

(Figure out what your major milestones for this project will be, including how long you anticipate it *may* take to reach that point)

# Anticipated Problems

The biggest anticipated problem may be designing and executing the interactive GUI that players will use.  By and large our team has limited experience designing games or creating GUIs through the java programming language.  Java has been used in the past by individuals or teams to create java games (e.g. Minecraft), but is by no means a prominent language used to create games.  Furthermore, our team consists of some members with limited java experience meaning there will be some potential roadblocks as they learn how to properly implement it in this context.  
 
Another problem we foresee is the lack of time for this project.  This is both in the upcoming deadline at the end of the Fall 2020 semester as well as the availability of time for each project team member.  The uncertainty and social distancing required by Covid-19 alone may be a problem, but it may also have unpredictable impacts on the project schedule.  We will continuously evaluate our deliverables against our proposed schedule, but nevertheless there may be impacts to system functionality if time constraints change.  

