using System;

class VSlip10A
{
    static void Main(string[] args)
    {
        Console.WriteLine("========== Primitive Data Types in C# ==========\n");

        // Demonstrating primitive data types
        int    intVal    = 42;
        long   longVal   = 9876543210L;
        float  floatVal  = 3.14f;
        double doubleVal = 3.141592653589793;
        char   charVal   = 'A';
        bool   boolVal   = true;
        byte   byteVal   = 255;
        short  shortVal  = 32767;

        Console.WriteLine("int    : " + intVal);
        Console.WriteLine("long   : " + longVal);
        Console.WriteLine("float  : " + floatVal);
        Console.WriteLine("double : " + doubleVal);
        Console.WriteLine("char   : " + charVal);
        Console.WriteLine("bool   : " + boolVal);
        Console.WriteLine("byte   : " + byteVal);
        Console.WriteLine("short  : " + shortVal);

        Console.WriteLine("\n========== Type Conversions ==========\n");

        // --- Integer to String ---
        int number = 2024;
        string numStr = number.ToString();        // Using ToString()
        string numStr2 = Convert.ToString(number); // Using Convert class

        Console.WriteLine("Integer to String:");
        Console.WriteLine("  Original int    : " + number + "  (Type: " + number.GetType() + ")");
        Console.WriteLine("  Using ToString(): " + numStr  + "  (Type: " + numStr.GetType() + ")");
        Console.WriteLine("  Using Convert   : " + numStr2 + "  (Type: " + numStr2.GetType() + ")");

        Console.WriteLine();

        // --- String to Integer ---
        string strVal = "1234";
        int parsedInt  = int.Parse(strVal);        // Using int.Parse()
        int convertInt = Convert.ToInt32(strVal);  // Using Convert class

        Console.WriteLine("String to Integer:");
        Console.WriteLine("  Original string   : " + strVal    + "  (Type: " + strVal.GetType() + ")");
        Console.WriteLine("  Using int.Parse() : " + parsedInt + "  (Type: " + parsedInt.GetType() + ")");
        Console.WriteLine("  Using Convert     : " + convertInt + "  (Type: " + convertInt.GetType() + ")");

        Console.WriteLine();

        // --- TryParse for safe conversion ---
        string invalidStr = "abc";
        bool success = int.TryParse(invalidStr, out int result);
        Console.WriteLine("Safe Conversion with TryParse:");
        Console.WriteLine("  Trying to parse \"" + invalidStr + "\" -> Success: " + success + ", Result: " + result);

        Console.ReadKey();
    }
}
