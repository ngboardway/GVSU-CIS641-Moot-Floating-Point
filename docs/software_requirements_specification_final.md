# Software Requirements
This section lists the different functional and non-functional software requirements of the Pac-Meme game.  
These requirements are delineated by the following features:  Menus, Scoring, Gameplay, Sprite, & Maze.

## Functional Requirements

### Menus

| ID | Requirement |
| :-------------: | :----------: |
| FR1 | The game shall prompt the player to input their name when the 'space bar' is pressed while the title screen is displayed. |
| FR2 | The high-score leaderboard shall display the best 10 scores. |
| FR3 | The player shall view the high-score leaderboard list after the 'L' button is pressed. |
| FR4 | Gameplay shall begin after user completes the name entry prompt. |
| FR5 | The high-score leaderboard shall list the entered name that corresponds with the score the player achieved. |

### Scoring 

| ID | Requirement |
| :-------------: | :----------: |
| FR6 | The game shall increment the score when the player character interacts with consumables. |
| FR7 | The player shall receive 10 points for collecting a dot. |
| FR8 | The player shall receive 25 points for collecting a fruit or a power-up. |
| FR9 | While in the powered-up state, the player shall receive 50 points for collecting a ghost. |
| FR10 | The maximum possible score a player shall receive for collecting all consumables within the maze is 1400 points. |
| FR11 | The game shall store the player score at the end of the game if it is sufficient enough to be in the top 10 on the leaderboard. |

### Gameplay

| ID | Requirement |
| :-------------: | :----------: |
| FR12 | The game shall end once the player character has died 3 times. |
| FR13 | Player shall immediately lose life upon contact with ghost during while in the “normal”, or non-powered up, gameplay mode. |
| FR14 | The user shall not have less than zero lives and no more than three. |
| FR15 | Ghosts shall de-spawn immediately upon contact with powered-up player character. |
| FR16 | The high-score leaderboard shall list the entered name that corresponds with the score the player achieved. |
| FR17 | The user shall move the player character using the arrow keys or "WASD" keys on the keyboard. |
| FR18 | Movement direction of the player character shall correspond with the direction of the arrow or "WASD" key pressed. |
| FR19 | The user shall achieve the win condition after collecting all available dots and fruits. |
| FR20 | The collectables shall be removed from the maze upon player interaction. |

### Sprites

| ID | Requirement |
| :-------------: | :----------: |
| FR21 | There shall be a pool of 9 different ghost-meme sprite options from which the game can display. |
| FR22 | The game shall randomly choose 5 ghost-meme sprites from the ghost-meme sprite pool. |
| FR23 | The game shall display a single type of dot sprite and a single type of fruit sprite. |
| FR24 | The player character sprite shall update to "powered-up" sprite image upon collection of power-up. |
| FR25 | The player character sprite shall be 40 x 40 pixels in size. |
| FR26 | The ghost and collectable sprites shall be 50 x 50 pixels in size. |

### Maze

| ID | Requirement |
| :-------------: | :----------: |
| FR27 | There can be only 1 player character within the maze at a time. |
| FR28 | The maze boundaries shall consist of grey squares with black borders. |
| FR29 | Each square of the maze boundary system shall be 50 x 50 pixels in size. |
| FR30 | The maze shall consist of a contiguous outer wall and non-contiguous inner walls.  |
| FR31 | The total size of the maze shall be 750 x 750 pixels. |

## Non-Functional Requirements

### Menus

| ID | Requirement |
| :-------------: | :----------: |
| NFR1 | The menu system for the game shall be simple and intuitive for users. |
| NFR2 | Transition from the menu to the game shall be fast. |
| NFR3 | The user shall easily understand how to enter their name into the dialog box. |
| NFR4 | The user shall have easy access to game controls from the title screen. |
| NFR5 | The user should find text within the start screen and high-score leaderboard to be of appropriate size and legible. |

### Scoring 

