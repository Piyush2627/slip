using System;

class Supplier
{
    private int    supplierId;
    private string supplierName;
    private string contactNumber;
    private string address;
    private string itemSupplied;
    private double supplyAmount;

    public void AcceptDetails()
    {
        Console.Write("  Supplier ID     : ");
        supplierId = int.Parse(Console.ReadLine());

        Console.Write("  Supplier Name   : ");
        supplierName = Console.ReadLine();

        Console.Write("  Contact Number  : ");
        contactNumber = Console.ReadLine();

        Console.Write("  Address         : ");
        address = Console.ReadLine();

        Console.Write("  Item Supplied   : ");
        itemSupplied = Console.ReadLine();

        Console.Write("  Supply Amount   : Rs. ");
        supplyAmount = double.Parse(Console.ReadLine());
    }

    public void DisplayDetails()
    {
        Console.WriteLine("  Supplier ID     : " + supplierId);
        Console.WriteLine("  Supplier Name   : " + supplierName);
        Console.WriteLine("  Contact Number  : " + contactNumber);
        Console.WriteLine("  Address         : " + address);
        Console.WriteLine("  Item Supplied   : " + itemSupplied);
        Console.WriteLine("  Supply Amount   : Rs. " + supplyAmount.ToString("F2"));
    }
}

class VSlip16B
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of suppliers: ");
        int n = int.Parse(Console.ReadLine());

        Supplier[] suppliers = new Supplier[n];

        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\n--- Enter details for Supplier " + (i + 1) + " ---");
            suppliers[i] = new Supplier();
            suppliers[i].AcceptDetails();
        }

        Console.WriteLine("\n========== Supplier Details ==========");
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\nSupplier " + (i + 1) + ":");
            suppliers[i].DisplayDetails();
            Console.WriteLine("  " + new string('-', 35));
        }

        Console.ReadKey();
    }
}
