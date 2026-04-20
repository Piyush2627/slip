using System;

class VSlip3A
{
    // Function to calculate sum of two numbers
    static double Sum(double a, double b)
    {
        return a + b;
    }

    static void Main(string[] args)
    {
        Console.Write("Enter first number  : ");
        double num1 = double.Parse(Console.ReadLine());

        Console.Write("Enter second number : ");
        double num2 = double.Parse(Console.ReadLine());

        double result = Sum(num1, num2);

        Console.WriteLine("\n---------------------------");
        Console.WriteLine("Sum of {0} + {1} = {2}", num1, num2, result);
        Console.WriteLine("---------------------------");

        Console.ReadKey();
    }
}
