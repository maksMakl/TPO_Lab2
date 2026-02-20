public class Program
{
    public static void main(String[] args)
    {
        (new Thread(new SymbolPrinter('|', 0))).start();
        (new Thread(new SymbolPrinter('\\', 1))).start();
        (new Thread(new SymbolPrinter('/', 2))).start();

//        (new Thread(new SymbolPrinterUnsafe('|'))).start();
//        (new Thread(new SymbolPrinterUnsafe('\\'))).start();
//        (new Thread(new SymbolPrinterUnsafe('/'))).start();
    }
}
