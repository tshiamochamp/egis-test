/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        writeFile();
    }
    
    public static void writeFile()
    {
        
    try
    {
        FileWriter fr = new FileWriter("Output.txt");
        PrintWriter pr = new PrintWriter(fr);
        int w = readFile().size();
        pr.println(rmsValue((ArrayList)readFile(),w));
        pr.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error"+ ex);
    }
    
    }
    
    public static List<Integer> readFile()
    {
        
        List<Integer> digits = new ArrayList<>();
        
        try 
        {
                       
            File file = new File("C:\\Users\\USER\\Desktop\\test1\\input.txt");
            Scanner sc = new Scanner(file);
                        
            
            while(sc.hasNextLine())
            {
               
                String line = sc.nextLine();
                
               for(int i=0;i< line.length();i++)
               {
                   char check = line.charAt(i);
                   if( isDigit(check))
                   {
                       
                       int num = Character.getNumericValue(check);
                       if(line.charAt(i-1) == '-')
                       {
                          
                           num = num*-1;
                           
                       }
                       digits.add(num);
                               
                   }
               }               
               
            }
                        
        } 
        catch (Exception ex)
        {
             System.out.println("Error"+ ex);
        }
        
        return digits;
        
    }
    
    public static float rmsValue(ArrayList digits, int n)
    {
        int square = 0;
        float mean = 0;
        float root = 0;
        
        for(int i = 0; i<n; i++)
        {
            square += Math.pow((int)digits.get(i), 2);
        }
        
        mean = (square/(float)(n));
        root = (float)Math.sqrt(mean);
        
        return root;
        
    }
    
}
