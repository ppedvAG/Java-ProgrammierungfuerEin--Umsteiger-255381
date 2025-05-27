public class Fahrrad implements IDriveable{
    double speed = 0.0;

    public double getSpeed() {
        return speed;
    }

    @Override
    public void drive(double speed) {
        if(speed+this.speed>0) {
            this.speed+=speed;
        }
    }


}
