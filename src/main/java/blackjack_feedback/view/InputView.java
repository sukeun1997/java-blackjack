package blackjack_feedback.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

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

}
