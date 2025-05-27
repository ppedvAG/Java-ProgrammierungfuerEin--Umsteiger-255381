import java.util.Scanner;

public class MeineKlasse {
       
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Bitte eine Priminput eingeben: ");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (IsPrimenumber(input)) {
                    System.out.println("Glückwunsch! "+input+" ist eine Primzahl.");
                } else {
                    System.out.println(input+" ist leider keine Primzahl.");
                }
            } else {
                System.out.println("Ungueltige Eingabe. Bitte erneut versuchen.");
            }

            System.out.println("Weitere Primzahl pruefen? (true/false)");

            if (!scanner.nextBoolean())
            {
                break;
            }
        }
    }

    static boolean IsPrimenumber(int number)
    {
        if (number <= 1)
            return false;

        if (number == 2)
            return true;

        if (number % 2 == 0)
            return false;

        for (int i = 3; i < number; i += 2)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }


}