package competition_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rubix {

	static Set<String> topColumnSides = new HashSet(Arrays.asList("1", "2", "5", "6"));
	static Set<String> topRowSides = new HashSet(Arrays.asList("2", "4", "6", "3"));

	static String[] columnTopOrder = { "1", "2", "5", "6" };
	static String[] columnSideOrder = { "1", "4", "5", "3" };

	static String[] rowTopOrder = { "2", "4", "6", "3" };
	static String[] rowSideOrder = { "1", "2", "5", "6" };

	public static String[][] createSide(char color) {
		String[][] side = new String[3][3];
		int value = 0;
		if (color == 'Y') {
			side[0][0] = "Y8";
			side[0][1] = "Y7";
			side[0][2] = "Y6";
			side[1][0] = "Y5";
			side[1][1] = "Y4";
			side[1][2] = "Y3";
			side[2][0] = "Y2";
			side[2][1] = "Y1";
			side[2][2] = "Y0";
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					side[i][j] = color + String.valueOf(value++);
				}
			}
		}
		return side;
	}

	public static TilePos findFocusTile(Map<String, String[][]> cube, String tile) {
		for (String sideNum : cube.keySet()) {
			String[][] side = cube.get(sideNum);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (tile.equalsIgnoreCase(side[i][j])) {
						return new TilePos(sideNum, i, j);
					}
				}
			}
		}
		return null;
	}

	
    /*
     * Complete the 'rotateCube' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING start
     *  2. STRING moves
     */

    public static String rotateCube(String start, String moves) {

		String[][] side1 = createSide('P');
		String[][] side2 = createSide('R');
		String[][] side3 = createSide('G');
		String[][] side4 = createSide('B');
		String[][] side5 = createSide('O');
		String[][] side6 = createSide('Y');

		Map<String, String[][]> cube = new HashMap<>();
		cube.put("1", side1);
		cube.put("2", side2);
		cube.put("3", side3);
		cube.put("4", side4);
		cube.put("5", side5);
		cube.put("6", side6);

		String[] movesList = moves.split(" ");
		for (String curMove : movesList) {
			boolean isColumn = (curMove.charAt(0) == 'C');
			boolean isClockWise = (curMove.charAt(1) == 'C');
			int clicks = Integer.valueOf(curMove.charAt(2));

			rotateCube(cube, start, isColumn, isClockWise, clicks);
		}
		TilePos pos = findFocusTile(cube, start);
		String[][] side = cube.get(pos.getSide());
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(side[i][j] + " ");
			}
		}
		return null; 
	}

	static void rotateCube(Map<String, String[][]> cube, String focusTile, boolean isColumn, boolean isClockWise,
			int clicks) {
		if (isColumn) {
			rotateCubeColumn(cube, focusTile, isClockWise, clicks);
		} else {
			rotateCubeRow(cube, focusTile, isClockWise, clicks);

		}
	}

	static void rotateCubeColumn(Map<String, String[][]> cube, String focusTile, boolean isClockWise, int clicks) {
		TilePos pos = findFocusTile(cube, focusTile);
		String[] sidesOrder = new String[4];
		if (topColumnSides.contains(pos.getSide())) {
			for (int i = 0; i < 4; i++) {
				sidesOrder[0] = columnTopOrder[(0 + i) % 4];
				sidesOrder[1] = columnTopOrder[(1 + i) % 4];
				sidesOrder[2] = columnTopOrder[(2 + i) % 4];
				sidesOrder[3] = columnTopOrder[(3 + i) % 4];
				if (columnTopOrder[i].equalsIgnoreCase(pos.getSide())) {
					break;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				sidesOrder[0] = columnSideOrder[(0 + i) % 4];
				sidesOrder[1] = columnSideOrder[(1 + i) % 4];
				sidesOrder[2] = columnSideOrder[(2 + i) % 4];
				sidesOrder[3] = columnSideOrder[(3 + i) % 4];
				if (columnSideOrder[i].equalsIgnoreCase(pos.getSide())) {
					break;
				}
			}
		}
		String[] tiles = new String[12];
		int sidePos = 0;
		for (int i = 0; i < 4; i++) {
			String[][] side = cube.get(sidesOrder[i]);
			tiles[sidePos++] = side[2][pos.getColumnIndex()];
			tiles[sidePos++] = side[1][pos.getColumnIndex()];
			tiles[sidePos++] = side[0][pos.getColumnIndex()];
		}

		if (isClockWise) {
			int count = 0;
			while (count < clicks) {
				String[] newTiles = new String[12];
				count++;
				for (int i = 0; i < 12; i++) {
					newTiles[(i + count) % 12] = tiles[i];
				}
				tiles = newTiles;
			}
		} else {
			int count = 0;
			while (count < clicks) {
				String[] newTiles = new String[12];
				count++;
				for (int i = 0; i < 12; i++) {
					int newIndex = i - count;
					if (newIndex < 0) {
						newIndex = 11;
					}
					newTiles[newIndex] = tiles[i];
				}
				tiles = newTiles;
			}
		}

		sidePos = 0;
		for (int i = 0; i < 4; i++) {
			String[][] side = cube.get(sidesOrder[i]);
			side[2][pos.getColumnIndex()] = tiles[sidePos++];
			side[1][pos.getColumnIndex()] = tiles[sidePos++];
			side[0][pos.getColumnIndex()] = tiles[sidePos++];
		}

	}

	static void rotateCubeRow(Map<String, String[][]> cube, String focusTile, boolean isClockWise, int clicks) {
		TilePos pos = findFocusTile(cube, focusTile);
		String[] sidesOrder = new String[4];
		if (topRowSides.contains(pos.getSide())) {
			for (int i = 0; i < 4; i++) {
				sidesOrder[0] = rowTopOrder[(0 + i) % 4];
				sidesOrder[1] = rowTopOrder[(1 + i) % 4];
				sidesOrder[2] = rowTopOrder[(2 + i) % 4];
				sidesOrder[3] = rowTopOrder[(3 + i) % 4];
				if (rowTopOrder[i].equalsIgnoreCase(pos.getSide())) {
					break;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				sidesOrder[0] = rowSideOrder[(0 + i) % 4];
				sidesOrder[1] = rowSideOrder[(1 + i) % 4];
				sidesOrder[2] = rowSideOrder[(2 + i) % 4];
				sidesOrder[3] = rowSideOrder[(3 + i) % 4];
				if (rowSideOrder[i].equalsIgnoreCase(pos.getSide())) {
					break;
				}
			}
		}
		String[] tiles = new String[12];
		int sidePos = 0;
		for (int i = 0; i < 4; i++) {
			String[][] side = cube.get(sidesOrder[i]);
			tiles[sidePos++] = side[pos.getRowIndex()][0];
			tiles[sidePos++] = side[pos.getRowIndex()][1];
			tiles[sidePos++] = side[pos.getRowIndex()][2];
		}

		if (isClockWise) {
			int count = 0;
			while (count < clicks) {
				String[] newTiles = new String[12];
				count++;
				for (int i = 0; i < 12; i++) {
					newTiles[(i + count) % 12] = tiles[i];
				}
				tiles = newTiles;
			}
		} else {
			int count = 0;
			while (count < clicks) {
				String[] newTiles = new String[12];
				count++;
				for (int i = 0; i < 12; i++) {
					int newIndex = i - count;
					if (newIndex < 0) {
						newIndex = 11;
					}
					newTiles[newIndex] = tiles[i];
				}
				tiles = newTiles;
			}
		}

		sidePos = 0;
		for (int i = 0; i < 4; i++) {
			String[][] side = cube.get(sidesOrder[i]);
			side[pos.getRowIndex()][0] = tiles[sidePos++];
			side[pos.getRowIndex()][1] = tiles[sidePos++];
			side[pos.getRowIndex()][2] = tiles[sidePos++];
		}
	}

	static void printCube(Map<String, String[][]> cube) {
		for (String sideNum : cube.keySet()) {
			String[][] side = cube.get(sideNum);
			System.out.println("Side " + sideNum);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(side[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}

	static class TilePos {
		private String side;
		private int rowIndex;
		private int columnIndex;

		public TilePos(String side, int rowIndex, int columnIndex) {
			super();
			this.side = side;
			this.rowIndex = rowIndex;
			this.columnIndex = columnIndex;
		}

		public String getSide() {
			return side;
		}

		public void setSide(String side) {
			this.side = side;
		}

		public int getRowIndex() {
			return rowIndex;
		}

		public void setRowIndex(int rowIndex) {
			this.rowIndex = rowIndex;
		}

		public int getColumnIndex() {
			return columnIndex;
		}

		public void setColumnIndex(int columnIndex) {
			this.columnIndex = columnIndex;
		}

		@Override
		public String toString() {
			return "TilePos [side=" + side + ", rowIndex=" + rowIndex + ", columnIndex=" + columnIndex + "]";
		}

	}

}
