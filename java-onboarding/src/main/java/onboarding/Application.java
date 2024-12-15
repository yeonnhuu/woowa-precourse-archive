package onboarding;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = "abcz";
        for (Character c : str.toCharArray()) {
            System.out.println(c.charValue());
            int index = 'Z'-((int)c-'A');
            System.out.println((char)index);
        }
    }
}
