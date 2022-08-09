public class Part2{

    public static int howMany(String stringa, String stringb){
        // how many times stringa appears in stringb
        int count = 0;
        int index = 0;
        while (index < stringb.length()) {
            index = stringb.indexOf(stringa, index);
            if (index == -1) {
                break;
            }
            count++;
            index += stringa.length();
        }
        //print 'stringa' appears 'count' times in 'stringb'
        System.out.println(stringa + " appears " + count + " times in " + stringb);
        return count;
    }

    public static void testHowMany(){
        howMany("GAA", "ATGAACGAATTGAATC");
        howMany("AA", "ATAAAA");
        howMany("A", "");
        howMany("", "A");
        //howMany("AA", "A"); <- should throw an exception, infinite loop?
    }

    public static void main(String[] args){
        testHowMany();
    }
}