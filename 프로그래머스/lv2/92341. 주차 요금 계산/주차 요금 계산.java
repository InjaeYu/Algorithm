import java.util.*;
import java.time.LocalTime;
import java.time.Duration;


class Solution {
    final Map<String, LocalTime> enterRecords = new HashMap<>();
    final Map<String, Integer> parkingTimeRecords = new HashMap<>();
    static String lastTime = "23:59";
    int defaultTime;
    int defaultCost;
    int unitTime;
    int unitCost;
    
    public int[] solution(int[] fees, String[] records) {
        initData(fees);
        
        for(String record : records) {
            String[] splitRecord = record.split(" ");
            String inOutTime = splitRecord[0];
            String carNumber = splitRecord[1];
            String inOrOut = splitRecord[2];
            
            if (inOrOut.equals("IN")) {
                inCar(carNumber, inOutTime);
            } else if (inOrOut.equals("OUT")) {
                outCar(carNumber, inOutTime);
                enterRecords.remove(carNumber);
            }
        }
        
        calcLastOut();
        
        return calcParkFee();
    }
    
    private void initData(int[] fees) {
        defaultTime = fees[0];
        defaultCost = fees[1];
        unitTime = fees[2];
        unitCost = fees[3];
    }
    
    private void inCar(String carNumber, String inTime) {
        if(enterRecords.containsKey(carNumber)) return;
        LocalTime enterTime = LocalTime.parse(inTime);
        enterRecords.put(carNumber, enterTime);
    }
    
    private void outCar(String carNumber, String outTime) {
        if(!enterRecords.containsKey(carNumber)) return;
        int previousTime = parkingTimeRecords.getOrDefault(carNumber, -defaultTime);
        LocalTime leaveTime = LocalTime.parse(outTime);
        int parkingTime = ((int)Duration.between(enterRecords.get(carNumber), leaveTime).getSeconds() / 60);
        
        parkingTimeRecords.put(carNumber, previousTime + parkingTime);
    }
    
    private void calcLastOut() {
        for(String carNumber : enterRecords.keySet()) {
            outCar(carNumber, lastTime);
        }
    }
    
    private int[] calcParkFee() {
        List<String> keyList = new ArrayList<>(parkingTimeRecords.keySet());
        
        keyList.sort(String::compareTo);
        
        return keyList.stream().map(key -> {
            double parkingTime = parkingTimeRecords.get(key);
            if(parkingTime <= 0) return defaultCost;
            return defaultCost + ((int)Math.ceil((parkingTime / unitTime)) * unitCost);
        })
            .mapToInt(i -> i)
            .toArray();
    }

}