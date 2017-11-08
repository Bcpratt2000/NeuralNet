package controller;

import model.*;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {

			final int ENGLISH = 0;
			final int GERMAN = 1;

			String inp;

			Scanner input = new Scanner(System.in);

			Net[] languages = new Net[] { new Net("src/model/TrainingData/WallOfText.txt"),
					new Net("src/model/TrainingData/German.txt") };

			Net net = new Net();

			while (true) {
				System.out.println("\nEnter Input:");
				inp = input.nextLine();
				if (!inp.equals("exit")) {
					if (languages[ENGLISH].check(inp) < languages[GERMAN].check(inp)) {
						System.out.println("German");
					}
					else {
						System.out.println("English");
					}
				} else {
					System.out.println("Quitting...");
					input.close();
					System.exit(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

}
