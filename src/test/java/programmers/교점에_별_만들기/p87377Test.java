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
                Point.of(0,0)
        );
    }

    @Test
    @DisplayName("교점, [[1, -1, 0], [4, -1, 0]]")
    void t002() {
        assertThat(new Solution().intersection(
                        new int[]{1, -1, 0},
                        new int[]{4, -1, 0}
                )
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점, [[2, -1, 0], [4, -1, 0]]")
    void t003() {
        assertThat(new Solution().intersection(
                        new int[]{2, -1, 0},
                        new int[]{4, -1, 0}
                )
        ).isEqualTo(
                Point.of(0, 0)
        );
    }




}