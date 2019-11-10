package com.tmp;


public class Main {

    public static void main(String[] args) {

        HashMapTest<String,String> mapTmp= new HashMapTest<String,String>();
        mapTmp.put("2","2");

        System.out.println("length22222222:"+mapTmp.getTable().length);
        mapTmp.put("3","2");
        mapTmp.put("4","2");
        mapTmp.put("5","2");
        mapTmp.put("6","2");
        mapTmp.put("7","2");
        mapTmp.put("8","2");
        mapTmp.put("9","2");
        mapTmp.put("10","2");
        mapTmp.put("11","2");
        mapTmp.put("12","2");
        mapTmp.put("13","2");
        mapTmp.put("14","2");
        mapTmp.put("15","2");
        mapTmp.put("16","2");
        mapTmp.put("17","2");
        mapTmp.put("17222222323424321dfsasdfsadfsadf","2");
        mapTmp.put("17222222323424321dfsasdfsadfsadf1111111111111111111111111111111111111111111111","2");
        mapTmp.put("1","2");

        int tab_len=mapTmp.getTable().length;
        int hash = mapTmp.getHash("17222222323424321dfsasdfsadfsadf");
        int i = (tab_len-1)&hash;
        System.out.println("length:"+tab_len);
        System.out.println("hash:"+hash);
        System.out.println("index:"+i);
        System.out.println("123455:"+mapTmp.getTable()[i]);

        System.out.println(mapTmp.get("3"));
    }
}
