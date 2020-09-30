package TestingTool;

public class Analyzer {
	public static boolean isCommentLine(String line) {
		if (line.trim().length() < 2) {
			return false;
		}

		if (line.trim().substring(0, 2) == "//" || line.trim().contains("//")) {
			return true;
		}

		return false;
	}

	public static int getTotalLines(String sourceCode) {
		return sourceCode.split("\n").length;
	}

	public static int getTotalCodeLines(String sourceCode) {
		int count = 0;
		String sourceSplitted[] = sourceCode.split("\n");
		boolean openComment = false;

		for (int i = 0; i < sourceSplitted.length; ++i) {
			String line = sourceSplitted[i].trim();

			if (line.startsWith("/*") && !line.contains("*/")) {
				openComment = true;
			}

			if (line.contains("*/")) {
				openComment = false;
			}

			if (line.length() != 0 && !line.startsWith("//") && !openComment) {
				count++;
			}
//			if (line.trim().length() != 0 && !isCommentLine(line)) {
//				count++;
//			}
		}
		return count;
	}

	public static int getTotalCommentLines(String sourceCode) {
		int count = 0;
		String sourceSplitted[] = sourceCode.split("\n");

		boolean openComment = false;

		for (int i = 0; i < sourceSplitted.length; ++i) {

			String line = sourceSplitted[i].trim();
			if (openComment) {
				count++;
				if (line.matches("^.*\\*/.*$")) {
					openComment = false;

				}
			} else {

				if (line.startsWith("//")) {
					count++;
				} else if (line.matches("^[^/]*/\\*.*$")) {

					if (!line.matches("^.*\\*/.*$")) {
						openComment = true;
					}
					count++;

				} else if (line.matches("^[^'\"]*//[^'\"]*$")) {
					count++;
				}

			}

/*			if (isCommentLine(line)) {
				count++;
			}*/
		}
		return count;
	}

	public static int getCyclesComplexity(String sourceCode) {
		return 0;
	}
}
