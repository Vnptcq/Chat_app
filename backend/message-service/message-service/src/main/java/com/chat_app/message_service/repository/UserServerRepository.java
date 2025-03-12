package com.chat_app.message_service.repository;

import com.chat_app.message_service.entity.UserServer;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServerRepository extends JpaRepository<UserServer, String> {
}
