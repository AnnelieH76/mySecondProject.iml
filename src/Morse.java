
import java.util.HashMap;

public class Morse {
    private static final HashMap<Character, String> morseCodeMap = new HashMap<>(); // HashMap kopplar bokstav med kod
    private static final HashMap<String, Character> reverseMorseCodeMap = new HashMap<>(); //HashMap för att översätta morsekod till bokstäver.

    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");

        for (HashMap.Entry<Character, String> entry : morseCodeMap.entrySet()) {//Skapa en omvänd hash map
            reverseMorseCodeMap.put(entry.getValue(), entry.getKey()); //där nycklar och värden byter plats med hjälp av en for-each.
        }
    }

    public static String toMorseCode(String text) {
        if (text == null || text.trim().isEmpty()) {//Kollar om texten är tom via mainklassen eller null via testklassen.
            return "Error: Input can't be empty.";
        }

        text = text.toUpperCase(); // Konverterar eventuella gemener till versaler
        String morse = "";

        for (int i = 0; i < text.length(); i++) {//Loopar igenom varje bokstav
            char c = text.charAt(i); //Hämtar tecknet vid position i.
            if (morseCodeMap.containsKey(c)) { //Om bokstaven finns i morseCodeMap
                if (!morse.isEmpty()) {
                    morse = morse.concat(" "); // Lägger till mellanslag mellan varje morsekod
                }
                morse = morse.concat(morseCodeMap.get(c)); //concat lägger till den returnerade morsekoden.
            } else if (c != ' ') { //Om tecknet inte är ett mellanslag (eller finns i hash mapen).
                return "Please write characters A-Z";
            }
        }
        return morse; // Returnerar hela Morsekod-strängen.
    }

    public static String fromMorseCode(String morse) {
        if (morse == null || morse.trim().isEmpty()) { //trim() tar bort alla mellanslag.
            return "Error: Input can't be empty.";
        }

        String text = "";
        String[] letters = morse.split(" "); //Dela upp inmatad Morse-kod i en array där varje element representerar en bokstav,
        // separerad med mellanslag.

        //Hämta bokstav vid position i
        for (String letter : letters) {
            if (reverseMorseCodeMap.containsKey(letter)) { //om Morsekoden finns i den omvända hash mapen
                text = text.concat(String.valueOf(reverseMorseCodeMap.get(letter))); // Lägg till motsvarande bokstav i textsträngen
            } else {
                return "Error. Invalid input";
            }
        }
        return text; //Returnerar den översatta textsträngen
    }
}


