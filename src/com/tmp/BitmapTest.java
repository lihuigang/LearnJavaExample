package com.tmp;

public class BitmapTest {

    private short[] bitmap;
    private short[] num;


    private  short calcElemIndex(short num){
        return (short)(num>>5);
    }





    //²åÈë
    public void set(short num) {
        //System.out.println(bitmap.length);
        if (num >=0) {
            short elemIndex = calcElemIndex(num);
            //Integer byteIndex = calcBitIndex(num);
            bitmap[elemIndex] =(short) (bitmap[elemIndex] |(1l << num));
        }
    }

    public void  removeNum(short num) {

        short elemIndex = calcElemIndex(num);
        //Integer byteIndex = calcBitIndex(num);
        bitmap[elemIndex] = (short) (bitmap[elemIndex] & (~(1l << num)));


    }

    public boolean containsNum (short num){
        short elemIndex = calcElemIndex(num);
        //Integer byteIndex = calcBitIndex(num);

        if ((bitmap[elemIndex] & (1l << (num))) == 0 ) {
            return false;
        }else{
            return true;
        }

    }

    public void set(int num){
       int a=num>>16;
       int b=num&32767;

    }
}
