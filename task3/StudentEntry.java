import java.util.ArrayList;

public class StudentEntry
{
    public String group;
    public String PIB;
    public final ArrayList<Integer> marks;
    private int markSum;

    public StudentEntry(String group, String PIB)
    {
        this.group = group;
        this.PIB = PIB;
        marks = new ArrayList<Integer>();
        markSum = 0;
    }

    public void PrintMarks()
    {
        System.out.println(group + " | " + PIB);

        for (int mark : marks)
            System.out.print(mark + " ");
        System.out.print("\nSum: " + markSum + '\n');
    }

    public boolean AddMark(int mark)
    {
        if (mark <= 0 || mark + markSum > 100)
            return false;

        marks.add(mark);
        markSum += mark;

        return true;
    }

    public boolean RemoveMark(int idx)
    {
        if (idx < 0 || idx >= marks.size())
            return false;

        markSum -= marks.remove(idx);

        return true;
    }

    public synchronized boolean AddMarkSync(int mark)
    {
        if (mark <= 0 || mark + markSum > 100)
            return false;

        marks.add(mark);
        markSum += mark;

        return true;
    }

    public synchronized boolean RemoveMarkSync(int idx)
    {
        if (idx < 0 || idx >= marks.size())
            return false;

        markSum -= marks.remove(idx);

        return true;
    }
}
