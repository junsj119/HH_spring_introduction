package com.sparta.spring01test.controller;
import com.sparta.spring01test.domain.Memo;
import com.sparta.spring01test.domain.MemoRepository;
import com.sparta.spring01test.domain.MemoRequestDto;
import com.sparta.spring01test.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController //스프링이 알아서 해줘~
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){     //RequestBody - 써줘야한다. DTO에 넣어야지~
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();

        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
        //두 코드 다 최근순정렬
        //return memoRepository.findAllByOrderByModifiedAtDesc();
        //return memoRepository.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));    //조금 더 깊게 알아보자
    }

    @DeleteMapping("/api/memos/{id}")
    public String deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        if(memoService.update(id, requestDto)) {
            memoRepository.deleteById(id);
            return "true";
        }else{
            return "false";
        }
    }

    @PutMapping("/api/memos/{id}")
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        if(memoService.update(id, requestDto)) {
            return "true";
        }else{
            return "false";
        }
    }
}
