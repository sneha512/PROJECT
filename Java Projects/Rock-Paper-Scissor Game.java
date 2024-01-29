import java.util.*;

class Main{
  public static void main(String []args){
    Random r=new Random();
    int x=r.nextInt(3);
    
    Scanner sc=new Scanner(System.in);
    System.out.println("Choose any of these numbers -> 0 = rock , 1 = scissors , 2 = paper");
    int n=sc.nextInt();
    System.out.println(x);
    if(x==0 && n==0){
      System.out.println("Try Again");
    }else if(x==0 && n==1){
      System.out.println("Computer Wins");
    }else if(x==0 && n==2){
      System.out.println("You Win");
    }else if(x==1 && n==0){
      System.out.println("You Win");
    }else if(x==1 && n==1){
      System.out.println("Try Again");
    }else if(x==1 && n==2){
      System.out.println("Computer Wins");
    }else if(x==0 && n==2){
      System.out.println("You Win");
    }else if(x==2 && n==0){
      System.out.println("Computer Wins");
    }else if(x==2 && n==1){
      System.out.println("You Win");
    }else if(x==2 && n==2){
      System.out.println("Try Again");
    }
  }
}
