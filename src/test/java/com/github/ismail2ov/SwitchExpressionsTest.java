package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SwitchExpressionsTest {

    @Test
    void testSwitchExpressions() {

        boolean thursday = isWorkDay(DayOfWeek.THURSDAY);
        boolean saturday = isWorkDay(DayOfWeek.SATURDAY);
        boolean yield = isWorkDay(DayOfWeek.SUNDAY);

        assertThat(thursday).isTrue();
        assertThat(saturday).isFalse();
        assertThat(yield).isFalse();
    }

    private boolean isWorkDay(DayOfWeek day) {
        return switch (day) {
            case SATURDAY, SUNDAY -> false;
            default -> true;
        };
    }

    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
