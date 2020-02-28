## Obligatorisk oppgave 2 
 
### Part 1
 
**Changes in team members and new roles**

Just at the start of this sprint our group lost a member. Our teamleder, Jørn, chose to withdraw from the course. Jørn had a lot of experience with creating larger systems and was therefore the natural choice as a leader. His departure was unexpected and skewed our agreed upon team processes while working on this delivery. We realized that this could also happen in professional scenarios. We were therefore quick to adopt a mindset of professionalism when handling the situation.

Following Jørns departure, we chose Tård as our new leader. We also discussed all our roles in more detail because we felt disorganized, and because we received feedback from our tutor assistants that our roles were too vague. These roles, as well as the reasons for choosing Tård as our new leader are outlined below.
 
_Tård_

Tård is chosen as a new leader because of his experience working on bigger projects intended to have long life spans. He has insight when it comes to the bigger questions such as architecture, design patterns and dependencies. The architectural decisions must be approved by him, and he also formalizes strategy for architecture long term, as well as overseeing that team members adhere to this strategy. He is also the main lead working on networking.

_Gytis_

Gytis is responsible for the master branch in our git repository, and thus the final delivery of each sprint. Being responsible for the master branch means overseeing commits and merges to the master branch. Because of this, Gytis will have more commits than other team members. Gytis is also responsible for game design and user experience, using photoshop and tiles, and programming the views for the end user.

_Henrik_

Henrik is responsible for rules being implemented correctly as game logic, and for implementing model-view-controller (MVC) design patterns. He is thus responsible for implementing the programmatic models that represent the game logic, which goes hand-in-hand with being responsible for rules being implemented correctly. Being responsible for MVC, he is also responsible for implementing the controllers that connect  models with the views that Gytis develops. Henrik and Tård work close together since Tård is overseeing the architecture of the project.

_Håkon_

Håkon has the role of administering meetings, responsible for the reports, overseeing deadlines and task completion. Since Håkons’ level of programming differs quite from the rest of the group, he will have less of a role as developer in this team. However, he will contribute where he can and learn from the others.

**Group dynamics and team processes**

Daily communication goes through Slack, where we help each other and discuss progress pertaining to already delegated tasks and deadlines we agree upon within each delivery. The project board on GitHub servers as an overview of what is going on at each particular moment. We typically meet two times a week, including the mandatory session as specified in the course. Task delegation and deadlines within the team are decided upon in these meetings. Team members also meet to perform couples programming, which is something that is often done when larger commits to the master branch are done, where Gytis’ laptop is often used for the final commit.

**Retrospective**

At this point a menu is designed, the design protocol for further development is formalized, and robot movement is implemented, where the implementation adheres to MVC. We have decided on which interfaces and what classes the game should have. We think our team processes are working efficiently, and task completion within the group is good. Motivation and engagement is also high within the group. 

The workload in the group has changed due to Jørn's absence. However, we all agree that the communication has been good and that we have been able to distribute the workload quite equally among the four of us. The meetings are held in an efficient way, where problems are made more clear so that team members look forward to the next meeting.

We are not experienced with working on a Git repository with multiple team members, and our experience with creating and merging branches are poor. There is therefore some unnecessary communication taking place where commits to the master branch are coordinated. Sometimes team members must wait to start working because another team member is soon commiting to the master branch. One big potential improvement there lies in the successful management of merges of branches to the master branch. 

### Part 2
**This delivery**

We did not implement the user stories specified in the first delivery. With shift in roles and leadership and the discussions that came with it, and a better understanding of the task at hand, we decided to develop the game in a bottoms-up approach. The user stories in the previous delivery were focused on the phase of the round where players are choosing cards to program their robot, but no robot movement was implemented. We decided to start the development creating a menu. This was done with relative ease, yet still gives a nice atmosphere in terms of design and professionalism of this delivery, and deliveries to come. The next focus in this sprint, which was the most time consuming and important, was implementing visible robot movement, where the game logic and view is separated. This is specified in user story number two. We created a demo, where a user can click buttons that represent cards that move the robot around. The second most important task of this sprint was choosing the architecture/design principles in further development, and starting to program and refactor accordingly. We decided to develop the game using the model-view-controller design pattern, which is something not visible for end users directly, but is still very important in terms of software lifespan and maintainability.
 

**User story no. 1**

I want a menu where I can choose «play» in order to play and «quit» in order to quit the game. The menu must have a nice design.

_Task_

* Implement a well designed menu with buttons where I can navigate using my mouse.  I want to be able to start a game and terminate the program with my mouse.

_Acceptance requirements_

* I must be able to make decisions to start and terminate the game with my mouse clicking buttons. 

_Known bugs_ 

* If the player clicks on the button LAN the program terminates

**User story no. 2**

I want to move the robot with cards.

