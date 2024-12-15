package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ExtractorTest extends NsTest {
    private final Extractor extractor = new Extractor();
    private final List<String> INITIAL_DELIMITERS = List.of(",", ":");

    @Test
    void 기본_구분자_추출_기능() {
        String input = "1,2:3;4&&5#6";
        List<String> expectedDelimiters = new ArrayList<>(INITIAL_DELIMITERS);
        String expectedInput = input;

        assertEquals(expectedDelimiters, extractor.extractDelimiters(input));
        assertEquals(expectedInput, extractor.extractInput(input));
    }

    @Test
    void 커스텀_구분자_문자_추출_기능() {
        String input = "//;\\n1,2:3;4&&5#6";
        List<String> expectedDelimiters = new ArrayList<>(INITIAL_DELIMITERS) {{
            add(";");
        }};
        String expectedInput = "1,2:3;4&&5#6";

        assertEquals(expectedDelimiters, extractor.extractDelimiters(input));
        assertEquals(expectedInput, extractor.extractInput(input));
    }

    @Test
    void 커스텀_구분자_문자열_추출_기능() {
        String input = "//&&\\n1,2:3;4&&5#6";
        List<String> expectedDelimiters = new ArrayList<>(INITIAL_DELIMITERS) {{
            add("&&");
        }};
        String expectedInput = "1,2:3;4&&5#6";

        assertEquals(expectedDelimiters, extractor.extractDelimiters(input));
        assertEquals(expectedInput, extractor.extractInput(input));
    }

    @Test
    void 앞부분_커스텀_구분자_문자열_추출_기능() {
        String input = "//#\\n1,2:3;//;\\n4&&5#6";
        List<String> expectedDelimiters = new ArrayList<>(INITIAL_DELIMITERS) {{
            add("#");
        }};
        String expectedInput = "1,2:3;//;\\n4&&5#6";

        assertEquals(expectedDelimiters, extractor.extractDelimiters(input));
        assertEquals(expectedInput, extractor.extractInput(input));

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
