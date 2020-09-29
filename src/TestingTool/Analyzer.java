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
		for (int i = 0; i < sourceSplitted.length; ++i) {
			String line = sourceSplitted[i];
			if (line.trim().length() != 0 && !isCommentLine(line)) {
				count++;
			}
		}
		return count;
	}
	
	public static int getTotalCommentLines(String sourceCode) {
		int count = 0;
		String sourceSplitted[] = sourceCode.split("\n");
		for (int i = 0; i < sourceSplitted.length; ++i) {
			String line = sourceSplitted[i];
			if (isCommentLine(line)) {
				count++;
			}
		}
		return count;
	}
	
	public static int getCyclesComplexity(String sourceCode) {
		return 0;
	}
}
