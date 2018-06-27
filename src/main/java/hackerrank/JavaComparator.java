package hackerrank;

import java.util.Arrays;
import java.util.Comparator;

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		if (p2.score > p1.score) return 1;
		if (p2.score < p1.score) return -1;
		int nameCompared = p1.name.compareTo(p2.name);
		return nameCompared > 0 ? 1 : (nameCompared < 0 ? -1 : 0 );
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class JavaComparator {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();

		String[][] players = new String[][] {
			{"amy", "100"},
			{"david", "100"},
			{"heraldo", "50"},
			{"aakansha", "75"},
			{"aleksa", "150"}
		};
		Player[] player = new Player[players.length];
		Checker checker = new Checker();

		for (int i = 0; i < players.length; i++) {
			player[i] = new Player(players[i][0], Integer.parseInt(players[i][1]));
		}
//		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}
