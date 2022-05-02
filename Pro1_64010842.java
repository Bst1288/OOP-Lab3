
public class Pro1_64010842 {
    public static void main(String[] args){
        int count = 0;
        for(int number = 0; count < 100; number++){
            if( checkPrime(number) && checkPalindrome(number) ){ //check if num is prome and palindrome
                System.out.printf("%7d",number);
                count++;
                if(count % 10 == 0 && number !=0) //if count is 10 and num isn't zero = new line 
                System.out.println();
            }
        }
    }

    public static boolean checkPrime(long num) { //method num is prime numbers
        if(num<2)
        return false;

        for(int i = 2; i <= num/2; i++){
            if(num % i == 0)
            return false; //if num % i == 0 -> isn't prime numbers
        }
        return true;
    }

    public static long reverseNum(int num){ //method reverse num for check palindrome
        int reverse = 0;
        while(num != 0){
            reverse = reverse*10;
            reverse = reverse + (num % 10);
            num = num/10;
        }
        return reverse;
    }

    public static boolean checkPalindrome(int num){ //check if reverse = num -> palindrome
        return (num == reverseNum(num));
    }
}