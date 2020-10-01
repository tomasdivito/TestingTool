package TestingTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public static float[] calculateHalstead(String sourceCode,List<String> list) {
		float halstead[] = new float[2];
		int cantidadOperadoresTotales = 0;
		int cantidadOperandosTotales = 0;
		int cantidadOperadoresUnicos = 0;
		int cantidadOperandosUnicos = 0;
		String textoSinComentarios= obtenerTextoSinComentarios(sourceCode);
		//var operadores = ["+", "-", "/", "*", "int", "double", "float", ";", ":", "public", "static", "void", "&&", "||", "<=", ">=", "<", ">"];
		ArrayList<String> operandosUnicos = new ArrayList<String>();
		//OPERADORES UNICOS Y TOTALES.
		for (int i = 0; i < list.size(); i++) 
		{
			if(textoSinComentarios.indexOf(list.get(i)) !=-1)
				cantidadOperadoresUnicos++;
			String o = list.get(i).trim();
			System.out.println(o);
			String [] split = textoSinComentarios.trim().split("\\"+o);
			System.out.println(Arrays.toString(split));
			cantidadOperadoresTotales += split.length -1;
			//cantidadOperadoresTotales += sourceCode.split(list.get(i)).length-1;
		}

		//OPERADORES TOTALES
		
		//OPERANDOS UNICOS Y TOTALES.
		String[] aAnalizar = textoSinComentarios.split(" ");
		int hasta = textoSinComentarios.split(" ").length;
		for (int j = 0; j < hasta; j++) 
		{
			//Si no es un operador y todavia no esta en el array de operandos unicos.
			if(list.indexOf(aAnalizar[j]) == -1 && operandosUnicos.indexOf(aAnalizar[j]) == -1)
			{
				operandosUnicos.add(aAnalizar[j]);
				cantidadOperandosUnicos++;
			}
			//Si no es un operador.
			if(list.indexOf(aAnalizar[j]) == -1)
				cantidadOperandosTotales++;
		}
		int longitudHalstead = (cantidadOperadoresUnicos*log2(cantidadOperadoresUnicos)+cantidadOperandosUnicos*log2(cantidadOperandosUnicos));
		float volumenHalstead  = ((cantidadOperadoresTotales+cantidadOperandosTotales)*log2(cantidadOperadoresUnicos+cantidadOperandosUnicos));
		halstead[0]=longitudHalstead;
		halstead[1]=volumenHalstead;
		System.out.println(halstead[0]+" "+halstead[1]);
		return halstead;
	}
	
	// Function to calculate the
    // log base 2 of an integer
    public static int log2(int N)
    {
        int result = (int)(Math.log(N) / Math.log(2));
        return result;
    }
	
	public static String obtenerTextoSinComentarios(String codigo) {
		return codigo.replace("(/\\*([\\s\\S]*?)\\*/)|(//(.*)$)", "");
	}
}
