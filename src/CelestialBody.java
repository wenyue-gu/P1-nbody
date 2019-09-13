

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

	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
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
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
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

	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67*1e-11;
		double F = G*myMass*b.getMass()/(this.calcDistance(b)*this.calcDistance(b));
		// TODO: complete method
		return F;
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(b.getX()-myXPos)/this.calcDistance(b);
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(b.getY()-myYPos)/this.calcDistance(b);
	}

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

	public void draw() {
		// TODO: complete method
	}
}
