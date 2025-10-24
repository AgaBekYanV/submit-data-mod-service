package com.mod.SubmitModS.Repository;

import com.mod.SubmitModS.Model.UserMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessageEntity, Long> {
}
