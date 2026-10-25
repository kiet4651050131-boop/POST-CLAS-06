package postclass06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestPokerHand {

    // Helper: gọi method private isStraightFlush() bằng reflection
    private static boolean invokeIsStraightFlush(PokerHand pHand) {
        try {
            Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
            method.setAccessible(true);
            return (boolean) method.invoke(pHand);
        }
        catch (ReflectiveOperationException e) {
            e.printStackTrace();
            fail();
            return false;
        }
    }

    // Bài 5.8: một trường hợp cho kết quả true
    @Test
    void testIsStraightFlush_True() {
        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.CLUBS));
        assertTrue(invokeIsStraightFlush(hand));
    }

    // Bài 5.9: phủ return false (statement coverage đủ với test này + test True)
    @Test
    void testIsStraightFlush_WrongSuit() {
        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SIX, Suit.DIAMONDS));
        assertFalse(invokeIsStraightFlush(hand));
    }

    // Bài 5.10: thêm test này để phủ vế thứ hai của || (branch coverage)
    @Test
    void testIsStraightFlush_WrongRank() {
        PokerHand hand = new PokerHand(
                Card.get(Rank.TWO, Suit.CLUBS),
                Card.get(Rank.THREE, Suit.CLUBS),
                Card.get(Rank.FOUR, Suit.CLUBS),
                Card.get(Rank.FIVE, Suit.CLUBS),
                Card.get(Rank.SEVEN, Suit.CLUBS));
        assertFalse(invokeIsStraightFlush(hand));
    }
}