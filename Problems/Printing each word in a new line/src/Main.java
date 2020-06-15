import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordsArr = new String[5];
        for (int i = 0; i < wordsArr.length; i++) {
            wordsArr[i] = scanner.next();
        }
        for(String world : wordsArr) {
            System.out.println(world);
        }
    }
}