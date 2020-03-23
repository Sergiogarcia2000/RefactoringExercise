package com.gmq.entornos.refactoring.exercice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateTest {

    Evaluate evaluate1;
    Evaluate evaluate2;

    @BeforeEach
    void setUp() {
        evaluate1 = new Evaluate("1", "Pepe",new String[6]);
        evaluate2 = new Evaluate("2", "Francisco");
    }

    @Test
    void should_get_last_evaluation() {
    	
    	evaluate1.evaluate_pupil(3);
    	assertEquals(evaluate1.getLastEvaluation(), "SUSPENSO");
    	evaluate1.evaluate_pupil(6);
    	assertEquals(evaluate1.getLastEvaluation(), "BIEN");
    	evaluate2.evaluate_pupil(7);
    	assertEquals(evaluate2.getLastEvaluation(), "NOTABLE");
    	evaluate2.evaluate_pupil(10);
    	assertEquals(evaluate2.getLastEvaluation(), "SOBRESALIENTE");
    }
    
    @ParameterizedTest
    @MethodSource("evaluatePupilValuesException")
    void throws_evaluate_pupil_exception(int values) {
    	assertThrows(RuntimeException.class, () -> evaluate1.evaluate_pupil(values));
    }

    static Stream<Arguments> evaluatePupilValuesException(){
    	return Stream.of(
                Arguments.of(12),
                Arguments.of(200));
    }
}