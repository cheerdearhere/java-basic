package step03_middleClass.chapter06_DateTime.timezone;

import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

public class ZoneIdMain {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        int count = 0;
        System.out.println("### Available ZoneIds");
        for(String zoneId : availableZoneIds) {
            count++;
            System.out.println("\t"+count+". "+zoneId+": "+ZoneId.of(zoneId).getRules());
        }
        System.out.println("input ZoneID - "+ZoneId.of("Asia/Seoul").getRules());
        //input ZoneID - ZoneRules[currentStandardOffset=+09:00]

        ZoneId sysDefault = ZoneId.systemDefault();
        System.out.println("### System Default: zoneId - "+sysDefault + " | "+sysDefault.getRules());
    }
}
