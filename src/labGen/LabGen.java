/**
 * 
 */
package labGen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Valentin "Alza�" Pearce
 *
 */
public class LabGen {

	/**
	 * Creates a square maze full of unvisited Areas with no doors.
	 * @param blank is a new ArrayList
	 * @param size is the amount of cells along one side of the maze
	 */
	public static void createEmpty(ArrayList<ArrayList<Area>> blank, int size){
		for (int i = 0; i < size; i++){
			blank.add(new ArrayList<Area>());
			for (int j = 0; j < size; j++){
				blank.get(i).add(new Area());
			}
		}
	}
	
	/**
	 * Generates a random "perfect" maze (i.e. one which never loops)
	 * @param map is an empty map that has been generated by createEmpty()
	 */
	public static void createMaze(ArrayList<ArrayList<Area>> map) {
		int size = map.size();
		int visited = 1;
		int totalCells = size*size;
		ArrayList<Coord> path = new ArrayList<Coord>();
		
		int startX =(int)(Math.random()*size);
		int startY =(int)(Math.random()*size);
		Coord visiting = new Coord(startX, startY);
		
		boolean chosen = false;
		boolean n = false;
		boolean s = false;
		boolean e = false;
		boolean w = false;
		path.add(new Coord(visiting.getX(),visiting.getY()));
		while (visited < totalCells){
			map.get(visiting.getX()).get(visiting.getY()).visit();
			n = false;
			s = false;
			e = false;
			w = false;
			chosen = false;
			System.out.println(visited+"<"+totalCells);
			
			if (visiting.getX() > 0 && !map.get(visiting.getX()-1).get(visiting.getY()).getVisited()){
				n = true;
			}
			
			if (visiting.getX() < size-1 && !map.get(visiting.getX()+1).get(visiting.getY()).getVisited()){
				s = true;
			}
			
			if (visiting.getY() < size-1 && !map.get(visiting.getX()).get(visiting.getY()+1).getVisited()){
				e = true;
			}
			
			if (visiting.getY() > 0 && !map.get(visiting.getX()).get(visiting.getY()-1).getVisited()){
				w = true;
			}
			
			if (n || s || e || w){
				while (!chosen){
					int direction = (int)(Math.random()*4);
					if (direction == 0 && n){
						chosen = true;
						map.get(visiting.getX()).get(visiting.getY()).blastN();
						visiting.setX(visiting.getX()-1);
						map.get(visiting.getX()).get(visiting.getY()).blastS();
						//System.out.println("Going N");
						visited++;
						//System.out.println(visited);
					} else if (direction == 1 && s){
						chosen = true;
						map.get(visiting.getX()).get(visiting.getY()).blastS();
						visiting.setX(visiting.getX()+1);
						map.get(visiting.getX()).get(visiting.getY()).blastN();
						//System.out.println("Going S");
						visited++;
						//System.out.println(visited);
					}  else if (direction == 2 && e){
						chosen = true;
						map.get(visiting.getX()).get(visiting.getY()).blastE();
						visiting.setY(visiting.getY()+1);
						map.get(visiting.getX()).get(visiting.getY()).blastW();
						//System.out.println("Going E");
						visited++;
						//System.out.println(visited);
					}  else if (direction == 3 && w){
						chosen = true;
						map.get(visiting.getX()).get(visiting.getY()).blastW();
						visiting.setY(visiting.getY()-1);
						map.get(visiting.getX()).get(visiting.getY()).blastE();
						//System.out.println("Going W");
						visited++;
						//System.out.println(visited);
					}
				}
				path.add(new Coord(visiting.getX(),visiting.getY()));
			} else {
				//System.out.println("Rollback");
				//System.out.println("Starting Cell : "+startX+","+startY);
				//System.out.println("Last in path before removal : "+path.get(path.size()-1).getX()+","+path.get(path.size()-1).getY());
				path.remove(path.size()-1);
				//System.out.println("Last in path after removal : "+path.get(path.size()-1).getX()+","+path.get(path.size()-1).getY());
				visiting.setX(path.get(path.size()-1).getX());
				visiting.setY(path.get(path.size()-1).getY());
				
			}
		}
		//System.out.println("Finished Generation");
		path.clear();
	}
	
	/**
	 * Asks for user input an generates a maze accordingly
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int size = 6;
		boolean askInput = true;
		while (askInput){
			try {
				size = input.nextInt();
				askInput = false;
			} catch (InputMismatchException ex){
				System.out.println("Please try again. (Incorrect input: an integer is required)");
			}
			input.nextLine();
		}
		

		ArrayList<ArrayList<Area>> map = new ArrayList<ArrayList<Area>>();
		
		createEmpty(map,size);
		
		createMaze(map);
		
		for(ArrayList<Area> i : map){
			for (Area a : i){
				a.unvisit();
				//System.out.println(a.getN()+","+a.getS()+","+a.getE()+","+a.getW());
			}
		}
	}
}
