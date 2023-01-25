
public class Transact {
	private int accountNumber;
	private int sum;

	public Transact(int aN, int val) {
		this.accountNumber=aN;
		this.sum=val;
	}

	public int getSum() {
		return sum;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
}
