/**
 * Created By liuyao on 2018/3/29 19:58.
 */
public class BinarySearch {

    public static int rank(int key,int[] a){
        int lo=0;
        int hi=a.length-1;
        while (lo <= hi){
            int mid=lo+(hi-lo)/2;
            if (key < a[mid]){
                hi=mid-1;
            }else if (key > a[mid]){
                lo=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1,2,2,3,4,5,6,6,7,7,7,7,8};
        System.out.println(rank(6,a));
    }
}
