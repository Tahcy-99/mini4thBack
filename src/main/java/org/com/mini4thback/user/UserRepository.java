package org.com.mini4thback.user;

import org.com.mini4thback.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
