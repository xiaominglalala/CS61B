public class NBody{
	public static double readRadius (String filename){
		In in = new In(filename);
		int num_planet = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Body[] readBodies (String filename){
		In in = new In(filename);
		int num_planet = in.readInt();
		double radius = in.readDouble();
		Body[] Body_array = new Body[num_planet];
		for (int i = 0; i < num_planet; i++){
			/*Body_array[i].xxPos = in.readDouble();
			Body_array[i].yyPos = in.readDouble();
			Body_array[i].xxVel = in.readDouble();
			Body_array[i].yyVel = in.readDouble();
			Body_array[i].mass = in.readDouble();
			Body_array[i].imgFileName = in.readString();*/
			double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Body_array [i] = new Body(xP, yP, xV, yV, m, img);
		}
		return Body_array;
	}
	public static void main(String[] args) {

		/*get data*/	
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		/*it's Body[]!!!*/
		Body[] Body_array = NBody.readBodies(filename);//it is NBody's method!!
		/*its double!!don't forget!!*/
		double radius = NBody.readRadius(filename);//you can't forget "NBody."
		
		/*draw background*/
		StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
/**		String imageToDraw = "images/starfield.jpg";
		public static void DrawBackground(){
		you can't use another public static */
/*		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0,imageToDraw);
		StdDraw.show();
		StdDraw.pause(2000);
		}
*/
		int len = Body_array.length;
		for (int i = 0; i < len; i++){
			Body_array[i].draw();
		}
		/*other'smethod*/
		// for (Body planet : Body_array) {
        //   planet.draw();
        //}
		
		for (double time = 0.0; time <= T; time += dt){
			StdDraw.enableDoubleBuffering();

			double[] xForces = new double [len]; 
			double[] yForces = new double [len];

			for (int j = 0; j < len; j++){
				/*not this,Body_array[j]!*/
				xForces[j] = Body_array[j].calcNetForceExertedByX(Body_array);
				yForces[j] = Body_array[j].calcNetForceExertedByY(Body_array);
		}
			/*it must be divided into two loops,
			because we can not make any calls to update until 
			all forces have been calculated and safely stored in xForces and yForces.*/		
			
			for (int j = 0; j < len; j++){	
				Body_array[j].update(dt, xForces[j], yForces[j]);
		}	

			StdDraw.picture(0, 0, "images/starfield.jpg");//these codes must be moved from next loop!
			for (int j = 0; j < len; j++){	
				Body_array[j].draw();
		}
				StdDraw.show();	
				StdDraw.pause(10);			
		}

		StdOut.printf("%d\n", len);
		StdOut.printf("%.2e\n", radius);
		for (int j = 0; j < len; j++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Body_array[j].xxPos, Body_array[j].yyPos, Body_array[j].xxVel,
                  Body_array[j].yyVel, Body_array[j].mass, Body_array[j].imgFileName);   
		}
	}


}