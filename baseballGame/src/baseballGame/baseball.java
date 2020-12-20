package baseballGame;

import java.util.*;
import java.util.Scanner;
public class baseball implements Runnable {
//	boolean hitCon;
//	Timer tos = new Timer();
	String pitch;
	int pnum;
	int mph;
	int ot;
	int yn1;
	int pt; // pitch time 
	int rows =3;
	int columns =3;
	int rloc;
	int cloc;
	int marker =1; //  temp place holder
	// String [][] zone= new String[2][2];
	// boolean fo;
	// boolean so;
	// boolean to;'
	// boolean isOc;
	int fbase;
	int sbase;
	int tbase;
	// int [] onbase = new int[2];
	public player batter;
	public player pitcher;
//	bases game;
	Random speed = new Random();
	Random rndm = new Random();
	Scanner scna = new Scanner(System.in);
	static int strikes;
	static int hrunCount;
	static int doubCount;
	static int tripCount;
	static int sinCount;
	static int balls;
	static int outs;
	static int innings;
	static int runcount;
	static int hcount = 0;
	static int scount = 0;
	static int wcount = 0;
//	timer pitchtime;

	public baseball(player p, player b/*, bases game*/) {
		pitcher = p;
		batter = b;
//		this.game=game;
		mph = pitcher.getMph();
		pnum = pitcher.getPnum();
	}

	public void ThePitch(int xnum) {
		pitcher.setPnum(xnum);
		if (pitcher.getPnum() == 0) {
			pitch = "fastball";
			mph = speed.nextInt(100 - 75) + 75;
			pitcher.setMph(mph);
			rloc = rndm.nextInt(2);
			cloc = rndm.nextInt(2);


		} else if (pitcher.getPnum() == 1) {
			pitch = "Curveball";
			mph = speed.nextInt(88 - 65) + 65;
			pitcher.setMph(mph);


		} else if (pitcher.getPnum() == 2) {
			pitch = "Knuckleball";
			mph = speed.nextInt(70 - 55) + 55;
			pitcher.setMph(mph);


		} else {
			int wp = rndm.nextInt(1);
			if (wp == 0) {
				System.out.println("wildpitch!");
				pitch = "fastball";
				pitcher.setPnum(4);

			} else
				System.out.println("wildpitch over the catcher");
			pitch = "fastball";
			pitcher.setPnum(4);
		}
	}

	public void soby() {
		if (pitcher.getPnum() == 0) {
			int sob = rndm.nextInt(6); //71% strike

			if (sob==0||sob==1||sob==2||sob==3||sob==4) {

				if (strikes < 2) {
					System.out.println("Strike");
					strikes++;
				} else {
					System.out.println("Strikeout!");
					strikes = 0;
					balls = 0;
					scount++;
					if (outs < 2) {
						outs++;
					} else {
						outs++;
						System.out.println(" 3 outs Change sides");
					}

				}

			} else {
				if (balls < 3) {
					System.out.println("Ball");
					balls++;
				} else {
					System.out.println("Ball 4!");
					balls = 0;
					strikes = 0;
					wcount++;
				}

			}
		}

		else if (pitcher.getPnum() == 1) {
			int sob = rndm.nextInt(4); //60% strike

			if (sob==0||sob==1||sob==2) {
				if (strikes < 2) {
					System.out.println("Strike");
					strikes++;
				} else {
					System.out.println("Strikeout!");
					strikes = 0;
					balls = 0;
					scount++;
					if (outs < 2) {
						outs++;
					} else {
						outs++;
						System.out.println(" 3 outs Change sides");
					}

				}

			} else {
				if (balls < 3) {
					System.out.println("Ball");
					balls++;
				} else {
					System.out.println("Ball 4!");
					balls = 0;
					strikes = 0;
					wcount++;
				}
			}

		}

		else if (pitcher.getPnum() == 2) {
			int sob = rndm.nextInt(7);//37.5% strike

			if (sob==0||sob==1||sob==2) {
				if (strikes < 2) {
					System.out.println("Strike");
					strikes++;
				} else {
					System.out.println("Strikeout!");
					strikes = 0;
					balls = 0;
					scount++;
					if (outs < 2) {
						outs++;
					} else {
						outs++;
						System.out.println(" 3 outs Change sides");
					}

				}

			} else {
				if (balls < 3) {
					System.out.println("Ball");
					balls++;
				} else {
					System.out.println("Ball 4!");
					balls = 0;
					strikes = 0;
					wcount++;
				}
			}
		}

		else if (pitcher.getPnum() == 5) {
			if (strikes < 2) {
				System.out.println("Strike");
				strikes++;
			} else {
				System.out.println("StrikeOut!");
				strikes = 0;
				balls = 0;
				scount++;
				if (outs < 2) {
					outs++;
				} else {
					outs++;
					System.out.println(" 3 outs Change sides");
				}
			}
		}

		else {
			if (balls < 3) {
				System.out.println("Ball");
				balls++;
			} else {
				System.out.println("Ball 4!");
				balls = 0;
				strikes = 0;
				wcount++;
			}
		}
	}

