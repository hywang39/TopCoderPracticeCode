import java.util.Arrays;
import java.util.ArrayList;

public class MakePalindrome{
    public static void main(String[] args){
        MakePalindrome mp = new MakePalindrome();
        String[] res = mp.constructMinimal("sdsdxg");
        for(String each: res){
            System.out.println(each);
        }
    }

    public String[] constructMinimal(String card){
        char[] charArray = card.toCharArray();
        String[] stringSet = new String[card.length()];
        
        Arrays.sort(charArray);
        //sort the array first, to make counting with less complexity

        int counter = 1;   
        ArrayList<String> evenStrings = new ArrayList<String>();
        ArrayList<String> oddStrings = new ArrayList<String>();

        for(int i=0; i<=charArray.length-1;i++){
            if (charArray.length ==1){
                stringSet[0] = new String(""+charArray[0]);
                return (stringSet);
            }
            //special case when the number of char is 1, since some place compares i+1 and i

            if (i!=charArray.length-1){
                if (charArray[i]==charArray[i+1]){
                    counter += 1;
                    continue;
                }
                else{
                    String temp = "";
                    for (int j=0; j<=counter-1; j++){
                        temp += charArray[i];
                    }
    
                    if (counter%2!=0){
                        oddStrings.add(temp);                    
                        }
                    else{
                        evenStrings.add(temp);
                    }
                    counter = 1;
                }
            }
            else
            
            {
                if (charArray[i]==charArray[i-1])
                {
                    String temp = "";
                    for (int j=0; j<=counter-1; j++){
                        temp += charArray[i];
                    }

                    if (counter%2!=0){
                        oddStrings.add(temp);                    
                        }
                    else{
                        evenStrings.add(temp);
                    }
                }

                else
                {
                    String temp2 = "";
                    temp2 += charArray[i];
                    oddStrings.add(temp2);
                }

            }

        }
        //group them into two lists, with either odd length or even length, then combining them back together.
        
        if(oddStrings.size()!=0){
            String newString = oddStrings.get(0);
            for (String string: evenStrings){
                String appendString = string.substring(string.length()/2);
                String prependString = string.substring(0,string.length()/2);
                newString = prependString + newString + appendString;
            }
            oddStrings.set(0,newString);
            //if there is at least one odd string, the old string will be center piece and all the even string will be seperated in pairs, the prepend and append the parts.
        }
        
        else
        {
            String newString = evenStrings.get(0);
            for (String string: evenStrings.subList(1,evenStrings.size()-1)){
                String appendString = string.substring(string.length()/2);
                String prependString = string.substring(0,string.length()/2);
                newString = prependString + newString + appendString;                
            }
            oddStrings.add(newString);
            //if there is no oddStrings, there would only be one big string made with all the even strings, store it in the empty odd strings for convinence.

        }
        
        stringSet = oddStrings.toArray(new String[oddStrings.size()]);    
        //use toArray built in method to transform array to arraylist, we don't need to write an iteration.               
        return stringSet;
        //***********************the solution is not very efficient and elegant, come back later********************
    }

    
}