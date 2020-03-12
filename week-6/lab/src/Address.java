import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	
	public static HashMap<String, String[]> zipData = new HashMap<>();

	static {
		// building the hashmap of zip:[city, state]
		try {
		File file = new File("zip_code_database.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT
				.withFirstRecordAsHeader() // header provided
                .withIgnoreHeaderCase()
                .withTrim());
		
		// iterate through csv file
		for (CSVRecord csvRecord : csvParser) {
			// accessing data by name
			String zip = csvRecord.get("zip");
			String[] data = {csvRecord.get("primary_city"), csvRecord.get("state")};
			zipData.put(zip, data);
		}
		fr.close();
		br.close();
		csvParser.close();
		
		} catch(IOException ioe) {
			System.out.println(ioe);
		}

	}

	// no arg constructor
	public Address() {
	}

	// full arg constructor
	public Address(String street, String zip) {
		this.street = street;
		setZip(zip);
	}

	// clone constructor
	public Address(Address toClone) {
		// handles null pointers
		if (toClone == null) {
			return;
		}
		this.street = toClone.street;
		this.city = toClone.city;
		this.state = toClone.state;
		this.zip = toClone.zip;
	}

	// gets street
	public String getStreet() {
		return street;
	}

	// sets street 
	public void setStreet(String street) {
		this.street = street;
	}

	// gets city
	public String getCity() {
		return city;
	}

	// gets state
	public String getState() {
		return state;
	}

	// gets zip
	public String getZip() {
		return zip;
	}

	/*
	 * sets the zip of the address
	 * if the zip exists in the zipData hashmap, sets the city and state
	 * with those associated with zip -- if zip is not found, set all 
	 * values to null
	 */
	public void setZip(String zip) {
		if(zipData.containsKey(zip)) {
			this.zip = zip;
			this.city = zipData.get(zip)[0];
			this.state = zipData.get(zip)[1];
		}
		else {
			this.zip = null;
			this.city = null;
			this.state = null;
		}
	}

	@Override
	public boolean equals(Object otherObject) {
		// test to make sure classes of objects are the same
		if (otherObject == null || otherObject.getClass() != this.getClass())
			return false;

		// casts otherObject as Address for comparison
		Address otherAddress = (Address) otherObject;

		return Objects.equals(this.street, otherAddress.street) && Objects.equals(this.city, otherAddress.city)
				&& Objects.equals(this.state, otherAddress.state) && Objects.equals(this.zip, otherAddress.zip);
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s", this.street, this.city, this.state, this.zip);
	}

}
