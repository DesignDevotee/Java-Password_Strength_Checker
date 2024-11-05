import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Pass_strength_check {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        Collection<String> suggestions = new ArrayList<>();

        System.out.println("Enter password:");
        String password = sc.next();
        System.out.println();



        boolean lengthCriteria = getlength(password);
        boolean haslowercase = false;
        boolean hasuppercase = false;
        boolean hasnumbers = false;
        boolean hascharacter = false;

        if (lengthCriteria) score++;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch) && !haslowercase) {
                haslowercase = true;
                score++;
            } else if (Character.isUpperCase(ch) && !hasuppercase) {
                hasuppercase = true;
                score++;
            } else if (Character.isDigit(ch) && !hasnumbers) {
                hasnumbers = true;
                score++;
            } else if ("!@#$%^&*()_+".contains(Character.toString(ch)) && !hascharacter) {
                hascharacter = true;
                score++;
            }
        }
        if(!lengthCriteria) suggestions.add("Password must me atleast 8 characters long");
        if(!haslowercase) suggestions.add("password must contain atleast one lower case letter");
        if(!hasuppercase) suggestions.add("password must contain atleast one upper case letter");
        if(!hasnumbers) suggestions.add("password must contain atleast one number"); 
        if(!hascharacter) suggestions.add("password must contain atleast one character (!@#$%^&*()_+)");


        switch (score) {
            case 1 -> System.out.println("Score : Very weak");
            case 2 -> System.out.println(" Score : Weak");
            case 3 -> System.out.println("Score : Normal");
            case 4 -> System.out.println("Score : Strong");
            case 5 -> System.out.println(" Score :Very strong");
            default -> System.out.println("error check if password entered1");
        }
         
        if (!suggestions.isEmpty()) {
            System.out.println("Suggestions to improve password");
            for (String s : suggestions) {
                System.out.println("- "+s);
            }
        }


        sc.close();
    }

    public static boolean getlength(String pass) {
        return pass.length() >= 8;
    }


}
