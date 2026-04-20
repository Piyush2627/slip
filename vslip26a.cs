using System;

class VSlip26A
{
    // Recursive function to find factorial
    static long Factorial(int n)
    {
        if (n < 0)
            throw new ArgumentException("Factorial is not defined for negative numbers.");
        if (n == 0 || n == 1)
            return 1;
        return n * Factorial(n - 1);
    }

    static void Main(string[] args)
    {
        Console.Write("Enter a non-negative integer: ");
        int number = int.Parse(Console.ReadLine());

        try
        {
            long result = Factorial(number);
            Console.WriteLine("\nFactorial of " + number + " = " + result);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine("\nError: " + ex.Message);
        }

        Console.ReadKey();
    }
}
