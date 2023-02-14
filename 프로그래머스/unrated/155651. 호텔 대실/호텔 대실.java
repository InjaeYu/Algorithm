import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int roomCount = 0;
        List<Integer> readyTime = new ArrayList<>(book_time.length);

        Arrays.sort(book_time, Comparator.comparingInt(l -> convertStringToLong(l[0])));

        for (String[] time : book_time) {
            readyTime.add(convertStringToLong(calcCleaning(time)));
        }
        Collections.sort(readyTime);

        for (String[] time : book_time) {
            int startTime = convertStringToLong(time[0]);
            if (readyTime.get(0) <= startTime) {
                readyTime.remove(0);
            } else {
                roomCount += 1;
            }
        }

        return roomCount;
    }

    private String calcCleaning(String[] time) {
        String[] endTime = time[1].split(":");

        int hour = Integer.parseInt(endTime[0]), min = Integer.parseInt(endTime[1]) + 10;

        if (min >= 60) {
            min -= 60;
            hour += 1;
        }

        return String.format("%02d:%02d", hour, min);
    }

    private int convertStringToLong(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }
}