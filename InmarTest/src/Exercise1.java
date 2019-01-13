import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class Exercise1 {
  public String Prefix;
  public String Suffix;
  public String st; 
  public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			
	             + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
@Test(priority=1)
  //Write a program to check if prefix and suffix of a string is a palindrome

  public void ToCheckPrefixSuffixPalindrome() {
	 // String test = "avhvhvsv";
	System.out.println("Enter the Expression to evaluate");
	Scanner scanner = new Scanner(System.in);
	String Expression = scanner.nextLine();
	  String Pre = GetPrefix(Expression, 3);
	  String Suff = GetSuffix(Expression,9 );
	  CheckPalindrome(Pre);
	  CheckPalindrome(Suff);
  }
  

	
	  @Test(priority=2) //Write a program to check if prefix and suffix of a string
	  //is a palindrome
	  
	  public void SortingUserBased() { 
	  sortArray("Descending"); 
	  }
	 

@Test(priority=3) //Write a program that returns the count of each word in the file.

public void FindCountofWords()
{
	try {
		String Expression = ReadData();
		String Rep = Expression.replace(",", "");
        String[] words = Rep.split(" ");
        
        int TotalWords = words.length;
        System.out.println("array is "+Arrays.toString(words));
        for (int i =0;i<TotalWords-1;i++)
        {
        	int count = 0;
        	for (int j=i+1;j<TotalWords;j++)
        	{
        		
        	if (words[i].trim().equals(words[j].trim()))
        	{
        		count++;
        		
        	}
        	
        	}
        	System.out.println("Total occurrence of word "+words[i]+" in file is :-"+count+1);
        }

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	


	  public String GetPrefix(String Exp,int Index) 
	  { 
		  try { 
			  if (!Exp.isEmpty() | Exp != null) 
			  { 
				  Prefix = Exp.substring(0, Index); 
			  }
	  
	  } catch(NullPointerException e) {
	  System.out.println("Null pointer exception");
	  } 
		  return Prefix;
	  }
	  
	  public String GetSuffix(String Exp,int Index) 
	  {
	    try
	  {
		  if (!Exp.isEmpty() | Exp != null) 
		  { 
			  int Length = Exp.length(); Suffix = Exp.substring(Index,Length);
		  }
	  
	  } catch(NullPointerException e) {
	  System.out.println("Null pointer exception"); }
	  
	  return Suffix;
	  
	  }
	  
	  public void CheckPalindrome(String Value)
	  {
		      String reverse = ""; // Objects of String class  
		      int length = Value.length();   
		      for ( int i = length - 1; i >= 0; i-- )  
		         reverse = reverse + Value.charAt(i);  
		      if (Value.equals(reverse))  
		         System.out.println("Entered string "+Value+" is a palindrome.");  
		      else  
		         System.out.println("Entered string "+Value+" isn't a palindrome.");   
		   }    
	  
	  //public void sortArray(String[] Array, String Preference)
	
	  public void sortArray(String Preference)
		{
		  	System.out.println("Enter the Array");
			Scanner scanner = new Scanner(System.in);
			String Exp = scanner.nextLine();
			String[] Names = Exp.split(" ");
			if (Preference.equalsIgnoreCase("Ascending"))
			{
				Arrays.sort(Names);
				System.out.println("String is sorted as below");
				printArray(Names);
			}
			if (Preference.equalsIgnoreCase("Descending"))
			{
				Arrays.sort(Names, Collections.reverseOrder());
				System.out.println("String is sorted as below");
				printArray(Names); 
			}
	  }

 public static void printArray(String[] anArray) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < anArray.length; i++) {
	if (i > 0) {
			   sb.append(", ");
			   }
			         sb.append(anArray[i]);
			      }
			      System.out.println(sb.toString());
			   }
			
 public String ReadData()throws Exception 
 { 
 
	 String basePath = new File("").getAbsolutePath();
	    System.out.println(basePath);
	    String Exp = "";
	    String path = new File("src/resources/Data.txt").getAbsolutePath();
	                                                           
 File file = new File(path); 
 
 BufferedReader br = new BufferedReader(new FileReader(file)); 
 
 
 while ((st = br.readLine()) != null) 
  // return st;
 {
	 System.out.println(st);
	 Exp = Exp+st;
 }
 return Exp; 
 } 				  

 public static boolean isValid(String email) 
 { 
     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                         "[a-zA-Z0-9_+&*-]+)*@" + 
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                         "A-Z]{2,7}$"; 
                           
     Pattern pat = Pattern.compile(emailRegex); 
     if (email == null) 
         return false; 
     return pat.matcher(email).matches(); 
 } 

 @Test(priority=4)
 public static void ValidateMailID() 
 { 
     // email = "contribute@geeksforgeeks.org"; 
	 System.out.println("Enter the mail id to validate");
		Scanner scanner = new Scanner(System.in);
		String email = scanner.nextLine();
     if (isValid(email)) 
         System.out.print("Yes mail id :"+email+" is valid"); 
     else
         System.out.print("No mail id :"+email+" is not valid"); 
 } 
 
 
@Test (priority=5)
 public void ParseCSVFile()
 
 {
	 String basePath = new File("").getAbsolutePath();
	    System.out.println(basePath);
	    String Exp = "";
	    String csvFile = new File("src/resources/TestCSV.csv").getAbsolutePath();
     BufferedReader br = null;
     String line = "";
     String cvsSplitBy = ",";

     try {

         br = new BufferedReader(new FileReader(csvFile));
         while ((line = br.readLine()) != null) {

             
             String[] country = line.split(cvsSplitBy);

             System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

         }

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } finally {
         if (br != null) {
             try {
                 br.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
 }
 
@Test (priority=6)
public void ParseCSVFileUit()

{
	String line = "\"10\",\"AU\",\"Aus\"\"tralia\"";
    List<String> result = CSVUtils.parseLine(line);
    assertTrue(result.get(0).equals("10"));
	assertTrue(result.get(1).equals("AU"));
//	assertTrue(result.get(2).equals("Aus"));
	//assertTrue(result.get(2).equals("Aus\\\"tralia"));
} 

public static class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public static void main(String[] args) throws Exception {

        String csvFile = "/Users/mkyong/csv/country2.csv";

        Scanner scanner = new Scanner(new File(csvFile));
        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine());
            System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
        }
        scanner.close();

    }

    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

}
 

} 


	 


