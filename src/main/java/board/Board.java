package board;

import rules.Neighbourhood;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private final int dimension;
    private final Cell[][] contents;

    private int currentLine = 0;

    public Board(int dimension) {
        this.dimension = dimension;
        this.contents = new Cell[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }

    public void addLine(List<Cell> line){
        for(int i = 0; i < dimension; i++) {
            this.contents[currentLine][i] = line.get(i);
        }
        currentLine++;
    }

    public Optional<Cell> get(int line, int column) {
        try {
            return Optional.of(contents[line][column]);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public void set(int i, int j, Cell c) {
        this.contents[i][j] = c;
    }

    public Neighbourhood neighbourhood(int line, int column) {
        Neighbourhood result = Neighbourhood.EMPTY;
        for(Cell c: getNeighbours(line,column))
            result = c.join(result);
        return result;
    }

    private Set<Cell> getNeighbours(int line, int column) {
        // getting the raw set of neighbours (8)
        Set<Optional<Cell>> raw = new HashSet<>();
        raw.add(this.get(line-1,column-1));
        raw.add(this.get(line,column-1));
        raw.add(this.get(line+1,column-1));
        raw.add(this.get(line-1,column));
        raw.add(this.get(line+1,column));
        raw.add(this.get(line-1,column+1));
        raw.add(this.get(line,column+1));
        raw.add(this.get(line+1,column+1));
        // Getting rid of out-of-bounds neighbours and mapping to a set of Cell
        raw.removeIf(Optional::isEmpty);
        return raw.stream().map(Optional::get).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++){
                builder.append(contents[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
