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

숫자를 포함하지 않는 경우 NORMAL 값 리턴
문자열 하나하나를 선택하여 확인 숫자가 있으면 true 반환
-> 기본 값 포함되어 있지 않음(false), 변수 ContainNumber, 문자열 변수 char 문자열을 하나씩 확인하기 위해서 for 사용, 문자열을
확인하는 범위 값, 각 문자열에 대해 포함되어 있으면 true 그렇지 않으면 false 반환
숫자가 포함되어 있으면 STRONG 반환, 포함되지 않았으면 NORMAL 반환

숫자 포함 확인 containNumber
문자열 안에 숫자 (0~9)가 있는지 인덱스마다 확인 ( for )

숫자를 포함 했을 때  ( True )
- STRONG 반환
- break

숫자를 포함 하지 않았을 때 ( False )
-NORMAL 반환
*/

enum class PasswordStrength {
    STRONG,
    NORMAL,
    INVALID,
    WEAK

}

class PasswordStrengthMeter {
    fun meter(s: String?): PasswordStrength {
        // 값이 없을 때 ,공백 값일 때
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID
        // 8글자 미만이면 NORMAL 값 리턴
        if (s.length < 8) {
            return PasswordStrength.NORMAL
        }
        // 길이가 8글자 이상을 충족하는 조건
        val lengthEnough = s.length >= 8

        // 숫자를 받아 포함되어 있는 조건
        val containNumber = meetsContainingNumberCriteria(s)

        // 대문자가 포함되어 있는 조건
        val containUppercase = meetsContainingUppercaseCriteria(s)


        // 길이가 8글자만 충족할 때
        if (lengthEnough && !containNumber && !containUppercase) return PasswordStrength.WEAK
        // 숫자 포함 조건만 충족할 때
        if (!lengthEnough && containNumber && !containUppercase) return PasswordStrength.WEAK

        if (!lengthEnough) return PasswordStrength.NORMAL
        if (!containNumber) return PasswordStrength.NORMAL
        if (!containUppercase) return PasswordStrength.NORMAL

        return PasswordStrength.STRONG
    }

    // 문자를 받아 대문자가 포함되어 있는지 확인해 주는 기능
    private fun meetsContainingUppercaseCriteria(s: String): Boolean {
        for (i in s.indices) {
            val char = s[i]
            if (char.isUpperCase()) {
                return true
            }
        }
        return false
    }


    // 문자를 받아 숫자가 포함되어 있는지 확인해주는 기능. 변수 중복 제거 리턴 값을 함수 Boolean 으로
    // TODO: 기능에 문제점이 있다. 다시 확인해 보자
    private fun meetsContainingNumberCriteria(s: String): Boolean {
        for (i in s.indices) {
            val char = s[i]
            if (char in '0'..'9') {
                return true
            }
        }
        return false
    }


}

