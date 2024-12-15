package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int CREW_MIN_NUMBER = 1;
    private static final int CREW_MAX_NUMBER = 10_000;
    private static final int CREW_INFO_SIZE = 2;
    private static final int EMAIL_MIN_LENGTH = 11;
    private static final int EMAIL_MAX_LENGTH = 20;
    private static final String EMAIL_DOMAIN = "email.com";
    private static final String NICKNAME_KOREAN_REGEX = "^[가-힣]+$";
    private static final int NICKNAME_MIN_LENGTH = 1;
    private static final int NICKNAME_MAX_LENGTH = 19;

    public static List<String> solution(List<List<String>> forms) {
        validateForms(forms);

        Map<String, Set<String>> twoLettersToEmailMap = buildTwoLettersMap(forms);
        Set<String> duplicateEmails = findDuplicateEmails(twoLettersToEmailMap);
        return duplicateEmails.stream()
                .sorted()
                .toList();
    }

    private static Map<String, Set<String>> buildTwoLettersMap(List<List<String>> forms) {
        Map<String, Set<String>> twoLettersToEmailMap = new HashMap<>();
        forms.forEach(form -> addTwoLettersToMap(form, twoLettersToEmailMap));
        return twoLettersToEmailMap;
    }

    private static void addTwoLettersToMap(List<String> form, Map<String, Set<String>> map) {
        String email = form.getFirst();
        String nickname = form.getLast();

        for (int i = 1; i < nickname.length(); i++) {
            String twoLetters = nickname.substring(i-1, i + 1);
            map.computeIfAbsent(twoLetters, k -> new HashSet<>())
                    .add(email);
        }
    }

    private static Set<String> findDuplicateEmails(Map<String, Set<String>> twoLettersToEmailMap) {
        return twoLettersToEmailMap.values().stream()
                .filter(emails -> emails.size() > 1)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private static void validateForms(List<List<String>> forms) {
        validateCrew(forms);

        forms.forEach(form -> {
            validateEmail(form.getFirst());
            validateNickname(form.getLast());
        });
    }

    private static void validateCrew(List<List<String>> forms) {
        validateCrewNumber(forms);
        validateCrewInfoSize(forms);
    }

    private static void validateEmail(String email) {
        validateEmailLength(email);
        validateEmailDomain(email);
    }

    private static void validateNickname(String nickName) {
        validateNicknameKorean(nickName);
        validateNicknameLength(nickName);
    }

    private static void validateCrewNumber(List<List<String>> forms) {
        if (forms.size() < CREW_MIN_NUMBER || forms.size() > CREW_MAX_NUMBER) {
            throw new IllegalArgumentException("Crew number must be between " + CREW_MIN_NUMBER + " and " + CREW_MAX_NUMBER);
        }
    }

    private static void validateCrewInfoSize(List<List<String>> forms) {
        forms.forEach(form -> {
            if (form.size() != CREW_INFO_SIZE) {
                throw new IllegalArgumentException("Crew info must contain exactly " + CREW_INFO_SIZE + " elements");
            }
        });
    }

    private static void validateEmailLength(String email) {
        if (email.length() < EMAIL_MIN_LENGTH || email.length() > EMAIL_MAX_LENGTH) {
            throw new IllegalArgumentException("Email length must be between " + EMAIL_MIN_LENGTH + " and " + EMAIL_MAX_LENGTH);
        }
    }

    private static void validateEmailDomain(String email) {
        if (!email.endsWith(EMAIL_DOMAIN)) {
            throw new IllegalArgumentException("Email domain must be " + EMAIL_DOMAIN);
        }
    }

    private static void validateNicknameKorean(String nickname) {
        if (!nickname.matches(NICKNAME_KOREAN_REGEX)) {
            throw new IllegalArgumentException("Nickname must be " + NICKNAME_KOREAN_REGEX);
        }
    }

    private static void validateNicknameLength(String nickname) {
        if (nickname.length() < NICKNAME_MIN_LENGTH || nickname.length() > NICKNAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Nickname length must be between " + NICKNAME_MIN_LENGTH + " and " + NICKNAME_MAX_LENGTH);
        }
    }


}
