package singleton;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {

		int option;
		Undo undo = null;
		String command;

		do {
			
			option = menu1();
			
			switch (option) {
			case 0:
				break;
			case 1:
				while (option != 0) {
					switch (option) {
					case 1:
						undo = Undo.getInstance();
						System.out.println("Type command.");
						command = sc.nextLine();
						undo.addToHistory(command);
						break;
					case 2:
						undo.undo();
						break;
					case 3:
						undo.redo();
						break;
					case 4:
						undo.showHistory();
						break;
					case 0:
						System.out.println("Thank you for using Undo.");
						break;
					default:
						System.out.println("Wrong option, try again.");
						option = -1;
					}
					
					option = menu2();
					
				}
				break;
			default:
				System.out.println("Wrong option, try again.");
			}

		} while (option != 0);

		System.out.println("End of the program.");
		
	}
	
	public static int menu1() {
		System.out.println("Choose option:");
		System.out.println("1 - Execute action.");
		System.out.println("0 - Exit.");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public static int menu2() {
		System.out.println("Choose next step:");
		System.out.println("1 - Execute action.");
		System.out.println("2 - Undo.");
		System.out.println("3 - Redo.");
		System.out.println("4 - Show history.");
		System.out.println("0 - Exit.");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
}
