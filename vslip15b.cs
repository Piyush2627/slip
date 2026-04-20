using System;

class Customer
{
    private string customerName;
    private string itemName;
    private int    quantity;
    private double pricePerUnit;
    private double totalPrice;

    public void AcceptDetails()
    {
        Console.Write("  Customer Name  : ");
        customerName = Console.ReadLine();

        Console.Write("  Item Name      : ");
        itemName = Console.ReadLine();

        Console.Write("  Quantity       : ");
        quantity = int.Parse(Console.ReadLine());

        Console.Write("  Price Per Unit : Rs. ");
        pricePerUnit = double.Parse(Console.ReadLine());

        totalPrice = quantity * pricePerUnit;
    }

    public void DisplayDetails()
    {
        Console.WriteLine("  Customer Name  : " + customerName);
        Console.WriteLine("  Item Name      : " + itemName);
        Console.WriteLine("  Quantity       : " + quantity);
        Console.WriteLine("  Price Per Unit : Rs. " + pricePerUnit.ToString("F2"));
        Console.WriteLine("  Total Price    : Rs. " + totalPrice.ToString("F2"));
    }

    public double GetTotalPrice() => totalPrice;
}

class VSlip15B
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of customers: ");
        int n = int.Parse(Console.ReadLine());

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\n--- Enter details for Customer " + (i + 1) + " ---");
            customers[i] = new Customer();
            customers[i].AcceptDetails();
        }

        double grandTotal = 0;

        Console.WriteLine("\n========== Customer Details ==========");
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("\nCustomer " + (i + 1) + ":");
            customers[i].DisplayDetails();
            grandTotal += customers[i].GetTotalPrice();
            Console.WriteLine("  " + new string('-', 35));
        }

        Console.WriteLine("\nGrand Total (All Items) : Rs. " + grandTotal.ToString("F2"));

        Console.ReadKey();
    }
}
