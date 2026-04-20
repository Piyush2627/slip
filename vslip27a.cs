using System;

class VSlip27A
{
    static void Main(string[] args)
    {
        Console.Write("Enter a string: ");
        string input = Console.ReadLine();

        // Using built-in Length property
        int lengthBuiltIn = input.Length;

        // Manual counting
        int lengthManual = 0;
        foreach (char c in input)
            lengthManual++;

        Console.WriteLine("\nString         : \"" + input + "\"");
        Console.WriteLine("Length (built-in): " + lengthBuiltIn);
        Console.WriteLine("Length (manual)  : " + lengthManual);

        Console.ReadKey();
    }
}
