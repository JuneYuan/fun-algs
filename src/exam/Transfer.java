package exam;

public class Transfer {

	   private final double[] accounts;  // 用户账号数组

	   public Transfer(int n)
	   {
	      accounts = new double[n];
	   }

	   public synchronized void transfer(int from, int to, double amount) throws InterruptedException
	   {
	      while (accounts[from] < amount)
	         wait();
	      System.out.print(Thread.currentThread());
	      accounts[from] -= amount;
	      System.out.printf(" %10.2f from %d to %d", amount, from, to);
	      accounts[to] += amount;
	      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	      notifyAll();
	   }

	   public synchronized double getTotalBalance()
	   {
	      double sum = 0;

	      for (double a : accounts)
	         sum += a;

	      return sum;
	   }

	   public int size()
	   {
	      return accounts.length;
	   }

}
