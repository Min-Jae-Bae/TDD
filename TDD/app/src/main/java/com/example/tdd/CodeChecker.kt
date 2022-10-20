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
    NORMAL,
    WEAK,
    INVALID

}

class PasswordStrengthMeter {

    fun meter(s: String?): PasswordStrength {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID
        val metCounts = getMetCriteriaCounts(s)
        if (metCounts <= 1) return PasswordStrength.WEAK
        if (metCounts == 2) return PasswordStrength.NORMAL

        return PasswordStrength.STRONG
    }

    private fun getMetCriteriaCounts(s: String): Int {
        var metCounts = 0
        if (s.length >= 8) metCounts++
        if (meetsContainingNumberCriteria(s)) metCounts++
        if (meetsContainingUppercaseCriteria(s)) metCounts++

        return metCounts
    }


    private fun meetsContainingUppercaseCriteria(s: String): Boolean {
        for (i in s.indices) {
            val char = s[i]
            if (char.isUpperCase()) {
                return true
            }
        }
        return false
    }


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

