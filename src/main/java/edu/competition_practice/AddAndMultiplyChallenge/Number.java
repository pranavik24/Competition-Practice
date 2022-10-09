package competition_practice;


import java.lang.Math; 

public class Number {
		int num; 
		int numLen; 
		int product;
		int sum; 
			public Number(int number){
				num = number; 
				double temp = Math.log10(num);
			     numLen = (int)temp + 1; 
			     sum = getSum(num);
			     product = getProduct(num); 
			}
			
			
			public int getDigit(int num, int pos) {
				double tmp = Math.pow(10,pos); 
			    double tmpposDigit = (num%tmp)/Math.pow(10,pos-1);
			    int posDigit = (int)tmpposDigit;
			    
			    return posDigit;
			}
			
			public int getSum(int num) {
				int sum =0; 
			     
				for(int i = 1; i <= numLen; i++) {
					sum += getDigit(num, i);

				}
			return sum; 
			}
			
			public int getProduct(int num) {
				int product = 1; 
			     
				for(int i = 1; i <= numLen; i++) {
					product *= getDigit(num, i);
				}
			return product; 
			}
			
			public void printProdMinusSum() {
				int finalAnswer = product - sum; 
				System.out.println(finalAnswer);
			}
			
		
}
