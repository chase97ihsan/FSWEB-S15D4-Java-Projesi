import java.util.*;

public class MainStack {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("---------------------");
        System.out.println(checkForPalindromeQueues("abccba"));
        System.out.println(checkForPalindromeQueues("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeQueues("I did, did I?"));
        System.out.println(checkForPalindromeQueues("hello"));
        System.out.println(checkForPalindromeQueues("Don't node"));
        System.out.println("---------------------");
        System.out.println(binaryNumber(13));
        System.out.println(binaryNumber(5));
        System.out.println(binaryNumber(6));


    }

    public static boolean checkForPalindrome(String text) {
        text = text.replaceAll("\\.", "");
        text = text.replaceAll("\\?", "");
        text = text.replaceAll("!", "");
        text = text.replaceAll("_", "");
        text = text.replaceAll("-", "");
        text = text.replaceAll(",", "");
        text = text.replaceAll("'", "");
        text = text.replaceAll(" ", "");
        String first = text.toLowerCase(Locale.ENGLISH);
        String[] array = first.split("");
        Stack<String> mystack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            mystack.add(array[i]);
        }
        String second = "";
        while (mystack.size() != 0) {
            second += mystack.peek();
            mystack.pop();
        }
        System.out.println(second);
        return second.equals(first);
    }

    public static boolean checkForPalindromeQueues(String text) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        String first = text.toLowerCase(Locale.ENGLISH);
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            if (c >= 'a' && c <= 'z') {  // <<<< Bunu yukarıda replaceAll ile yapıp bu if i kullanmamıza gerek kalmazdı.q
                queue.add(c);
                stack.push(c);

            }
        }
        System.out.println(stack);
        System.out.println(queue);
       while (stack.size()>1){
           if(!stack.pop().equals(queue.remove())){
               return false;
           }
       }
       return true;
    }

    //DECİMAL SAYIYI BİNARY ÇEVİRME:
    //13
    //13%2=1  6%2=0  3%2=1 1%2=1   <<<<<<TERSTEN YAZIDIR: 1101
    //13/2=6  6/2=3  3/2=1 1/2=0
    public static int binaryNumber(int decimal) {
        String kalan="";
        String kalanReverse="";
        int bolum=decimal;

        while(bolum>0){
             kalan+=String.valueOf(bolum%2);
             bolum=bolum/2;
        }
             char[] array=kalan.toCharArray();
         for(int i=array.length-1;i>=0;i--){
             kalanReverse+=array[i];
         }
         return Integer.parseInt(kalanReverse);
    }


}