using System;

// Base class: Person
class Person
{
    protected string name;
    protected int    age;
    protected string address;

    public virtual void AcceptDetails()
    {
        Console.Write("  Name    : ");
        name = Console.ReadLine();
        Console.Write("  Age     : ");
        age = int.Parse(Console.ReadLine());
        Console.Write("  Address : ");
        address = Console.ReadLine();
    }

    public virtual void DisplayDetails()
    {
        Console.WriteLine("  Name       : " + name);
        Console.WriteLine("  Age        : " + age);
        Console.WriteLine("  Address    : " + address);
    }
}

// Derived class: Employee
class Employee : Person
{
    private int    empId;
    private string designation;
    private double salary;

    public override void AcceptDetails()
    {
        Console.Write("  Employee ID  : ");
        empId = int.Parse(Console.ReadLine());
        base.AcceptDetails();
        Console.Write("  Designation  : ");
        designation = Console.ReadLine();
        Console.Write("  Salary       : ");
        salary = double.Parse(Console.ReadLine());
    }

    public override void DisplayDetails()
    {
        Console.WriteLine("  Employee ID  : " + empId);
        base.DisplayDetails();
        Console.WriteLine("  Designation  : " + designation);
        Console.WriteLine("  Salary       : Rs. " + salary.ToString("F2"));
    }
}

class VSlip14B
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of employees: ");
        int n = int.Parse(Console.ReadLine());

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\n--- Enter details for Employee " + (i + 1) + " ---");
            employees[i] = new Employee();
            employees[i].AcceptDetails();
        }

        Console.WriteLine("\n========== Employee Details ==========");
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\nEmployee " + (i + 1) + ":");
            employees[i].DisplayDetails();
            Console.WriteLine("  " + new string('-', 35));
        }

        Console.ReadKey();
    }
}
