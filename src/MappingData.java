import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingData {

    private static final Map<String, String> MTK_2_MAP_RU = new HashMap<>();
    private static final Map<String, String> MTK_2_MAP_NUM = new HashMap<>();
    private static final Map<String, String> MTK_2_MAP_EN = new HashMap<>();
    private static final Map<String, Integer> MASK_SYNDROME = new HashMap<>();

    private static List<String> syndromeMask = new ArrayList<>();

    public MappingData() {
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

    public static Map<String, String> getMtk2MapRu() {
        return MTK_2_MAP_RU;
    }

    public static Map<String, String> getMtk2MapNum() {
        return MTK_2_MAP_NUM;
    }

    public static Map<String, String> getMtk2MapEn() {
        return MTK_2_MAP_EN;
    }

    public static Map<String, Integer> getMaskSyndrome() {
        return MASK_SYNDROME;
    }

    public static List<String> getSyndromeMask() {
        return syndromeMask;
    }
}
