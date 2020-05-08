# Obligatorisk oppgave 4

### Part 1
**Team roles**

The roles within the team have remained the same since the two previous deliveries. 
Every team member is satisfied with their role and it is therefore no need for change. 
The roles have settled in after weeks of working on the same project and results in a stable 
group communication.

**Methodology**

Our selected methodology, Kanban, has in our eyes been the preferred and most suitable project 
methodology in our current situation. Due to the pandemic, the physical meetings have been cancelled. 
The project board has therefore played an even more important role throughout the project as it has 
kept the group members updated at all times. When dealing with a more unstable situation, a project 
board is a simple way for all the group members to check the projects progress. In order to communicate 
face to face and arrange group meetings we still benefit from using Microsoft Teams. 

As Kanban has been our selected project methodology since the second delivery, we acknowledge  
that the group could have benefited from trying out the other project methodologies presented in 
the course, such as Extreme programming (XP) or Scrum. However, it is known that projects rarely 
follows one single methodology and one end up combining differents procedures. In this way, the 
team is satisfied with the way we choose to work and would continue in the same way if it was not 
the last delivery. 

**Retrospective and Covid19**

As mentioned in the earlier deliveries, the project started with five group members. 
After the first delivery, the person who had been chosen as group leader decided to quit 
the course, which resulted in a change of roles. Tård become the new group leader and has 
lead the group ever since. The group dynamic changed due to the sudden situation and we all 
saw this as an learning opportunity as unforeseen changes often occurs within projects. 

Throughout the project the group has tried to work systematically and evenly spread the workload. 
As a group we try to help each other out as much as possible when difficulties, issues and errors 
occur. Our group has a very open dialogue which makes it a lot easier for members to ask for help 
and admit to mistakes. Every member of the group wants to make the best game possible and by helping
 each other the final product only becomes better. By the use of branches, the group have made it 
 easier to follow each members code and commits to the master branch when everything works as it should.
 
In a retro spective, the project could have started in a more efficient way. It was not possible to 
have foreseen the absence of one group member, however we could have created a team contract in order
 to define a concrete group goal and write down each of the members expectation of the group. The team
  contract could have included the descriptions of each role and preferred meeting hours. Furthermore,
   the contract could have listed expectation of each member of the group and listed some simple rules
    in order to accentuate efficiency and is something we would have done differently it we have started
     for the beginning. Additionally, we could have been better at writing meetings commentaries as this
      is not something we practiced.   

The communication between the group member have been somewhat stable throughout the period. However, 
he pandemic has naturally changed the group dynamic. As it was no longer possible to meet physically, 
the weekly group meetings we use to have at Realfagsbygget had to be done online. This affected the 
communication truly more than anticipated. It is important to mention that INF112 is not the only course 
this semester that demands a high workload, and the weekly communication between the group members are 
naturally dependent on the other course activities such as assignments and evaluations. 

In the third delivery the group faced a communication problem. Håkon, who had the main responsibility of 
writing the report, did not catch all the updates considering the different implementation of the game. 
The description of the game and the explained tests did not match the delivered code. This was an 
unfortunate incident, and could easily have been resolved with better communication. However, since 
that incident the group has tried to have more frequently communication.

The closing of the school and the implementation of strict guidelines made an impact on the project 
but also on many other aspects in our daily lives. The weekly meetings has not been prioritized in
 the previous weeks due to other courses with assignments. However, the communication has remained 
 somewhat stable. We have mainly used Slack and Facebook Messenger as a platform for discussion and 
 questions and Microsoft Teams when bigger updates and discussion were necessary. The progress of the 
 project has therefore been slightly delayed due to the pandemic but is not something we truly did not expect. 
 
As mentioned in previous deliveries, the number of commits differs between the members. Håkon has the main 
responsibility of the reports and Tård usually commits less then Henrik and Gytis as he has worked mainly
 on the LAN and server. 
 
**Projectboard**

Shown below is a screenshot of the current project board

![Project board](https://github.com/inf112-v20/DVD-Project-Blue/blob/master/deliverables/UML/ProjectBoardOblig4.PNG?raw=true)

### Part 2
The fourth delivery is the final delivery and the result should therefore be a complete game. Now the player 
of the game should be able to select the amount of AI-players it want to play against. However, the AI-players 
select the cards randomly and are not considered as smart.

Since last time we wanted to set up a server such that the player could play against other human players 
through a LAN. Unfortunately, we did not manage to implement this before the deadline. This part of the 
project has been challenging and we must admit that we should have started earlier. By starting earlier we 
could have faced the challenges while still having time to fix them. The implementation of LAN is really 
something we wished to accomplish and we talked about it in an early stage of the project. However,  even 
though the player could not play through a LAN, we have learned a lot and the written code has not been for 
nothing. This is something we will take with us in future game development projects. Furthermore, the elements 
on the board interacts with the player on the board. This is essential in order to create a complete game. There
 are now communication between the user, controllers, cards and players of the game. 
 
 In this delivery we have prioritized to complete the ability to play against other, and consider this as part 
 of the MVP. A complete game should have this option and it’s the main reason for the MVP consideration.
 
 **User stories**
 
 **_User stoy number 1_**
 
 I want to be able to choose the amount of robot-players to play against
 
 _Task:_
 
 Implement a method such that the player could choose the amount robot AI
 
 _Acceptance requirements:_
 
 A player should be able to choose the amount of players by clicking “player count” in the menu. 
 
 **_User story number 2_**
 
  I want to be able to win
  
 _Task:_
 
  Implement a method that indicates whenever a player has won the game
  
 _Acceptance requirements:_
 
 The player should be able to win the game if it has collected all the flags and has remaining health points (hp). 
 
 **_User story number 3_**
 
 I want to able to see when I die
 
 _Task:_
 
 Implement a method that indicates when the player have no lives left and the game is over.
 
 _Acceptance requirements:_
 
 The player should visually see when its own player dies, both on the board and in the player hub, 
 so that it knows when to restart the game.
 
 **_User story number 4_**
 
  I want to hear sound effects
  
 _Task:_
 
 Add on soundtrack when the players locations meets the location of an item
 
 _Acceptance requirements:_
 
 The player should be able to hear a sound when hitting an item on the board, i.e., a laser or a hole 
 
 **Bugs**
 
 ### Part 3
 
 Shown below is the respective class-diagram:
 
 **How to run the program**
 
 The game is run by running Main in the inf112.RoboRally.app folder. When running _Main_, 
 a new window will appear and the player is shown a menu with four different choices. 
 _Play_, _lan_, _test game_ and _quit_. When selecting _play_, the player can choose which game 
 board/map it wants and the amount of players it want to play against. It would have 
 been possible to play against other human players by clicking the _Lan_ button. When 
 clicking _Start_, the selected map appears and the player gets to drag and drop cards 
 from the right side of the board. The player has also the opportunity to change cards 
 by clicking the _Cards_ button. When the player has selected the preferred cards the game
  begin by clicking on the _Ready_-button. 
  