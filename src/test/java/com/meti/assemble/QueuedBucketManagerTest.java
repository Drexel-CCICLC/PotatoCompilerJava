package com.meti.assemble;

import com.meti.token.InlineToken;
import com.meti.token.TokenType;
import org.junit.jupiter.api.Test;

import static com.meti.assemble.CountPredicate.count;
import static com.meti.assemble.PredicateBucket.by;
import static com.meti.assemble.TypePredicate.any;
import static java.util.Collections.nCopies;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.*;

class QueuedBucketManagerTest {

    @Test
    void add() {
        var first = by(count(3));
        var second = by(any());
        var manager = new QueuedBucketManager(first, second);
        var copies = nCopies(4, new InlineToken<>(TokenType.CONTENT));
        assertTrue(manager.addAll(copies));
        assertTrue(first.content().containsAll(copies.subList(0, 4)));
        assertIterableEquals(singleton(copies.get(3)), second.content());
    }

    @Test
    void reset() {
        var first = by(count(3));
        var second = by(any());
        var manager = new QueuedBucketManager(first, second);
        var copies = nCopies(4, new InlineToken<>(TokenType.CONTENT));

        assertTrue(manager.addAll(copies));
        assertFalse(first.content().isEmpty());
        assertFalse(second.content().isEmpty());

        manager.reset();
        assertTrue(first.content().isEmpty());
        assertTrue(second.content().isEmpty());
    }
}