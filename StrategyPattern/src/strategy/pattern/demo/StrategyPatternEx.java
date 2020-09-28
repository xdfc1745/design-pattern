package strategy.pattern.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import choices.FirstChoice;
import choices.IChoice;
import choices.SecondChoice;
import contextofchoice.Context;

class StrategyPatternEx {
	public static void main(String[] args) throws IOException {
		System.out.println("***Strategy Pattern Demo***\n");
		Scanner in = new Scanner(System.in);
		IChoice ic = null;
		Context cxt = new Context();
		String input1, input2;
		
		try {
			for (int i=1; i<=2; i++) {
				System.out.println("Enter an integer");
				input1 = in.nextLine();
				System.out.println("Enter another integer");
				input2 = in.nextLine();
				System.out.println("Enter ur choice(1 or 2)");
				System.out.println("Press 1 for Addition, 2 for Concatenation");
//				String c= in.nextLine();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String sc = br.readLine();
				if(sc.contentEquals("1")) {
					ic = new FirstChoice();
				}
				else {
					ic = new SecondChoice();
				}
				cxt.SetChoice(ic);
				cxt.ShowCoice(input1, input2);
			}
		}finally {
			in.close();
		}
		System.out.println("End of Strategy Pattern");
	}
}
