import java.util.Scanner;

public class problem01 {

    public static String solve(String s){
        // Split words in string
        String[] sList = s.split("\\s+");
        // save position and maximum length
        int place = 0, lenMax = 0;
        for(int i = 0; i < sList.length; i++){
            if(sList[i].length() > lenMax){
                lenMax = sList[i].length();
                place = i;
            }
        }
        return sList[place];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string:");
        String s = sc.nextLine();
        System.out.println(solve(s));
    }
}
