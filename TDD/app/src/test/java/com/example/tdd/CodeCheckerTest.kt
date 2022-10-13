package com.example.tdd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName

/*
 생성자와, 비밀번호, 측정이 중복되었다.
 하나의 기능으로 뽑았다.

 */

class CodeCheckerTest {

    class PasswordStrengthTest {


        @DisplayName("모든 규칙을 충족하는 테스트")
        @Test
        fun `When meet all criteria expect strong`() {
            assertStrength("aA123!58", PasswordStrength.STRONG)
        }

        @DisplayName("길이만 8글자 미만이고 나머지 충족하는 테스트")
        @Test
        fun `When meet all criteria except for less than 8 characters expect normal`() {
            assertStrength("a!123A4", PasswordStrength.NORMAL)

        }

        @DisplayName("숫자를 포함하지 않고 나머지 충족하는 테스트")
        @Test
        fun `When meet all criteria except for number expect normal`() {
            assertStrength("!@ah!gf#", PasswordStrength.NORMAL)
        }

        private fun assertStrength(password: String, expectedString: PasswordStrength) {
            val meter = PasswordStrengthMeter()
            val result: PasswordStrength = meter.meter(password)
            assertEquals(expectedString, result)
        }
    }
}

