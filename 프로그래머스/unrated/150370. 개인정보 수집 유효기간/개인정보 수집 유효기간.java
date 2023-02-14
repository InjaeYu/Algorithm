import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> termsMap = new HashMap<>();
        for (String s : terms) {
            String[] ss = s.split(" ");
            termsMap.put(ss[0].charAt(0), Integer.parseInt(ss[1]));
        }

        int index = 1;
        for (String s : privacies) {
            String[] ss = s.split(" ");
            String date = calcDate(ss[0], termsMap.get(ss[1].charAt(0)));
            if (checkLimitDate(today, date)) {
                result.add(index);
            }
            index += 1;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private String calcDate(String date, int terms) {
        String[] splitDate = date.split("\\.");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);

        month += terms;
        if (month > 12) {
            year += month / 12;
            month %= 12;
            if(month == 0) {
                month = 12;
                year -= 1;
            }
        }

        return String.format("%d.%02d.%02d", year, month, day);
    }

    private boolean checkLimitDate(String today, String privacies) {
        String[] splitToday = today.split("\\.");
        int todayYear = Integer.parseInt(splitToday[0]);
        int todayMonth = Integer.parseInt(splitToday[1]);
        int todayDay = Integer.parseInt(splitToday[2]);

        String[] splitPrivacies = privacies.split("\\.");
        int privaciesYear = Integer.parseInt(splitPrivacies[0]);
        int privaciesMonth = Integer.parseInt(splitPrivacies[1]);
        int privaciesDay = Integer.parseInt(splitPrivacies[2]);

        if (todayYear > privaciesYear) {
            return true;
        }

        if (todayYear == privaciesYear && todayMonth > privaciesMonth) {
            return true;
        }

        return todayYear == privaciesYear && todayMonth == privaciesMonth && todayDay >= privaciesDay;
    }
}