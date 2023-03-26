package board;

import rules.Neighbourhood;

public class AliveCell implements Cell {

    @Override
    public String toString() { return "X"; }

    @Override
    public Neighbourhood join(Neighbourhood n) {
        return n.increase(); // alive cells counts towards the neighbourhood's population
    }

    @Override
    public Cell next(Neighbourhood n) {
        return n.next(this); // Delegating the decision to the neighbourhood
    }
}
