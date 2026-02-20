public class SymbolPrinter implements Runnable
{
    private static int symbolCounter = 0;
    private final char symbol;
    private final int order;
    private final static int ROW_SIZE = 10 * 3;
    private final static int N_ROWS = 90;

    public SymbolPrinter(char symbol, int order)
    {
        this.symbol = symbol;
        this.order = order;
    }

    public void print()
    {
        synchronized (SymbolPrinter.class)
        {
            while (symbolCounter % 3 != order)
            {
                try {
                    SymbolPrinter.class.wait();
                } catch (InterruptedException e) { }
            }

            System.out.print(symbol);
            symbolCounter++;

            if (symbolCounter % ROW_SIZE == 0)
                System.out.print('\n');
            SymbolPrinter.class.notifyAll();
        }
    }

    public void run()
    {
        for (int i = 0; i < ROW_SIZE * N_ROWS / 3; i++)
        {
            print();
        }
    }
}
