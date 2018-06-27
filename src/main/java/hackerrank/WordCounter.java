package hackerrank;

public class WordCounter {
	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		String s = scan.nextLine();
		//String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
		String s = ",_! ! _@?'  !?_,'! '_'_@.... ''?. ?_ !?. ..!'!?@,?@',?_@'!, !!?_,@?,'@@',, !.? @@@@!!?' _, @???_,@ !_";
		s = s.replaceAll("[^a-zA-Z\\s]", " ");
		s = s.replaceAll("\\s+", " ");
		s = s.replaceAll("(^\\s)|(\\s$)", "");
		if (s.length() == 0) {
			System.out.println(0);
		} else {
			String[] words = s.split(" ");
			System.out.println(words.length);
			for(int i = 0; i < words.length; i++) {
				System.out.println("---" + words[i] + "---");
			}
		}
//		scan.close();
	}
}
