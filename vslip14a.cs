using System;

class VSlip14A
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of elements in array: ");
        int n = int.Parse(Console.ReadLine());

        int[] arr = new int[n];

        Console.WriteLine("Enter elements:");
        for (int i = 0; i < n; i++)
        {
            Console.Write("  arr[{0}] = ", i);
            arr[i] = int.Parse(Console.ReadLine());
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        Console.Write("\nArray: [ ");
        for (int i = 0; i < n; i++)
            Console.Write(arr[i] + (i < n - 1 ? ", " : " "));
        Console.WriteLine("]");

        Console.WriteLine("Sum of all elements = " + sum);

        Console.ReadKey();
    }
}
