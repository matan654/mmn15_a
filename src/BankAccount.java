
public class BankAccount {
	private int accountNumber;
	private int balance;

	public BankAccount(int accNum) {
		this.accountNumber=accNum;
		this.balance=0;
	}

	public synchronized void transaction(int transactionOpreration) {
		while(this.balance + transactionOpreration<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		balance += transactionOpreration;
		notifyAll();
	}

	public synchronized int getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return "Bank account number: " + this.accountNumber + "\tBalance: " + this.balance;
	}
}
