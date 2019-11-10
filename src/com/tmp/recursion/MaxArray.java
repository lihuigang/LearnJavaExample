package com.tmp.recursion;

public class MaxArray {

    class InfoA{
        private int maxLeft;
        private int maxRight;
        private int sum;

        public InfoA(int maxLeft,int maxRight,int sum){
            this.maxLeft=maxLeft;
            this.maxRight=maxRight;
            this.sum=sum;
        }

        public int getMaxLeft(){
            return this.maxLeft;
        }

        public int getMaxRight(){
            return this.maxRight;
        }


        public int getSum(){
            return this.sum;
        }
    }




    public InfoA getInfo(int[] a,int low,int mid,int high){


        int maxLeft=-1;
        int maxRight=-1;
        int left_sum=-10000;
        int right_sum=-10000;
        int sum=0;
        for (int i=mid;i>=low;i--){
            sum+=a[i];
            if (sum>left_sum){
                left_sum=sum;
                maxLeft=i;
            }
        }

        sum=0;
        for (int i=mid+1;i<=high;i++){
            sum+=a[i];
            if (sum>right_sum){
                right_sum=sum;
                maxRight=i;
            }
        }
        return new InfoA(maxLeft,maxRight,left_sum+right_sum) ;
    }


    public InfoA getMax(int[] a,int low,int high){

        if (low == high){
            return new InfoA(low,high,a[low]);
        }else{
            int mid=(low+high)/2;
            InfoA leftInfo=getMax(a,low,mid);
            InfoA rightInfo=getMax(a,mid+1,high);
            InfoA crossInfo=getInfo(a,low,mid,high);
            if(leftInfo.getSum()>=rightInfo.getSum()&&leftInfo.getSum()>=crossInfo.getSum()){
                return leftInfo;
            }else if(rightInfo.getSum()>=leftInfo.getSum()&&rightInfo.getSum()>=crossInfo.getSum()){
                return rightInfo;
            }else{
                return crossInfo;
            }
        }
    }

    public static void main(String[] args){

        MaxArray aa= new MaxArray();
        int[] a = {-7,-2,-1,-4,-9,-2,-3,-9};
        InfoA infoA=aa.getMax(a,0,7);
        System.out.println(infoA.getSum());
        System.out.println(infoA.getMaxLeft());

    }
}
