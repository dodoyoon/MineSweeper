import java.io.*;
import java.util.*;

public class Ranking {
	private boolean recorded = false;;
	public void Ranking(int mines, String name, String result) {
		int level = 0;
		if(mines == 10) level = 1;
		else if(mines == 40) level = 2;
		else if(mines == 99) level = 3;
		
		String fileName = "level" + level + ".txt";
		PrintWriter outputStream = null;
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(fileName));
			String line = inputStream.nextLine();
			String fName[] = null;
			String fResult[] = null;
			int rank = 0;
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				String[] ary = line.split(" ");
				int fRank = Integer.parseInt(ary[0]);
				fName[fRank] = ary[1];
				fResult[fRank] = ary[2];
				rank++;
			}
			inputStream.close();
			
			outputStream = new PrintWriter(fileName);
			outputStream.println("Rank Name Time");
			if(rank == 0)
				outputStream.printf("%4d %s %s\n", rank+1, name, result);
			else {
				for(int i = 0; i < rank; i++) {
					if(!recorded && isBetter(result, fResult[i])) {
						outputStream.printf("%4d %s %s\n", i+1, name, result);
						i--;
						recorded = true;
					}
					else {
						outputStream.printf("%4d %s %s\n", i+1, fName[i], fResult[i]);
					}
				}
			}
			outputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file "+fileName);
			System.exit(0);
		}
	}
	
	private boolean isBetter(String result, String fResult) {
		String[] newResult = result.split(":");
		String[] Result = fResult.split(":");
		
		int newResultH = Integer.parseInt(newResult[0]);
		int newResultM = Integer.parseInt(newResult[1]);
		int newResultS = Integer.parseInt(newResult[2]);
		int ResultH = Integer.parseInt(Result[0]);
		int ResultM = Integer.parseInt(Result[1]);
		int ResultS = Integer.parseInt(Result[2]);
		
		if(newResultH < ResultH)
			return true;
		else if(newResultH == ResultH && newResultM < ResultM)
			return true;
		else if(newResultH == ResultH && newResultM == ResultM && newResultS < ResultS)
			return true;
		return false;
	}
}