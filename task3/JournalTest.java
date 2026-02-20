public class JournalTest
{
    public static void main(String[] args)
            throws InterruptedException
    {
       //UnsafeEJournalTest();
       SafeEJournalTest();
    }

    private static void UnsafeEJournalTest()
            throws InterruptedException
    {
        StudentEntry[] students = new StudentEntry[1];
        students[0] = new StudentEntry("Group A", "John");
        EJournal journal = new EJournal(students);

        int n_threads = 100;
        Thread[] threads = new Thread[n_threads];
        for (int i = 0; i < n_threads; i++)
        {
            threads[i] = new Thread(() -> {
                boolean flag = true;
                while (flag)
                {
                    flag = journal.AddMark(0, 2);
                }
            });
        }

        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads)
            thread.join();
        journal.PrintMarks(0);
    }

    private static void SafeEJournalTest()
            throws InterruptedException
    {
        StudentEntry[] students = new StudentEntry[1];
        students[0] = new StudentEntry("Group A", "John");
        EJournal journal = new EJournal(students);

        int n_threads = 100;
        Thread[] threads = new Thread[n_threads];
        for (int i = 0; i < n_threads; i++)
        {
            threads[i] = new Thread(() -> {
                boolean flag = true;
                while (flag)
                {
                    flag = journal.AddMarkSync(0, 2);
                }
            });
        }

        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads)
            thread.join();
        journal.PrintMarks(0);
    }
}
