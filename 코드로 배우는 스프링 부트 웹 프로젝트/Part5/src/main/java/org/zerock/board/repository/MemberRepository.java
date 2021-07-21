package org.zerock.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.board.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
