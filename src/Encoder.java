import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Encoder implements Reversable {

    private String symbolsToDecimal(Character digit, String alphabet) {
        try {
            return switch (alphabet) {
                case ("RuChar") -> MappingData.getMtk2MapRu().get(String.valueOf(Character.toUpperCase(digit)));
                case ("Num") -> MappingData.getMtk2MapNum().get(String.valueOf(Character.toUpperCase(digit)));
                case ("EnChar") -> MappingData.getMtk2MapEn().get(String.valueOf(Character.toUpperCase(digit)));
                default -> throw new Exception("Unknown symbol found. It will be replaced with a space.");
            };
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "04";
        }
    }

    public String binaryToDecimal(String digit) {
        Integer integer = Integer.parseInt(digit, 2);
        if (integer < 10)
            return ("0" + String.valueOf(integer));
        else return String.valueOf(integer);
    }

    public String decimalToBinary(String digit) {
        StringBuilder digitBuilder = new StringBuilder(Integer.toBinaryString(Integer.parseInt(digit)));
        while (digitBuilder.length() != 5)
            digitBuilder.insert(0, "0");
        digit = digitBuilder.toString();
        return digit;
    }

    public String decimalToHammingCode(String digit) {
        digit = digit + doubleXOr((String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(2))));
        digit = digit + tripleXOr((String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(2))), (String.valueOf(digit.charAt(3))));
        digit = digit + tripleXOr((String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(3))), (String.valueOf(digit.charAt(4))));
        digit = digit + tripleXOr((String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(4))));
        return digit;
    }

    private String doubleXOr(String a, String b) {
        return a.equals(b) ? "0" : "1";
    }

    private String tripleXOr(String a, String b, String c) {
        return doubleXOr(a, b).equals(c) ? "0" : "1";
    }

    private String quadXOr(String a, String b, String c, String d) {
        return tripleXOr(a, b, c).equals(d) ? "0" : "1";
    }

    public List<String> parserToList(String string) {

        String digit;
        String alphabet = "RuChar";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            digit = String.valueOf(string.charAt(i)).toUpperCase();
            if (MappingData.getMtk2MapRu().get(digit) != null) {
                if (!alphabet.equals("RuChar")) {
                    alphabet = "RuChar";
                    list.add("00");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            } else if (MappingData.getMtk2MapNum().get(digit) != null) {
                if (!alphabet.equals("Num")) {
                    alphabet = "Num";
                    list.add("27");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            } else if (MappingData.getMtk2MapEn().get(digit) != null) {
                if (!alphabet.equals("EnChar")) {
                    alphabet = "EnChar";
                    list.add("31");
                }
                list.add(symbolsToDecimal(string.charAt(i), alphabet));
            }
        }
        return list;
    }

    public void syndrome(List<String> list) {
        for (String digit : list) {
            String syndrome = tripleXOr((String.valueOf(digit.charAt(5))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(2))));
            syndrome += quadXOr((String.valueOf(digit.charAt(6))), (String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(2))), (String.valueOf(digit.charAt(3))));
            syndrome += quadXOr((String.valueOf(digit.charAt(7))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(3))), (String.valueOf(digit.charAt(4))));
            syndrome += quadXOr((String.valueOf(digit.charAt(8))), (String.valueOf(digit.charAt(0))), (String.valueOf(digit.charAt(1))), (String.valueOf(digit.charAt(4))));

            MappingData.getSyndromeMask().add(syndrome);
        }
    }

    public List<String> corrector(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            int bit = (MappingData.getMaskSyndrome().get(MappingData.getSyndromeMask().get(i)));
            list.set(i, reverse(list.get(i), bit));
        }
        return list;
    }

    public String hammingToText(List<String> list) {

        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> entryMap = MappingData.getMtk2MapRu();
        for (String digit : list) {
            digit = digit.substring(0, 5);
            digit = binaryToDecimal(digit);
            digit = getKeyByValue(entryMap, digit);
            switch (digit) {
                case ("RuChar"): {
                    entryMap = MappingData.getMtk2MapRu();
                    break;
                }
                case ("Num"): {
                    entryMap = MappingData.getMtk2MapNum();
                    break;
                }
                case ("EnChar"): {
                    entryMap = MappingData.getMtk2MapEn();
                    break;
                }
                default: {
                    stringBuilder.append(digit);
                }
            }
        }

        return stringBuilder.toString();
    }

    private String getKeyByValue(Map<String, String> entryMap, String digit) {
        for (Map.Entry<String, String> entry : entryMap.entrySet()) {
            if (digit.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }
}
