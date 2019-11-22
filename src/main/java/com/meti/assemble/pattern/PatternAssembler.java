package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatternAssembler implements Assembler {
    private final List<? extends Pattern> patterns;

    private PatternAssembler(List<? extends Pattern> patterns) {

        this.patterns = patterns;
    }

    public PatternAssembler(Pattern... patterns) {
        this(List.of(patterns));
    }

    @Override
    public Node assemble(List<? extends Token<?>> tokens) {
        tokens.forEach(this::buildNode);
        return patterns.stream()
                .map(pattern -> pattern.collect(this))
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There was no content " +
                        "to parse."));
    }

    @Override
    public Assembler copy() {
        var list = patterns.stream()
                .map(Pattern::copy)
                .collect(Collectors.toList());
        if (list.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("Pattern.copy() was not implemented.");
        }
        return new PatternAssembler(list);
    }

    private void buildNode(Token<?> token) {
        patterns.forEach(pattern -> pattern.form(token));
    }
}
