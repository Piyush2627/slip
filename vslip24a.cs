using System;

class VSlip24A
{
    // Function to check if a number is prime
    static bool IsPrime(int n)
    {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    static void Main(string[] args)
    {
        Console.Write("Enter a number to check: ");
        int number = int.Parse(Console.ReadLine());

        Console.WriteLine();
        if (IsPrime(number))
            Console.WriteLine(number + " is a PRIME number.");
        else
            Console.WriteLine(number + " is NOT a prime number.");

        Console.ReadKey();
    }
}
