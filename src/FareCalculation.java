public class FareCalculation {


    public static double calculate(String trainType, String seatType, double Distance) {
        if (seatType.equals("Ac")) {
            if (trainType.equals("SuperFast")) {
                return Distance * 1.90;
            }
            if (trainType.equals("ChairCar")) {
                return Distance * 1.30;
            }
            if (trainType.equals("VandeBharat")) {
                return Distance * 2.50;
            }
        }
         if(seatType.equals("General")) {
             if (trainType.equals("SuperFast")) {
                 return Distance * 1.10;
             }
             if (trainType.equals("ChairCar")) {
                 return Distance * 0.70;
             }
             if (trainType.equals("VandeBharat")) {
                 return Distance * 1.35;
             }

        }
        return 0;
    }

    public static int Seats(String trainType, String seatType) {
        if (seatType.equals("Ac")) {
            if (trainType.equals("SuperFast")) {
                return 64;
            }
            if (trainType.equals("ChairCar")) {
                return 128;
            }
            if (trainType.equals("VandeBharat")) {
                return 32;
            }

        }
        if(seatType.equals("General")) {
            if (trainType.equals("SuperFast")) {
                return 64;
            }
            if (trainType.equals("ChairCar")) {
                return 128;
            }
            if (trainType.equals("VandeBharat")) {
                return 32;
            }

        }
        return 0;
    }

}


