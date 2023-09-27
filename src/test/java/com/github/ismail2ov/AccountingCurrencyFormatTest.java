package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.NumberFormat;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class AccountingCurrencyFormatTest {

    @Test
    void testAccountingCurrencyFormat() {
        // Example *without* language tag extension
        Locale locale = Locale.forLanguageTag("en-US");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

        // Example *with* language tag extension
        Locale localeAccounting = Locale.forLanguageTag("en-US-u-cf-account");
        NumberFormat cfAccounting = NumberFormat.getCurrencyInstance(localeAccounting);

        assertThat(cf.format(-14.95)).isEqualTo("-$14.95");
        assertThat(cfAccounting.format(-14.95)).isEqualTo("($14.95)");
    }
}
