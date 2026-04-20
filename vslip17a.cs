using System;

class VSlip17A
{
    static void Main(string[] args)
    {
        Console.Write("Enter a string: ");
        string input = Console.ReadLine();

        string vowels = "aeiouAEIOU";
        string foundVowels = "";

        Console.WriteLine("\nScanning string: \"" + input + "\"");
        Console.WriteLine("----------------------------------");

        for (int i = 0; i < input.Length; i++)
        {
            if (vowels.Contains(input[i].ToString()))
            {
                Console.WriteLine("Position [{0}] -> '{1}'  (Vowel found)", i, input[i]);
                if (!foundVowels.Contains(input[i].ToString()))
                    foundVowels += input[i];
            }
        }

        if (foundVowels.Length == 0)
            Console.WriteLine("No vowels found in the given string.");
        else
        {
            Console.WriteLine("----------------------------------");
            Console.Write("Unique vowels found: ");
            foreach (char c in foundVowels)
                Console.Write("'" + c + "' ");
            Console.WriteLine();
        }

        Console.ReadKey();
    }
}
