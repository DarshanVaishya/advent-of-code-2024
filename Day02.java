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
			boolean isSafe = true;
			boolean isInc = false;
			int prev = row.get(0);
			int curr = row.get(1);

			if(prev < curr && prev != curr) isInc = true;
			else if(prev == curr) continue;

			for(int i = 1; i < row.size(); i++) {
				curr = row.get(i);
				int diff = Math.abs(curr - prev);

				if(isInc && prev >= curr || !isInc && prev <= curr) {
					isSafe = false;
					break;
				} else if(diff < 1 || diff > 3) {
					isSafe = false;
					break;
				}
				prev = curr;
			}
			if(isSafe) res++;
		}

		return res;
	}

	public static void main(String[] args) {
		parseInput();
		int res = solve1();
		System.out.println("Part 1: " + res);
	}
}
