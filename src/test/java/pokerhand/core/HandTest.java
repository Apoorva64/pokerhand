package pokerhand.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandTest {
    @Test
    void test_toString_WhenGivenDifferentHands_ReturnsCorrectStringRepresentationOfTheHand() {
        assertEquals(
                "[As♣]", new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB))).toString());
        assertEquals(
                "[Roi♣]", new Hand(List.of(new Card(CardValue.KING, CardColor.CLUB))).toString());
        assertEquals(
                "[Dame♣]", new Hand(List.of(new Card(CardValue.QUEEN, CardColor.CLUB))).toString());
        assertEquals(
                "[Valet♣]", new Hand(List.of(new Card(CardValue.JACK, CardColor.CLUB))).toString());
        assertEquals(
                "[10♥]", new Hand(List.of(new Card(CardValue.TEN, CardColor.HEART))).toString());

        assertEquals(
                "[As♣, Roi♣, Dame♣, Valet♣, 10♣]",
                new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)))
                        .toString());
        assertEquals(
                "[10♥, 9♦, 8♥, 7♦, 6♠]",
                new Hand(
                                List.of(
                                        new Card(CardValue.TEN, CardColor.HEART),
                                        new Card(CardValue.NINE, CardColor.DIAMOND),
                                        new Card(CardValue.EIGHT, CardColor.HEART),
                                        new Card(CardValue.SEVEN, CardColor.DIAMOND),
                                        new Card(CardValue.SIX, CardColor.SPADE)))
                        .toString());
        assertEquals(
                "[6♥, 5♠, 4♣, 3♣, 2♣]",
                new Hand(
                                List.of(
                                        new Card(CardValue.SIX, CardColor.HEART),
                                        new Card(CardValue.FIVE, CardColor.SPADE),
                                        new Card(CardValue.FOUR, CardColor.CLUB),
                                        new Card(CardValue.THREE, CardColor.CLUB),
                                        new Card(CardValue.TWO, CardColor.CLUB)))
                        .toString());
    }

    @Nested
    @DisplayName("Test from string method")
    class TestFromString {

        private static Stream<Arguments> provideValidHandStrings() {
            return Stream.of(
                    Arguments.of("ATr", new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)))),
                    Arguments.of(
                            "RTr", new Hand(List.of(new Card(CardValue.KING, CardColor.CLUB)))),
                    Arguments.of(
                            "DTr", new Hand(List.of(new Card(CardValue.QUEEN, CardColor.CLUB)))),
                    Arguments.of(
                            "VPi", new Hand(List.of(new Card(CardValue.JACK, CardColor.SPADE)))),
                    Arguments.of(
                            "10Pi", new Hand(List.of(new Card(CardValue.TEN, CardColor.SPADE)))),
                    Arguments.of(
                            "9Pi", new Hand(List.of(new Card(CardValue.NINE, CardColor.SPADE)))),
                    Arguments.of(
                            "8Co", new Hand(List.of(new Card(CardValue.EIGHT, CardColor.HEART)))),
                    Arguments.of(
                            "7Co", new Hand(List.of(new Card(CardValue.SEVEN, CardColor.HEART)))),
                    Arguments.of(
                            "6Co", new Hand(List.of(new Card(CardValue.SIX, CardColor.HEART)))),
                    Arguments.of(
                            "5Ca", new Hand(List.of(new Card(CardValue.FIVE, CardColor.DIAMOND)))),
                    Arguments.of(
                            "4Ca", new Hand(List.of(new Card(CardValue.FOUR, CardColor.DIAMOND)))),
                    Arguments.of(
                            "3Ca", new Hand(List.of(new Card(CardValue.THREE, CardColor.DIAMOND)))),
                    Arguments.of(
                            "2Ca", new Hand(List.of(new Card(CardValue.TWO, CardColor.DIAMOND)))),
                    Arguments.arguments(
                            "ATr RCa DPi VCo 10Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.ACE, CardColor.CLUB),
                                            new Card(CardValue.KING, CardColor.DIAMOND),
                                            new Card(CardValue.QUEEN, CardColor.SPADE),
                                            new Card(CardValue.JACK, CardColor.HEART),
                                            new Card(CardValue.TEN, CardColor.CLUB)))),
                    Arguments.arguments(
                            "RTr DCa VPi 10Co 9Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.KING, CardColor.CLUB),
                                            new Card(CardValue.QUEEN, CardColor.DIAMOND),
                                            new Card(CardValue.JACK, CardColor.SPADE),
                                            new Card(CardValue.TEN, CardColor.HEART),
                                            new Card(CardValue.NINE, CardColor.CLUB)))),
                    Arguments.arguments(
                            "DTr VCa 10Pi 9Co 8Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.QUEEN, CardColor.CLUB),
                                            new Card(CardValue.JACK, CardColor.DIAMOND),
                                            new Card(CardValue.TEN, CardColor.SPADE),
                                            new Card(CardValue.NINE, CardColor.HEART),
                                            new Card(CardValue.EIGHT, CardColor.CLUB)))),
                    Arguments.arguments(
                            "VTr 10Ca 9Pi 8Co 7Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.JACK, CardColor.CLUB),
                                            new Card(CardValue.TEN, CardColor.DIAMOND),
                                            new Card(CardValue.NINE, CardColor.SPADE),
                                            new Card(CardValue.EIGHT, CardColor.HEART),
                                            new Card(CardValue.SEVEN, CardColor.CLUB)))),
                    Arguments.arguments(
                            "10Tr 9Ca 8Pi 7Co 6Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.TEN, CardColor.CLUB),
                                            new Card(CardValue.NINE, CardColor.DIAMOND),
                                            new Card(CardValue.EIGHT, CardColor.SPADE),
                                            new Card(CardValue.SEVEN, CardColor.HEART),
                                            new Card(CardValue.SIX, CardColor.CLUB)))),
                    Arguments.arguments(
                            "9Tr 8Ca 7Pi 6Co 5Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.NINE, CardColor.CLUB),
                                            new Card(CardValue.EIGHT, CardColor.DIAMOND),
                                            new Card(CardValue.SEVEN, CardColor.SPADE),
                                            new Card(CardValue.SIX, CardColor.HEART),
                                            new Card(CardValue.FIVE, CardColor.CLUB)))),
                    Arguments.arguments(
                            "8Tr 7Ca 6Pi 5Co 4Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.EIGHT, CardColor.CLUB),
                                            new Card(CardValue.SEVEN, CardColor.DIAMOND),
                                            new Card(CardValue.SIX, CardColor.SPADE),
                                            new Card(CardValue.FIVE, CardColor.HEART),
                                            new Card(CardValue.FOUR, CardColor.CLUB)))),
                    Arguments.arguments(
                            "7Tr 6Ca 5Pi 4Co 3Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.SEVEN, CardColor.CLUB),
                                            new Card(CardValue.SIX, CardColor.DIAMOND),
                                            new Card(CardValue.FIVE, CardColor.SPADE),
                                            new Card(CardValue.FOUR, CardColor.HEART),
                                            new Card(CardValue.THREE, CardColor.CLUB)))),
                    Arguments.arguments(
                            "6Tr 5Ca 4Pi 3Co 2Tr",
                            new Hand(
                                    List.of(
                                            new Card(CardValue.SIX, CardColor.CLUB),
                                            new Card(CardValue.FIVE, CardColor.DIAMOND),
                                            new Card(CardValue.FOUR, CardColor.SPADE),
                                            new Card(CardValue.THREE, CardColor.HEART),
                                            new Card(CardValue.TWO, CardColor.CLUB)))));
        }

        private static Stream<Arguments> provideInvalidHandStrings() {
            return Stream.of(
                    Arguments.of("A21"),
                    Arguments.of("123dc"),
                    Arguments.of("11"),
                    Arguments.of("12"),
                    Arguments.of(""),
                    Arguments.of(" "),
                    Arguments.of("  "),
                    Arguments.of("\n"),
                    Arguments.of("\t"),
                    Arguments.of("1"),
                    Arguments.of("0"),
                    Arguments.of("13"),
                    Arguments.of("Z"),
                    Arguments.of("A K Q J 99"),
                    Arguments.of("A K aj J 10"),
                    Arguments.of("9i K Q J 10"),
                    Arguments.of("8 2 3 1 9"));
        }

        @ParameterizedTest
        @DisplayName("Test valid hand strings")
        @MethodSource("provideValidHandStrings")
        void test_fromString_WhenGivenValidString_ReturnsCorrectHand(
                String handString, Hand expectedHand) {
            assertEquals(expectedHand, Hand.fromString(handString));
        }

        @ParameterizedTest
        @DisplayName("Test invalid hand strings")
        @MethodSource("provideInvalidHandStrings")
        void test_fromString_WhenGivenInvalidString_ThrowsIllegalArgumentException(
                String handString) {
            assertThrows(IllegalArgumentException.class, () -> Hand.fromString(handString));
        }
    }

    @Nested
    @DisplayName("Test comparison between two hands")
    class TestComparison {
        @Nested
        @DisplayName("Test the equals method")
        class TestEquals {
            @Test
            void test_equals_WhenGivenEqualHands_ReturnsTrue() {
                Hand hand1 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                Hand hand2 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                assertEquals(hand1, hand2);

                Hand hand3 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                Hand hand4 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                assertEquals(hand3, hand4);
            }

            @Test
            void test_equals_WhenGivenDifferentObjects_ReturnsFalse() {
                Hand hand1 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                assertNotEquals(hand1, new Object());
            }

            @Test
            void test_equals_WhenGivenDifferentHandTypes_ReturnsFalse() {
                Hand hand1 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                Hand hand2 = new Hand(List.of(new Card(CardValue.KING, CardColor.CLUB)));
                assertNotEquals(hand1, hand2);

                Hand hand3 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                Hand hand4 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.NINE, CardColor.CLUB)));
                assertNotEquals(hand3, hand4);
            }
        }

        @Nested
        @DisplayName("Test the hashcode method")
        class TestHashCode {
            @Test
            void test_hashcode_WhenGivenEqualHands_ReturnsTheSameHashCode() {
                Hand hand1 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                Hand hand2 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                assertEquals(hand1.hashCode(), hand2.hashCode());

                Hand hand3 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                Hand hand4 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                assertEquals(hand3.hashCode(), hand4.hashCode());
            }

            @Test
            void test_hashcode_WhenGivenDifferentHandTypes_ReturnsDifferentHashcode() {
                Hand hand1 = new Hand(List.of(new Card(CardValue.ACE, CardColor.CLUB)));
                Hand hand2 = new Hand(List.of(new Card(CardValue.KING, CardColor.CLUB)));
                assertNotEquals(hand1.hashCode(), hand2.hashCode());

                Hand hand3 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.TEN, CardColor.CLUB)));
                Hand hand4 =
                        new Hand(
                                List.of(
                                        new Card(CardValue.ACE, CardColor.CLUB),
                                        new Card(CardValue.KING, CardColor.CLUB),
                                        new Card(CardValue.QUEEN, CardColor.CLUB),
                                        new Card(CardValue.JACK, CardColor.CLUB),
                                        new Card(CardValue.NINE, CardColor.CLUB)));
                assertNotEquals(hand3.hashCode(), hand4.hashCode());
            }
        }
    }
}
