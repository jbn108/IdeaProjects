package sample;

public class conversionMethods {

    public static double celciusToFahrenheit(String input){
        return ((Double.valueOf(input) / 5) * 9) + 32;
    }

    public static double meterToYards(String input){
        return Double.valueOf(input) * 1.0936133;


    }

    public static double cmToInch(String input){
        return Double.valueOf(input) * 0.3937007874;
    }

}
