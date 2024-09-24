package learning.java.concepts.io;

import java.util.*;
import java.io.*;

/**

Kattis has started a new hobby, postcard collection.
She strives to collect postcards for as many unique cities as possible every year.
She already has a few years’ collection.
Can you tell her how many unique cities these postcards come from?

Input
The first line of input contains a single positive integer 
 indicating the number of years to investigate. Then follows, for each year, a line with a single positive integer 
 indicating the number postcards from that year. The following 
 lines describe the city each postcard comes from.
 The ith such line simply contains the name of the city of the  ith postcard.

The names of the cities are normalized to make processing easier:
city names only contain lowercase English letters, have at least one letter, and do not contain spaces.

The number of postcards is at most 100 and no city name contains more than 20 characters.

Output
For each year,
simply output a single line containing a single integer that is the number of distinct
cities that Kattis has gathered postcards from this year.

Sample Input 1
2
7
saskatoon
toronto
winnipeg
toronto
vancouver
saskatoon
toronto
3
edmonton
edmonton
edmonton

Sample Output 1
4
1
*/

public class ProblemPostCardUniqueCities {
    
    public static void main(String[] args) {
        
        //Reading file from current directory
        try (Scanner sc = new Scanner(new File("E:\\projects\\tousif\\data-structures-and-algorithms\\src\\main\\java\\learning\\java\\code\\snippets\\everywhere-01.in"));
            PrintWriter wr = new PrintWriter(new File("E:\\projects\\tousif\\data-structures-and-algorithms\\src\\main\\java\\learning\\java\\code\\snippets\\everywhere-01.ans"))) {

        	wr.println();
        	
            int years = sc.nextInt();
    
            for(int year = 0; year < years; year++) {
                
                int totalCards = sc.nextInt();
                HashSet<String> cities = new HashSet<>();
                
                for(int i = 0; i < totalCards; i++) {
                    String city = sc.next();
                    cities.add(city);
                }
                
                System.out.println(cities.size());
                wr.println(cities.size());
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}