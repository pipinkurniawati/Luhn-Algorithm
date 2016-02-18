package luhn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Luhn {
	FileReader reader;
	private List<Integer> counter = new ArrayList<Integer>();
	private List<String> valid = new ArrayList<String>();
	
	public Luhn(String filename) {
		reader = new FileReader(filename);
		validateAll();
		try {
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//fungsi untuk menentukan apakah suatu nomor credit card valid atau tidak
	//berdasarkan checksum algoritma Luhn
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
	
	//melakukan generate terhadap nomor kartu yg memiliki karakter ?
	// dan melakukan validasi keseluruhan dengan memanggil fungsi isValid()
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
			
			//generate angka pengganti karakter ?
			Set<String> temp = new HashSet<String>();
			if (!index.isEmpty()) {
				while (temp.size() < Math.pow(10, index.size())) {
					for (int j=0; j<index.size(); j++) {
						str.setCharAt(index.get(j), (char)(((int)(Math.random() * 10)) +'0'));
					}
					temp.add(str.toString());
				}
				
				//melakukan validasi tiap nomor kartu hasi generate
				Iterator iterator = temp.iterator(); 
				while (iterator.hasNext()){
					String s = iterator.next().toString();
					if (isValid(s)) {
						valid.add(s);
						count++;
					}
				}
				
				
			} else {
				if (isValid(str.toString())) {
					valid.add(str.toString());
					count++;
					//System.out.println(str.toString());
				}
			}
			counter.add(count);
			//System.out.println(count);
		}
	}
	
	//menampilkan hasil validasi ke layar
	public StringBuilder getOutput() {
		StringBuilder str = new StringBuilder();
		str.append("\t\t          Output:\n");
		for (int i=0; i<counter.size(); i++) {
			str.append("\t\t          Kartu " + String.valueOf(i+1) + "> " + counter.get(i) +"\n");
		}
		return str;
	}
	
	//menulis jumlah nomor yg valid beserta nomor kartunya ke file output
	public void writeToFile() throws IOException {
		FileWriter fw = new FileWriter(new File("output.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuilder str = new StringBuilder();
		str.append("Output:\n");
		
		int k = 0;
		for (int i=0; i<counter.size(); i++) {
			str.append("Kartu " + String.valueOf(i+1) + "> " + counter.get(i) +"\n"); 
			int temp = k;
			while (k < temp+counter.get(i)) {
				//System.out.println(k +" " + str + " "+ valid.size());
				str.append("\t"+valid.get(k)+"\n");
				k++;
			}
		}
		
		bw.write(str.toString());
		bw.close();
	}
	
	public List <Integer> getCounter() {
		return counter;
	}
}
