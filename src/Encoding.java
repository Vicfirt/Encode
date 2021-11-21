import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Encoding {

    private static String text = null;
    private static String distortionBitNumbers = null;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {

                System.out.println("Enter a string for encoding:");

                text = reader.readLine();
                text = text.replaceAll("[Чч]", "4");
                text = text.toUpperCase();

                while (!text.matches("[^ёЁъЪ]+")) {
                    System.out.println("The string contains a prohibited character.\nPlease re-enter:");
                    text = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("In text format:");
        System.out.println(text);
        list = Encoder.parserToList(text);
        System.out.println("Decimal:");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Encoder.decimalToBinary(list.get(i)));
        }
        System.out.println("Binary:");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Encoder.decimalToHammingCode(list.get(i)));
        }
        System.out.println("Hamming code:");
        System.out.println(list);

            try {

                System.out.println("Enter the distortion bit numbers:");
                distortionBitNumbers = reader.readLine();

                while (Encoding.checkForbiddenCharacters(distortionBitNumbers)) {
                    System.out.println("Incorrect numbers entered.\nTry again:");
                    distortionBitNumbers = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            Distortion.setDistortionBit(distortionBitNumbers);
            list = Distortion.distortion(list);

        System.out.println("Distortion:");
        System.out.println(list);

        Encoder.syndrome(list);
        System.out.println("Distortion mask:");
        System.out.println(Encoder.getSyndromeMask());

        list = Encoder.corrector(list);
        System.out.println("Corrected:");
        System.out.println(list);

        System.out.println("Hamming to text:");
        System.out.println(Encoder.hammingToText(list));

    }

    private static boolean checkForbiddenCharacters (String distortionBitNumbers){
            if (distortionBitNumbers.length() != list.size()){
                return true;
            }
            if (!distortionBitNumbers.matches("[1-9]+")){
                return true;
            }
        return false;
    }

}
