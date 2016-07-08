public class GreetMe {

    public String greet(String name) {
        String greet = "";
        name = name.toLowerCase();
        String firstLetter = name.substring(0, 1);
        greet = name.replaceFirst(firstLetter, "Hello " + firstLetter.toUpperCase()) + "!";
        return greet;
    }
}