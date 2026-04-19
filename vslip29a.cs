



































using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter a string: ");
        string str = Console.ReadLine();

        foreach (char ch in str)
        {
            Console.WriteLine(ch);
        }
    }
}