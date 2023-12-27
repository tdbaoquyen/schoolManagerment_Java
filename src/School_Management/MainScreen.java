package School_Management;

import java.util.Scanner;
import java.util.ArrayList;

public class MainScreen {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		//	ENTER STUDENT'S INFORMATION
		System.out.println("\n   *** ENTER OF STUDENT's INFORMATION *** \n");

		int qty;
		try {
			System.out.print("* Enter quantity of Students: ");
			qty = Integer.parseInt(scan.nextLine());
			while (qty <= 0){
				System.out.print("     => Quantity of Student cannot be <=0 \n* Enter quantity of Students: ");
				qty = Integer.parseInt(scan.nextLine());
			}
		}		
		catch (NumberFormatException ne) {
			System.out.print("     => Wrong format input type \n* Enter quantity of Students: ");
			qty = Integer.parseInt(scan.nextLine());
		}
		
		ArrayList <Student> arrSV = new ArrayList<>(qty);
		
		System.out.print("\n* Do you want to continue (Y/N): ");
		String answer = scan.nextLine().toUpperCase();
		
		do {
			if (answer.isEmpty() == true) {
				System.out.print("     => Cannot be empty. Plz enter \"Y\" or \"N\": ");
				answer = scan.nextLine().toUpperCase();
			}
			if (answer.equalsIgnoreCase("Y")) {
				
					System.out.println("\n* Enter information of Student: ");
					Student student = new Student();
					student.enterInformation(scan);
					arrSV.add(student);
				
					System.out.print("\n* Do you want to continue (Y/N): ");
					answer = scan.nextLine().toUpperCase();
				
			}
			else if (answer.equalsIgnoreCase("N")) {
				System.out.println("\n  => End of entering Student's information!");
				break;
			}
			else if (!"Y".equalsIgnoreCase(answer) && !"N".equalsIgnoreCase(answer)) {
				System.out.print("     => Error format input type. Plz enter \"Y\" or \"N\": ");
				answer = scan.nextLine().toUpperCase();
			}
		}while (answer.isEmpty() == true || answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N") || 
				!"Y".equalsIgnoreCase(answer) && !"N".equalsIgnoreCase(answer));
		
		
		//	SHOW OUT LIST OF STUDENT's INFORMATION
		System.out.println("\n   *** LIST OF STUDENT's INFORMATION ***");
		for (int i=0; i< arrSV.size(); i++) {
			System.out.println("\n* STUDENT [" +(i+1)+ "]: ");
			System.out.println("     + Student's fullName  : " + arrSV.get(i).getFullName());
			System.out.println("     + Student's address   : " + arrSV.get(i).getAddress());
			System.out.println("     + Student's birthday  : " + arrSV.get(i).getDoB());
			System.out.println("     + Student's gender    : " + arrSV.get(i).getGender());
			System.out.println("     + Student's finalGrade: " + arrSV.get(i).getFinalGrade());
		}
		
		//	SHOW OUT STUDENT'S FINALGRADE
		System.out.println("\n   *** LIST OF STUDENT's FINALGRADE ***");
		for (int i=0; i<arrSV.size(); i++) {
			float grade = arrSV.get(i).getFinalGrade();
			if (grade < 4.0) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực KÉM");
			}
			if (grade >= 4.0 && grade < 5.0) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực YẾU");
			}
			if (grade >= 5.0 && grade < 5.5) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực TRUNG BÌNH YẾU");
			}
			if (grade >= 5.5 && grade < 6.5) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực TRUNG BÌNH");
			}
			if (grade >= 6.5 && grade < 7.0) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực TRUNG BÌNH KHÁ");
			}
			if (grade >= 7.0 && grade < 8.0) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực KHÁ");
			}
			if (grade >= 8.0 && grade < 8.5) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực KHÁ GIỎI");
			}
			if (grade >= 8.5 && grade < 10.0) {
				System.out.println("   Student [" +arrSV.get(i).getFullName()+ "] has finalGrade: " + arrSV.get(i).getFinalGrade()+ " ==> học lực GIỎI");
			}
		}
		
		//	SHOW OUT GRADE POINT AVERAGE OF ALL STUDENTs
		float totalGrade = 0;
		for (int i=0; i<arrSV.size(); i++) {
			totalGrade += arrSV.get(i).getFinalGrade();
		}
		System.out.println("\n   *** GPA OF ALL STUDENTs (TotalFinalGrade / total Students) = " +(totalGrade/arrSV.size())+ " ***");
		
		System.out.println("\n\n ===== FINISH SYSTEM =====");
	}

}
