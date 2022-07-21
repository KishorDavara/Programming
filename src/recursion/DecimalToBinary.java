package recursion;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(convertIntoBinary(233,"")); //11101001
        System.out.println(convertIntoBinary(189765,"")); //101110010101000101
    }

    private static String convertIntoBinary(int decimal,String result) {
     if(decimal == 0) {
         return result;
     }
     result = decimal % 2 + result;
     return convertIntoBinary(decimal / 2, result);
    }
}
