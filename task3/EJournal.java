public class EJournal
{
    private final StudentEntry[] students;

    public EJournal(StudentEntry[] students)
    {
        this.students = students;
    }

    public boolean AddMark(int studentID, int mark)
    {
        if (studentID < 0 || studentID >= students.length)
            return false;

        return students[studentID].AddMark(mark);
    }

    public boolean RemoveMark(int studentID, int markIdx)
    {
        if (studentID < 0 || studentID >= students.length)
            return false;

        return students[studentID].RemoveMark(markIdx);
    }

    public boolean AddMarkSync(int studentID, int mark)
    {
        if (studentID < 0 || studentID >= students.length)
            return false;

        return students[studentID].AddMarkSync(mark);
    }

    public boolean RemoveMarkSync(int studentID, int markIdx)
    {
        if (studentID < 0 || studentID >= students.length)
            return false;

        return students[studentID].RemoveMarkSync(markIdx);
    }

    public void PrintMarks(int studentID)
    {
        if (studentID < 0 || studentID >= students.length)
            return;

        students[studentID].PrintMarks();
    }
}
