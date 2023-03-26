package rules;

import board.Board;
import board.Cell;

public class Simulation {

    private final Board start;
    private final int cycles;

    public Simulation(Board aBoard, int cycles) {
        this.start = aBoard;
        this.cycles = cycles;
    }

    public Board execute() {
        System.out.println("#----------[INITIAL]----------#");
        System.out.println(this.start);
        Board current = this.start;
        for(int i = 0; i < cycles; i++) {
            current = next(current);
            System.out.println("#----------["+(i+1)+"]----------#");
            System.out.println(current);
        }
        return current;
    }

    private Board next(Board theBoard) {
        Board next = new Board(theBoard.getDimension());
        for(int i = 0; i < theBoard.getDimension(); i++){
            for(int j = 0; j < theBoard.getDimension(); j++) {
                Cell currentCell = theBoard.get(i,j).get();
                Neighbourhood neighbourhood = theBoard.neighbourhood(i,j);
                // neighbourhood.next(currentCell); Does not compile! Static type vs runtime type
                next.set(i, j, currentCell.next(neighbourhood)); // double dispatch!
            }
        }
        return next;
    }
}
