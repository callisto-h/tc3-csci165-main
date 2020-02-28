
public class Temperature {

	// in case somebody needs to check what scales are available
	public static enum Scale {
		F, C
	};

	// instance variables
	private float temperature;
	private Scale scale;

	// no arg constructor
	public Temperature() {
	};

	// arg constructor to set temperature and scale of a Temperature object
	public Temperature(float _temperature, Scale _scale) {
		setScaleAndTemperature(_scale, _temperature);
	}

	// checks to see if the current scale is in F, if it is perform calculations.
	// otherwise, just return the current temperature
	public float getDegreesC() {
		float temp;
		if (scale == Scale.F)
			temp = (5.0f * (getDegreesF() - 32.0f)) / 9.0f;
		else
			temp = temperature;

		// this "rounds" to one decimal place, but the way IEEE 754 encoding
		// works means that it will not be perfect. A different way to do it
		// would have been to have this function return a String, but that
		// felt weird.
		temp = (float) (Math.round(temp * 10) / 10.0);

		return temp;
	};

	// checks to see if the current scale is in C, if it is perform calculations.
	// otherwise, just return the current temperature
	public float getDegreesF() {
		float temp;
		if (scale == Scale.C)
			temp = ((9.0f * (getDegreesC() / 5.0f)) + 32.0f);
		else
			temp = temperature;

		// this "rounds" to one decimal place, but the way IEEE 754 encoding
		// works means that it will not be perfect. A different way to do it
		// would have been to have this function return a String, but that
		// felt weird.
		temp = (float) (Math.round(temp * 10) / 10.0); // rounds to one decimal place

		return temp;
	};

	// sets instance variable temperature
	public void setTemperature(float _temperature) {
		temperature = _temperature;
	};

	// sets the instance variable scale, no domain validation
	public void setScale(Scale _scale) {
		if (_scale == Scale.C)
			scale = Scale.C;
		else
			scale = Scale.F;
	};

	// sets both the scale and temperature using their respective setter
	// method calls
	public void setScaleAndTemperature(Scale _scale, float _temperature) {
		setScale(_scale);
		setTemperature(_temperature);
	};

	// checks to see if the celsius values of two temperature objects
	// are equivalent. If one of the objects is Fahrenheit it won't
	// make a difference because of the structure of getDegreesC();
	public boolean equals(Temperature t) {
		return this.getDegreesC() == t.getDegreesC();
	};

	// compare celsius values of calling and argument Temperature objects
	public int compareTo(Temperature t) {

		float this_temp_c = this.getDegreesC();
		float other_temp_c = t.getDegreesC();

		if (this_temp_c > other_temp_c)
			return 1;
		else if (this_temp_c < other_temp_c)
			return -1;
		else
			return 0;
	};

	@Override
	public String toString() {
		String state = "";
		state += temperature + " degrees ";
		state += (scale == Scale.C ? "Celsius" : "Fahrenheit");
		return state;
	};
}
