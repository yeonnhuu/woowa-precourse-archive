package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int CREW_NUMBER_MIN = 1;
    private static final int CREW_NUMBER_MAX = 10_000;
    private static final int EMAIL_LENGTH_MIN = 11;
    private static final int EMAIL_LENGTH_MAX = 20;
    private static final String EMAIL_DOMAIN = "email.com";
    private static final String NICKNAME_KOREAN_REGEX = "^[가-힣]+$";
    private static final int NICKNAME_LENGTH_MIN = 1;
    private static final int NICKNAME_LENGTH_MAX = 20;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        validate(forms);
        answer = getLimitEmails(forms);
        return answer;
    }

    private static List<String> getLimitEmails(List<List<String>> forms) {
        List<String> formNicknames = getFormNicknames(forms);
        Map<String, Set<String>> twoLettersMap = buildTwoLettersMap(formNicknames);
        return forms.stream()
                .filter(form -> hasConflictingTwoLetters(form.getLast(), twoLettersMap))
                .map(List::getFirst)
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> getFormNicknames(List<List<String>> forms) {
        return forms.stream()
                .map(List::getLast)
                .collect(Collectors.toList());
    }

    private static Map<String, Set<String>> buildTwoLettersMap(List<String> nicknames) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String nickname : nicknames) {
            for (int i = 1; i < nickname.length(); i++) {
                String letters = nickname.substring(i-1, i+1);
                result.computeIfAbsent(letters, k -> new HashSet<>()).add(nickname);
            }
        }
        return result;
    }

    private static boolean hasConflictingTwoLetters(String nickname, Map<String, Set<String>> twoLettersMap) {
        for (int i = 1; i < nickname.length(); i++) {
            String letters = nickname.substring(i-1, i+1);
            if (twoLettersMap.getOrDefault(letters, Collections.emptySet()).size() > 1) {
                return true;
            }
        }
        return false;
    }

    private static void validate(List<List<String>> forms) {
        validateCrewNumber(forms);
        validateForm(forms);
    }

    private static void validateCrewNumber(List<List<String>> forms) {
        if (forms.size() < CREW_NUMBER_MIN || forms.size() > CREW_NUMBER_MAX) {
            throw new IllegalArgumentException("Crew number is invalid");
        }
    }

    private static void validateForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            validateEmail(form.getFirst());
            validateNickname(form.getLast());
        }
    }

    private static void validateEmail(String email) {
        validateEmailLength(email);
        validateEmailDomain(email);
    }

    private static void validateNickname(String nickname) {
        validateNicknameKorean(nickname);
        validateNicknameLength(nickname);
    }

    private static void validateEmailLength(String email) {
        if (email.length() < EMAIL_LENGTH_MIN || email.length() > EMAIL_LENGTH_MAX) {
            throw new IllegalArgumentException("Email length is invalid");
        }
    }

    private static void validateEmailDomain(String email) {
        if (!email.endsWith(EMAIL_DOMAIN)) {
            throw new IllegalArgumentException("Email domain is invalid");
        }
    }

    private static void validateNicknameKorean(String nickname) {
        if (!nickname.matches(NICKNAME_KOREAN_REGEX)) {
            throw new IllegalArgumentException("Nickname korean is invalid");
        }
    }

    private static void validateNicknameLength(String nickname) {
        if (nickname.length() < NICKNAME_LENGTH_MIN || nickname.length() > NICKNAME_LENGTH_MAX) {
            throw new IllegalArgumentException("Nickname length is invalid");
        }
    }
}
