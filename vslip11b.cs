using System;

// Base class
class Fruit
{
    protected string name;
    protected int count;

    public Fruit(string name, int count)
    {
        this.name  = name;
        this.count = count;
    }

    public virtual void Display()
    {
        Console.WriteLine("Fruit : {0,-10} | Count : {1}", name, count);
    }

    public int GetCount() => count;
}

// Derived class: Apples
class Apples : Fruit
{
    private string variety;

    public Apples(int count, string variety) : base("Apple", count)
    {
        this.variety = variety;
    }

    public override void Display()
    {
        Console.WriteLine("Fruit : {0,-10} | Count : {1,-5} | Variety : {2}", name, count, variety);
    }
}

// Derived class: Mangoes
class Mangoes : Fruit
{
    private string type;

    public Mangoes(int count, string type) : base("Mango", count)
    {
        this.type = type;
    }

    public override void Display()
    {
        Console.WriteLine("Fruit : {0,-10} | Count : {1,-5} | Type    : {2}", name, count, type);
    }
}

class VSlip11B
{
    static void Main(string[] args)
    {
        Console.Write("Enter number of Apples : ");
        int appleCount = int.Parse(Console.ReadLine());
        Console.Write("Enter Apple variety    : ");
        string variety = Console.ReadLine();

        Console.Write("\nEnter number of Mangoes : ");
        int mangoCount = int.Parse(Console.ReadLine());
        Console.Write("Enter Mango type        : ");
        string type = Console.ReadLine();

        Apples  apples  = new Apples(appleCount, variety);
        Mangoes mangoes = new Mangoes(mangoCount, type);

        Console.WriteLine("\n========== Fruit Basket Details ==========");
        apples.Display();
        mangoes.Display();

        int total = apples.GetCount() + mangoes.GetCount();
        Console.WriteLine("==========================================");
        Console.WriteLine("Total fruits in basket : " + total);

        Console.ReadKey();
    }
}
