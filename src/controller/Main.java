package controller;

import model.*;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {

			String inp;

			Scanner input = new Scanner(System.in);

			
			Net net = new Net("src/model/TrainingData/WallOfText.txt");

			while (true) {
				System.out.println("\nEnter Input:");
				inp = input.nextLine();
				if (!inp.equals("exit")) {
					net.check(inp);
				} else {
					System.out.println("Quitting...");
					System.exit(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

}
