import java.util.Random;

public class HelperFunctions {
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
}