	public void hom(int yn) {
		yn1 = yn;
		if (yn1 == 0) {
			if (pitcher.getPnum() == 0) {

				if (pitcher.getMph() <= 82) {
					boolean hitCon;
					int poh = rndm.nextInt(3);  //50% to hit slow fastba;;
					if (poh == 0 || poh == 1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						hcount++;
						inPlay(hitCon);
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();

					}

				}

				else if (83 < pitcher.getMph() && pitcher.getMph() <= 93) {
					int poh = rndm.nextInt(5);	// 30% to hit mid speed fb
					boolean hitCon;
					if (poh == 0 || poh == 1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {

						pitcher.setPnum(5);
						soby();

					}
				}

				else {
					int poh = rndm.nextInt(3); //25% to hit fast fb
					boolean hitCon;
					if (poh == 0) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();
					}
				}
			}

			else if (pitcher.getPnum() == 1) {
				if (pitcher.getMph() <= 72) {
					boolean hitCon;
					int poh = rndm.nextInt(4); //40% to hit slow curve
					if (poh == 0||poh==1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();

					}
				}

				else if (73 < pitcher.getMph() && pitcher.getMph() <= 80) {
					boolean hitCon;
					int poh = rndm.nextInt(3);//25% to hit mid spped curve
					if (poh == 0) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();
					}
				}

				else {
					boolean hitCon;
					int poh = rndm.nextInt(5);
					if (poh == 0) { //16% to hit fast curve
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();
					}
				}
			}

			else {
				if (pitcher.getMph() <= 60) {
					boolean hitCon;
					int poh = rndm.nextInt(5);//33% to hit kb
					if (poh == 0 || poh == 1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();
					}
				}

				else if (61 < pitcher.getMph() && pitcher.getMph() <= 66) {
					boolean hitCon;
					int poh = rndm.nextInt(8);//22% to hit mid kb
					if (poh == 0 || poh==1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();

					}
				}

				else {
					boolean hitCon;
					int poh = rndm.nextInt(12);//15% to hit fast kb
					if (poh == 0 ||poh==1) {
						System.out.println("HIT");
						hitCon=true;
						strikes = 0;
						balls = 0;
						inPlay(hitCon);
						hcount++;
					} else {
						pitcher.setPnum(5);
						hitCon=false;
						soby();

					}
				}
			}

		} else if(yn1==1) {
			soby();
		}
		else{
			soby();
		}
	}

	public void getPitchTime(int tmph){

		if(tmph >=85){
			pt=2;
		}
		else if (tmph >85 && tmph <75){
			pt=3;
			}
		else {
			pt=4;
		}
	}

	public void pitchZone(int pnum){ //pitch is the input of pnum
		String[][] tempzone = {{"| ","  "," |"},{"| ","  "," |"},{"| ","  "," |"}};

		if(pnum==0 || pnum==1 || pnum==2){
			int a=rndm.nextInt(3);
			int b=rndm.nextInt(3);
					if(tempzone[a][b]==tempzone[0][1] || tempzone[a][b]==tempzone[1][1]|| tempzone[a][b]==tempzone[2][1]) {
						String Os="O ";
						tempzone[a][b]= Os;
						System.out.println(a);
						System.out.println(b);
					}
					
					else if (tempzone[a][b]==tempzone[0][0] || tempzone[a][b]==tempzone[1][0]|| tempzone[a][b]==tempzone[2][0]) {
						String Os="|O";
						tempzone[a][b]= Os;
						System.out.println(a);
						System.out.println(b);
				}
					else if(tempzone[a][b]==tempzone[0][2] || tempzone[a][b]==tempzone[1][2]|| tempzone[a][b]==tempzone[2][2]) {
						String Os ="O|";
						tempzone[a][b]= Os;
						System.out.println(a);
						System.out.println(b);
					}
			}
			
			


		for(int i=0; i<tempzone.length;i++){
			for(int j=0;j<tempzone[i].length; j++){
				System.out.print(tempzone[i][j]);
				}
				System.out.println();
			}
				System.out.println();
	}


	public void inPlay(boolean hitcon){
		// 1=base occupied 0== not ..
		boolean inp=hitcon;
		if(inp==true){
			
			int roll = rndm.nextInt(9);
			if(roll==0){
				System.out.println("Homerun!!!");
				hrunCount++;
				runcount++;
				
			}

			if(roll==1||roll==2||roll==3||roll==4||roll==5)
			{
				System.out.println("Single");
				sinCount++;
				fbase=1; 
				// fo=true;
			}

			if(roll==6||roll==7||roll==8){
				System.out.println("Double");
				doubCount++;
				sbase=2;
				// so=true;

			}

			if(roll==9){
				System.out.println("Triple");
				tripCount++;
				tbase=3;
				// to=true;
				}
		}
			}	

		// void isOccupied(int ruuner){

		// 		if(onbase[runner]==1){
				
				
		// 	}
		// }

		// void stateOfRunners(){
		// 	if(fbase==1){
				
			
			
		// }	

		// public void schedule(TimerTask task, Date time){

		// }

