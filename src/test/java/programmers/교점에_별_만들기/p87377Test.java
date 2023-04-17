package programmers.교점에_별_만들기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class p87377Test {

    @Test
    @DisplayName("교점, [[1, -1, 0], [2, -1, 0]]")
    void t001() {
        assertThat(new Solution().intersection(
                        new int[]{1, -1, 0},
                        new int[]{2, -1, 0}
                )
        ).isEqualTo(
                new long[]{0, 0}
        );
    }


}