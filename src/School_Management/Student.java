package School_Management;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student {
	private String fullName;
	private String address;
	private String DoB;
	private String gender;
	private float finalGrade;
	static boolean b = true;
	static Scanner scan = new Scanner(System.in);
	
	public Student () {
	}
	public Student (String fullName, String address, String DoB, String gender, float finalGrade) {
		this.fullName = fullName;
		this.address  = address;
		this.DoB	  = DoB;
		this.gender   = gender;
		this.finalGrade = finalGrade;
	}
	
	public void setFullName (String fullName) {
		this.fullName = fullName;
	}
	public String getFullName () {
		return fullName;
	}
	public void setAddress (String address) {
		this.address = address;
	}
	public String getAddress () {
		return address;
	}
	public void setDoB (String DoB) {
		this.DoB = DoB;
	}
	public String getDoB () {
		return DoB;
	}
	public void setGender (String gender) {
		this.gender = gender;
	}
	public String getGender () {
		return gender;
	}
	public void setFinalGrade (float finalGrade) {
		
		this.finalGrade = finalGrade;
	}
	public float getFinalGrade () {
		return finalGrade;
	}
	
	// ===== CREATE METHOD ===== //
	public void enterInformation (Scanner scan) throws Exception {
		
		// Method: enter Student's fullName
		System.out.print("   + Enter fullName: ");
		fullName = scan.nextLine();
		while (fullName.isEmpty() == true) {
			System.out.print("     => FullName cannot be empty. Plz enter FullName: ");
			fullName = scan.nextLine();
		}
		
		// Method: enter Student's address
		System.out.print("   + Enter address: ");
		address = scan.nextLine();
		while (address.isEmpty() == true) {
			System.out.print("     => Address cannot be empty. Plz enter Address: ");
			address = scan.nextLine();
		}
		
		
		// Method: enter Student's DoB
		System.out.print("   + Enter DoB (yyyy/MM/dd): ");
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String d = "";
		do {
			try {
				d = scan.nextLine();
				LocalDate.parse(d, dateformat);
				b = true;
			}
			catch (DateTimeException ex) {
				System.out.print("     => Wrong format input type. Plz enter DoB (yyyy/MM/dd): ");
				b = false;
			}
			if (b) {
				DoB = d.formatted(dateformat);
				b = true;
				break;
			}
		} while (b == false);

		
		// Method: enter Student's gender
		System.out.print("   + Enter gender (Male/ Female): ");
		gender = scan.nextLine().toUpperCase();
		do {
			if (!"MALE".equals(gender) && !"FEMALE".equals(gender)) {
				System.out.print("     => Error format input type. Plz enter gender (Male/ Female): ");
				gender = scan.nextLine().toUpperCase();
			}
			if (gender.isEmpty() == true) {
				System.out.print("     => Gender cannot be empty. Plz enter gender (Male/ Female): ");
				gender = scan.nextLine().toUpperCase();
			}
		}
		while (!"MALE".equals(gender) && !"FEMALE".equals(gender) || gender.isEmpty() == true);
		
		
		// Method: enter Student's finalGrade
		System.out.print("   + Enter FinalGrade (as numberic): ");
		String numberRegex = "^[0-9]*\\.?[0-9]";
        do {
            try {
                String fGrade = scan.nextLine();
                if (fGrade.matches(numberRegex)) {
                    finalGrade = Float.parseFloat(fGrade);
                    b = true;
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("     => Wrong format input type. Plz FinalGrade (as numberic): ");
                b = false;
            }
        } while (b == false);
		
	}
}
