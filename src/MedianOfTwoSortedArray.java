public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        for(int k = 0; k < merge.length; k++){
            int num1, num2;
            if(i < nums1.length){
                num1 = nums1[i];
            } else {
                num1 = Integer.MAX_VALUE;
            }
            if(j < nums2.length){
                num2 = nums2[j];
            } else {
                num2 = Integer.MAX_VALUE;
            }
            if(num1 <= num2){
                merge[k] = num1;
                i++;
            } else {
                merge[k] = num2;
                j++;
            }
        }
        if(merge.length % 2 == 1){
            return merge[merge.length/2];
        } else {
            return (merge[merge.length/2-1] + merge[merge.length/2])/2.0;
        }
    }
}
