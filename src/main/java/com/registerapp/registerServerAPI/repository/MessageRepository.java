package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM message m WHERE (m.sender_id = ?1 AND m.receiver_id = ?2) OR (m.receiver_id = ?1 AND m.sender_id = ?2)", nativeQuery = true)
    List<Message> findAllByUserIdOrReceiver(Long sender_id, Long receiver_id);
}
