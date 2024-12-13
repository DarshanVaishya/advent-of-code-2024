import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Day01 {
	static List<List<Integer>> parse() {
		List<Integer> left = new LinkedList<>();
		List<Integer> right = new LinkedList<>();

		try {
			File inputFile = new File("Day01.data");
			String input = Files.readString(inputFile.toPath());
			String[] data = input.split("\n");

			for(String row : data) {
				String[] items = row.split("   ");
				left.add(Integer.parseInt(items[0]));
				right.add(Integer.parseInt(items[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<List<Integer>> res = new LinkedList<>();
		res.add(left);
		res.add(right);

		return res;
	}

	public static int solve1(List<List<Integer>> data) {
		List<Integer> left = data.get(0);
		List<Integer> right = data.get(1);
		Collections.sort(left);
		Collections.sort(right);
		int res = 0;

		for(int i = 0; i < left.size(); i++) {
			res += Math.abs(left.get(i) - right.get(i));
		}

		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> data = parse();
		int p1Res = solve1(data);
		System.out.println("Part 1: " + p1Res);
	}
	
}
