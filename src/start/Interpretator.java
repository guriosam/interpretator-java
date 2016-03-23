package start;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Interpretator {

	public static void main(String[] args) {

		ArrayList<String> memory = new ArrayList<String>();

		try {
		
			memory.add("20 3 4 5 *");
			memory.add("2 3 4 5 +");
			memory.add("2 3 4 5 -");
			memory.add("20 5 4 /");

			ArrayList<String> chars = new ArrayList<String>();
			ArrayList<Integer> numbers = new ArrayList<Integer>();

			for (String s : memory) {

				chars = separate(s);

				String op = chars.get(chars.size() - 1);
				int result = Integer.parseInt(chars.get(0));

				switch (op) {
				case "*":
					for(int i = 1; i < chars.size()-1; i++){
						result *=  Integer.parseInt(chars.get(i));
					}
					break;
				case "/":
					
					for(int i = 1; i < chars.size()-1; i++){
						int aux = Integer.parseInt(chars.get(i));
						result /=  aux;
					}
					break;
				case "+":
					for(int i = 1; i < chars.size()-1; i++){
						result +=  Integer.parseInt(chars.get(i));
					}
					break;
				case "-":
					for(int i = 1; i < chars.size()-1; i++){
						result -=  Integer.parseInt(chars.get(i));
					}
					break;
				}

				System.out.println(result);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ArrayList<String> separate(String s) {
		ArrayList<String> numbers = new ArrayList<String>();
		int i = 0;
		int j = s.indexOf(" ");

		while (true) {

			numbers.add(s.substring(i, j));
			//System.out.println(s.substring(i, j));

			s = s.substring(j + 1);
			j = s.indexOf(" ");

			if (j == -1) {
				numbers.add(s);
				//System.out.println(s);
				break;
			}
		}
		// TODO Auto-generated method stub
		return numbers;
	}

}
