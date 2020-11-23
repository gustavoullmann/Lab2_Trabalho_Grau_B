import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewTask {

	public static void CreateTask() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\t" + "Opção 2 - Criar tarefa" + "\n");
		
		LocalDate scheduledDateToAccomplish = null;
		String taskDescription = "";
		Integer year = null;
		Integer month = null;
		Integer day = null;
		
		try {
			System.out.print("Digite o ano: ");
			year = Integer.parseInt(input.nextLine());
							
			System.out.print("Digite o mês: ");
			month = Integer.parseInt(input.nextLine());
			
			System.out.print("Digite o dia: ");
			day = Integer.parseInt(input.nextLine());
			
			scheduledDateToAccomplish = LocalDate.of(year, month, day);
			if(scheduledDateToAccomplish.isBefore(LocalDate.now()) == true) {
				System.out.println("\n\t" + "Não é possível definir uma data anterior a atual!" + "\n");
				Menu.menu();
			}				
		} catch (NumberFormatException e) {
			System.out.println("\n" + "ATENÇÃO: Digite apenas números!" + "\n");
			Menu.menu();
		}
		
		System.out.print("Digite a descrição da tarefa: ");
		taskDescription = input.nextLine();
		
		System.out.print("\n" + "Escolha a prioridade da tarefa "
				+ "\n\n\t" + "1 - Alta prioridade"
				+ "\n\t" + "2 - Média prioridade"
				+ "\n\t" + "3 - Baixa prioridade"
				+ "\n\n" + "Qual a sua opção? ");				
		int taskPriority = Integer.parseInt(input.nextLine());
		
		switch (taskPriority) {
	
		case 1:
			Task newTaskHigh = new TaskHigh(year,month,day,taskDescription);
			System.out.println("\n\t" + "A tarefa de alta prioridade: " + newTaskHigh.getTaskDescription());
			System.out.println("\t" + "Foi definida para o dia: " + newTaskHigh.getScheduledDateToAccomplish() + "\n");
			Menu.menu();
			break;
			
		case 2:
			Task newTaskMedium = new TaskMedium(year,month,day,taskDescription);
			System.out.println("\n\t" + "A tarefa de média prioridade: " + newTaskMedium.getTaskDescription());
			System.out.println("\t" + "Foi definida para o dia: " + newTaskMedium.getScheduledDateToAccomplish() + "\n");
			Menu.menu();
			break;
		
		case 3:
			Task newTaskLow = new TaskLow(year,month,day,taskDescription);
			System.out.println("\n\t" + "A tarefa de baixa prioridade: " + newTaskLow.getTaskDescription());
			System.out.println("\t" + "Foi definida para o dia: " + newTaskLow.getScheduledDateToAccomplish() + "\n");
			Menu.menu();
			break;
		default:
			System.out.println("\n" + "ATENÇÃO: O número digitado não consta no menu!" + "\n");
			Menu.menu();
		}
		input.close();
	}	
}