_Task_ 
* Create functionality where user can move the robot around using cards. With the first delivery, a demonstration of movement will be implemented via buttons that represent cards that can be chosen in a sequence.

_Acceptance_ 
*  A player can move the robot around according to cards represented by buttons.

_Know bugs in completion_
 * The robot is able to move outside the board and the screen.

**User story no. 3** 

I want to program the robots movements in a sequence by choosing multiple cards in a specified order.

_Task_ 
* Implement a round organizer that deals out movement cards for the user to choose from, and make a user able to choose these cards via drag and drop with his/her mouse.

_Acceptance requirements_
 * A player must be able to choose cards among several options via mouse drag and drop, and see that his/hers robots moves accordingly.


**User story no. 4** 

I want to play against other AI players, where I have the possibility to push the other players robot and also shoot the other robot with a laser, and vice versa.

_Task_ 

* Implement a simple AI robot that moves around the board via card choices.

_Acceptance requirements_
 
* A user can play a game against other opponents on the board.

**User story no. 5**
 
I want my robot to interact with effects on the board: conveyor belts, turning cogs, holes, etc, in compliance with game rules..

_Task_ 
* Implement game logic where different effects are positioned on the board, and they  affect robots in the same position.

_Acceptance requirements_ 
* A players’ robot interacts with effects positioned on the board when in the same position, in compliance with the boardgame. 

**User story no. 6**

I want the game to have a time limit while choosing cards in order to create a more action-packed game

_Task_ 
* Implement a timer that puts a limit on the time where a player is ablo to choose cards, and that forces a players’ already made choices when the timer stops.

_Acceptance requirements_ 
* A player can only choose his/hers cards in the specified time, which counts down visibly on the screen.

We consider the user history 2,3 and 4 as the most important parts of a MVP as this is what makes the game fun; to strategize better than other players in a short amount of time, choosing cards that outmaneuver other players in the context of fun elements on the board.


### Part 3

**Build, run and structure**

The code builds and runs by running ‘Main’ which is located in the inf112.RoboRally.app folder - the outermost folder in our package hierarchy. A LwgjApplication is initialized, with the ‘GameScreen’ class, which sets the screen to the ‘MainMenu’ class. From the ‘MainMenu’ class ‘ShowBoard’ is initialized, where current models for cards and robots are initialized manually within the class, and views are hardcoded. Refer to the UML diagram below ,which contains only the most important dependencies with regards to the focus of this delivery.

![UML diagram](https://github.com/inf112-v20/DVD-Project-Blue/blob/master/deliverables/UML/ObligatoriskOppgave2UML.png?raw=true)

**Navigating the menu**

The code builds and runs by running Main.java which is located in the inf112.RoboRally.app folder - the outermost folder in our package hierarchy.
The user is then taken to a menu, where he can choose between the buttons ‘PLAY’, ‘LAN’ and ‘QUIT’. There are currently no LAN functionality, so this button does not work, and mouse clicking it will terminate the program. Mouse clicking ‘QUIT’ will terminate the program, as intended. Mouse clicking ‘PLAY’ will take the user to a board with a robot placed at its correct starting position.

**Manual Movement Test**

The user can then manually test the robots’ movement by mouse clicking cards placed at the left hand side of the board. What is important to note in this test is that the placeholder card buttons represent actual card model objects that move a robot model around, and a view of these movements connected via the controllers ‘Position’ and ‘Direction’. Here is a picture of how this is programmed, in the case of the card that moves that moves the robot three steps forward:

![code snippet](Link here)

The card model object is initialized at line 122 in the picture above. It then takes the robot model object as input, to its method ‘moveRobot’ at line 123. The view/cell that is visibly moving around is never performing any logic, it is only asking questions about the robot models’ state, and setting its position accordingly. This is happening at line 124 in the picture above. All the buttons are programmed like in the example code in the picture, and can be viewed in the ‘ShowBoard’ class, highlighted by comments. The view is currently hardcoded in the ‘ShowBoard’ class, which was fine for the purposes of manually testing an established control between model and view, but will be abstracted abruptly in future progress. 

**Automated tests**

Our former team member had written automated Cucumber tests for models yet to be implemented in our previous delivery, setting way for test driven development. Cucumber is a software tool that the remaining team members have no experience with. These tests were therefore replaced by JUnit tests. The JUnit tests now in place can be found in the Test folder. The tests cover the following classes: ‘Position’, ‘Direction’, ‘Robot’ and ‘Card’, where the ‘Card’ test focuses on testing the intended logical effect that cards are intended to have on robots. 

Tests for models that are the next step in development are to be found in the ‘NextDeliveryTests’ branch. This branch also includes skeletons classes for round, board and player models.

Our team does not have any experience with automatic testing of views, but is the next focus in the development process, along with abstracting views and rendering separately. 
