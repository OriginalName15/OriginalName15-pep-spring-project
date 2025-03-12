package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface MessageRepository extends JpaRepository<Message, Integer>{
    List<Message> findByPostedBy(int accountId);
    Optional<Message> findById(int messageId);
}
