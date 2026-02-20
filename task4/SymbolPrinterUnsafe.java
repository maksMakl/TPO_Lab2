public class SymbolPrinterUnsafe implements Runnable
{
    private static int symbolCounter = 0;
    private final char symbol;
    private final static int ROW_SIZE = 10 * 3;
    private final static int N_ROWS = 90;

    public SymbolPrinterUnsafe(char symbol, int order)
    {
        this.symbol = symbol;
    }

    public void print()
    {
        System.out.print(symbol);
        symbolCounter++;
        if (symbolCounter % ROW_SIZE == 0)
            System.out.print('\n');
    }

    public void run()
    {
        for (int i = 0; i < ROW_SIZE * N_ROWS / 3; i++)
        {
            print();
        }
    }
}
