import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any random paragraph or text:");
		String text = scanner.nextLine();

		if (text.trim().isEmpty()) {
			System.out.println("The input is empty. Please enter some text.");
			return;
		}
		int totalCharacters = text.length();
		System.out.println("\nTotal number of characters: " + totalCharacters);
		String[] words = text.split("\\s+");
		int totalWords = words.length;
		System.out.println("Total number of words: " + totalWords);
		Map<Character, Integer> charFrequency = new HashMap<>();
		for (char ch : text.toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				ch = Character.toLowerCase(ch);
				charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
			}
		}

		char mostCommonChar = Collections.max(charFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println("Most common character: " + mostCommonChar);
		System.out.println("\nEnter a character to check its frequency:");
		char userChar = scanner.next().toLowerCase().charAt(0);

		if (!Character.isLetterOrDigit(userChar)) {
			System.out.println("Please enter a valid alphanumeric character.");
			return;
		}

		int charCount = 0;
		for (char ch : text.toLowerCase().toCharArray()) {
			if (ch == userChar) {
				charCount++;
			}
		}
		System.out.println("The character '" + userChar + "' appears " + charCount + " times in the text.");
		scanner.nextLine();
		System.out.println("Enter a word to check its frequency:");
		String userWord = scanner.nextLine().toLowerCase();

		int wordCount = 0;
		for (String word : words) {
			if (word.equalsIgnoreCase(userWord)) {
				wordCount++;
			}
		}
		System.out.println("The word '" + userWord + "' appears " + wordCount + " times in the text.");
		Set<String> uniqueWords = new HashSet<>();
		for (String word : words) {
			uniqueWords.add(word.toLowerCase());
		}
		System.out.println("Number of unique words: " + uniqueWords.size());

		scanner.close();
	}
}
