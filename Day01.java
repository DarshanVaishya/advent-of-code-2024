import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Day01 {
	static List<Integer> left = new LinkedList<>();
	static List<Integer> right = new LinkedList<>();

	static void parseInput() {
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
	}

	public static int solve1() {
		Collections.sort(left);
		Collections.sort(right);
		int res = 0;

		for(int i = 0; i < left.size(); i++) {
			res += Math.abs(left.get(i) - right.get(i));
		}

		return res;
	}

	public static int solve2() {
		HashMap<Integer, Integer> occ = new HashMap<>();

		for(int i = 0; i < right.size(); i++) {
			int num = right.get(i);
			occ.put(num, occ.getOrDefault(num, 0) + 1);
		}

		int res = 0;
		for(int i = 0; i < left.size(); i++) {
			int num = left.get(i);
			res += num * occ.getOrDefault(num, 0);
		}

		return res;
	}

	public static void main(String[] args) {
		parseInput();
		int p1Res = solve1();
		System.out.println("Part 1: " + p1Res);
		int p2Res = solve2();
		System.out.println("Part 2: " + p2Res);
	}
	
}
