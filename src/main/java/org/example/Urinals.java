package org.example;
import java.io.*;
import java.util.Scanner;
public class Urinals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ster;
        System.out.println(" enter the input");
        ster = sc.nextLine();

        //System.out.println(output);

        System.out.println("enter option");
        int opt = sc.nextInt();
        if (opt == 1) {
            int output = COUNT_OPTIONS(ster);
            System.out.println(output);
        }
        else {
            try {
                FileReader file = new FileReader(new File("urinal.dat"));
                File myObj = new File("urinal.dat");
                BufferedReader br = null;
                br = new BufferedReader(file);
                //int j=0, c=0;
                File fout = new File("rule.txt");
                if (!fout.exists()) {
                    fout.createNewFile();

                }

                FileWriter fw = new FileWriter(fout.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(fw);
                while (true) {
                    String temp = br.readLine();
                    if (temp == null) break;
                    int val = COUNT_OPTIONS(temp);
                    //    System.out.println(val);
                    bw.write(Integer.toString(val));
                    bw.newLine();
                }
                br.close();
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
                // i=getUrinals(null);
            }
        }

    }
    public static boolean goodString( String str )
    {  // checks to see if valid string
        boolean gs=false;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0'||str.charAt(i)=='1')
            {
                gs=true;
            }
            else {
                gs=false;
                break;
            }
        }
        return gs;
    }


    public static int COUNT_OPTIONS(String s) {

        int c_zero = 0, cone=0,count = 0;
        char[] str= new char[s.length()];
        for(int i=1;i<str.length;i++) {
            if(s.contains("11")) {
                System.out.println("string formatting error");
                return -1;
            }
        }
        if(!s.contains(("1"))){
            return (s.length()+1)/2;
        }
        for(int i=0;i< s.length();i++) {
            str[i]=s.charAt(i);
        }
        int i=0;
        while(i<str.length){
            if(str[i]=='0')
                c_zero++;
            else {
                count = count + (c_zero-cone)/2;
                c_zero=0;
                cone=1;
            }
            i++;

        }
        count = count + c_zero/2;
        return count;
    }
}



