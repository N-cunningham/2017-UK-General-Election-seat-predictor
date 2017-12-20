package UK;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Nation scotland = new Nation("Scotland");// Make sure same spelling a
													// CSV file
		ArrayList<Double> newScottishVote = new ArrayList<Double>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter Scottish vote");

		Party ScotCon = new Party("Conservatives", 0, 0, 0, 28.6, Nation.ConservateCSVColumn);
		scotland.parties.add(ScotCon);
		Party ScotLab = new Party("Labour", 0, 0, 0, 27.1, Nation.LabourCSVColumn);
		scotland.parties.add(ScotLab);
		Party ScotLD = new Party("Lib Dems", 0, 0, 0, 6.8, Nation.LibDemCSVColumn);
		scotland.parties.add(ScotLD);
		Party SNP = new Party("SNP", 0, 0, 0, 36.9, Nation.SNPCSVColumn);
		scotland.parties.add(SNP);

		for (int i = 0; i < scotland.parties.size(); i++) {

			System.out.println(scotland.parties.get(i).getName() + ": ");
			newScottishVote.add(scan.nextDouble());

		}
		
	

		Nation england = new Nation("England");// Make sure same spelling as in CSV
		
		ArrayList<Double> newEnglishVote = new ArrayList<Double>();
		//Scanner scan2 = new Scanner(System.in);
		System.out.println("Please enter English vote");

		Party EngCon = new Party("Conservatives", 0, 0, 0, 45.4, Nation.ConservateCSVColumn);
		england.parties.add(EngCon);
		Party EngLab = new Party("Labour", 0, 0, 0, 41.9, Nation.LabourCSVColumn);
		england.parties.add(EngLab);
		Party EngLD = new Party("Lib Dems", 0, 0, 0, 7.8, Nation.LibDemCSVColumn);
		england.parties.add(EngLD);
		Party EngUKIP = new Party("UKIP", 0, 0, 0, 2.1, Nation.UKIPCSVColumn);
		england.parties.add(EngUKIP);
		Party EngGreen = new Party("Green", 0, 0, 0, 1.9, Nation.GreenCSVColumn);
		england.parties.add(EngGreen);

		for (int i = 0; i < england.parties.size(); i++) {

			System.out.println(england.parties.get(i).getName() + ": ");
			newEnglishVote.add(scan.nextDouble());

		}
		
		scan.close();

		scotland.setNewNationalVote(newScottishVote);
		scotland.calculate();
		scotland.printResults();
		
		england.setNewNationalVote(newEnglishVote);
		england.calculate();
		england.printResults();
		
		
		// scotland.printConstituencyResults();

	}

}
