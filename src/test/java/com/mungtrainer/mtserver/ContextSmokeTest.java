package com.mungtrainer.mtserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        classes = MtServerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@ActiveProfiles("test")
class ContextSmokeTest {

    @Test
    void contextStarts() {
        // 최소 기동 확인
    }
}
