package luhn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Luhn {
	FileReader reader;
	private List<Integer> counter = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		Luhn tes = new Luhn("input.txt");
		tes.getOutput();
	}
	
	public Luhn(String filename) {
		reader = new FileReader(filename);
		validateAll();
	}
	
	public boolean isValid(String cardNumber) {
            int sum = 0;
            boolean alternate = false;
            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                    int n = Integer.parseInt(cardNumber.substring(i, i + 1));
                    if (alternate) {
                            n *= 2;
                            if (n > 9) {
                                    n = (n % 10) + 1;
                            }
                    }
                    sum += n;
                    alternate = !alternate;
            }
            return (sum % 10 == 0);
    }
	
	public void validateAll() {
		for (int i=0; i<reader.getCCount(); i++) {
			int count=0;
			StringBuilder str = new StringBuilder(reader.getCardNumbers().get(i));
			List<Integer> index  = new ArrayList<Integer>();
			
			for (int j=0; j<str.length(); j++) {
				if ((int)str.charAt(j)==63) {
					index.add(j);
				}
			}
			
			Set<String> temp = new HashSet<String>();
			if (!index.isEmpty()) {
				while (temp.size() < Math.pow(10, index.size())) {
					for (int j=0; j<index.size(); j++) {
						str.setCharAt(index.get(j), (char)(((int)(Math.random() * 10)) +'0'));
					}
					temp.add(str.toString());
				}
				
				Iterator iterator = temp.iterator(); 
				while (iterator.hasNext()){
					String s = iterator.next().toString();
					if (isValid(s)) {
						System.out.println(s);
						count++;
					}
				}
				
				
			} else {
				if (isValid(str.toString())) {
					count++;
					System.out.println(str.toString());
				}
			}
			counter.add(count);
			System.out.println(count);
		}
	}
	
	public StringBuilder getOutput() {
		StringBuilder str = new StringBuilder();
		str.append("Output:\n");
		for (int i=0; i<counter.size(); i++) {
			str.append("Kartu " + String.valueOf(i+1) + "> " + counter.get(i) +"\n");
		}
		//System.out.println(str);
		return str;
	}
	
	public List <Integer> getCounter() {
		return counter;
	}
}
