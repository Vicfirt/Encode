public interface Reversable {

     default String reverse(String digit, int numberOfBit){
        char[] charArray = digit.toCharArray();
         charArray[numberOfBit] = charArray[numberOfBit] == '0' ? '1' : '0';
        return String.valueOf(charArray);
    }
}
