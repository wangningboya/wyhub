package cn.wy.util;

import java.util.UUID;

public class RandomId {

    public static String getUUID32(){
        UUID uuid=UUID.randomUUID();
        String str=uuid.toString();
        String i=str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return i;
    }

}
