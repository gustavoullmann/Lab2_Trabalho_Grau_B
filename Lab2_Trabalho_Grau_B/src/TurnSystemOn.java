import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TurnSystemOn {
		
	public static void getRegisteredUsersList() {
		
		try {
			Scanner fileReader = new Scanner(new BufferedReader(new FileReader("registeredUsersList")));
			
			while(fileReader.hasNextLine()) {				//TODO falta carregar as linhas lidas como usuários
				String line = fileReader.nextLine();
				System.out.println(line);	
			}
			fileReader.close();
			System.out.println();
			Menu.menu();
			
		} catch (FileNotFoundException e) {
			System.out.println("ATENÇÃO: O arquivo 'registeredUsersList.txt' não existe!");
			System.out.println("É necessário cadastrar um usuário para começar!");
			RegisteredUsers.CreateUser();
		}
	}
}

