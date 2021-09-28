package passwordChecker;

public class Checker {
	
	
	
	public int check(String pass) throws Exception {
		if(pass.length()>12 || pass.length()<8) {
			throw new Exception("Password must be between 8 and 12");
		}
		int leng = 1;
		int maxLeng = 0;
		char hold = pass.charAt(0);
		for(int i = 1; i<pass.length();i++) {
			if(pass.charAt(i)==hold) {
				leng++;
			}else {
				hold = pass.charAt(i);
				if(leng>maxLeng) {
					maxLeng = leng;
				}
				leng = 1;
			}
		}
		return maxLeng;
		
	}

}
