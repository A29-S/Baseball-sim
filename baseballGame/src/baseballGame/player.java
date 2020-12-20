package baseballGame;

import java.util.Scanner;

public class player {
	Scanner scna = new Scanner(System.in);
	String name;
	int pnum;
	String cr;
	int rps;
	int mph;
	static int count = 1;
	static int hcount = 0;
	static int scount = 0;
	static int wcount = 0;

	public player() {
		int z = 1;
		while (z == 1) {
			System.out.println("You will need to enter the name(s) of the player(s)");

			if (count == 1) {
				System.out.println("enter name of the Pitcher ");
				name = scna.next();
				count++;
			} else {
				System.out.println("enter name of the Batter ");
				name = scna.next();
				count++;
			}

			System.out.println("Is this correct?");
			System.out.println(name);
			cr = scna.next();
			if (cr.equals("yes") || cr.equals("y") || cr.equals("YES") || cr.equals("Y") || cr.equals("Yes")) {

				System.out.println("Okay perfect");
				z = 0;
			} else {
				z = 1;
				count--;
			}
		}

	}

	public String getName() {
		return name;
	}

	public int getMph() {

		return mph;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public void setMph(int mph) {
		this.mph = mph;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @Override
	// public String toString() {
	// String fug;
	// if (gen.equals("M") || gen.equals("Male") || gen.equals("m") ||
	// gen.equals("male"))
	// fug = "MALE";
	// else
	// fug = "FEMALE";
	// return name + " is a " + fug;

}
