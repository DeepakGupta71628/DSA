public class MaximunCircularSubArray {
    static void main() {
        int[] arr=new int[] {2,3,-5,1,6,8,-10,-6,11};

        int totalSum=0;
        int maxSum=Integer.MIN_VALUE;
        int ctrSum=0;
        int ctrminSum=0;
        int minSum=Integer.MAX_VALUE;
        for(int x:arr){
            totalSum+=x;
            ctrSum+=x;
            maxSum=Math.max(ctrSum,maxSum);
            if(ctrSum<0) ctrSum=x;
            ctrminSum+=x;
            minSum=Math.min(minSum,ctrminSum);
            if(ctrminSum>0) ctrminSum=x;

        }

        System.out.println(Math.max(totalSum-ctrminSum,maxSum));

    }
}
