
public class Cat
{
    private double originWeight;
    private double weight;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final int EYES_AMOUNT = 2;

    private CatColor color;

    private double eaten = 0.;


    private static int count = 0;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        color = CatColor.BLACK;
    }

    public Cat(Double weight) {
        this();
        this.weight = weight;
    }

    public static Cat copyCat (Cat inputCat){
        Cat copy = new Cat(inputCat.weight);
        copy.originWeight = inputCat.originWeight;
        return copy;
    }


    public void defecate(){
        if (this.eaten < 20){
            System.out.println("Can't defecate! Feed me more!");
        }
        if (this.eaten <= 100 && this.eaten >= 20){
           weight -= eaten;
           System.out.println("Normal stools");
       }
       if (this.eaten > 100 && this.eaten < 500){
           weight -= (eaten - 50);
           System.out.println("Double stools");
       }
       if (this.eaten >= 500){
           weight -= 300;
           System.out.println("Triple stools! Don't feed me so much!");
       }
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        eaten += amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public static int getCount() {
        return count;
    }

    public double getEaten(){
        return eaten;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getMIN_WEIGHT() {
        return MIN_WEIGHT;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            count--;
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}