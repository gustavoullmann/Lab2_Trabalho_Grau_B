import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisteredUsers extends DoublyLinkedList<User> {

	public RegisteredUsers() {
		super();
	}
	
	public void registeredUsersLogWriter(String nome) {
		
		try {		
			
			File registeredUsersList = new File("registeredUsersList");
			
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("registeredUsersList", true));
			fileWriter.write(nome);
			fileWriter.newLine();
			fileWriter.flush();
			fileWriter.close();
						
		} 
		catch (FileNotFoundException e) {
			System.out.println("O arquivo 'registeredUsersList.txt' não existe!");
		} 
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo 'registeredUsersList.txt'!");
		}
	}
	
	public static User CreateUser() {
						
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\t" + "Opção 1 - Criar um novo usuário" + "\n");
		System.out.print("Digite um nome de usuário: ");
	
		String name = input.nextLine();
		User newUser = new User(name);
		input.close();
		
		System.out.println("\n\t" + "O usuário " + name + " foi cadastrado com sucesso!" + "\n");
		Menu.menu();
		
		return newUser;
	}
}
