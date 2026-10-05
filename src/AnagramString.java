public class AnagramString {
    static void main() {
        String a="deepak";
        String b="deepak";

        int[] count=new int[26];

        if(a.length()!=b.length())  System.out.print("Not Anagram");


        for(int i=0;i<a.length();i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }


        for(int x:count){
            if(x!=0) System.out.print("Not Anagram");
        }

        System.out.print("Anagram");




    }
}
