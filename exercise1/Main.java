import java.util.ArrayList;

public class Main {
	static class EmptyArray extends Exception {
	}

	static class Avg {
		private float average;
		private int[] invalid;
		private boolean valid;

		Avg(float average) {
			this.average = average;
			valid = true;
		}

		Avg(int[] invalid) {
			this.invalid = invalid;
			valid = false;
		}

		float getAverage() {
			return average;
		}

		int[] getInvalid() {
			return invalid;
		}

		boolean isValid() {
			return valid;
		}

	}

	static Avg avg(int[] nums) throws EmptyArray {
		int sum = 0;
		ArrayList<Integer> invalid = new ArrayList<>();
		if (nums == null || nums.length == 0)
			throw new EmptyArray();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				invalid.add(i);
			}
			sum += nums[i];
		}
		if (invalid.isEmpty()) {
			return new Avg(sum / nums.length);
		} else {
			return new Avg(invalid.stream().mapToInt(i -> i).toArray());
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, -2, -3, 4 };
		Avg result = null;
		try {
			result = avg(nums);
		} catch (EmptyArray e) {
			return;
		}

		if (result.isValid()) {
			System.out.println(String.valueOf(result.getAverage()));
		} else {
			for (int i : result.getInvalid()) {
				String suffix;
				switch (i + 1) {
					case 1:
						suffix = "st";
						break;
					case 2:
						suffix = "nd";
						break;
					case 3:
						suffix = "rd";
						break;
					default:
						suffix = "th";
				}
				System.out.println("The " + String.valueOf(i + 1) + suffix + " number " + String.valueOf(nums[i])
						+ " in your array is invalid");
			}
		}
	}
}
