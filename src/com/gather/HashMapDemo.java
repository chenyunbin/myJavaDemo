package com.gather;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String,String> map = new HashMap<String,String>(100,0.75f);
        map.put("str1","value1");
        Class<?> cla = map.getClass();
        System.out.println(cla);
        Field[] fields = cla.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            System.err.println(fields[i]);
        }
        Field field = cla.getDeclaredField("threshold");
        field.setAccessible(true);
        System.out.println(field.getInt(map));
        System.out.println(tableSizeFor(100));
        String name = new String("lisi");
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
