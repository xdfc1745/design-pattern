package chain.pattern.demo;

public class HwSupport extends Support{
	public HwSupport (String name) {
		super(name);
	}
	protected boolean resolve(Trouble trouble) {
		if (calcPrimeNumber(trouble.getNumber())) return true;
		else return false;
	}
	
	protected boolean calcPrimeNumber(int num) {
		 boolean result = true;
	        for(int i = 2; i < num; i++) {
	            if( num%i == 0) {
	                result = false;
	                break; 
	            } else {
	                result = true;
	            }
	        }        
	        return result;      
	}
}
