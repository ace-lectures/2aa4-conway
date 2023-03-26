package board;

import rules.Neighbourhood;

public class DeadCell implements Cell {

    @Override
    public String toString() { return "_"; }

    @Override
    public Neighbourhood join(Neighbourhood n) {
        return n; // dead cells does not count towards the neighbourhood's population
    }

    @Override
    public Cell next(Neighbourhood n) {
        return n.next(this); // Delegating the decision to the neighbourhood
    }
}
