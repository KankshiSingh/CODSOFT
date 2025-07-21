import java.util.Scanner;
class range{
    public int generate(int max, int min){
        return (int) (Math.random()*(max-min+1)+min);
    }
}
public class NumberGame{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        range r=new range();
        int total=0;
        int win=0;

        while(true){
            System.out.println("Enter lower limit:");
            int min=s.nextInt();
            System.out.println("Enter upper limit:");
            int max=s.nextInt();
            s.nextLine();
            int c = r.generate(max,min);
            int A=0;

            while(true){
                System.out.println("Guess a number between "+min+" and "+max);
                int g=s.nextInt();
                A++;

                if(g>c){
                    System.out.println("Too High");
                }
                else if(g<c){
                    System.out.println("Too Low");
                }
                else{
                    System.out.println("Your guess is correct.");
                    win++;
                    break;
                }
            }
            total=total+A;
            System.out.println("Attempt="+A);
            System.out.println("Wins="+win);

            double winrate=(double) win/total*100;
            System.out.printf("Your winrate is %.2f%%\n",winrate);
            System.out.println("Do you want to play again (Y/N)");
            String PA=s.next();
            if(!PA.equalsIgnoreCase("Y")){
                s.close();
                System.exit(0);
            }
            s.nextLine();
        }
    }
}