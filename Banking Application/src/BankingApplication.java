import java.util.Scanner;

public class BankingApplication {

	public static void main ( String args[] ) {
		BankAccount obj1 = new BankAccount("Adam Carter", "8697 5856");
		obj1.showMenu();
	}	
}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}
	
	void deposit( int amount ) {
		if( amount != 0 ) {
			balance = balance + amount;
			previousTransaction = -amount;
		}
	}
	
	void withdraw( int amount ) {
		if( amount != 0 ) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if( previousTransaction > 0 ) {
			System.out.println("Deposited: " + previousTransaction);
		} else if( previousTransaction < 0 ) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No Transaction Occured");
		}
	}
	
	void showMenu() {
		
		char option = '\0';
		Scanner scanner = null;
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		try {
		    scanner = new Scanner(System.in);
			do {
				System.out.println("==========================");
				System.out.println("Enter an option");
				System.out.println("==========================");
				option = scanner.next().charAt(0);
				System.out.println("\n");
				
				switch(option) {
					case 'A':
						System.out.println("__________________________");	
						System.out.println("Balance " + balance);	
						System.out.println("__________________________");	
						System.out.println("\n");
						break;
					
					case 'B':
						System.out.println("__________________________");
						System.out.println("Enter an amount to deposit:");
						System.out.println("__________________________");
						int amount = scanner.nextInt();
						deposit(amount);
						System.out.println("\n");
						break;
					
					case 'C':
						System.out.println("__________________________");
						System.out.println("Enter an amount to withdraw:");
						System.out.println("__________________________");
						int amount2 = scanner.nextInt();
						withdraw(amount2);
						System.out.println("\n");
						break;
						
					case 'D':
						System.out.println("__________________________");
						System.out.println("Previous Transaction:");
						System.out.println("__________________________");
						getPreviousTransaction();
						System.out.println("\n");
						break;
						
					case 'E':
						System.out.println("**************************");
						break;
						
					default:
						System.out.println("Invalid Option!! Please enter again");
						break;	
				}				
			} while( option != 'E');
		}
		finally {
		    if(scanner!=null)
		        scanner.close();
		}
		
		System.out.println("Thank you for using our service");
		
	}
}