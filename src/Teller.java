import java.util.ArrayList;
import java.util.Random;

public class Teller extends Thread { 
	private final int TIME=100;
	private TransactionPool transPool;
	private ArrayList<BankAccount> bankAccList;
	private int tellerID;
	private static int counterID;

	public Teller(TransactionPool tp, ArrayList<BankAccount> baList) {
		this.transPool = tp;
		this.bankAccList = baList;
		this.tellerID=counterID++;
	}

	public void run() {
		super.run();
		Random rand = new Random();
		Transact transac;
		BankAccount bankAcc;
		transac = transPool.getTransact();
		while(transac != null) {
			bankAcc = bankAccList.get(transac.getAccountNumber());
			System.out.println("Teller: " + this.tellerID + "\tAccount number: " + bankAcc.getAccountNumber()  + "  \tAdd transact: "+transac.getSum()+ "\tOld balance: " + bankAcc.getBalance());
			bankAcc.transaction(transac.getSum());
			System.out.println("   Teller: " + this.tellerID + "\tAccount number: " + bankAcc.getAccountNumber()  + "  \tAdd transact: "+transac.getSum()+ "\tNew balance: " + bankAcc.getBalance());
			transac = transPool.getTransact();
		}
		try {
			sleep(rand.nextInt(TIME));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
