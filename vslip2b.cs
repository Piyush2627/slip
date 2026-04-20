using System;

// Base class
class Department
{
    protected int deptId;
    protected string deptName;
    protected string location;

    public void AcceptDetails()
    {
        Console.Write("Enter Department ID: ");
        deptId = int.Parse(Console.ReadLine());
        Console.Write("Enter Department Name: ");
        deptName = Console.ReadLine();
        Console.Write("Enter Location: ");
        location = Console.ReadLine();
    }

    public virtual void DisplayDetails()
    {
        Console.WriteLine("\n--- Department Details ---");
        Console.WriteLine("Department ID   : " + deptId);
        Console.WriteLine("Department Name : " + deptName);
        Console.WriteLine("Location        : " + location);
    }
}

// Derived class: Sales
class Sales : Department
{
    private double salesTarget;
    private string region;

    public void AcceptDetails()
    {
        base.AcceptDetails();
        Console.Write("Enter Sales Target (in lakhs): ");
        salesTarget = double.Parse(Console.ReadLine());
        Console.Write("Enter Region: ");
        region = Console.ReadLine();
    }

    public override void DisplayDetails()
    {
        base.DisplayDetails();
        Console.WriteLine("Sales Target    : " + salesTarget + " Lakhs");
        Console.WriteLine("Region          : " + region);
    }
}

// Derived class: HumanResource
class HumanResource : Department
{
    private int totalEmployees;
    private string hrManager;

    public void AcceptDetails()
    {
        base.AcceptDetails();
        Console.Write("Enter Total Employees: ");
        totalEmployees = int.Parse(Console.ReadLine());
        Console.Write("Enter HR Manager Name: ");
        hrManager = Console.ReadLine();
    }

    public override void DisplayDetails()
    {
        base.DisplayDetails();
        Console.WriteLine("Total Employees : " + totalEmployees);
        Console.WriteLine("HR Manager      : " + hrManager);
    }
}

class VSlip2B
{
    static void Main(string[] args)
    {
        Console.WriteLine("========== SALES DEPARTMENT ==========");
        Sales sales = new Sales();
        sales.AcceptDetails();
        sales.DisplayDetails();

        Console.WriteLine("\n========== HUMAN RESOURCE DEPARTMENT ==========");
        HumanResource hr = new HumanResource();
        hr.AcceptDetails();
        hr.DisplayDetails();

        Console.ReadKey();
    }
}
