
import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean validChoice = false; //Avgör om användaren har gjort ett giltigt val och avsluta loopen

        while (!validChoice) { //Programmet kommer att fortsätta fråga tills ett korrekt val görs.
            System.out.println("Välj 1: För att översätta engelska till morsekod");
            System.out.println("Välj 2: För att översätta morsekod till engelska");
            System.out.println("Ditt val: ");

            try {
                int choice = Integer.parseInt(scan.nextLine()); //Läser in svaret och omvandlar till integer.

                if (choice == 1) {
                    System.out.println("Please write something in English (A-Z): ");
                    String inputText = scan.nextLine(); //Läser in text
                    String morseCode = Morse.toMorseCode(inputText);//Anropar metoden toMorseCode texten
                    System.out.println(morseCode);// Skriver ut morsekoden
                    validChoice = true;  // Avslutar loopen
                } else if (choice == 2){
                    System.out.println("Please write something in Morse Code (use space between letters): ");
                    String inputCode = scan.nextLine(); //Läser in kod
                    String text = Morse.fromMorseCode(inputCode); //Anropar metoden toMorseCode som översätter koden
                    System.out.println(text); //Skriver ut text
                    validChoice = true;  // Avsluta loopen
                }
                else{
                    System.out.println("Invalid number. Choose between 1 or 2."); //Om inmatning är ett ogiltigt heltal.
                }
            } catch (NumberFormatException e) {
                System.out.println(e + "Empty or invalid input. Please try again."); //Om imnatning är tom eller är ett ogiltigt tecken.
            }
        }
        scan.close();
    }
}

/*
❖ Skriv ett program som gör om morsekod till engelska och engelska till morsekod
❖ Skriv programmet med minst en logikklass samt en klass som läser in text och skriver ut text (med en main-metod). Utveckla programmet i TDD och skriv minst 5 JUnit-testfall
❖ Logik-klass
❖ Main-klass
❖ Test-klass
❖ Skapa minst två felhanteringar i systemet som hanterar två saker som användaren kan göra som går utanför det vanliga användandet av systemet
❖ Använd den internationella morsekoden för bokstäverna A till Z
❖ Korta och långa signaler ska representeras med punkt (.) och bindestreck (-)
❖ F = ..-.
❖ Flera bokstäver skall gå att hantera men separation av ord behöver inte hanteras
❖ …. . .--- = HEJ
❖ .... . .-.. .-.. --- .-- --- .-. .-.. -.. = HELLOWORLD
❖ HELLO WORLD = .... . .-.. .-.. --- .-- --- .-. .-.. -..
 */