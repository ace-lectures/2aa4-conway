package rules;

import board.*;

public abstract class Neighbourhood {
    public static final Neighbourhood EMPTY = new Empty();

    public abstract Neighbourhood increase();
    public abstract Cell next(AliveCell c) ;
    public abstract Cell next(DeadCell c);


    private static class Empty extends Neighbourhood {
        @Override public Neighbourhood increase() { return new One(); }
        @Override public Cell next(AliveCell c) { return new DeadCell(); }
        @Override public Cell next(DeadCell c)  { return new DeadCell(); }
    }

    private static class One extends Neighbourhood {
        @Override public Neighbourhood increase() { return new Two(); }
        @Override public Cell next(AliveCell c) { return new DeadCell(); }
        @Override public Cell next(DeadCell c)  { return new DeadCell(); }
    }

    private static class Two extends Neighbourhood {
        @Override public Neighbourhood increase() { return new Three(); }
        @Override public Cell next(AliveCell c) { return new AliveCell(); }
        @Override public Cell next(DeadCell c)  { return new DeadCell(); }
    }

    private static class Three extends Neighbourhood {
        @Override public Neighbourhood increase() { return new Crowded(); }
        @Override public Cell next(AliveCell c) { return new AliveCell(); }
        @Override public Cell next(DeadCell c)  { return new AliveCell(); }
    }

    private static class Crowded extends Neighbourhood {
        @Override public Neighbourhood increase() { return this; }
        @Override public Cell next(AliveCell c) { return new DeadCell(); }
        @Override public Cell next(DeadCell c)  { return new DeadCell(); }
    }

}
