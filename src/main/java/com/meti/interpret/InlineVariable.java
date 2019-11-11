package com.meti.interpret;

class InlineVariable implements Variable {
    private final Type type;
    private final String name;
    private final boolean mutable;

    InlineVariable(Type type, String name, boolean mutable) {
        this.type = type;
        this.name = name;
        this.mutable = mutable;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
