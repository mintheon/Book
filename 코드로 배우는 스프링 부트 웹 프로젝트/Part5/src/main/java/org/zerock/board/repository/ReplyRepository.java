package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.board.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
