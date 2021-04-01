package ua.kiev.prog.automation.ui.zvisno.utils;

import ua.kiev.prog.automation.ui.zvisno.utils.DBModel;

import java.util.Random;

public class Utils {
    final static public DBModel db = new DBModel();

    static public String genRandString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
