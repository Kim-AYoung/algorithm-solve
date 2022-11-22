package simulation;

public class FindTheTemperature {
    static double closestToZero(double[] ts) {

        if (ts.length == 0) {
            return 0;
        }

        double temperatureClosestToZero = 5526;
        for (int i = 0; i < ts.length; i++) {
            double temperature = ts[i];

            if (Math.abs(temperature) < Math.abs(temperatureClosestToZero)) {
                temperatureClosestToZero = temperature;
            } else if ((Math.abs(temperature) == Math.abs(temperatureClosestToZero)) && temperature > 0) {
                temperatureClosestToZero = temperature;
            }
        }

        return temperatureClosestToZero;
    }

    public static void main(String args[]) throws Exception {
        double[] ts =
                {7, -10, 13, 8, 4, -7.2, -12, -3.7, 3.5, -9.6, 6.5, -1.7, -6.2, 1.7};

        double result = closestToZero(ts);

        System.out.println("Result: " + result);
    }
}
