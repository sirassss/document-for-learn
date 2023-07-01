package design.pattern.creational.abstracFactory;

public class Demo {

    /**
     * factory
     * */
    interface VehicleFactory {
        Vehicle createVehicle();
    }

    /**
     * concrete factory
     * */
    class SUVFactory implements VehicleFactory {

        public Vehicle createVehicle() {
            return new SUV();
        }
    }

    class SedanFactory implements VehicleFactory {

        public Vehicle createVehicle() {
            return new Sedan();
        }
    }

    class SportBikeFactory implements VehicleFactory {

        public Vehicle createVehicle() {
            return new SportBike();
        }
    }

    abstract class Vehicle {

    }

    class Sedan extends Vehicle {

    }

    class SportBike extends Vehicle {

    }

    class SUV extends Vehicle {

    }

}
