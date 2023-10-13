import java.util.*;

public class Test40 {
    public static void main(String[] args) {
        //HashMap<String, ArrayList> caterpillar = new HashMap();
        HashSet set = new HashSet<>();
        addWord(set, "sfgdsfg");


    }

    private static void addWord(HashSet set, String str) {
        if (str.length() == 0 || str == null) {
            return;
        }
        //ArrayList list;
        //if (str.length() == 1) {



            //caterpillar.put(str, list);
        //}
        String[] arr = str.split("");
        /*for(String s : arr){
            caterpillar.put()
        }*/
        //Map o = caterpillar;
        for (int i = 0; i < arr.length; i++) {
            /*if (i < arr.length - 1) {
               o.put(arr[i], Arrays.copyOfRange(arr, 1, arr.length - 1));
            }*/
            /*if (set.contains(arr[i])){
                set = (ArrayList) set..get(arr[i]);
            } else {
                list = new ArrayList();
                list.add(arr[i]);
            }*/
        }
    }
}
