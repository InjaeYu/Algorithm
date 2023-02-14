import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String[][] book_time) throws ParseException {
        int roomCount = 0;
        List<Long> readyTime = new ArrayList<>(book_time.length);
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");

        Arrays.sort(book_time, (l, r) -> {
            try {
                return (int) (s.parse(l[0]).getTime() - s.parse(r[0]).getTime());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        for (String[] time : book_time) {
            readyTime.add(s.parse(calcCleaning(time)).getTime());
        }
        Collections.sort(readyTime);

        for (String[] time : book_time) {
            Long startTime = s.parse(time[0]).getTime();
            if(readyTime.get(0) <= startTime) {
                readyTime.remove(0);
            } else {
                roomCount += 1;
            }
        }

        return roomCount;
    }

    public static String calcCleaning(String[] time) {
        String[] endTime = time[1].split(":");

        int hour = Integer.parseInt(endTime[0]), min = Integer.parseInt(endTime[1]) + 10;

        if (min >= 60) {
            min -= 60;
            hour += 1;
        }

        return String.format("%02d:%02d", hour, min);
    }
}