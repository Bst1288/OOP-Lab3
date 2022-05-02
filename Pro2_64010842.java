import java.util.Scanner;
import java.util.Arrays;
 
public class Pro2_64010842 {
  public static void main(String[] args){
    int[] list1,list2;
    Scanner input= new Scanner(System.in);
    System.out.print("Enter list1: ");
    String ls1[] = input.nextLine().split(" ");

    System.out.print("Enter list2: ");
    String ls2[] = input.nextLine().split(" ");
    
    list1 = new int[ls1.length];
    for(int i=0; i<ls1.length; i++){
      list1[i] = Integer.parseInt(ls1[i]);
    }

    list2 = new int[ls2.length];
    for(int i=0; i<ls2.length; i++){
      list2[i] = Integer.parseInt(ls2[i]);
    }
    int[] ans;
    ans = merge(list1, list2);
    System.out.print("The merge list is ");

    for(int i=0; i<ans.length; i++){
      System.out.print(ans[i]+" ");
    }
    input.close();
  }

  public static int[] merge(int[] list1,int[] list2){
    int[] ans;
    int length = list1.length + list2.length;
    ans = new int[length];

    int k=0;
    for(int i=0; i<list1.length; i++){
      ans[k] = list1[i];
      k++;
    }
    for(int n=0; n<list2.length; n++){
      ans[k] = list2[n];
      k++;
    }
    Arrays.sort(ans);
    return ans;
  }
}
