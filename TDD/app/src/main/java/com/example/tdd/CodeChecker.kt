package com.example.tdd

/*
암호 검사기 규칙에 따라 암호를 강함, 보통, 약함

검사할 규칙 세가지
1. 길이가 8글자 이상
2. 0부터 9사이의 숫자를 포함
3. 대문자 포함

세 규칙을 모두 충족하면 암호는 강함
2개의 규칙을 충족하면 암호는 보통
1개 이하의 규칙을 충족하면 암호는 약함
*/


enum class PasswordStrength {
    STRONG

}

class PasswordStrengthMeter {
    fun meter(s: String): PasswordStrength {
        return PasswordStrength.STRONG
    }

}

