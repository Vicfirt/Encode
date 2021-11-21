public interface Reverse {
    public static String reverse(String digit, int numberOfBit){
        char[] charArray = digit.toCharArray();

        if (charArray[numberOfBit] == '0')
            charArray[numberOfBit] = '1';
        else charArray[numberOfBit] = '0';

        return String.valueOf(charArray);
    }
}
