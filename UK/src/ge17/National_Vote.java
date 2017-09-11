package ge17;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class National_Vote extends JFrame{
	
	
	public National_Vote(){
		
		
	}
	
	
	protected static int[] seats = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};  

	
		
	public static void main(String[] args) {
		
		
		National_Vote w = new National_Vote(); 
		
		
		double[] popvote = {0,0,0,0,0,0,0,0,0,0,0,0,0}; 
		double[] popvote2015 = { 36.8, 30.5, 7.9, 12.6, 3.8, 4.7, 0.6, 0.6, 0.6, 0.3, 0.4, 0.2, 1}; 

		double tot = 0;

		System.out.println("Please enter the national vote:" );
		Scanner scan = new Scanner(System.in);		
		System.out.println("Conservatives");
		popvote[0] = scan.nextDouble();		
		System.out.println("Labour");
		popvote[1] = scan.nextDouble();		
		System.out.println("Liberal Democrates");
		popvote[2]  = scan.nextDouble();		
		System.out.println("UKIP ");
		popvote[3]  = scan.nextDouble();		
		System.out.println("Green Party");
		popvote[4]  = scan.nextDouble();	
		System.out.println("Scottish National Party");
		popvote[5]  = scan.nextDouble();		
		System.out.println("Plaid Cymru");
		popvote[6]  = scan.nextDouble();		
		System.out.println("Democratic Unionist party");
		popvote[7]  = scan.nextDouble();		
		System.out.println("Sinn Fein");
		popvote[8]  = scan.nextDouble();		
		System.out.println("Social Democratic Labour Party");
		popvote[9]  = scan.nextDouble();		
		System.out.println("Ulster Unionist Party");
		popvote[10]  = scan.nextDouble();		
		System.out.println("alliance");
		popvote[11]  = scan.nextDouble();		
		System.out.println("other");
		popvote[12]  = scan.nextDouble();
		
		scan.close();
		
		tot = popvote[0]  + popvote[1]  + popvote[2]  + popvote[3]  + popvote[4]  + popvote[5]  + popvote[6]  + popvote[7] + popvote[8] + popvote[9] +popvote[10] + popvote[11] + popvote[12]; 
		
	if(tot != 100){
		System.out.println( tot + " Total vote not rqual to 100");
	}
		
	

                String csvFile = "/Users/Niall_cunningham/Downloads/hocl-ge2015-results-summary.csv";
                BufferedReader br = null;
                String line = "	";
                String cvsSplitBy = ",";
                
                int p = 1;

                try {

                    br = new BufferedReader(new FileReader(csvFile));
                    while ((line = br.readLine()) != null) {

                        String[] vote = line.split(cvsSplitBy);
                        
                        double currentMax = 0;
                        int indexMax = 0;
                        int i = 0;
                        
                        double[] vote2017 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                        
                        
                        for(int q = 0; q < 12; q++){
                        
                        vote2017[q] = (Integer.parseInt(vote[q+15]) * (popvote[q] / popvote2015[q]));
                        
                        }
                        
                        
                		while(i<=12){
                			
                			if(currentMax < vote2017[i]){
                				
                				currentMax = vote2017[i];
                				indexMax = i;
                				
                			}
                			
                			i++;
                		}
                        
                		
                        seats[indexMax] = seats[indexMax] + 1;
                        
                        System.out.println("Con = " + vote2017[0] + " , Lab = " + vote2017[1] + " , Lib = " + vote2017[2] + " , ukip = " + vote2017[3] + " , Green = " + vote2017[4] + " , SNP = " + vote2017[5] + " , Plaid = " +"  " + vote2017[6] +" , DUP " + vote2017[7]+ " , Sinn féin " +vote2017[8] +" , SDLP " + vote2017[9] +" , UUP " + vote2017[10] + " , all " + vote2017[11] + " other  " + vote2017[12]  );
                        System.out.println(p + " Winner is " + indexMax);
                        p++;
                        
                        
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

                if(seats[3] != 0){
                seats[3] = seats[3] - 1;
                seats[12] = seats[12] + 1;

                }
                
                if(seats[7] != 0){
                    seats[7] = seats[7] - 1;
                    seats[12] = seats[12] + 1;
                    
                    }
                
                System.out.println("Con = " + seats[0] + " , Lab = " + seats[1] + " , Lib = " + seats[2] + " , ukip = " + seats[3] + " , Green = " + seats[4] + " , SNP = " + seats[5] + " , Plaid = " + seats[6]+ ",  DUP = " + seats[7]  + ",  SF = " + seats[8]  + ",  SDLP = " + seats[9] +  ",  UUP = " + seats[10] +  ",  Alliance = " + seats[11] + ", Other  = " + seats[12]);
                               
                
      	}
	
	
	
}
