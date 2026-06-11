class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println(type + " engine starting.");
    }
}

class Car2 {
    private String make;
    private Engine engine; // Composition: Car "has an" Engine

    public Car2(String make, String engineType) {
        this.make = make;
        this.engine = new Engine(engineType); // Engine instance created within Car
    }

    public void startCar() {
        System.out.println(make + " car is starting.");
        engine.start(); // Delegating to the Engine's functionality
    }
}

 class CompositionExample {
    public static void main(String[] args) {
        Car2 myCar = new Car2("Toyota", "V6");
        myCar.startCar();
    }
}