import board.Board;
import io.BoardReader;
import rules.Simulation;

public class Main {

    public static void main(String[] args) {
        BoardReader reader = new BoardReader();
        Board theBoard = reader.build(args[0]);
        int cycles = Integer.parseInt(args[1]);
        Simulation simulation = new Simulation(theBoard, cycles);
        simulation.execute();
    }

}
