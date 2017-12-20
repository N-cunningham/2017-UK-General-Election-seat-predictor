package UK;

import java.util.ArrayList;

public class Constituency {

	private ArrayList<Double> oldVote;
	private ArrayList<Double> newVote;
	private String nation;
	private String name;
	private String winner;
	private static int winnerIndex;

	public Constituency(ArrayList<Double> oldVote, ArrayList<Double> newVote, String nation, String name, String winner,
			int winnerIndex) {

		this.oldVote = oldVote;
		this.newVote = newVote;
		this.nation = nation;
		this.name = name;
		this.winner = winner;
		this.winnerIndex = winnerIndex;

	}

	public ArrayList<Double> getNewVote() {
		return newVote;
	}

	public void setNewVote(ArrayList<Double> newVote) {
		this.newVote = newVote;
	}

	public String toString() {

		String res = "";
		int winningVote = newVote.get(winnerIndex).intValue();

		for (int i = 0; i < newVote.size(); i++) {

			if (newVote.get(i) != newVote.get(winnerIndex)) {

				res = res + "Partie " + i + ": " + newVote.get(i).intValue() + "\t";

			}

		}

		return winner + " won " + name + " with " + winningVote + "\n" + res;

	}
}
