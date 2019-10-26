public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;


	public Body(double xP, double yP ,double xV, double yV,
					double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	public double calcDistance(Body b){
		double Disx = this.xxPos - b.xxPos;
		double Disy = this.yyPos - b.yyPos;
		double Dis = Math.sqrt(Math.pow(Disx, 2)+ Math.pow(Disy, 2));
		return Dis;
	}
	public double calcForceExertedBy(Body b){
		double G = 6.67e-11;
		double Force = (G * this.mass * b.mass)/Math.pow(calcDistance(b), 2);
		return Force;
	}
	public double calcForceExertedByX(Body b){
		double Forcex = this.calcForceExertedBy(b) * (b.xxPos - this.xxPos)/this.calcDistance(b); // repulsive force;everything needs this!!
		return Forcex;
	}
	public double calcForceExertedByY(Body b){
		double Forcey = this.calcForceExertedBy(b) * (b.yyPos - this.yyPos)/this.calcDistance(b); 
		return Forcey;
	}
	public double calcNetForceExertedByX(Body[] allBodys){
		double NetForcex = 0.0;
		for (int i = 0; i < allBodys.length; i++ ){
			if(!this.equals(allBodys[i])){
				NetForcex += this.calcForceExertedByX(allBodys[i]);
			}
		}
		return NetForcex;
	}
	public double calcNetForceExertedByY(Body[] allBodys){
		double NetForcey = 0.0;
		for (int i = 0; i < allBodys.length; i++ ){
			if (!this.equals(allBodys[i])){
				NetForcey += this.calcForceExertedByY(allBodys[i]);
			}
		}
		return NetForcey;
	}
	public void update (double dt,double fX, double fY){
		double a_x = fX/this.mass;
		double a_y = fY/this.mass;
		this.xxVel = this.xxVel + a_x * dt;
		this.yyVel = this.yyVel + a_y * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}
	public void draw (){
	/*	StdDraw.enableDoubleBuffering();

		 Clears the drawing window. 
		StdDraw.clear();
	*/
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);//most important
	}
}
/**
double xxPos: Its current x position
double yyPos: Its current y position
double xxVel: Its current velocity in the x direction
double yyVel: Its current velocity in the y direction
double mass: Its mass
String imgFileName: The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)
*/