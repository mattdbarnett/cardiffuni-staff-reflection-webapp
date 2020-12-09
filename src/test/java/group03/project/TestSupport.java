package group03.project;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.containsString;

public class TestSupport {

    /*
Code adapted from StackOverflow answer:-
User: Michael W
Question: "Spring MockMvc don't expect content"
URL: https://stackoverflow.com/questions/56657018/spring-mockmvc-dont-expect-content?fbclid=IwAR1OLVXC0Bb8oD35tRUrBDgt8e0IGyatBmAJDhxrDLEMs5FACUubI8kTuJc
 */
    public static Matcher<String> doesNotContainString(String s) {
        return CoreMatchers.not(containsString(s));
    }

}
