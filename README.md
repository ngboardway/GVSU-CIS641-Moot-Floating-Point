# Moot Floating Point

Our project is based off the core premise of Pac-Man. Your character moves around the maze while trying to avoid collisions with walls or ghosts. The player’s goal is to collect all of the dots, which both increase your score and allow you to beat each level. There are special power-ups that allow you to eat ghosts. Our unique addition to the game comes in the form of Meme-based sprites.

## Team Members and Roles

* [Natalie Boardway](https://github.com/ngboardway/CIS641-HW2-Boardway) (Co-lead software developer)
* [Jon Griesen](https://github.com/griesenj/CIS641-HW2-Griesen) (Project manager / Documentation lead)
* [Nick Reitz](https://github.com/Reitzn/CIS641-HW2-Reitz) (Diagram / Artifact lead)
* [Nate Stern](https://github.com/nstern-gvsu/CIS641-HW2-Stern) (Co-lead software developer)

## Prerequisites

Players will need a copy of an IDE (Integrated development environment) that will run Java, we recommend using [Intellij IDEA](https://www.jetbrains.com/idea/download/) community edition. The player will also need a JDK (Java Development Kit). Open Intellij IDEA and select File -> Project Structure -> Project Settings -> Project. If there is no JDK already selected in the section that says ‘Project SDK’ then click the drop down and click ‘Add SDK’ and then ‘Download JDK.’ Select the latest version of the JDK and select ‘Oracle OpenJDK’ for the Vendor and then click 'Download.' Now Intellij IDEA and the JDK are all set up and the player will be able to run the game.

## Run Instructions

From this GitHub page, click the drop down menu in the top-middle part of the screen that says ‘Code’ and select ‘Download ZIP.’ Navigate to the download folder and extract the zipped file. Open a Java IDE and open the new extracted folder named “GVSU-CIS641-Moot-Floating-Point-master.” Expanding the Project folder will show all of the files in the project. Expand the folder named ‘src,’ right click on the ‘PacMeme’ file, and click ‘RunPackMeme.main()”. The Pack-Meme application window will open and the game can now be played.

The player's goal when playing Pac-Meme is to gather all of the collectables (dots, fruits, and power-ups) in order to win the game. There will be ghosts that can eat the player as they try to gather collectables. If the player is eaten by a ghost, they lose a life and respawn at the starting point. If the player has consumed a power up from one of the game board's four corners, they will enter a powered up state and be able to eat ghosts. Eating a ghost removes the enemy from the game board and rewards the player with points. The game is completed when Pac-Meme has either eaten all of the collectables or lost all three lives.
