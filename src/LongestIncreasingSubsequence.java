public class LongestIncreasingSubsequence {
    static void main() {
        int[] arr=new int[]{2,3,5,2,3,4,5,6,74,6,3};
        int res=0;
        int len=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                len++;
            }else{
                res=Math.max(len,res);
                len=0;
            }
        }
        System.out.println(res+1);
    }
}
