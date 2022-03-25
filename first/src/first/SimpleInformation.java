package first;

import java.util.Locale;

public class SimpleInformation {
    public static void main(String[] args) {
        String s = "to!refrain!from!imitation!is!the!best!revenge.     ";

        s = s.substring(0, 1).toUpperCase() + s.substring(1).replace("!", " ").strip();

        String answer = "To refrain from imitation is the best revenge.";
        if (answer.equals(s))
            System.out.println("well done");
        else
            System.out.println("ju dum lol");
        System.out.println(s+'|');
    }
}
