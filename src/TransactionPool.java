import java.util.ArrayList;

public class TransactionPool {
	private  ArrayList<Transact> transPoolArray;

	public TransactionPool() {
		transPoolArray = new ArrayList <Transact>();
	}

	public void addTransact(int accountNumber, int sum) {
		transPoolArray.add(new Transact(accountNumber, sum));
	}


	public  synchronized Transact getTransact() {
		if(transPoolArray.isEmpty())
			return null;
		return transPoolArray.remove(0);
	}

	public void print() {
		for(int i=0;i<transPoolArray.size();i++)
			System.out.println("Account number: " + transPoolArray.get(i).getAccountNumber() + "\tTransact: " + transPoolArray.get(i).getSum());
	}
}
