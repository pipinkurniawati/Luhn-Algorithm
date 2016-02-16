package luhn;

public class Luhn {
	FileReader reader;
	
	public Luhn(String filename) {
		reader = new FileReader(filename);
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
}