package com.shiping.leetcode.easy;

public class RomanToInteger {
	public int romanToInt(String s) {
		return thousand(s);
		
	}
	
	public int thousand(String s) {
		if(s.length() >= 3 && s.substring(0, 3).equals("MMM")) return 3000 + hundred(s.substring(3)); 
		if(s.length() >= 2 && s.substring(0, 2).equals("MM")) return 2000  + hundred(s.substring(2));
		if(s.length() >= 1 && s.substring(0, 1).equals("M"))   return 1000 + hundred(s.substring(1));
		return hundred(s);
	}
	
	public int hundred(String s) {
		if(s.length() >= 4 && s.substring(0, 4).equals("DCCC")) return 800 + ten(s.substring(4));
		if(s.length() >= 3 && s.substring(0, 3).equals("DCC"))  return 700 + ten(s.substring(3));
		if(s.length() >= 3 && s.substring(0, 3).equals("CCC"))  return 300 + ten(s.substring(3));
		if(s.length() >= 2 && s.substring(0, 2).equals("CC"))   return 200 + ten(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("CD"))   return 400 + ten(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("DC"))   return 600 + ten(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("CM"))   return 900 + ten(s.substring(2));
		if(s.length() >= 1 && s.substring(0, 1).equals("C"))    return 100 + ten(s.substring(1));
		if(s.length() >= 1 && s.substring(0, 1).equals("D"))    return 500 + ten(s.substring(1));
		return ten(s);
		
	}
	
	public int ten(String s) {
		if(s.length() >= 4 && s.substring(0, 4).equals("LXXX")) return 80 + digit(s.substring(4));
		if(s.length() >= 3 && s.substring(0, 3).equals("LXX"))  return 70 + digit(s.substring(3));
		if(s.length() >= 3 && s.substring(0, 3).equals("XXX"))  return 30 + digit(s.substring(3));
		if(s.length() >= 2 && s.substring(0, 2).equals("XX"))   return 20 + digit(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("XL"))   return 40 + digit(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("LX"))   return 60 + digit(s.substring(2));
		if(s.length() >= 2 && s.substring(0, 2).equals("XC"))   return 90 + digit(s.substring(2));
		if(s.length() >= 1 && s.substring(0, 1).equals("X"))    return 10 + digit(s.substring(1));
		if(s.length() >= 1 && s.substring(0, 1).equals("L"))    return 50 + digit(s.substring(1));
		return digit(s);
		
	}
	
	public int digit(String s) {
		if(s.length() >= 4 && s.substring(0, 4).equals("VIII")) return 8;
		if(s.length() >= 3 && s.substring(0, 3).equals("VII"))  return 7;
		if(s.length() >= 3 && s.substring(0, 3).equals("III"))  return 3;
		if(s.length() >= 2 && s.substring(0, 2).equals("II"))   return 2;
		if(s.length() >= 2 && s.substring(0, 2).equals("IV"))   return 4;
		if(s.length() >= 2 && s.substring(0, 2).equals("VI"))   return 6;
		if(s.length() >= 2 && s.substring(0, 2).equals("IX"))   return 9;
		if(s.length() >= 1 && s.substring(0, 1).equals("I"))    return 1;
		if(s.length() >= 1 && s.substring(0, 1).equals("V"))    return 5;
		return 0;
		
	}

}
