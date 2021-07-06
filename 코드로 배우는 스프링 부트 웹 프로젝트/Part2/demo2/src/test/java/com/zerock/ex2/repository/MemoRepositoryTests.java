package com.zerock.ex2.repository;

import com.zerock.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder()
                .text("Sample-" + i)
                .build();

            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=========================");

        if(result.isPresent()) {
            Memo memo = result.get();

            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {
        Long mno = 100L;

//        Memo memo = memoRepository.getOne(mno);
        // 책에서는 getOne을 사용했으나 현재 Deprecate 되어 getById로 사용함.
        Memo memo = memoRepository.getById(mno);

        System.out.println("=========================");
        System.out.println(memo);
    }

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder()
                .mno(100L)
                .text("Update Text")
                .build();

        System.out.println(memoRepository.save(memo));
    }
}
