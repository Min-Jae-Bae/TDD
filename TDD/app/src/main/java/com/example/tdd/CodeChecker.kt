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
    STRONG,
    NORMAL

}

class PasswordStrengthMeter {
    fun meter(s: String): PasswordStrength {
        // 8글자 미만이면 NORMAL 값 리턴
        if (s.length < 8) {
            return PasswordStrength.NORMAL
        }
        /*
        숫자를 포함하지 않는 경우 NORMAL 값 리턴
        문자열 하나하나를 선택하여 확인 숫자가 있으면 true 반환
        -> 기본 값 포함되어 있지 않음(false), 변수 ContainNumber, 문자열 변수 char 문자열을 하나씩 확인하기 위해서 for 사용, 문자열을
        확인하는 범위 값, 각 문자열에 대해 포함되어 있으면 true 그렇지 않으면 false 반환
        숫자가 포함되어 있으면 STRONG 반환, 포함되지 않았으면 NORMAL 반환
        */
        var containNumber: Boolean = false
        for (i in s.indices) {
            val char = s.elementAt(i)
            if (char.code < 48 || char.code > 57) {
                containNumber = true
                break
            }
        }
        if (!containNumber) return PasswordStrength.NORMAL

        return PasswordStrength.STRONG
    }

}

