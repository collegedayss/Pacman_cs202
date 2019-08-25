
public class HelperRobot extends Robot {
	static char[][] grid;
	public static char randomInt;


	public HelperRobot(String name, int energyLevel,int row, int column) {
		super(name, energyLevel, row, column);
	}
	@Override
	public void move() {

		move(RobotGame.user, RobotGame.robotE, RobotGame.robotH);
	}


	public void move(Robot user, EvilRobot evil, HelperRobot help){

		if(help.getEnergyLevel() < 1) {
			System.out.println("Helper Robot Has no energy right now");

			return;
		}


		else if(help.getColumn() == user.getColumn() && (help.getRow() == user.getRow() - 1 || help.getRow() == user.getRow() + 1

				) || help.getRow() == user.getRow() && (help.getColumn() == user.getColumn() - 1 || help.getColumn() == user.getColumn() + 1)) {

			help.setEnergyLevel(help.getEnergyLevel() - 2);

			user.setEnergyLevel(user.getEnergyLevel() + 2);

			System.out.println("Helper helpsss you!");
			return;
		}

		if(user.getRow() < help.getRow()){
			randomInt = 'u';
		}//moveup
		else if(user.getRow() > help.getRow()) {
			randomInt = 'd';
		}//move down
		else if(user.getColumn() < help.getColumn()) {
			randomInt = 'l';
		}//move left(a)
		else	if(user.getColumn() > help.getColumn()) {
			randomInt = 'r';
		}//move right(D)


		switch (randomInt){

		case 'u':
			System.out.println("Helper Moves UP");
			System.out.print(" Robot Energy Level:" + help.getEnergyLevel());
			if (help.getRow() >= 0) {
				help.setRow(help.getRow() - 1);

				if((help.getRow()  == user.getRow() && help.getColumn() == user.getColumn())
						||(RobotGame.goalRow == help.getRow() && RobotGame.goalCol == help.getColumn())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					System.out.println("  Warning! Helper Just Bumped into something");
					help.setRow(help.getRow() +1);
					help.setEnergyLevel(help.getEnergyLevel() - 1);

				}
			}
			else {	

				System.out.println("  Warning! Robot just bumped into the wall");
			}
			break;

		case 'd':
			System.out.print("Helper move down");
			System.out.print("  Robot Energy Level:" + help.getEnergyLevel());
			if( help.getRow() < RobotGame.GRID_SIZE - 1) {
				help.setRow(help.getRow() + 1);

				if((help.getRow()  == user.getRow() && help.getColumn() == user.getColumn())
						||(RobotGame.goalRow == help.getColumn() && RobotGame.goalCol == help.getRow())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					System.out.println("  Warning! Helper Just Bumped");
					help.setRow(help.getRow()-1);

					return;
				}help.setEnergyLevel(help.getEnergyLevel() - 1);
			}
			else {

				System.out.println("BUMPY INTO THE WALLY");
			}

			break;

		case 'r':
			System.out.print("move right");
			System.out.print("  Robot Energy Level:" + help.getEnergyLevel());
			if (help.getColumn() >= 0) {
				help.setColumn(help.getColumn() +1);
				if((help.getRow()  == user.getRow() && help.getColumn() == user.getColumn())
						||(RobotGame.goalRow == help.getColumn() && RobotGame.goalCol == help.getRow())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					System.out.println("  Warning!Helper Just Bumped");

					help.setColumn(help.getColumn() - 1);

					return;
				}help.setEnergyLevel(help.getEnergyLevel() - 1);
				}


			else {

				System.out.println("BUMP BY THE WALL");

			}


			break;


		case 'l':
			System.out.print("move left");

			System.out.print("  Robot Energy Level:" + help.getEnergyLevel());
			if( help.getRow() < RobotGame.GRID_SIZE - 1) {
				help.setColumn(help.getColumn() - 1);

				if((help.getRow()  == user.getRow() && help.getColumn() == user.getColumn())
						||(RobotGame.goalRow == help.getColumn() && RobotGame.goalCol == help.getRow())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					System.out.println("  Warning!Helper Just Bumped");

					help.setColumn(help.getColumn()+1);
					return;

				}help.setEnergyLevel(help.getEnergyLevel() - 1);}
			else {

				System.out.println("Bumpy into Wall=E");

			}  
			break;





		}}}







