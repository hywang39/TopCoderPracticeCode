public class ABBA{
    
    public static void main(String[] args){
        ABBA test = new ABBA();
        System.out.println(test.canObtain("BBAB","ABABABABB"));
    }
    
    // a recursion function reducing target string to initial string each iteration, slicing out the last character in the string
    public String canObtain(String initial, String target){
        if (initial.length() == target.length()){
            //have to use .equals instead of ==, since "==" checks reference in memory which will always be false
            if (initial.equals(target)){
                return "Possible";
            }
            else {
                return "Impossible";
            }
        }
        else {
            if (target.charAt(target.length()-1) == 'A'){
                return canObtain(initial, target.substring(0,target.length()-1));
            }
            else{
                StringBuilder sb =  new StringBuilder();
                sb.append(target.substring(0,target.length()-1));
                return canObtain(initial, sb.reverse().toString());
            }
        }
    }
}
