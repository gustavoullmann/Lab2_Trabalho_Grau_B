
import java.util.Scanner;

public class Menu {
			
	public static void menu() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Escolha uma opção no menu abaixo: " + "\n");
		
		System.out.println("\t" + "1 - Criar um novo usuário");
		System.out.println("\t" + "2 - Para incluir uma tarefa");
		System.out.println("\t" + "0 - Para encerrar o programa");

		System.out.print("\n" + "Digite a opção desejada: ");
		
		try {
			int option = Integer.parseInt(input.nextLine());
			
			switch (option) {
		
			case 1:
				
				RegisteredUsers usuariosRegistrados = new RegisteredUsers();
				User newUser = RegisteredUsers.CreateUser();
				usuariosRegistrados.insertLast(newUser);
				usuariosRegistrados.registeredUsersLogWriter(newUser.getName());
			
			case 2:
				
				CreateNewTask.CreateTask();
								
			case 0:
				System.out.println("O programa foi encerrado!");
				
				System.exit(0);
				
			default:
				System.out.println("\n" + "ATENÇÃO: O número digitado não consta no menu!" + "\n");
				menu();
			}
		} 
		catch (NumberFormatException e) {
			System.out.println("\n" + "ATENÇÃO: Digite apenas números!" + "\n");
			menu();
		}
		input.close();
	}
}


