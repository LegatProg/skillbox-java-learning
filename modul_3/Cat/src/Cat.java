
public class Cat {
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final int EYES_AMOUNT = 2;

    private static final String DEAD = "Dead";
    private static final String EXPLODED = "Exploded";
    private static final String SLEEPING = "Sleeping";
    private static final String PLAYING = "Playing";

    private double originWeight;
    private double weight;
    private double eaten = 0.;
    private CatColor color;
    private boolean isAlive;

    private static int catsCount = 0;

    public Cat() {                                  //Если парвильно понял с конструкторами
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(Double weight) {
        this.weight = weight;
        originWeight = weight;
        catsCount++;
        color = CatColor.BLACK;
        isAlive = true;
    }

    public static Cat copyCat(Cat inputCat) {
        Cat copy = new Cat(inputCat.weight);
        copy.originWeight = inputCat.originWeight;

        if (inputCat.isAlive) {
            return copy;
        } else {
            catsCount--;
            return copy;
        }
    }

    public void defecate() {
        if (isAlive) {
            if (eaten < 20) {
                System.out.println("Can't defecate! Feed me more!");
            }
            if (eaten <= 100 && eaten >= 20) {
                weight -= eaten;
                System.out.println("Normal stools");
            }
            if (eaten > 100 && eaten < 500) {
                weight -= (eaten - 50);
                System.out.println("Double stools");
            }
            if (eaten >= 500) {
                weight -= 300;
                System.out.println("Triple stools! Don't feed me so much!");
            }
            tryToDecrementCatsCount();
        } else {
            System.out.println("Dead cat can't defecate!");
        }
    }

    public void meow() {
        if (isAlive) {
            weight--;
            System.out.println("Meow");
            tryToDecrementCatsCount();
        } else {
            System.out.println("Dead cat can't meow!");
        }
    }

    public void feed(double amount) {
        if (isAlive) {
            weight += amount;
            eaten += amount;
            tryToDecrementCatsCount();
        } else {
            System.out.println("Dead cat can't eat!");
        }
    }

    public void drink(double amount) {
        if (isAlive) {
            weight += amount;
            tryToDecrementCatsCount();
        } else {
            System.out.println("Dead cat can't drink!");
        }
    }

    private void tryToDecrementCatsCount() {
        if (isAlive && ((getStatus().equals(DEAD) || getStatus().equals(EXPLODED)))) {
            catsCount--;
            this.isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    public double getEaten() {
        return eaten;
    }

    public double getWeight() {
        return weight;
    }

    public double getMinWeight() {
        return MIN_WEIGHT;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return DEAD;
        } else if (weight > MAX_WEIGHT) {
            return EXPLODED;
        } else if (weight > originWeight) {
            return SLEEPING;
        } else {
            return PLAYING;
        }
    }


}