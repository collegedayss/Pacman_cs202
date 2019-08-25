
public class EvilRobot extends Robot {
	static char[][] grid;
	public static char move;	
	public EvilRobot(String name, int energyLevel,int row, int column) {

		super(name, energyLevel, row , column);

	}
	@Override
	public void move() {
		move(RobotGame.user, RobotGame.robotE, RobotGame.robotH);
	}


	public void move(Robot user, EvilRobot evil, HelperRobot help){

		if((evil.getColumn() == user.getColumn() && (evil.getRow() == user.getRow() - 1 || evil.getRow() == user.getRow() + 1

				) || evil.getRow() == user.getRow() && (evil.getColumn() == user.getColumn() - 1 || evil.getColumn() == user.getColumn() + 1)) ){

			evil.setEnergyLevel(evil.getEnergyLevel() + 2);

			user.setEnergyLevel(user.getEnergyLevel() - 2);

			System.out.println("Your Energy Just decreased by two because evil");
			return;
		}
		if((evil.getColumn() == help.getColumn() && 
				(evil.getRow() == help.getRow() - 1 || evil.getRow() == help.getRow() + 1) 
				|| evil.getRow() == help.getRow() && 
				(evil.getColumn() == help.getColumn() - 1 ||
				evil.getColumn() == help.getColumn() + 1))) {
			evil.setEnergyLevel(evil.getEnergyLevel() + 2);
System.out.println("Your Helper robots energy decreased by 2");
			help.setEnergyLevel(help.getEnergyLevel() - 2);
			
			
		}
		else if(evil.getEnergyLevel() < 1) {
			System.out.println("ROBOT Won't move anymore");
			evil.setEnergyLevel(evil.getEnergyLevel());
			return;}
		else if(user.getRow() < evil.getRow()){
			move = 'u';
		}//moveup
		else if(user.getRow() > evil.getRow()) {
			move = 'd';
		}//move down
		else if(user.getColumn() < evil.getColumn()) {
			move = 'l';
		}//move left(a)
		else	if(user.getColumn() > evil.getColumn()) {
			move = 'r';
		}//move right(D)


		switch (move){

		case 'u':
			System.out.println("Evil Dude Moves UP");
			System.out.print(" Robot Energy Level:" + evil.getEnergyLevel());
			if (evil.getRow() > 0) {
				evil.setRow(evil.getRow() - 1);

				if((evil.getRow()  == user.getRow() && evil.getColumn() == user.getColumn())
						||(RobotGame.goalRow == evil.getRow() && RobotGame.goalCol == evil.getColumn())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					System.out.println("  Warning! Robot just bumped into Something");
					evil.setRow(evil.getRow() +1);
					return;

				}
				evil.setEnergyLevel(evil.getEnergyLevel() - 1);
			}
			else {	

				System.out.println("  Warning! Robot just bumped into the wall");
			}
			break;

		case 'd':
			System.out.print("Evil Dude move down");
			System.out.print("  Robot Energy Level:" + evil.getEnergyLevel());
			if( evil.getRow() < RobotGame.GRID_SIZE - 1) {
				evil.setRow(evil.getRow() + 1);

				if((evil.getRow()  == user.getRow() && evil.getColumn() == user.getColumn())
						||(RobotGame.goalRow == evil.getRow() && RobotGame.goalCol == evil.getColumn())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					evil.setRow(evil.getRow()-1);

					return;
				}evil.setEnergyLevel(evil.getEnergyLevel() - 1);}
			else {

				System.out.println("BUMPY INTO THE WALLY");
			}

			break;

		case 'r':
			System.out.print(" Evil move right");
			System.out.print("  Robot Energy Level:" + evil.getEnergyLevel());
			if (evil.getColumn() >= 0) {
				evil.setColumn(evil.getColumn() +1);
				if((evil.getRow()  == user.getRow() && evil.getColumn() == user.getColumn())
						||(RobotGame.goalRow == evil.getRow() && RobotGame.goalCol == evil.getColumn())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {
					evil.setColumn(evil.getColumn() - 1);
					return;

				}
				evil.setEnergyLevel(evil.getEnergyLevel() - 1);
			}


			else {

				System.out.println("/nBUMP BY THE WALL");

			}


			break;


		case 'l':
			System.out.print("Evil dude move left");

			System.out.print("  Robot Energy Level:" + evil.getEnergyLevel());
			if( evil.getRow() < RobotGame.GRID_SIZE - 1) {
				evil.setColumn(evil.getColumn() - 1);

				if((evil.getRow()  == user.getRow() && evil.getColumn() == user.getColumn())
						||(RobotGame.goalRow == evil.getRow() && RobotGame.goalCol == evil.getColumn())
						||(evil.getRow()  == help.getRow() && evil.getColumn() == help.getColumn())) {

					evil.setColumn(evil.getColumn()+1);
					return;
				}					
				
				evil.setEnergyLevel(evil.getEnergyLevel() - 1);
			}
			else {

				System.out.println("Bumpy into Wall=E");

			}  
			break;





		}}}
