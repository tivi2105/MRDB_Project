package com.mrdb;

import com.mrdb.entities.UserEntity;
import com.mrdb.entities.UserEntityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class MrdbApplicationTests {
	@Autowired
	private UserEntityRepository repo;

	@Test
	public void testingUserEntity() {
		UserEntity user = new UserEntity("Santoshi", "GOD", "Thopugunta", "santo1303",
				"santoshi@gmail.com", "5123955856", "123");
		UserEntity savedUser = repo.save(user);
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
	}

}
