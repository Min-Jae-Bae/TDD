package com.example.tdd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class CodeCheckerTest {

    class PasswordStrengthTest {

        @DisplayName("모든 규칙을 충족")
        @Test
        fun `When meetAllRules expect strength`() {
            val meter = PasswordStrengthMeter() // 암호 강함 측정 클래스 생성하고 meter 변수에 넣음
            val result: PasswordStrength = meter.meter("aA123!58") // 결과 변수 타입은 암호 강함  = 그것은 측정 클래스의 측정 기능으로 "aA123!58"를 측정한 것
            assertEquals(PasswordStrength.STRONG, result) // 강력한 암호라는 것을 증명함
        }
    }
}

