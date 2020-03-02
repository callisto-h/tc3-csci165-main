public class Address{

	private String 	street;
	private String 	city;
	private String 	state;
	private int 	zip;

	public Address(){}

	public Address(String s, String c, String state, int z){
		this.street = s;
		this.city 	= c;
		this.state 	= state;
		this.zip 	= z;
	}

	public String getStreet(){
		return street;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}

	public int getZip(){
		return zip;
	}

	public boolean equals(Address a){
		return 	this.street.equals(a.street) 	&&
				this.city.equals(a.city) 		&&
				this.state.equals(a.state) 		&&
				this.zip == a.zip;

	}
	public String toString(){
		return street + " " + city + " " + state + ", " + zip;
	}
}
