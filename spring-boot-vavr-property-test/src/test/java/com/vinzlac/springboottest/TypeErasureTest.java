package com.vinzlac.springboottest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TypeErasureTest {

  @Test
  public void givenIntegerStack_whenStringPushedAndAssignPoppedValueToInteger_shouldFail() {
    IntegerStack integerStack = new IntegerStack();
    Stack stack = integerStack;
    stack.push("Hello"); // compile ok - no exception
    Assertions.assertThatThrownBy(
            () -> {
              Integer data = integerStack.pop(); // java.lang.ClassCastException
            })
        .isInstanceOf(ClassCastException.class);
  }

  public final class IntegerStack extends Stack<Integer> {}
}
