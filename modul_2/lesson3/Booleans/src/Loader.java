
public class Loader
{
    private static boolean canCookSomething;


    public static void main(String[] args)
    {
        int milkAmount = (int)(Math.random() * 3000); // ml
        int powderAmount = (int)(Math.random() * 1000); // g
        int eggsCount = (int)(Math.random() * 50); // pcs
        int sugarAmount = (int)(Math.random() * 50); // g
        int oilAmount = (int)(Math.random() * 500); // ml
        int appleCount = (int)(Math.random() * 5); //pcs

        System.out.println("You have:");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(powderAmount + " g of powder");
        System.out.println(eggsCount + " eggs");
        System.out.println(sugarAmount + " g of sugar");
        System.out.println(oilAmount + " ml of oil");
        System.out.println(appleCount + " apples");
        System.out.println("======================================");
        System.out.println("You can cook:");

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >=1000 && oilAmount >= 30) {
            canCookDish("Pancakes");
        }
        //milk - 300 ml, powder - 5 g, eggs - 5
        if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            canCookDish("Omelette");
        }
        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        if (appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) {
            canCookDish("Apple pie");
        }

        System.out.println(canCookSomething ? "" : "Nothing. Add more products.");

    }

    private static void canCookDish(String dish){
        System.out.println(dish);
        canCookSomething = true;
    }
}