package labGen;

/**
 * Area represents a cell in a maze.
 * 
 * @author Valentin "Alzaï" Pearce
 *
 */
/**
 * @author Alzai
 *
 */
public class Area {
	
	/**
	 * Northern door of the Area
	 */
	private boolean n;
	
	/**
	 * Southern door of the Area
	 */
	private boolean s;
	
	/**
	 * Eastern door of the Area
	 */
	private boolean e;
	
	/**
	 * (Spaghetti) Western door of the Area
	 */
	private boolean w;
	
	/**
	 * Has the cell already been visited ? Used for generation. can be used in a game.
	 */
	private boolean visited;
	
	/**
	 * Creates a new unvisited instance with no doors
	 */
	public Area (){
		n = false;
		s = false;
		e = false;
		w = false;
		visited = false;
	}

	/**
	 * @return <pre><code>true</code></pre> if a northern door exists, <pre><code>false</code></pre> if not.
	 */
	public boolean getN(){
		return this.n ;
	}
	
	/**
	 * @return <pre><code>true</code></pre> if a southern door exists, <pre><code>false</code></pre> if not.
	 */
	public boolean getS(){
		return this.s ;
	}
	
	/**
	 * @return <pre><code>true</code></pre> if a eastern door exists, <pre><code>false</code></pre> if not.
	 */	
	public boolean getE(){
		return this.e ;
	}
	
	/**
	 * @return <pre><code>true</code></pre> if a western door exists, <pre><code>false</code></pre> if not.
	 */
	public boolean getW(){
		return this.w ;
	}
	
	/**
	 * @return <pre><code>true</code></pre> if the cell has already been visited, <pre><code>false</code></pre> if not.
	 */
	public boolean getVisited(){
		return this.visited;
	}
	
	/**
	 * Sets the northern door to <pre><code>true</code></pre> by figuratively blasting through the wall. Think Kool-aid Man.
	 * Initially meant to be only used once during maze generation.
	 */
	public void blastN(){
		this.n = true;		
	}
	
	/**
	 * Sets the southern door to <pre><code>true</code></pre> by figuratively blasting through the wall. Think Kool-aid Man.
	 * Initially meant to be only used once during maze generation.
	 */
	public void blastS(){
		this.s = true;		
	}
	
	/**
	 * Sets the eastern door to <pre><code>true</code></pre> by figuratively blasting through the wall. Think Kool-aid Man.
	 * Initially meant to be only used once during maze generation.
	 */
	public void blastE(){
		this.e = true;		
	}
	
	/**
	 * Sets the western door to <pre><code>true</code></pre> by figuratively blasting through the wall. Think Kool-aid Man.
	 * Initially meant to be only used once during maze generation.
	 */
	public void blastW(){
		this.w = true;		
	}
	
	/**
	 * Sets visited to <pre><code>true</code></pre>
	 */
	public void visit(){
		this.visited = true;
	}
	
	/**
	 * Sets visited to <pre><code>false</code></pre>
	 */
	public void unvisit(){
		this.visited = false;
	}
}
