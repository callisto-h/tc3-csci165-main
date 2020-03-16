
public class CountyResults2016 {

	private double demVotes;
	private double gopVotes;
	private double totalVotes;
	private double percentDem;
	private double percentGOP;
	private double difference;
	private double percentDifference;
	private String stateAbbreviation;
	private String county;
	private int fips;

	public CountyResults2016(double _demVotes, double _gopVotes, double _totalVotes, double _percentDem,
			double _percentGOP, double _difference, double _percentDifference, String _stateAbbreviation,
			String _county, int _fips) {
		// assign instance variables
		demVotes = _demVotes;
		gopVotes = _gopVotes;
		totalVotes = _totalVotes;
		percentDem = _percentDem;
		percentGOP = _percentGOP;
		difference = _difference;
		percentDifference = _percentDifference;
		stateAbbreviation = _stateAbbreviation;
		county = _county;
		fips = _fips;
	}

	public double getTotalVotes() {
		return totalVotes;
	}

	public double getDemVotes() {
		return demVotes;
	}

	public double getGOPVotes() {
		return gopVotes;
	}

	public double getDifference() {
		return difference;
	}

	public double getPercentDifference() {
		return percentDifference;
	}

	public String getState() {
		return stateAbbreviation;
	}

	public String getCounty() {
		return county;
	}

	@Override
	public String toString() {
		String output = "";
		output += "Total votes: " + getTotalVotes() + "\n";
		output += "Dem votes: " + getDemVotes() + "\n";
		output += "GOP votes: " + getGOPVotes() + "\n";
		output += "Difference: " + getDifference() + "\n";
		output += "Percent Dem: " + percentDem + "\n";
		output += "Percent GOP: " + percentGOP + "\n";
		output += "Percent Difference: " + getPercentDifference() + "\n";
		output += "State: " + getState() + "\n";
		output += "County: " + getCounty() + "\n";
		output += "Fips: " + fips + "\n";

		return output;
	}

}
