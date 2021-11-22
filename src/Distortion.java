import java.util.List;

public class Distortion implements Reversable {

    private String distortionBit;

    public Distortion(String distortionBit) {
        this.distortionBit = distortionBit;
    }
        public List<String> makeDistortion(List<String> list) {
        for (int i = 0; i < distortionBit.length(); i++) {
            list.set(i, reverse(list.get(i), Integer.parseInt(String.valueOf(distortionBit.charAt(i))) - 1));
        }
        return list;
    }
}
