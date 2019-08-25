/**
 * PLEASE READ:
 * This program RobotGame.java contains some code to help you start.
 * You do not have to use this program if you prefer not do.
 * 
 * some method headers are given to you, and you need to complete the 
 * method implementation. You might also need to create other methods 
 * to support needed functionalities. 
 * 
 */
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RobotGame {
	static HelperRobot robotH;
	static EvilRobot robotE;
	public static Robot user; //player of the game, who is also a robot.
	public static int goalRow; //row index of the GOAL
	public static int goalCol; //column index of the GOAL
	static char[][] grid; //a two-dimentional array.
	final static int GRID_SIZE = 4;
	static int energylevel = 10;
	static int urow, ucol, hrow,hcol, erow, ecol;


	/**initGame(): initialize the game
	 * Do the following:
	 * - create robotH, robotE, and user, including setting their positions based on requirements.
	 * - set goalRow and goalCol to be random numbers between [0, GRID_SIZE-1]
	 * - initialize the 2D array grid to be all 'o's.
	 */

	public static void initGame(){//initialize game
		//PUT DOWN YOUR CODE HERE
		Random randomGenerator = new Random();


		grid = new char[GRID_SIZE][GRID_SIZE];

		for(int i = 0; i < grid.length; i++)
		{
			for(int j =0; j < grid[i].length; j++) {
				grid[i][j]= 'o';

			}}

		do {
			goalRow = randomGenerator.nextInt(GRID_SIZE-1);
			goalCol = randomGenerator.nextInt(GRID_SIZE-1);


		}while (goalCol == 0 && goalRow  == 0);
		urow = 0;
		ucol = 0;

		do {
			hrow = randomGenerator.nextInt(GRID_SIZE-1);
			hcol = randomGenerator.nextInt(GRID_SIZE-1);


		}while ((hrow == goalRow  && hcol == goalCol)  || (hcol == 0 && hrow == 0 )||  (hrow == erow && hcol == ecol ));

		do {
			erow = randomGenerator.nextInt(GRID_SIZE-1);
			ecol = randomGenerator.nextInt(GRID_SIZE-1);


		}while ((ecol == 0 && erow == 0) || (erow == goalRow && ecol == goalCol) ||  (erow == hrow && ecol == hcol));

		user = new Robot("USER ROBOT", 5 , urow , ucol);
		robotH = new HelperRobot("HELPER ROBOT", energylevel, hrow, hcol);
		robotE = new EvilRobot("EVIL ROBOT", energylevel, erow, ecol);



	}



	/**
	 * print the grid and show the user robot as 'u',
	 * helper robot as 'h' and evil robot as 'e'
	 */
	public static void printGrid(){
		//PUT DOWN YOUR CODE HERE
		grid[goalRow][goalCol] = 'G';


		grid[robotE.getRow()][robotE.getColumn()] = 'E';
		grid[robotH.getRow()][robotH.getColumn()] = 'H';
		grid[user.getRow()][user.getColumn()] = 'U';

		System.out.println("     ");
		for(int i = 0; i < grid.length; i++)
		{
			for(int j =0; j < grid.length; j++) {


				if(j== grid.length-1) {


					System.out.println("       " + grid[i][j]);

				}
				else {

					System.out.print("       " + grid[i][j]);
				}
				if((i == user.getRow()) && (j == user.getColumn())) {
					System.out.format("(%d) ", user.getEnergyLevel());
				}
				else if((i == robotH.getRow()) && (j == robotH.getColumn())){
					System.out.format("(%d)", robotH.getEnergyLevel());

				}

				else if((i == robotE.getRow()) && (j == robotE.getColumn())){
					System.out.format("(%d)", robotE.getEnergyLevel());

				}	
				
			}	

		}


	}//end printGrid();

	/** 
	 * update the robot, reflecting all three robots' locations.
	 * For example, if the helper robot's location is [rowH, colH],
	 * then set grid[rowH][colH] to be 'h'.
	 */
	public static void updateRobotLocationOnGrid(){
		//PUT DOWN YOUR CODE HERE


		//user Robot
		if(Robot.direction == 's') {
			int temp =user.getRow()-1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[temp][user.getColumn()] = 'o';
			}
		}
		if(Robot.direction == 'w') {
			int temp1 =user.getRow()+1 ;
			if(temp1 > -1 && temp1 < GRID_SIZE ) {
				grid[temp1][user.getColumn()] = 'o';
			}
		}
		if(Robot.direction == 'd') {
			int temp =user.getColumn()-1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[user.getRow()][temp] = 'o';
			}
		}
		if(Robot.direction == 'a') {
			int temp1 =user.getColumn()+1 ;
			if(temp1 > -1 && temp1 < GRID_SIZE) {
				grid[user.getRow()][temp1] = 'o';
			}
		}
		//Helper Robot
		if(HelperRobot.randomInt == 'u') {
			int temp1 =robotH.getRow()+1 ;
			if(temp1 > -1 && temp1 < GRID_SIZE) {
				grid[temp1][robotH.getColumn()] = 'o';
			}
		}
		if(HelperRobot.randomInt == 'd') {
			int temp =robotH.getRow()-1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[temp][robotH.getColumn()] = 'o';
			}

		}
		if(HelperRobot.randomInt == 'r') {
			int temp =robotH.getColumn()-1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[robotH.getRow()][temp] = 'o';				}

		}
		if(HelperRobot.randomInt == 'l') {
			int temp1 =robotH.getColumn()+1 ;
			if(temp1 > -1 && temp1 < GRID_SIZE) {
				grid[robotH.getRow()][temp1] = 'o';
			}
		}
		//Evilrobot

		if(EvilRobot.move == 'u') {
			int temp =robotE.getRow()+1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[temp][robotE.getColumn()] = 'o';
			}
		}
		if(EvilRobot.move == 'd') {
			int temp1 =robotE.getRow()-1 ;
			if(temp1 < GRID_SIZE && temp1 > -1) {
				grid[temp1][robotE.getColumn()] = 'o';
			}

		}
		if(EvilRobot.move == 'r') {
			int temp =robotE.getColumn()-1 ;
			if(temp > -1 && temp < GRID_SIZE) {
				grid[user.getRow()][temp] = 'o';
			}

		}
		if(EvilRobot.move == 'l') {
			int temp1 =robotE.getColumn()+1 ;
			if(temp1 < GRID_SIZE && temp1 > -1 ) {
				grid[user.getRow()][temp1] = 'o';
			}
		}


		grid[goalRow][goalCol] = 'G';


		if( (user.getRow()==goalRow) && (user.getColumn() == goalCol)) {
			System.out.println("GAME OVER!, YOU WIN!!!!!!!!!!!");
			System.exit(1);
		}

	}


	public static void greetings(){
		//PUT DOWN YOUR CODE HERE
		System.out.println("Abridged Pacman Game. ");
		System.out.println("Muhammad Moiz Saeed and Ethan Lewis ");
		System.out.println("You may enter 'w' to go up, 's' to go down ");
		System.out.println("'d' to go right and 'a' to go left \n ");

	}


	public static void main(String[] args) throws IOException{

		greetings();

		initGame(); 
		updateRobotLocationOnGrid();
		printGrid();

		while(true){  

			//	user plays
			play(user);
			updateRobotLocationOnGrid();
			printGrid();
			//robotH plays
			play(robotH);
			updateRobotLocationOnGrid();
			printGrid(); 

			//robotE plays
			play( robotE);
			updateRobotLocationOnGrid();
			printGrid();
			user.printRobotInfo();


		}//end of while

	}//end of main()	

	/**
	 * thisRobot makes a move. 
	 * @param thisRobot (can be a user robot, a helper robot, or an evil robot)
	 * @throws IOException 
	 */
	public static void play(Robot thisRobot) throws IOException{
		//dynamic binding

		thisRobot.move();

	}//end of play()



}//end of class


