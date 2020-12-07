package ru.geekbrains;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class MainTest {


    @ParameterizedTest
    @MethodSource("valuesProviderArray")
    void shouldReturnNumbersAfterFour(int[] expected, int[] nums){
        Assertions.assertArrayEquals(expected, Main.getAllAfterLastFour(nums));
    }

    @Test
    void shouldThrowNumbersAfterFourException() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, () -> Main.getAllAfterLastFour(new int[]{1,1,1}));
    }


    @ParameterizedTest
    @MethodSource("valuesProvider")
    void shouldCheckBooleanIsOneOrFourCheckArray(boolean expected, int[] nums){
        Assertions.assertEquals(expected, Main.isOneOrFourCheckArray(nums));
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1,1,4,4}),
                Arguments.arguments(false, new int[]{2,3})
        );
    }

    private static Stream<Arguments> valuesProviderArray() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{2, 3}, new int[]{1, 2, 4, 4, 2, 3}),
                Arguments.arguments(new int[]{3}, new int[]{1, 2, 4, 3})
        );
    }

}
