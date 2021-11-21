import java.util.List;

public class Distortion implements Reverse{

    private static String distortionBit;

    public static void setDistortionBit(String distortionBit) {
        Distortion.distortionBit = distortionBit;
    }


    public static List<String> distortion(List<String> list){
        for (int i = 0; i < distortionBit.length(); i++) {
            list.set(i, Reverse.reverse(list.get(i), Integer.parseInt(String.valueOf(distortionBit.charAt(i)))-1));
        }
        return list;
    }


}
