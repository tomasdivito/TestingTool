package TestingTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

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

			/*
			 * if (isCommentLine(line)) { count++; }
			 */
		}
		return count;
	}

	public static int getCyclesComplexity(String sourceCode) {
		return 0;
	}

	public static double[] calculateHalstead(String sourceCode, List<String> list) {
		double halstead[] = new double[2];
		int cantidadOperadoresTotales = 0;
		int cantidadOperandosTotales = 0;
		int cantidadOperadoresUnicos = 0;
		int cantidadOperandosUnicos = 0;
		String textoSinComentarios = obtenerTextoSinComentarios(sourceCode);
		// var operadores = ["+", "-", "/", "*", "int", "double", "float", ";", ":",
		// "public", "static", "void", "&&", "||", "<=", ">=", "<", ">"];
		ArrayList<String> operandosUnicos = new ArrayList<String>();
		// OPERADORES UNICOS Y TOTALES.
		for (int i = 0; i < list.size(); i++) {
			String operador = list.get(i).trim();
			int cantDeApariciones = StringUtils.countMatches(textoSinComentarios, operador);
			if (cantDeApariciones > 0) {
				cantidadOperadoresUnicos++;
				cantidadOperadoresTotales += cantDeApariciones;
			}
		}

		// OPERADORES TOTALES

		// OPERANDOS UNICOS Y TOTALES.
		String[] aAnalizar = textoSinComentarios.split(" ");
		
		int hasta = aAnalizar.length;
		for (int j = 0; j < hasta; j++) {
			// Si no es un operador y todavia no esta en el array de operandos unicos.
			if (!list.contains(aAnalizar[j])) {
				if (!operandosUnicos.contains(aAnalizar[j])) {
					operandosUnicos.add(aAnalizar[j]);
					cantidadOperandosUnicos++;
				}
				cantidadOperandosTotales++;
			}
		}
		double longitudHalstead = (cantidadOperadoresUnicos * log2(cantidadOperadoresUnicos)
				+ cantidadOperandosUnicos * log2(cantidadOperandosUnicos));
		double volumenHalstead = ((cantidadOperadoresTotales + cantidadOperandosTotales)
				* log2(cantidadOperadoresUnicos + cantidadOperandosUnicos));
		halstead[0] = longitudHalstead;
		halstead[1] = volumenHalstead;
		
		return halstead;
	}

	public static double log2(int N) {
		double result = (Math.log(N) / Math.log(2));
		return result;
	}

	public static String obtenerTextoSinComentarios(String codigo) {
		return StringUtils.normalizeSpace(codigo).replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
	}
	
	public static int complejidadCiclomatica(String sourceCode){
		int c = 0;
		String texto= obtenerTextoSinComentarios(sourceCode);
		c+=texto.split("if").length - 1;
		c+=texto.split("else").length - 1;
		c+=texto.split("for").length - 1;
		c+=texto.split("while").length - 1;
		c+=texto.split("\\|\\|").length - 1;
		c+=texto.split("&&").length - 1;
		return c+1;
	}
}
