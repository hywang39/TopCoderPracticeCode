import java.util.Arrays;
public class TopXorer {
    public static void main(String args[]) {
        TopXorer topXorer = new TopXorer();
        int[] testArray = {7,4,12,33,6,8,3,1};
        System.out.println(topXorer.maximalRating(testArray));
    }
    
    public int MaxXOR(int larger, int smaller){
        
        if (smaller==0){
            return larger;
        }
        //special case when the smaller == 0

        int small_transformed;
        int bitFlip = (~larger)<< 32-Integer.toBinaryString(larger).length()>>32-Integer.toBinaryString(larger).length();
        //omit any digit extra of the digit of the binary string, so that the flipped number will still be unsigned
        if (bitFlip <= smaller){
            small_transformed = (bitFlip);
        }
        else {            
            small_transformed = (bitFlip)&smaller;
            //leave the intersection of bitFlip & smaller so the smaller transformed to new integer which complement the larger
        }

        larger = larger ^ small_transformed;

        return larger;
    }

    public int maximalRating(int[] x){
        Arrays.sort(x);
        int larger = x[x.length-1];                
        for(int i = x.length-2; i>=0; i--){
            larger = this.MaxXOR(larger,x[i]);
        }
        //firstly sort the Array
        return larger;
    }
}
