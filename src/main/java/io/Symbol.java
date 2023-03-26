package io;

import board.*;
import java.util.*;

public enum Symbol {
    DEAD('_', DeadCell.class), ALIVE('X', AliveCell.class);

    private final char code;
    private final Class<? extends Cell> klass;

    private final static Map<Character, Symbol> bindings = new HashMap<>();
    static {
        for(Symbol s: Symbol.values()) {
            bindings.put(s.code, s);
        }
    }

    Symbol(char code, Class<? extends Cell> c) {
        this.code = code;
        this.klass = c;
    }

    public static Cell buildFrom(String data) {
        Symbol translated = bindings.get(data.charAt(0));
        Objects.requireNonNull(translated);
        return translated.instantiate();
    }

    private Cell instantiate() {
        try {
            return this.klass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(this.klass.getName());
        }
    }


}
