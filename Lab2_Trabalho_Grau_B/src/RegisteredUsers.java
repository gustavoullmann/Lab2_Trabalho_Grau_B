import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisteredUsers extends DoublyLinkedList<User> {

	public RegisteredUsers() {
		super();
	}
	
	public void registeredUsersLogWriter() {
		
		try {
			DNode<User> current = head;			
			while(current != null) {
				String nome = current.getElement().getName();
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter("registeredUsersList", true));
				fileWriter.write(nome);
				fileWriter.newLine();
				fileWriter.flush();
				fileWriter.close();
				current = current.getNext();
			}				
		} 
		catch (FileNotFoundException e) {
			System.out.println("O arquivo 'registeredUsersList.txt' não existe!");
		} 
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo 'registeredUsersList.txt'!");
		}
	}
	
	public static void CreateUser() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\t" + "Opção 1 - Criar um novo usuário" + "\n");
		System.out.print("Digite um nome de usuário: ");
	
		String name = input.nextLine();
		User newUser = new User(name);
		
		
		
		System.out.println("O usuário " + name + " foi cadastrado com sucesso!");
		Menu.menu();
	}
}
