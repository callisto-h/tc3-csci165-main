
public class TemperatureDriver {

	public static void main(String[] args) {

		// arg-less constructor
		Temperature temp1 = new Temperature();

		// setScale() test
		temp1.setScale(Temperature.Scale.C);

		// setTemperature() test
		temp1.setTemperature(101.0f);

		// toString()
		System.out.println("temp1 toString:\n" + temp1 + "\n");

		// getDegreesF() test
		float temp1_F = temp1.getDegreesF();
		float temp1_C = temp1.getDegreesC();

		// just displaying that the getDegrees methods work
		// the "round to the 10th place" requirement was a bit confusing
		// because in cases where you end up rounding to something like
		// 101.8, IEEE 754 encoding disallows for perfect accuracy and you
		// will end up with 101.800003. The getDegrees functions do, however,
		// approximate well. For example, 101.834644 would become 101.800003.
		// The function *did* round to the 10ths place, but binary is dumb
		System.out.printf("temp1 degrees F: %.1f\ntemp1 degrees C: %.1f\n\n", temp1_F, temp1_C);

		// overloaded constructor
		Temperature temp2 = new Temperature(0.8f, Temperature.Scale.C);

		// another toString()
		System.out.println("temp2 toString: \n" + temp2 + "\n\n");

		// setScaleAndTemperature() test
		temp2.setScaleAndTemperature(Temperature.Scale.F, 32.0f);

		// equals() test
		boolean test = temp1.equals(temp2);
		System.out.printf("temp1 equals temp2: %b\n", test);

		// compareTo() test
		int compare = temp1.compareTo(temp2);
		System.out.printf("temp1 compared to temp2: %d\n", compare);
	}

}
