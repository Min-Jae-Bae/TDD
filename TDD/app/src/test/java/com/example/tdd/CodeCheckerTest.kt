package com.example.tdd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class CodeCheckerTest {

    class PasswordStrengthTest {

        @DisplayName("모든 규칙을 충족하는 테스트")
        @Test
        fun `When meet all criteria expect strong`() {
            val meter = PasswordStrengthMeter() // 암호 강함 측정 클래스 생성하고 meter 변수에 넣음
            val result: PasswordStrength =
                meter.meter("aA123!58") // 결과 변수 타입은 암호 강함  = 그것은 측정 클래스의 측정 기능으로 "aA123!58"를 측정한 것
            assertEquals(PasswordStrength.STRONG, result) // 강력한 암호라는 것을 증명함
        }

        @DisplayName("길이만 8글자 미만이고 나머지 충족하는 테스트")
        @Test
        fun `When meet all criteria except for less than 8 characters expect normal`() {
            val meter = PasswordStrengthMeter()
            val result: PasswordStrength = meter.meter("a!123A4")
            assertEquals(PasswordStrength.NORMAL, result)

        }

        @DisplayName("숫자를 포함하지 않고 나머지 충족하는 테스트")
        @Test
        fun `When meet all criteria except for number expect normal`() {
            val meter = PasswordStrengthMeter()
            val result: PasswordStrength = meter.meter("!@ah!gf#")
            assertEquals(PasswordStrength.NORMAL, result)
        }
    }
}

