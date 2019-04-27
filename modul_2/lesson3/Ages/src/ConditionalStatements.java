public class ConditionalStatements {
    public static void main(String[] args) {
//-------------initialize---------------------
        int firstPersonAge = (int) (Math.random() * 100);
        int secondPersonAge = (int) (Math.random() * 100);
        int thirdPersonAge = (int) (Math.random() * 100);

        int max = firstPersonAge;
        int mid = firstPersonAge;
        int min = firstPersonAge;
//--------------find max----------------------
        if (secondPersonAge >= max) {
            max = secondPersonAge;
        }
        if (thirdPersonAge >= max) {
            max = thirdPersonAge;
        }
//--------------find min----------------------
        if (secondPersonAge <= min) {
            min = secondPersonAge;
        }
        if (thirdPersonAge <= min) {
            min = thirdPersonAge;
        }
//--------------find mid----------------------
        if (secondPersonAge < max && secondPersonAge > min){
            mid = secondPersonAge;
        }
        if (thirdPersonAge < max && thirdPersonAge > min) {
            mid = thirdPersonAge;
        }
//-------------printing-----------------------
        System.out.println("First person age is " + firstPersonAge);
        System.out.println("Second person age is " + secondPersonAge);
        System.out.println("Third person age is " + thirdPersonAge);
        System.out.println("\n=============================================\n");

        System.out.println("The oldest person is " + max + " y.o.");
        System.out.println("The middle person is " + mid + " y.o.");
        System.out.println("The youngest person is " + min + " y.o.");


    }
}
