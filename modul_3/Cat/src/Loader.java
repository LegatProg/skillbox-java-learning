public class Loader {
    public static void main(String[] args) {

        Cat vaska = new Cat();
        Cat murka = new Cat();
        Cat murzik = new Cat();
        Cat barsik = new Cat();
        Cat kuzya = new Cat();
        Cat kitten = Loader.createKitten();
        Cat copy = Cat.copyCat(vaska);

        System.out.println("Vaska: " + vaska.getWeight());
        System.out.println("Vaska copy: " + copy.getWeight());
        System.out.println("Murka: " + murka.getWeight());
        System.out.println("Murzik: " + murzik.getWeight());
        System.out.println("Barsik: " + barsik.getWeight());
        System.out.println("Kuzya: " + kuzya.getWeight());
        System.out.println("Kitten: " + kitten.getWeight());
        System.out.println("The COUNT is: " + Cat.getCatsCount());

        System.out.println("======================================");
        System.out.println("Experiment with feeding and defecating Murka begins: ");
        for (int i = 1; i <= 15; i++) {
            murka.feed(i * 10.1);
            if (i % 3 == 0) {
                System.out.println("total eaten: " + murka.getEaten());
                murka.defecate();
            }
        }
        System.out.println("Experiment with feeding and defecating Murka ends. ");
        System.out.println("======================================");

        vaska.feed(100.);

        murzik.meow();
        murzik.feed(10000.);

        barsik.meow();
        for (int i = 0; i < 10000; i++) {
            if (barsik.getWeight() < barsik.getMinWeight()) {
                break;
            }
            barsik.meow();
        }

        kuzya.drink(10.1);
        kuzya.feed(125.);
        kuzya.meow();

        System.out.println("Vaska: " + vaska.getStatus());
        System.out.println("Vaska copy: " + copy.getStatus());
        System.out.println("Murka: " + murka.getStatus());
        System.out.println("Murzik: " + murzik.getStatus());
        System.out.println("Barsik: " + barsik.getStatus());
        System.out.println("Kuzya: " + kuzya.getStatus());
        System.out.println("Kitten: " + kitten.getStatus());
        System.out.println("The COUNT is: " + Cat.getCatsCount());

    }

    public static Cat createKitten() {
        return new Cat((1000 + Math.random() * 100));
    }
}