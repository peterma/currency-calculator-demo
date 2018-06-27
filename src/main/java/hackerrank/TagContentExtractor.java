package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
	public static void main(String[] args) {
		// String regex = "<([A-Za-z0-9!\"#$%&'()*+,.\\/:;<=>?@\\[\\] ^_`{|}~-]+)>(^(<([A-Za-z0-9!\"#$%&'()*+,.\\/:;<=>?@\\[\\]
		// ^_`{|}~-]+)>))*<\\/\\1>";
		String regex = "<([\\S\\s]+)>([\\S\\s]*)<\\/\\1>";
		Pattern pattern = Pattern.compile(regex);
		String[] testCases = new String[] { "<h1>Nayeem loves counseling</h1>",
				"<h1><h1>Sanjay has no watch</h1>invalid<h2>WTF</h2>INVALID</h1><par>So wait for a while</par>",
				"<Amee>safat codes like a ninja</amee>", "<SA premium>Imtiaz has a secret crush</SA premium>",
				"qqoNVOmJDG@6IBDZoEmk9337LswEL&TQnLCuR`04XD%1t{G)Jmi_iNEXKwp&<iBKMbDGtF4v@coLsF1_LqgTJ3cSp& 3a~I&Q(j0h_w~Vk(oBZCL#vhYY9%c><wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>haZQKlWPxlRqXXkKHo=FDofc6$_S-GWA&m0zT*D~uorf_nAF^ym*U&6hGAI)s<XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><FbTSC#F104{py9Xl6s{yi-R~}k5Fv4i1kCgmBY7P=vVj-j48xUg8x9BCxl~Y><lyxRRMqnMBGj1_d7Qqh5Ebn7 aMb{Q0Dm){9~I0DTS8BZ7+bui~)rQ\"2Yb4f>EeZWvJvHIk</XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><BkkZV631Pnj}#%TWhZn@Y><kXjDpTvLA^tnXYb`h+cA J2" };
		int testCaseNo = testCases.length;
		while (testCaseNo-- > 0) {
			String line = testCases[testCaseNo];
			Matcher matches = pattern.matcher(line);
			boolean found = false;
			while (matches.find()) {
				found = true;
				System.out.println(matches.group(2));
			}

			if (!found) {
				System.out.println("None");
			}
		}
		// Scanner in = new Scanner(System.in);
		// int testCases = Integer.parseInt(in.nextLine());
		// while (testCases > 0) {
		// String line = in.nextLine();

		// Write your code here

		// testCases--;
		// }
	}
}
