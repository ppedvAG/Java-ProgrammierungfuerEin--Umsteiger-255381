public interface IDriveable {
    void drive(double speed);
    double getSpeed();


    static void whatCanIDo() {
        System.out.println("I can drive");
    }
}
