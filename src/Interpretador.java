import java.util.ArrayList;

public class Interpretador {

	public static void main(String[] args) {

		ArrayList<String> inputDataMemory = new ArrayList<String>();

		try {
			inputDataMemory.add("20 3 4 5 *");
			inputDataMemory.add("2 5 1 7 +");
			inputDataMemory.add("9 5 2 3 -");
			inputDataMemory.add("20 8 2 /");
			inputDataMemory.add("17 5 2 ");

			ArrayList<String> chars = new ArrayList<String>();

			for (String s : inputDataMemory) {

				chars = separate_data(s);

				Instruction instruction = getInstructionType(chars.get(chars.size() - 1));
				int result = Integer.parseInt(chars.get(0));

				switch (instruction) {
				case SUM:
					for(int i = 1; i < chars.size()-1; i++)
						result +=  Integer.parseInt(chars.get(i));
					break;
				case SUB:
					for(int i = 1; i < chars.size()-1; i++)
						result -=  Integer.parseInt(chars.get(i));
					break;
				case MULT:
					for(int i = 1; i < chars.size()-1; i++)
						result *=  Integer.parseInt(chars.get(i));
					break;
				case DIV:
					for(int i = 1; i < chars.size()-1; i++){
						int aux = Integer.parseInt(chars.get(i));
						result /=  aux;
					}
					break;
				default:
					break;
				}
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<String> separate_data(String s) {

		ArrayList<String> numbers = new ArrayList<String>();
		int i = 0;
		int j = s.indexOf(" ");

		while (true) {
			numbers.add(s.substring(i, j));
			s = s.substring(j + 1);
			j = s.indexOf(" ");

			if (j == -1) {
				numbers.add(s);
				break;
			}
		}
		return numbers;
	}

	private static Instruction getInstructionType(String operation) {

		switch (operation) {
		case "+":
			return Instruction.SUM;
		case "-":
			return Instruction.SUB;
		case "*":
			return Instruction.MULT;
		case "/":
			return Instruction.DIV;
		default:
			return Instruction.NONE;
		}
	}

	public enum Instruction {

		SUM("+"), SUB("-"), MULT("*"), DIV("/"), NONE(" ");

		private Instruction(String operation) {}
	}
}
