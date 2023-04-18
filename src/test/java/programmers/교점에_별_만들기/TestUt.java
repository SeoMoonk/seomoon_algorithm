package programmers.교점에_별_만들기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestUt {


    @Test
    @DisplayName("t001")
    void t001(){

        // 일반호출
        new Solution().intersection(
                new int[]{1, -1, 0},
                new int[]{2, -1, 0}
        );

        // 리플렉션을 이용한 호출
        (Point) TestUt.call(
                new Solution(),
                "intersection",
                new int[]{1, -1, 0},
                new int[]{2, -1, 0}
        );
    }
}
