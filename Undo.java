package singleton;

import java.util.Scanner;
import java.util.ArrayList;

public class Undo {
	
	Scanner sc = new Scanner(System.in);
	
	private static Undo instance;
	//En el ArrayList history se guardará el historial de acciones ejecutadas.
	private static ArrayList<String> history;
	//En el ArrayList undone se guardará el historial de acciones deshechas.
	private static ArrayList<String> undone;
	
	private Undo() {}
	
	public static Undo getInstance() {
		if(instance == null ) {
			instance = new Undo();
			history = new ArrayList<String>();
			undone = new ArrayList<String>();
		}
		return instance;
	}
	
	public void addToHistory(String action) {
		//Añade una acción al historial de acciones ejecutadas y borra el historial
		//de acciones deshechas.
		Undo.history.add(action);
		Undo.undone.clear();
		System.out.println("\""+action+"\" executed.");
		System.out.println("history: " + Undo.history);
		System.out.println("undone: " + Undo.undone);
	}
	
	public void undo() {
		//Si history no está vacío, añade el último elemento de history a undone y lo elimina
		//de history
		if (Undo.history.isEmpty()) {
			System.out.println("There is no action to undo.");
		} else {
			Undo.undone.add(Undo.history.get(Undo.history.size() - 1));
			Undo.history.remove(Undo.history.size() - 1);
			System.out.println("\"" + Undo.undone.get(Undo.undone.size() - 1) + "\" undone.");
		}
		System.out.println("history: " + Undo.history);
		System.out.println("undone: " + Undo.undone);
	}
	
	public void redo() {
		//Si undone no está vacío, añade el primer elemento de undone a history y lo elimina
		//de undone
		if(Undo.undone.isEmpty()) {
			System.out.println("There is no undone action that can be redone.");
		} else {
			Undo.history.add(Undo.undone.get(Undo.undone.size()-1));
			Undo.undone.remove(Undo.undone.size()-1);
			System.out.println("\"" + Undo.history.get(Undo.history.size() - 1) + "\" redone.");
		}
		System.out.println("history: " + Undo.history);
		System.out.println("undone: " + Undo.undone);
	}
	
	public void showHistory() {
		System.out.println("Choose action:\nPress A to see all history.\nPress any key to choose"
				+ " the number of actions to be shown.");
		String option = sc.nextLine();
		printHistory(option);
	}
	
	public void printHistory(String option) {
		if (option.equalsIgnoreCase("A")) {
			System.out.println("See below the history of actions from most recent to oldest:");
			for(int i = Undo.history.size() - 1; i >= 0; i--) {
				System.out.println(Undo.history.get(i));
			}
		} else {
			System.out.println("Enter number of actions to be shown");
			int numberOfActions = sc.nextInt();
			System.out.println("See below the most recent " + numberOfActions + " actions.");
			for(int i = Undo.history.size() - 1; i >= Undo.history.size() - numberOfActions; i--) {
				System.out.println(Undo.history.get(i));
			}
		}
		System.out.println("Choose option:");
	}

}
