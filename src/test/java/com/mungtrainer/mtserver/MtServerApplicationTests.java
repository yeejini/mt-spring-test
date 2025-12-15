package com.mungtrainer.mtserver;

import com.mungtrainer.mtserver.config.AwsS3TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(AwsS3TestConfig.class)
class MtServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
