import java.util.Random;

public class HelperFunctions {
    // gen_random_name and gen_random_id could be one function.
    public static String gen_random_name() {
        Random rand = new Random();
        String name = "";
        char rand_letter;
        for(int i = 0; i < 15; i++) {
            rand_letter = (char) (rand.nextInt(26) + 'a');
            name = name + Character.toString(rand_letter);
        }
        return name;
    }
    public static String gen_random_id() {
        Random rand = new Random();
        String number = "";
        char rand_digit;
        for(int i = 0; i < 15; i++) {
            rand_digit = (char) (rand.nextInt(10) + '0');
            number = number + Character.toString(rand_digit);
        }
        return number;
    }
}
