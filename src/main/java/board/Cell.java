package board;

import rules.Neighbourhood;

public interface Cell {

    /**
     * Called when this cell joins the neighbourhood of another one
     * @param n the current neighbourhood
     * @return the neighborhood n, now including this
     */
    Neighbourhood join(Neighbourhood n);

    /**
     * Give the next kind of cell, considering the given neighbourhood
     * @param n the current neighbourhood
     * @return A cell that is Dead or Alive, depending on the neighbourhood
     */
    Cell next(Neighbourhood n);

}