public void run() {
	try {
		while(innings < 6){

			while (outs < 3) {
				System.out.println(pitcher.getName() + ":" + " Choose your pitch");
				System.out.println("Fastball(0) -- Curveball(1) -- Knuckleball(2)");
				int xnum = scna.nextInt();
				if(xnum==256) {
					outs=3;
				}
				ThePitch(xnum);
				System.out.println(batter.getName() + ":" + " Swing(0)  TakePitch(1)");
				getPitchTime(pitcher.getMph());
				for(int i=0;i <pt;i++){
				Thread.sleep(250);
				System.out.println(".");
				Thread.sleep(250);
				if(i+1==pt){
					System.out.println(pitch + " ");
					ot = scna.nextInt();
				
					}
				}
				pitchZone(xnum);
				hom(ot);
				// System.out.println(pitch + " " + pitcher.getMph() + "mph");
				System.out.println("COUNT: " + balls + " " + strikes);
				System.out.println("OUTS: " + outs);
				System.out.println("HITS: " + hcount);
				// System.out.println("ON base" + );

				// print out 2d array based on pitch the array is inisilaized with all o and the pitch is inputted as x 

				// 	zone = new int[rows][columns];
				// System.out.println(Arrays.deepToString(zone));
			}
			innings++;
			System.out.println(batter.getName() +" TOTAL HITS  = " + hcount);
			System.out.println(pitcher.getName()+" TOTAL STRIKEOUTS = " + scount);
			System.out.println(pitcher.getName()+" TOTAL WALKS = " + wcount);
			System.out.print(batter.getName() +" HOMERUNS " + "("+hrunCount+")");
			System.out.print(" Singles " + "("+sinCount+")");
			System.out.print(" Triples " + "("+tripCount+")");
			System.out.print(" Doubles " + "("+doubCount+")");
			player b = batter;
			player p =pitcher;
		}
	}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}