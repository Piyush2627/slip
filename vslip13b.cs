using System;

class Student
{
    private int    rollNo;
    private string name;
    private double marks1, marks2, marks3;
    private double percentage;

    public void AcceptDetails()
    {
        Console.Write("  Roll No          : ");
        rollNo = int.Parse(Console.ReadLine());

        Console.Write("  Name             : ");
        name = Console.ReadLine();

        Console.Write("  Marks (Subject 1): ");
        marks1 = double.Parse(Console.ReadLine());

        Console.Write("  Marks (Subject 2): ");
        marks2 = double.Parse(Console.ReadLine());

        Console.Write("  Marks (Subject 3): ");
        marks3 = double.Parse(Console.ReadLine());

        percentage = (marks1 + marks2 + marks3) / 3.0;
    }

    public void DisplayDetails()
    {
        Console.WriteLine("  Roll No    : " + rollNo);
        Console.WriteLine("  Name       : " + name);
        Console.WriteLine("  Subject 1  : " + marks1);
        Console.WriteLine("  Subject 2  : " + marks2);
        Console.WriteLine("  Subject 3  : " + marks3);
        Console.WriteLine("  Percentage : " + percentage.ToString("F2") + "%");
    }
}

class VSlip13B
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of students: ");
        int n = int.Parse(Console.ReadLine());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\n--- Enter details for Student " + (i + 1) + " ---");
            students[i] = new Student();
            students[i].AcceptDetails();
        }

        Console.WriteLine("\n========== Student Details ==========");
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\nStudent " + (i + 1) + ":");
            students[i].DisplayDetails();
            Console.WriteLine("  " + new string('-', 35));
        }

        Console.ReadKey();
    }
}
