package io;

import board.Board;
import board.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BoardReader {

    public Board build(String filename) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));
            Integer dimension = Integer.parseInt(r.readLine().trim());
            Board board = new Board(dimension);
            int index = 0;
            while (index < dimension) {
                List<Cell> line = buildLine(r.readLine().trim());
                board.addLine(line);
                index ++;
            }
            return board;
        } catch(IOException e) {
            throw new IllegalArgumentException(filename);
        }
    }

    private List<Cell> buildLine(String data) {
        List<Cell> line = new LinkedList<>();
        for (String s: data.split(" ")) {
            line.add(Symbol.buildFrom(s));
        }
        return line;
    }

}
