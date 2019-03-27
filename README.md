# JavaSwingTicTacToe
Java Swing application that uses TCP to allow 2 users to play Tic-Tac-Toe on different machines over a simulated distributed server network. 
Group project collab with Brandon James (jamesbra)

Our initial idea was to use TCP to allow two users to play a game. We would have two clients, and two servers, and each client would connect to their own (local) server, and the two servers would communicate with each other.

This simulates a distributed system where two players are playing a game in two different geographical locations on different game servers. Game logic is handled on the application (client) side. Servers are simply used to pass each Tic-Tac-Toe move to the players.

Our first steps were to begin writing a Client and Server class that communicated using TCP to begin. Once we had a Client and Server communicating by sending messages back and forth, we wrote another Client and another Server class that did the same thing and allowed our servers to communicate between each other as well. At this point, we used a Java Swing UI to create our Tic-Tac-Toe board and assigned indexes to each box.

Steps:
Launch Server 2
Launch Server 1
Server 1 initiates a TCP connection with Server 2
Launch Client 1
Launch Client 2
Client 1 connects to Server 1
Client 2 connects to Server 2
Client 1 begins the game...
