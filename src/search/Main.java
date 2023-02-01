package search;

public class Main {

    public static void main(String[] args) {
        String fileName;
        if (args.length == 2 && "--data".equals(args[0])) {
            fileName = args[1];
        } else {
            fileName = "text.txt";
        }
        Engine.start(fileName);
    }
}
