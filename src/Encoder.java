import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encoder implements Reverse{
    private static final Map<String, String> MTK_2_MAP_RU = new HashMap<>();
    private static final Map<String, String> MTK_2_MAP_NUM = new HashMap<>();
    private static final Map<String, String> MTK_2_MAP_EN = new HashMap<>();
    private static final Map<String, Integer> MASK_SYNDROME = new HashMap<>();

    private static List<String> syndromeMask = new ArrayList<>();

static {
    MTK_2_MAP_EN.put("A", "03");
    MTK_2_MAP_EN.put("B", "25");
    MTK_2_MAP_EN.put("C", "14");
    MTK_2_MAP_EN.put("D", "09");
    MTK_2_MAP_EN.put("E", "01");
    MTK_2_MAP_EN.put("F", "13");
    MTK_2_MAP_EN.put("G", "26");
    MTK_2_MAP_EN.put("H", "20");
    MTK_2_MAP_EN.put("I", "06");
    MTK_2_MAP_EN.put("J", "11");
    MTK_2_MAP_EN.put("K", "15");
    MTK_2_MAP_EN.put("L", "18");
    MTK_2_MAP_EN.put("M", "28");
    MTK_2_MAP_EN.put("N", "12");
    MTK_2_MAP_EN.put("O", "24");
    MTK_2_MAP_EN.put("P", "22");
    MTK_2_MAP_EN.put("Q", "23");
    MTK_2_MAP_EN.put("R", "10");
    MTK_2_MAP_EN.put("S", "05");
    MTK_2_MAP_EN.put("T", "16");
    MTK_2_MAP_EN.put("U", "07");
    MTK_2_MAP_EN.put("V", "30");
    MTK_2_MAP_EN.put("W", "19");
    MTK_2_MAP_EN.put("X", "29");
    MTK_2_MAP_EN.put("Y", "21");
    MTK_2_MAP_EN.put("Z", "17");

    MTK_2_MAP_EN.put("\r", "08");
    MTK_2_MAP_EN.put("\n", "02");
    MTK_2_MAP_EN.put("EnChar", "31");
    MTK_2_MAP_EN.put("Num", "27");
    MTK_2_MAP_EN.put("\s", "04");
    MTK_2_MAP_EN.put("RuChar", "00");


    MTK_2_MAP_RU.put("А", "03");
    MTK_2_MAP_RU.put("Б", "25");
    MTK_2_MAP_RU.put("Ц", "14");
    MTK_2_MAP_RU.put("Д", "09");
    MTK_2_MAP_RU.put("Е", "01");
    MTK_2_MAP_RU.put("Ф", "13");
    MTK_2_MAP_RU.put("Г", "26");
    MTK_2_MAP_RU.put("Х", "20");
    MTK_2_MAP_RU.put("И", "06");
    MTK_2_MAP_RU.put("Й", "11");
    MTK_2_MAP_RU.put("К", "15");
    MTK_2_MAP_RU.put("Л", "18");
    MTK_2_MAP_RU.put("М", "28");
    MTK_2_MAP_RU.put("Н", "12");
    MTK_2_MAP_RU.put("О", "24");
    MTK_2_MAP_RU.put("П", "22");
    MTK_2_MAP_RU.put("Я", "23");
    MTK_2_MAP_RU.put("Р", "10");
    MTK_2_MAP_RU.put("С", "05");
    MTK_2_MAP_RU.put("Т", "16");
    MTK_2_MAP_RU.put("У", "07");
    MTK_2_MAP_RU.put("Ж", "30");
    MTK_2_MAP_RU.put("В", "19");
    MTK_2_MAP_RU.put("Ь", "29");
    MTK_2_MAP_RU.put("Ы", "21");
    MTK_2_MAP_RU.put("З", "17");

    MTK_2_MAP_RU.put("\r", "08");
    MTK_2_MAP_RU.put("\n", "02");
    MTK_2_MAP_RU.put("EnChar", "31");
    MTK_2_MAP_RU.put("Num", "27");
    MTK_2_MAP_RU.put("\s", "04");
    MTK_2_MAP_RU.put("RuChar", "00");


    MTK_2_MAP_NUM.put("-", "03");
    MTK_2_MAP_NUM.put("?", "25");
    MTK_2_MAP_NUM.put(":", "14");
    MTK_2_MAP_NUM.put("WHO'S THERE?", "09");
    MTK_2_MAP_NUM.put("3", "01");
    MTK_2_MAP_NUM.put("Э", "13");
    MTK_2_MAP_NUM.put("Ш", "26");
    MTK_2_MAP_NUM.put("Щ", "20");
    MTK_2_MAP_NUM.put("8", "06");
    MTK_2_MAP_NUM.put("Ю", "11");
    MTK_2_MAP_NUM.put("(", "15");
    MTK_2_MAP_NUM.put(")", "18");
    MTK_2_MAP_NUM.put(".", "28");
    MTK_2_MAP_NUM.put(",", "12");
    MTK_2_MAP_NUM.put("9", "24");
    MTK_2_MAP_NUM.put("0", "22");
    MTK_2_MAP_NUM.put("1", "23");
    MTK_2_MAP_NUM.put("4", "10");
    MTK_2_MAP_NUM.put("'", "05");
    MTK_2_MAP_NUM.put("5", "16");
    MTK_2_MAP_NUM.put("7", "07");
    MTK_2_MAP_NUM.put("=", "30");
    MTK_2_MAP_NUM.put("2", "19");
    MTK_2_MAP_NUM.put("/", "29");
    MTK_2_MAP_NUM.put("6", "21");
    MTK_2_MAP_NUM.put("+", "17");

    MTK_2_MAP_NUM.put("\r", "08");
    MTK_2_MAP_NUM.put("\n", "02");
    MTK_2_MAP_NUM.put("EnChar", "31");
    MTK_2_MAP_NUM.put("Num", "27");
    MTK_2_MAP_NUM.put("\s", "04");
    MTK_2_MAP_NUM.put("RuChar", "00");


    MASK_SYNDROME.put("0001", 8);
    MASK_SYNDROME.put("0010", 7);
    MASK_SYNDROME.put("0011", 4);
    MASK_SYNDROME.put("0100", 6);
    MASK_SYNDROME.put("0101", 0);
    MASK_SYNDROME.put("0110", 3);
    MASK_SYNDROME.put("1000", 5);
    MASK_SYNDROME.put("1011", 1);
    MASK_SYNDROME.put("1100", 2);

}

    private static String symbolsToDecimal (Character digit, String alphabet){
        switch (alphabet) {
            case ("RuChar"): return MTK_2_MAP_RU.get(String.valueOf(Character.toUpperCase(digit)));
            case ("Num"): return MTK_2_MAP_NUM.get(String.valueOf(Character.toUpperCase(digit)));
            case ("EnChar"): return MTK_2_MAP_EN.get(String.valueOf(Character.toUpperCase(digit)));
            default: {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Unknown symbol found. It will be replaced with a space.");
                    return  "04";
                }
            }
        }
    }

    public static String binaryToDecimal (String digit){
        Integer integer = Integer.parseInt(digit, 2);
        if (integer < 10)
            return ("0" + String.valueOf(integer));
        else  return String.valueOf(integer);
    }

    public static String decimalToBinary (String digit){
        StringBuilder digitBuilder = new StringBuilder(Integer.toBinaryString(Integer.parseInt(digit)));
        while (digitBuilder.length() != 5)
            digitBuilder.insert(0, "0");
        digit = digitBuilder.toString();
        return digit;
    }

    public static String decimalToHammingCode (String digit){
            digit = digit + doubleXOr((String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(2))));
            digit = digit + tripleXOr((String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(2))), (String.valueOf(digit.charAt(3))));
            digit = digit + tripleXOr((String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(3))), (String.valueOf(digit.charAt(4))));
            digit = digit + tripleXOr((String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(4))));
            return digit;
    }

    private static String doubleXOr (String a, String b){
        if (a.equals(b)){
            return "0";
        } else return "1";
    }

    private static String tripleXOr (String a, String b, String c){
        if (doubleXOr(a, b).equals(c)){
            return "0";
        } else return "1";
    }

    private static String quadXOr(String a, String b, String c, String d){
        if (tripleXOr(a, b, c).equals(d)){
            return "0";
        } else return "1";
    }

    public static List<String> parserToList(String string){

        String digit;
        String alphabet = "RuChar";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            digit = String.valueOf(string.charAt(i)).toUpperCase();
            if (MTK_2_MAP_RU.get(digit) != null) {
                if (!alphabet.equals("RuChar")) {
                    alphabet = "RuChar";
                    list.add("00");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            } else if (MTK_2_MAP_NUM.get(digit) != null) {
                if (!alphabet.equals("Num")) {
                    alphabet = "Num";
                    list.add("27");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            } else if (MTK_2_MAP_EN.get(digit) != null) {
                if (!alphabet.equals("EnChar")) {
                    alphabet = "EnChar";
                    list.add("31");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            }

        }

        return list;
    }

    public static void syndrome(List<String> list){
        for (String digit: list) {
            String syndrome = tripleXOr((String.valueOf(digit.charAt(5))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(2))));
            syndrome += quadXOr((String.valueOf(digit.charAt(6))), (String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(2))), (String.valueOf(digit.charAt(3))));
            syndrome += quadXOr((String.valueOf(digit.charAt(7))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(3))), (String.valueOf(digit.charAt(4))));
            syndrome += quadXOr((String.valueOf(digit.charAt(8))), (String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(4))));

            syndromeMask.add(syndrome);
        }
    }

    public static List<String> getSyndromeMask() {
        return syndromeMask;
    }

    public static List<String> corrector(List<String> list){

        for (int i = 0; i < list.size(); i++) {
            int bit = (MASK_SYNDROME.get(syndromeMask.get(i)));
            list.set(i, Reverse.reverse(list.get(i), bit));
        }
        return list;
    }

    public static String hammingToText (List<String> list){

        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> entryMap = MTK_2_MAP_RU;
        for (String digit: list) {
            digit = digit.substring(0 , 5);
            digit = binaryToDecimal(digit);
            digit = getKey(entryMap, digit);
            switch (digit){
                case ("RuChar"):{
                    entryMap = MTK_2_MAP_RU;
                    break;
                }
                case ("Num"):{
                    entryMap = MTK_2_MAP_NUM;
                    break;
                }
                case ("EnChar"):{
                    entryMap = MTK_2_MAP_EN;
                    break;
                }
                default:{
                    stringBuilder.append(digit);
                }
            }
        }

        return stringBuilder.toString();

    }

    private static String getKey(Map<String,String> entryMap, String digit) {

        for (Map.Entry<String, String> entry : entryMap.entrySet()) {
            if (digit.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }
}
