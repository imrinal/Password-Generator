import java.util.*;
public class PasswordGenerator {
    static Scanner scanner = new Scanner(System.in);
    String promt;
    static int length;
    public static void main(String[] args) {
        DisplayIntro();
        System.out.print("Length of the Password: ");
        length = scanner.nextInt();
        scanner.nextLine();

        Boolean includeNumbers = getYesOrNo("Include numbers? (y/n): ", scanner);
        Boolean includeLowerCase = getYesOrNo("Include lowercase letters? (y/n): ", scanner);
        Boolean includeUpperCase = getYesOrNo("Include uppercase letters? (y/n): ", scanner);
        Boolean includeSpecialChars = getYesOrNo("Include special characters? (y/n): ", scanner);

        System.out.println("\nGenerating password...");

        String Password = GeneratePassword(length, includeNumbers, includeLowerCase, includeUpperCase, includeSpecialChars);
        System.out.println("\nYour random password is: " + Password);

        System.out.println("\n--------------------------------------------------");
        System.out.println("          Password Generated Succesfully          ");
        System.out.println("--------------------------------------------------");
    }

    public static void DisplayIntro(){
        System.out.println("--------------------------------------------------");
        System.out.println("     Welcome to the Random Password Generator     ");
        System.out.println("--------------------------------------------------");
        System.out.println("");
    }

    public static Boolean getYesOrNo(String promt, Scanner scanner){
        while(true){
            System.out.print(promt);
            String YesOrNo = scanner.nextLine().trim().toLowerCase();
            
            if(YesOrNo.equals("y")){
                return true;
            }else if(YesOrNo.equals("n")){
                return false;
            }else{
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
    }

    public static String GeneratePassword(int length, Boolean includeNumbers, Boolean includeLowerCase, Boolean includeUpperCase, Boolean includeSpecialChars){
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()_+{}[]|<>?";

        String validchars="";
        if(includeNumbers){
            validchars = validchars + numberChars;
        }if(includeLowerCase){
            validchars = validchars + lowercaseChars;
        }
        if(includeUpperCase){
            validchars = validchars + uppercaseChars;
        }if(includeSpecialChars){
            validchars = validchars + specialChars;
        }

        if (validchars.isEmpty()) {
            throw new IllegalArgumentException("You must include at least one type of characters in the password.");
        }

        Random random = new Random();
        StringBuilder Password = new StringBuilder();
    
        for(int i = 0; i < length; i++){
            int RandomIndex = random.nextInt(validchars.length());
            Password.append(validchars.charAt(RandomIndex));
        }

        return Password.toString();
    }
}
