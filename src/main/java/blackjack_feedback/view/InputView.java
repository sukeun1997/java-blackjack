package blackjack_feedback.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String BETMONEY_REQUEST_MESSAGE = "의 배팅 금액은?";
    static Scanner sc = new Scanner(System.in);

    public static String[] createGamers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        String gamers = sc.nextLine();
        if (!validationName(gamers)) {
            throw new IllegalArgumentException("이름이 옳바르지 않습니다.");
        }
        return gamers.split(",");
    }

    private static boolean validationName(String gamers) {

        Pattern pattern = Pattern.compile("([a-zA-Z]*)(,([a-zA-Z]+))*");
        Matcher matcher = pattern.matcher(gamers.trim());

        if (matcher.find()) {
            if (matcher.group().equals(gamers)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static int betMoney(String name) {
        System.out.println("\n"+ name + BETMONEY_REQUEST_MESSAGE);
        int money = sc.nextInt();
        if (money < 1 && money >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("배팅 머니는 0 이상 " + Integer.MAX_VALUE + " 이하의 값만 입력 가능합니다.");
        }
        return money;
    }

    public static int betMoney(int Money) {
        int money = Money;
        if (money < 1 && money >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("배팅 머니는 0 이상 " + Integer.MAX_VALUE + " 이하의 값만 입력 가능합니다.");
        }
        return money;
    }

}