| ID | Requirement |
| :-------------: | :----------: |
| NFR6 | The system shall prevent unauthorized access to high score leaderboard data. |
| NFR7 | The player’s score shall be clearly visible throughout game play. |
| NFR8 | The player shall perceive the different collectable score allocations as fair and appropriately rewarding. |
| NFR9 | The player shall achieve a score equitable to their level of skill by the end of the game. |
| NFR10 | The player shall not be able to alter their score in any way beyond interacting with collectables during the course of a game. |

### Gameplay

| ID | Requirement |
| :-------------: | :----------: |
| NFR11 | The player character shall immediately respond to all keyboard inputs. |
| NFR12 | The player character shall move around the map smoothly and not have any glitches. |
| NFR13 | Collision detection between the player character and the collectables shall appear to be accurate. |
| NFR14 | Users shall deem the gameplay to be intuitive and easy to perform. |
| NFR15 | Users shall find the gameplay fun and rewarding. |
| NFR16 | The gameplay screen and layout shall be logical and consistent with user expectations. |

### Sprites

| ID | Requirement |
| :-------------: | :----------: |
| NFR17 | The sprites used by the game shall be colorful and easily distinguishable from one another. |
| NFR18 | The ghost-meme sprites used by the game shall be amusing and recognizable by users. |
| NFR19 | The game shall use high quality sprites as models for characters and consumables. |
| NFR20 | The user shall quickly learn the difference and purpose of each of the different sprites. |
| NFR21 | The sprites shall have a frame rate that is pleasing to the user's eyes. |

### Maze

| ID | Requirement |
| :-------------: | :----------: |
| NFR22 | The user shall quickly understand how to navigate the player character through the maze. |
| NFR23 | The maze layout shall provide sufficient challenge to the user attempting to find optimized routes. |
| NFR24 | The game shall not allow users to clip the player character through the outer boundary wall nor the inner maze walls. |
| NFR25 | Users shall learn quickly that the walls of the maze serve as an impenetrable boundary. |
| NFR26 | Users shall not be able to alter the maze layout or the location of collectibles within the maze. |

# Change management plan

    As with all applications, a key consideration for Pac-Meme will be ensuring effective and widespread
    adoption of the platform amongst the target user base. To achieve this stated goal, the help of a formal
    change management plan will be enlisted. At the center of this plan is assessing an appropriate overall
    strategy for facilitating adoption and applying it uniformly to the product rollout. While our application
    does not necessarily serve as a direct replacement of any single existing technology, it does provide several
    advantages relative to previous game offerings (the as-is system), and these competitive advantages will
    serve as the primary vehicle to encourage adoption.

    At the forefront of the Pac-Meme change management plan is selling benefits of the application to
    potential adopters. These benefits include ease of installation, a gentle learning curve, high quality meme
    references, and exceptional player enjoyment. For an application that serves predominantly as a means of
    entertainment, the rational-empirical approach likely makes the most sense, as we should be focusing heavily
    on framing the advantages provided by our game relative to comparable games that a potential user base would
    be familiar with. Attempts to strongarm a player base into adopting the technology by way of the coercive 
    approach would pose a significant risk to longer term adoption metrics, as the gaming community at large is
    fickle and can rapidly transition between competing offerings.

    In terms of integration into the ecosystems of sponsors and potential adopters, the easily accessible
    nature of PacMeme should prove to be advantageous. As outlined in the README.md, the only requisites for
    running the application are installation of the Java Runtime Environment (JRE) and a Java IDE such as Eclipse
    or IntelliJ. These applications can be run on virtually any computer ecosystem (Windows, Mac, Linux) and will
    allow for widespread usage of PacMeme across a variety of adopter circumstances. This integration methodology
    is likely to be even further streamlined down the road through the use of executable JAR files, which could
    completely remove the need for a Java IDE from the equation.

    Another key aspect of the adoption process will be access to training that covers installation, menu
    navigation, and general gameplay. Though the training available to potential adopters is likely to be
    somewhat informal in the context of a video game such as Pac-Meme, there are several resources that we 
    intend to provide to ease their transition into playing the game. First, our README.md has been crafted to
    provide a general overview of running the application and beginning usage. Once the game is running, our
    application provides convenient access to game controls and leaderboards directly from the main menu,
    allowing new players to get up and running almost immediately. Prompts also exist from submenus that provide
    additional menu navigation instructions. If the prospective player is not familiar with games in general, we
    also intend to provide instructional videos on the developer website that outline the core gameplay mechanics
    of Pac-Meme and the best strategies for getting the most out of the gaming experience.

    Lastly, it is likely that the nature of Pac-Meme as a minimum viable product at time of delivery will result
    in a need for ongoing refinements as customer needs evolve. We feel that our design choices during the
    creation of Pac-Meme have set us up to successfully manage these needs and meet expectations. Specifically,
    we are confident that the foresight applied to technical aspects of the application (scalable class structure
    and adherence to object-oriented principles) will allow our development team to successfully address the need
    for maintainability and refinement over the project lifetime. This adaptability will prove essential to
    ensure our deliverable goes above and beyond to deliver long-term value to sponsors and adopters alike.
    Adopters will also be able to submit questions and improvement suggestions for Pac-Meme directly through our
    developer website. This input will be continually consulted to ensure user concerns are being addressed and
    gameplay improvements are being actively applied.

