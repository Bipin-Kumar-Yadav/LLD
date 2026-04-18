package SingletonPattern.Logger;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter info message:");
        String infoMessage = sc.nextLine();
        logger.info(infoMessage);
        System.out.println("Enter warn message:");
        String warnMessage = sc.nextLine();
        logger.warn(warnMessage);
        System.out.println("Enter error message:");
        String errorMessage = sc.nextLine();
        logger.error(errorMessage);
        sc.close();
    }
}
