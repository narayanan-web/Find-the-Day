import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) 
    {
        int odd=0;
        int t2,t3;
        int leap=0;
        if(year%4==0 && year%100!=0)
            leap=1;
        if(year%4==0 && year%400==0)
            leap=1;
        year-=1;
        if(year<=2399)
            year-=2000;
        else if(year<=2799)
            year-=2400;
        else
            year-=2800;
        if(year>=100)
        {
            int t=year/100;
            odd=5*t;
            year%=100;
        }
        t2=year/4;
        t3=year-t2;
        odd+=(t2*2+t3*1);
        odd%=7;
        for (int i=1;i<month;i++)
        {
            if(i==1 || i==3 || i==5 || i==7 || i==9 || i==11 )
                odd+=31;
            else if(i==2)
            {
                if(leap==1)
                    odd+=29;
                else
                    odd+=28;
            }
            else
                odd+=30;
        }
        odd+=day;
        odd%=7;
        switch(odd)
        {
            case 0 :
                return "SUNDAY";
            case 1 :
                return "MONDAY";
            case 2 :
                return "TUESDAY";
            case 3 :
                return "WEDNESDAY";
            case 4 :
                return "THURSDAY";
            case 5 :
                return "FRIDAY";
            case 6 :
                return "SATURDAY";
            default :
                return "WRONG INPUT";
        }

    }

}

public class Solution {
