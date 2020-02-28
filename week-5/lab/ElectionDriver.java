import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ElectionDriver {

	public static ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>();

	public static void main(String[] args) {
		fillList();

		CountyResults2016 largestNYMargin = findLargestMargin("CA");
		System.out.println("Largest margin: NY");
		System.out.println(largestNYMargin);
		System.out.println();

		CountyResults2016 largestMargin = findLargestMargin();
		System.out.println("Largest margin: National");
		System.out.println(largestMargin);
		System.out.println();

		// gets state totals
		String[] states = getStateTotals();
		// prints state totals
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}
	}

	public static void fillList() {
		try {
			File file = new File("2016_US_County_Level_Presidential_Results.csv");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			// skips first boring line
			br.readLine();
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				CountyResults2016 countyResults = parseLine(line);
				results.add(countyResults);
			}
			fr.close();
			br.close();
		} catch (IOException ioe) {
			System.out.print("IOException");
		}
	}

	private static CountyResults2016 parseLine(String line) {
		// initialize variables
		double demVotes, gopVotes, totalVotes, percentDem, percentGOP, difference, percentDifference;
		String stateAbbreviation, county;
		int fips, length;
		String[] entries;

		// breaks line up
		entries = line.split(",");

		demVotes = Double.parseDouble(entries[1]);
		gopVotes = Double.parseDouble(entries[2]);
		totalVotes = Double.parseDouble(entries[3]);
		percentDem = Double.parseDouble(entries[4]);
		percentGOP = Double.parseDouble(entries[5]);
		// here we check to see if the "difference" column was
		// separated by a "," which would cause an addition entry
		length = entries.length;

		if (length == 13) {
			difference = Double.parseDouble((entries[6] + entries[7] + entries[8]).replace("\"", ""));
		} else if (length == 12) {
			difference = Double.parseDouble((entries[6] + entries[7]).replace("\"", ""));
		} else {
			difference = Double.parseDouble(entries[6]);
		}
		// use 'length - x' to reuse code
		percentDifference = Double.parseDouble(entries[length - 4].replace("%", ""));
		stateAbbreviation = entries[length - 3];
		county = entries[length - 2];
		fips = Integer.parseInt(entries[length - 1]);

		CountyResults2016 countyResults = new CountyResults2016(demVotes, gopVotes, totalVotes, percentDem, percentGOP,
				difference, percentDifference, stateAbbreviation, county, fips);
		return countyResults;
	}

	// Swagner and I worked together on these methods so they
	// may look a bit similar
	private static int findFirstIndexOfState(String state) {
		// only works if you look up a valid state
		for (int i = 0; i < results.size(); i++) {
			if (results.get(i).getState().equals(state)) {
				return i;
			}
		}
		return 0;
	}

	public static CountyResults2016 findLargestMargin() {
		return findLargestMargin(null);
	}

	// we went with PERCENT margin because the document wasn't 100% clear
	public static CountyResults2016 findLargestMargin(String state) {
		int largestIndex = (state == null ? 0 : findFirstIndexOfState(state));

		// very straightforward loop finding maximum value in our array
		for (int i = 0; i < results.size(); i++) {
			// checks to see if there is a state variable AND the states are not equal,
			// otherwise we skip this iteration -- effectively filters by state IF there
			// is a state.
			if (state != null && !results.get(i).getState().equals(state)) {
				continue;
			}
			// finds max as long as above condition is correct
			if (results.get(i).getDifference() > results.get(largestIndex).getDifference()) {
				largestIndex = i;
			}
		}
		return results.get(largestIndex);
	}

	public static String[] getStateTotals() {
		String[] totals = new String[51];
		String[] finishedStatesValues = new String[51];
		boolean stateUsed;
		String currentState, stateString;
		double totalDemVotes, totalGOPVotes, totalDifference;
		int totalsIndex = 0;

		for (int i = 0; i < results.size(); i++) {
			// reset variables for loop through
			stateUsed = false;
			currentState = results.get(i).getState();
			totalDemVotes = 0.0;
			totalGOPVotes = 0.0;
			totalDifference = 0.0;
			stateString = "";

			// checks to see if the state has been used
			for (int j = 0; j < 51; j++) {
				if (currentState.equals(finishedStatesValues[j])) {
					stateUsed = true;
					break;
				}
				if (finishedStatesValues[j] == null) {
					finishedStatesValues[j] = currentState;
					totalsIndex = j;
					break;
				}
			}
			if (stateUsed)
				continue; // skips this countyresult if the state has been used

			// if the state has NOT been used, iterate through the results
			// and get data from any entries that match state
			for (int j = 0; j < results.size(); j++) {
				if (currentState.equals(results.get(j).getState())) {
					totalDemVotes += results.get(j).getDemVotes();
					totalGOPVotes += results.get(j).getGOPVotes();
					totalDifference += results.get(j).getDifference();
				}
			}

			stateString = String.format(
					"State: %s, Dem votes: %-8.0f, GOP votes: %-8.0f, Margin of victory: %-8.0f, Winning Party: %s",
					currentState, totalDemVotes, totalGOPVotes, totalDifference,
					(totalDemVotes > totalGOPVotes ? "Democrats" : "GOP"));
			totals[totalsIndex] = stateString;
		}
		return totals;
	}

	// used in debugging, could not get the fillarray()
	// method to only invoke one time and still be accessible
	// to junit tests
	public static void clear() {
		results.clear();
	}
}
