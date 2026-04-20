using System;

class VSlip8B
{
    static void Main(string[] args)
    {
        int rows1, cols1, rows2, cols2;

        Console.Write("Enter rows of Matrix A    : ");
        rows1 = int.Parse(Console.ReadLine());
        Console.Write("Enter columns of Matrix A : ");
        cols1 = int.Parse(Console.ReadLine());

        Console.Write("Enter rows of Matrix B    : ");
        rows2 = int.Parse(Console.ReadLine());
        Console.Write("Enter columns of Matrix B : ");
        cols2 = int.Parse(Console.ReadLine());

        if (cols1 != rows2)
        {
            Console.WriteLine("\nMatrix multiplication not possible! Columns of A must equal Rows of B.");
            Console.ReadKey();
            return;
        }

        int[,] A = new int[rows1, cols1];
        int[,] B = new int[rows2, cols2];
        int[,] C = new int[rows1, cols2];

        Console.WriteLine("\nEnter elements of Matrix A:");
        for (int i = 0; i < rows1; i++)
            for (int j = 0; j < cols1; j++)
            {
                Console.Write("  A[{0}][{1}] = ", i, j);
                A[i, j] = int.Parse(Console.ReadLine());
            }

        Console.WriteLine("\nEnter elements of Matrix B:");
        for (int i = 0; i < rows2; i++)
            for (int j = 0; j < cols2; j++)
            {
                Console.Write("  B[{0}][{1}] = ", i, j);
                B[i, j] = int.Parse(Console.ReadLine());
            }

        // Multiplication
        for (int i = 0; i < rows1; i++)
            for (int j = 0; j < cols2; j++)
                for (int k = 0; k < cols1; k++)
                    C[i, j] += A[i, k] * B[k, j];

        Console.WriteLine("\n--- Matrix A ---");
        PrintMatrix(A, rows1, cols1);

        Console.WriteLine("\n--- Matrix B ---");
        PrintMatrix(B, rows2, cols2);

        Console.WriteLine("\n--- Product (A x B) ---");
        PrintMatrix(C, rows1, cols2);

        Console.ReadKey();
    }

    static void PrintMatrix(int[,] M, int rows, int cols)
    {
        for (int i = 0; i < rows; i++)
        {
            Console.Write("  ");
            for (int j = 0; j < cols; j++)
                Console.Write("{0,6}", M[i, j]);
            Console.WriteLine();
        }
    }
}
