package hellojpa;

import org.hibernate.internal.build.AllowSysOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class test {
    public static void main(String[] args){
       System.out.println(781*5);
    }

    /*public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            answer+= A[i]*B[B.length-1-i];
        }

        return answer;
    }*/

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String[] file1 = detach(s);
                String[] file2 = detach(t1);

                int head = file1[0].compareTo(file2[0]);

                if(head==0){
                    int no1 = Integer.parseInt(file1[1]);
                    int no2 = Integer.parseInt(file2[1]);

                    return no1 - no2;
                }else{
                    return head;
                }
            }

            private String[] detach(String str) {
                String head = "";
                String number = "";
                String tail = "";

                int idx = 0;
                for(; idx<str.length(); ++idx){
                    char ch = str.charAt(idx);
                    if(ch >= '0' && ch<= '9')
                        break;
                    head += ch;
                }
                for(; idx<str.length(); ++idx){
                    char ch = str.charAt(idx);
                    if(!(ch >= '0' && ch<= '9'))
                        break;
                    number += ch;
                }
                for(; idx<str.length(); ++idx){
                    char ch = str.charAt(idx);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};
                return file;
            }
        });


        return files;
    }
}
