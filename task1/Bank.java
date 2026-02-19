class Bank
{
    public static final int NTEST = 100000;
    private final int[] accounts;
    private long ntransacts = 0;

    public Bank(int n, int initialBalance)
    {
        accounts = new int[n];
        int i;
        for (i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
        ntransacts = 0;
    }

    public void transfer(int from, int to, int amount)
    {
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }

    public synchronized void transfer_syncMethod(int from, int to, int amount)
    {
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }

    public void transfer_syncBlock(int from, int to, int amount)
    {
        synchronized (this)
        {
            accounts[from] -= amount;
            accounts[to] += amount;
            ntransacts++;
            if (ntransacts % NTEST == 0)
                test();
        }
    }

    public synchronized void transfer_wait(int from, int to, int amount)
    {
        while (accounts[from] < amount)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                return;
            }
        }

        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
        notifyAll();
    }

    public void test()
    {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++)
            sum += accounts[i] ;
        System.out.println("Transactions:" + ntransacts
                + " Sum: " + sum);
        for (int i = 0; i < accounts.length; i++)
        {
            System.out.printf("account N%d: %d\n", i, accounts[i]);
        }
        System.out.println('\n');
    }

    public int size()
    {
        return accounts.length;
    }
}