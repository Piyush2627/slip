using System;

class VSlip22A
{
    // Swap using ref parameters
    static void Swap(ref int a, ref int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    static void Main(string[] args)
    {
        Console.Write("Enter first integer  : ");
        int x = int.Parse(Console.ReadLine());

        Console.Write("Enter second integer : ");
        int y = int.Parse(Console.ReadLine());

        Console.WriteLine("\nBefore Swap: x = " + x + ", y = " + y);

        Swap(ref x, ref y);

        Console.WriteLine("After Swap : x = " + x + ", y = " + y);

        Console.ReadKey();
    }
}
