package dat;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import employees.Artiste;
import employees.Artiste.*;
import employees.SimTime;


public class User {
	

	boolean rightMouseDown = false;
	private BlockGrid grid;
	private BlockType[] bType;
	private int index;
	private ArrayList<TrafficLight1> tLightList;
	private TrafficLightType TLType;
	public User(BlockGrid grid) {
		this.grid = grid;
		this.bType = new BlockType[3];
		this.bType[0] = BlockType.Ground;
		this.bType[1] = BlockType.Road;
		this.bType[2] = BlockType.Building;
		this.TLType = TrafficLightType.xGreen;
		this.index = 0;		
	}
	
	public void setBlock() {
		grid.setBlock(
				(int)Math.floor(Mouse.getX() / BlockGrid.BLOCK_SIZE),
				(int) Math.floor((Artiste.HEIGHT -Mouse.getY() - 1) / BlockGrid.BLOCK_SIZE), 
				bType[index]);
	}
	
	public void update() {
		if(Mouse.isButtonDown(0)) {
		setBlock();
		
		}
		if(Mouse.isButtonDown(1) && !rightMouseDown) {
	//	tLightList.add(new TrafficLight1(QuickLoad("Intersection1"), grid.getBlock(18, 9)));
		}
		rightMouseDown = Mouse.isButtonDown(1);
		
		while(Keyboard.next()) {
			if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				iterateIndex();
			}
			
			if(Keyboard.getEventKey() == Keyboard.KEY_UP && Keyboard.getEventKeyState() && SimTime.Multiplier() < 3) {
				SimTime.ChangeMultiplier(0.2f);
			}
			
			if(Keyboard.getEventKey() == Keyboard.KEY_DOWN && Keyboard.getEventKeyState() && SimTime.Multiplier() >= 0.2) {
				SimTime.ChangeMultiplier(-0.2f);
			}
		}		
	}

	private void iterateIndex() {
		index++;
		if(index > bType.length - 1) {
			index = 0;
		}
	}
	
	
	
	
}
