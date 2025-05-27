import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        IDriveable fahrbaresObjekt;
//
//        // virtuelle Klasse um ein Interface schnell zu verwenden
//        fahrbaresObjekt = new IDriveable() {
//            int countDoors;
//
//            public int getCountDoors() {
//                return countDoors;
//            }
//
//            public void setCountDoors(int countDoors) {
//                this.countDoors = countDoors;
//            }
//
//            @Override
//            public void drive(double speed) {
//
//            }
//
//            @Override
//            public double getSpeed() {
//                return 0;
//            }
//        };
//        fahrbaresObjekt.drive(15);
//        System.out.println(fahrbaresObjekt.getSpeed());
//
//        Fahrrad tomTurbo  = new Fahrrad();
//
//        IDriveable fahrbaresObjekt2 = (IDriveable)tomTurbo;

        IDriveable.whatCanIDo();
        System.out.println("ende");


        try {
            exampleFunction2();
        } catch (IntOutOfRangeException e) {
            throw new RuntimeException(e);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }

        List meineListe = new ArrayList();

    }

    static void exampleFunction() {
        throw new IntOutOfRangeException("4");
    }

    static void exampleFunction2() throws IntOutOfRangeException, ArithmeticException {
        exampleFunction();
    }
}