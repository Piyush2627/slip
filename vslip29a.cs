using System;

class VSlip29A
{
    static void Main(string[] args)
    {
        Console.Write("Enter a string: ");
        string input = Console.ReadLine();

        Console.WriteLine("\nString: \"" + input + "\"");
        Console.WriteLine("Individual characters:");
        Console.WriteLine("----------------------");

        for (int i = 0; i < input.Length; i++)
        {
            Console.WriteLine("  [{0}] -> '{1}'", i, input[i]);
        }

        Console.WriteLine("----------------------");
        Console.WriteLine("Total characters: " + input.Length);

        Console.ReadKey();
    }
}