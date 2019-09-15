

/**
 * Celestial Body class for NBody
 * @author
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
    private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}

	/**
	 * Return the object's value of the x position
	 * @return value of x position
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 * Return the body's value of the y position
	 * @return value of y position
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Return the body's value of the x velocity
	 * @return value of x velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * Return mass of this Body.
	 * @return value of mass.
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * Return name of this Body.
	 * @return value of name.
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double dx = b.getX() - myXPos;
		double dy = b.getY() - myYPos;
		double r = Math.sqrt(dx*dx+dy*dy);
		// TODO: complete method
		return r;
	}

	/**
	 * Return the force between this body and another
	 * calculated with equation F = Gm1m2/(r^2)
	 * r is the distance between the two objects, calculated with the calcDistance method
	 * m1 m2 are the respective mass of the two objects
	 * @param b the other body
	 * @return force between this body and b
	 */
	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67*1e-11;
		double F = G*myMass*b.getMass()/(this.calcDistance(b)*this.calcDistance(b));
		// TODO: complete method
		return F;
	}
	/**
	 * Return the force in x direction between this body and another
	 * calculated with equation Fx = F*dx/r
	 * r is the distance between the two objects, calculated with the calcDistance method
	 * dx is the difference between the object's x position
	 * @param b the other body
	 * @return force in x direction between this body and b
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(b.getX()-myXPos)/this.calcDistance(b);
	}

	/**
	 * Return the force in y direction between this body and another
	 * calculated with equation Fy = F*dy/r
	 * r is the distance between the two objects, calculated with the calcDistance method
	 * dx is the difference between the object's y position
	 * @param b the other body
	 * @return force in y direction between this body and b
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(b.getY()-myYPos)/this.calcDistance(b);
	}

	/**
	 * Return the net force in x direction between this body and a set of other bodies
	 * calculate the force between this body and every body in the set, then add
	 * exclude this body from the set of bodies in case it is in the set
	 * @param bodies the set of other bodies
	 * @return net x direction force between this body and the set of body bodies
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double net = 0;
		for(CelestialBody b : bodies){
			if(!b.equals(this)){
				net = net + this.calcForceExertedByX(b);

			}
		}
		return net;
	}
	/**
	 * Return the net force in y direction between this body and a set of other bodies
	 * calculate the force between this body and every body in the set, then add
	 * exclude this body from the set of bodies in case it is in the set
	 * @param bodies the set of other bodies
	 * @return net y direction force between this body and the set of body bodies
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double net2 = 0;
		for(CelestialBody b : bodies){
			if(!b.equals(this)){
				net2 = net2 + this.calcForceExertedByY(b);

			}
		}
		return net2;
	}
	/**
	 * Update the x position, y position, x velocity, y velocity of this body
	 * acceleration is calculated by force/mass
	 * new velocity is calculated by old velocity + acceleration in this direction * deltaT
	 * new position is calculated by old position + new velocity in this direction * deltaT
	 * @param deltaT is the amount of time that has passed since last update
	 * @param xforce is the force in the x direction
	 * @param yforce is the force in the y direction
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax = xforce/myMass;
		double ay = yforce/myMass;
		double nvx = myXVel + deltaT*ax;
		double nvy = myYVel + deltaT*ay;
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;

		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;

	}

	/**
	 * Draws the star/output the figure
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
