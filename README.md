
Java application.

In the following test case:
1.	Display of the grid is not in a square shape.
2.	When helper robot moves, sometimes its energy was not decreased. For example, in the first round.
3.	In the very last round, the user robot moves and covers the evil robot, which should not happen. Also, when the evil robot moves, why did the helper robot, which is not next to the evil,  lose energy?

Abridged Pacman Game. 
You may enter 'w' to go up, 's' to go down 
'd' to go right and 'a' to go left
 
     
       U(5)        o       G       o
       o       o       o       o
       E(10)       H(10)       o       o
       o       o       o       o
Please Enter the Direction You want your Robot to move
You may enter 'w' to go up, 's' to go down 
'd' to go right and 'a' to go left  
d

 Users moving right
     
       o       U(4)        G       o
       o       o       o       o
       E(10)       H(10)       o       o
       o       o       o       o
Helper Moves UP
 Robot Energy Level:10     
       o       U(4)        G       o
       o       H(10)       o       o
       E(10)       o       o       o
       o       o       o       o
Evil Dude Moves UP
 Robot Energy Level:10     
       o       U(4)        G       o
       E(9)       H(10)       o       o
       o       o       o       o
       o       o       o       o
 Name: USER ROBOT, row = 0, column = 1, energy: 4
Please Enter the Direction You want your Robot to move
You may enter 'w' to go up, 's' to go down 
'd' to go right and 'a' to go left  
a
 Users moving left
     
       U(3)        o       G       o
       E(9)       H(10)       o       o
       o       o       o       o
       o       o       o       o
Helper Moves UP
 Robot Energy Level:10     
       U(3)        H(10)       G       o
       E(9)       o       o       o
       o       o       o       o
       o       o       o       o
Your Energy Just decreased by two because evil
     
       U(1)        H(10)       G       o
       E(11)       o       o       o
       o       o       o       o
       o       o       o       o
 Name: USER ROBOT, row = 0, column = 0, energy: 1
Please Enter the Direction You want your Robot to move
You may enter 'w' to go up, 's' to go down 
'd' to go right and 'a' to go left  
s

 Usersmoving down
     
       o       H(10)       G       o
       U(0)        o       o       o
       o       o       o       o
       o       o       o       o
Helper move down  Robot Energy Level:10     
       o       o       G       o
       U(0)        H(9)       o       o
       o       o       o       o
       o       o       o       o
Your Helper robots energy decreased by 2
Evil Dude Moves UP
 Robot Energy Level:13     
       E(12)       o       G       o
       U(0)        H(7)       o       o
       o       o       o       o
       o       o       o       o
 Name: USER ROBOT, row = 1, column = 0, energy: 0
warning: Robot runs out of energy. Can't move! Game Over!


