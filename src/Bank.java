import java.util.ArrayList;
import java.util.Random;

public class Bank {
	static final int NUM_OF_ACCOUNTS = 5;
	static final int NUM_OF_TRANSACTION = 20;
	static final int MAX_DEPOSITS_WITHDRAWAL = 2000;
	static final int NUM_OF_TELLER = 10;


	public static void main(String[] args) {
		ArrayList<BankAccount> bankAccList = new ArrayList<BankAccount>();
		TransactionPool transaction = new TransactionPool();
		Random rand = new Random();
		Teller teller[] = new Teller[NUM_OF_TELLER];

		for(int i=0; i<NUM_OF_ACCOUNTS; i++) {
			bankAccList.add(new BankAccount(i));
		}

		for(int i=0; i<NUM_OF_TRANSACTION;i++) {
			transaction.addTransact(rand.nextInt(NUM_OF_ACCOUNTS), rand.nextInt(MAX_DEPOSITS_WITHDRAWAL)-1000);
		}

		transaction.print();

		for(int i=0; i<NUM_OF_TELLER; i++) {
			teller[i] = new Teller(transaction, bankAccList);
		}

		for(int i=NUM_OF_TELLER-1; i>=0; i--) {
			teller[i].start();
		}
		
		for(int i=NUM_OF_TELLER-1; i>=0; i--) {
			try {
				teller[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nDone");
	}
}
