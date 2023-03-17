import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class monsterLevel extends Room {
	
	public monsterLevel() {
        	super();
   	}
    
        enemySpawnChance = 1;
	@Override
    	public void roomEngine() {
    		Scanner scnr = new Scanner(System.in);
    		try {
    			BufferedReader trap = new BufferedReader(new FileReader("monsterLevelText.txt"));
                	String line = trap.readLine(); 
    			while(line != null && scnr.next().equals("/n")) {
    				System.out.print(line);
				line = trap.readLine();
    			}
               		//reads out room enter text, with each new line being generated when the player hits enter
                	trap.close();
                if (this.Room.getMonsters() == "Snake"){
                    System.out.print("You see a horrible, slithery snake!");
                }
                // If there's a snake in the room, it generates text. (insert toxic by britney spears) 
                else if (this.Room.getMonsters() == "Zombie"){
                    System.out.print("You see a shambling corpse!");
                }
                // If there's a zombie (insert Cranberries song here)
                else if (this.Room.getMonsters() == "Frog"){
                    System.out.print("You see a... brightly colored frog?");
                }
                //poison dart frog - soon to have its own ending (greatful dead?).
                
                System.out.print("Maybe don't get too close... you don't have very many options.");
                // hints that the player should keep away from the monster
		
		for (int i = 0; i < getEnemyPosition.length; i++){
                	if (getPlayerPosition() == getEnemyPosition(i)) {
                    		if (this.Room.getMonsters() == "Snake"){
                       	 	System.out.print("The snake lunges! You've been bitten!");
                       	 	// if you interact with the snake
                    		}
                    		else if (this.Room.getMonsters() == "Zombie"){
                       	 	System.out.print("The zombie leaps at you with a snarl!");
                        	// if you interact with the Zombie
                    		}
                   	 else if (this.Room.getMonsters() == "Frog"){
                       	 	System.out.print("You pick up the frog. It wiggles indignantly.");
                        	// if you interact with the frog
                    	} 
    				try {
                        	BufferedReader pitBuffer = new BufferedReader(new FileReader("poisonEnemy.txt"));
				String line2 =  pitBuffer.readLine();
    			        while(line2 != null && scnr.next().equals("/n")) {
    				        System.out.print(line2);
					line2 =  pitBuffer.readLine();
    			        }
				//reads out the poisoned ending, with each new line being generated when the player hits enter
                        pitBuffer.close();
                        IOException end;
                        throw end;
			//creates and throws an end condition to be caught by the game engine
    				}
                     
                	catch (FileNotFoundException e) {
                	e.printStackTrace();
                	}
                	catch (IOException e) {
        			e.printStackTrace();
				System.out.print("Sorry! You can't do that here.");
                	}
			//catches any errors generated by the second filereader
                	}
		}
    		}
    		catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} 
    		catch (IOException e) {
    			e.printStackTrace();
			System.out.print("Sorry! You can't do that here.");
    		}
		//catches any errors generated by the first filereader
    	}
}
