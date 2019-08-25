/**
 * PLEASE READ:
 * you will find the given methods useful. But you can add more methods if you need to.
 * 
 */ 
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Robot {
	private String name;
	private int energyLevel;
	private int row; //robot's row coordinate
	private int column; //robot's column coordinate
	public static char direction;


	public Robot(String name, int energyLevel){
		this.name = name;
		this.energyLevel = energyLevel;
		Random randomNumbers = new Random();
		do{
			row = randomNumbers.nextInt(RobotGame.GRID_SIZE);
			column = randomNumbers.nextInt(RobotGame.GRID_SIZE);
		}while (row == 0 && column ==0); //row and column should NOT be both 0!

	}

	public Robot(String name, int energyLevel, int row, int column){
		this.name = name;
		this.energyLevel = energyLevel;
		this.row = row;
		this.column = column;

	}

	public String getName(){
		return name;
	}

	public int getRow(){
		return row;
	}

	public int getColumn(){
		return column;
	}

	public int getEnergyLevel(){
		return energyLevel;
	}

	public void setName(String name){
		this.name = name;
	}

	//	public void setType(int type){
	//		this.type = type;
	//	}

	public void setRow(int row){
		this.row = row;
	}

	public void setColumn(int column){
		this.column = column;
	}

	public void setEnergyLevel(int energyLevel){
		this.energyLevel = energyLevel;
	}

	public void printRobotInfo(){
		System.out.println(" Name: " + name + ", row = " + row + ", column = " + column + ", energy: " + energyLevel);
	}

	//assumption: new row and new colmn are both within [0, 3]
	//guaranteed by the isBoundary() method in RobotGame() class.
	public void move(char direction){

		switch (direction){
		case 'w':
			System.out.println("\n Users moving up");
			if (row > 0) {//move up only when row > 0	
				row--;
				energyLevel--;

				if((RobotGame.hrow  == row && RobotGame.hcol == column) || (RobotGame.erow  == row && RobotGame.ecol == column)) {
				System.out.println("\n Warning! User Bumped into Us");
				setRow(row + 1);
				energyLevel++;
			}}
			else {
				System.out.println("You've bumped into a wall, can't move that way!");
			}
			break;
		case 's':
			System.out.println("\n Usersmoving down");
			if (row < RobotGame.GRID_SIZE - 1){
				row++;
				energyLevel--;
			
			if((RobotGame.hrow  == row && RobotGame.hcol == column) || (RobotGame.erow  == row && RobotGame.ecol == column)) {
				System.out.println("  Warning! User Bumped into Something");
				setRow(row - 1);
				energyLevel++;
			}}

			else {
				System.out.println("You've bumped into a wall, can't move that way!");}
			break;
		case 'a':
			System.out.println("\n Users moving left");
			if (column > 0){
				column--;
				energyLevel--;
			

			if((RobotGame.hrow  == row && RobotGame.hcol == column) || (RobotGame.erow  == row && RobotGame.ecol == column)) {
				System.out.println("  Warning! User Bumped into Something");
				setColumn(column +1);
				energyLevel++;
			}}
			else {
				System.out.println("You've bumped into a wall, can't move that way!");
			}
			break;
		case 'd':
			System.out.println("\n Users moving right");
			//				if (column < RobotGame.GRID_SIZE)
			if (column < RobotGame.GRID_SIZE - 1) {//fixed
				column++;
				energyLevel--;
			
			if((  RobotGame.hrow == row && RobotGame.hcol == column) || (RobotGame.erow  == row && RobotGame.ecol == column)) {
				System.out.println("  Warning! User Bumped Robot");
				setColumn(column - 1);
				energyLevel++;
			}}
			else {
				System.out.println("You've bumped into a wall, can't move that way!");
			}
			break;
		default:
			System.out.println("Invalid moving direction! Must be w/s/d/a!");
			break;

		}//end switch
	}//end move()

	//assumption: new row and new column are both within [0, 3]
	//guaranteed by the isBoundary() method in RobotGame() class.
	public void move (){
		if (energyLevel <= 0){
			System.out.println( "warning: Robot runs out of energy. Can't move! Game Over!");
			System.exit(1);
		}
		else{
			System.out.println("Please Enter the Direction You want your Robot to move");
			System.out.println("You may enter 'w' to go up, 's' to go down ");
			System.out.println("'d' to go right and 'a' to go left  ");
			Scanner d = new Scanner(System.in);
			direction = d.next().charAt(0);
			move(direction);

		}//end else

	}//end move()

}//end of class