# Traceability links

This section highlights how key UML diagrams link to the various funtional and non-functional requirements listed in the previous software requirements section.  
*Note: not all functional requirements directly link to the UML diagrams listed below.

## Activity Diagram Traceability

| Artifact ID | Artifact Name | Requirement ID |
| :-------------: | :----------: | :----------: |
| [Activity Diagram #1 - Ver2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Activity%20Diagram%20%231%20-%20Ver2.pdf) | Gameplay and Movement | FR12-15, FR17-18, FR19-20, NFR12-15 |
| [Activity Diagram #2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Activity%20Diagram%20%232.pdf) | High-Score Leaderboard | FR2-3, FR5, NFR1-2, NFR5 |

## Use-Case Diagram Traceability

| Artifact ID | Artifact Name | Requirement ID |
| :-------------: | :----------: | :----------: |
| [Use Case Diagram #1](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use%20Case%20Diagram%20%231.pdf) | Game System | FR19-20, NFR12-15 |
| [Use Case Diagram #2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use%20Case%20Diagram%20%232.pdf)  | Start Menu | FR3-4, NFR1-2, NFR5 |
| [Use Case Diagram #3](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use_Case_Diagram%20%233.pdf) | High Score Menu | FR2, FR5, NFR1-2, NFR5 |

## Class Diagram

| Artifact ID | Artifact Name | Requirement ID |
| :-------------: | :----------: | :----------: |
| [Class Diagram](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/structural-models/Class%20Diagram.pdf) | Collectable | FR6-9, FR20, FR23, FR26, NFR8, NFR13, NFR17, NFR19-20 |

# Software Artifacts

Linked below are all of the relevant software artifacts created prior to or during the development of the Pac-Meme game.

## Functional Models

* [Activity Diagram #1 - Ver2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Activity%20Diagram%20%231%20-%20Ver2.pdf)
* [Activity Diagram #2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Activity%20Diagram%20%232.pdf)
* [Use Case Description #1 - Ver2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use%20Case%20Description%20%231%20-%20Ver2.pdf)
* [Use Case Diagram #1](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use%20Case%20Diagram%20%231.pdf)
* [Use Case Diagram #2](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use%20Case%20Diagram%20%232.pdf)
* [Use Case Diagram #3](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/functional-models/Use_Case_Diagram%20%233.pdf)

## Structural Models

* [Class Diagram](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/structural-models/Class%20Diagram.pdf)
* [CRC Card](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/structural-models/Collectible%20CRC%20Card.pdf)
* [Object Diagram](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/structural-models/Object%20Diagram.pdf)

## Data Persistence Models

* [Relational, NoSQL, & Flat File Database Diagrams](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/data-persistence-models/Data%20Persistence%20Models.pdf)

## Human-Computer Interaction (HCI)

* [Windows Navigation Diagram](https://github.com/ngboardway/GVSU-CIS641-Moot-Floating-Point/blob/master/artifacts/hci/WND.pdf)