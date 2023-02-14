package org.cis120.TwentyFortyEight;

import java.io.*;

public class SaveState {
    private BufferedReader reader;
    private GameState gs;
    private boolean hasGS;

    public SaveState() {
        try {
            reader = new BufferedReader(new FileReader("hw09_local_temp/files/savestate.txt"));
        } catch (FileNotFoundException e) {
            reader = null;
            gs = null;
        }
        gs = readSave();
    }

    private boolean hasNext() {
        if (gs == null) {
            hasGS = false;
        }
        boolean hasNext = hasGS;
        if (!hasGS) {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("error");
            }
        }
        return hasNext;
    }

    public GameState getGS() {
        if (hasGS) {
            return gs;
        }
        return null;
    }

    private GameState readSave() {
        int[][] arr = new int[4][4];
        int s = 0;
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(reader.readLine());
                }
            }
            s = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return null;
        }
        GameState g = new GameState(arr, s);
        return g;
    }

    public static void writeState(GameState gs) {
        int[][] arr = gs.getBoard();
        int s = gs.getScore();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "hw09_local_temp/files/savestate.txt"));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    writer.write(Integer.toString(arr[i][j]));
                    writer.newLine();
                }
            }
            writer.write(Integer.toString(s));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
