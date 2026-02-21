package org.Entity;

public class Car {
    private Engine engine;

    public Car(){}
    public Car(Engine eng){
        this.engine = eng;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
