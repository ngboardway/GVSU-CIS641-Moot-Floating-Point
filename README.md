# Moot Floating Point

Our project is based off the basics of Pac-Man. Your character moves around the maze while trying to not into walls or ghosts. The player’s goal is to collect all of the dots, which both increase your score and allow you to beat each level. There are special power-ups that allow you to eat the ghosts and temporarily disables them. Our update to the game includes Meme based sprites.

## Team Members and Roles

* [Natalie Boardway](https://github.com/ngboardway/CIS641-HW2-Boardway) (Assistant to the Regional Project Manager)
* [Jon Griesen](https://github.com/griesenj/CIS641-HW2-Griesen) (Project Manager (timeline overseer / sprite integration))
* [Nick Reitz](https://github.com/Reitzn/CIS641-HW2-Reitz) (Makes (all of the) diagrams -- usually overdone.  Also superb note-taker)
* [Nate Stern](https://github.com/nstern-gvsu/CIS641-HW2-Stern) (Software Engineer - Coding Extraordinaire)

## Prerequisites

Players will need a copy of an IDE (Integrated development environment) that will run Java, we recommend using [Intellij IDEA](https://www.jetbrains.com/idea/download/) community edition. The player will also need a JDK (Java Development Kit). Open Intellij IDEA and select File -> Project Structure -> Project Settings -> Project. If there is no JDK already selected in the section that says ‘Project SDK’ then click the drop down and click ‘Add SDK’ and then ‘Download JDK.’ Select the latest version of the JDK and select ‘Oracle OpenJDK’ for the Vendor and then click 'Download.' Now Intellij IDEA and the JDK are all set up and the player will now be able to run the game. 

## Run Instructions

From this Git Hub page, click the drop down in the top-middle part of the screen that says ‘Code’ and select ‘Download ZIP.’ Navigate to the download folder and extract the zipped file. Open a Java IDE and open the new extracted folder named “GVSU-CIS641-Moot-Floating-Point-master.” Expanding the Project folder will show all of the files in project. Expand the folder names ‘src,’ right click on ‘PacMeme’ file, and click ‘RunPackMeme.main()”. Pack-Meme will now be running and can be played. 

The players goal when playing Pac-Meme is to gather all of the collectables (dots, fruits, and power-ups) in order to win the game. There will be ghost that fallower the player trying to eat him while trying to eat the collectables. If the player is eaten by a ghost, they lose a life and respawn at the starting point. If the player is in power up mode, from eating a power up located in each corner of the game, the player will be able to eat ghosts removing them from the game and rewarding the player with points. The game is done when Pac-Meme has either eaten all of the collectables or if he has lost all three of his lives.

