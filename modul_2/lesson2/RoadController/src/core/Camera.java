package core;

import java.util.HashMap;

public class Camera
{
    //HashMap<String, Integer> carsSpeed
    public static HashMap<String, Integer> carsSpeed = new HashMap<>();

    public static Car getNextCar()
    {
        //String randomNumber
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        //Integer randomHeight
        Integer randomHeight = (int) (1000 + 3500. * Math.random());
        //Double randomWeight
        Double randomWeight = 600 + 10000 * Math.random();
        //Car car
        Car car = new Car(randomNumber, randomHeight, randomWeight, Math.random() > 0.5);
        if(Math.random() < 0.15) {
            car.setIsSpecial();
        }
        Police.resetCalled();

        return car;
    }
    //                                Car car
    public static Integer getCarSpeed(Car car)
    {
        //String carNumber
        String carNumber = car.getNumber();
        if(!carsSpeed.containsKey(carNumber)) {
            carsSpeed.put(carNumber, (int) (180 * Math.random()));
        }
        return carsSpeed.get(carNumber);
    }
}