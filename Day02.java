import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class Day02 {
	static List<List<Integer>> data = new LinkedList<>();

	public static void parseInput() {
		try {
			File f = new File("Day02.data");
			String[] rows = Files.readString(f.toPath()).split("\n");

			for (String row : rows) {
				List<Integer> nums = new LinkedList<>();
				for (String val : row.split(" ")) {
					nums.add(Integer.parseInt(val));
				}

				data.add(nums);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int solve1() {
		int res = 0;
		for (List<Integer> row : data) {
			boolean inc = false;
			boolean dec = false;
			boolean isValid = true;

			for(int i = 0; i < row.size() - 1; i++) {
				int n1 = row.get(i);
				int n2 = row.get(i + 1);

				if(n1 < n2) {
					inc = true;
				} else if(n1 > n2) {
					dec = true;
				} else {
					isValid = false;
					break;
				}

				int diff = Math.abs(n1 - n2);

				if((diff <= 0 || diff > 3) || (inc == dec == true)) {
					isValid = false;
					break;
				}
			}

			if (isValid)
				res++;
		}

		return res;
	}

	public static void main(String[] args) {
		parseInput();
		int res = solve1();
		System.out.println("Part 1: " + res);
	}
}
