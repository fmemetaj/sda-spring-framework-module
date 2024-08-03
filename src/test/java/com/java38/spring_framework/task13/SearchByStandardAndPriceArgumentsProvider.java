package com.java38.spring_framework.task13;

import com.java38.spring_framework.exercises.task13.Reservation;
import com.java38.spring_framework.exercises.task13.Standard;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SearchByStandardAndPriceArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        ),
                        Standard.NORMAL,
                        300.0f,
                        List.of(
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        )
                ),
                Arguments.arguments(
                        Collections.emptyList(),
                        Standard.NORMAL,
                        200.0f,
                        Collections.emptyList()
                ),
                Arguments.arguments(
                        Arrays.asList(
                                new Reservation(1L, "res1", "hotel1", 2, Standard.NORMAL, 250.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(2L, "res2", "hotel1", 2, Standard.NORMAL, 280.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(3L, "res3", "hotel1", 2, Standard.NORMAL, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1)),
                                new Reservation(4L, "res4", "hotel1", 2, Standard.EXCLUSIVE, 300.0f, LocalDate.now(), LocalDate.now().plusDays(1))
                        ),
                        Standard.EXCLUSIVE,
                        400.0f,
                        Collections.emptyList()
                )
        );
    }
}
