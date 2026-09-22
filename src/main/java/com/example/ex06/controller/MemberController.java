package com.example.ex06.controller;

import com.example.ex06.entity.Member;
import com.example.ex06.repository.MemberRepository;
import com.example.ex06.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    // 2가지...@Autowird private fianl
    private final MemberService memberService;

//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // members 호출 하게 되면...
//    @GetMapping("members")
    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id){
        System.out.println("id = "+id);
        return null;
    }

    @PostMapping
    public Member save(@RequestBody Member member){
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public Member update(
            @PathVariable Long id,
            @RequestBody Member member) throws Exception {
        return memberService.update(id, member);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "회원을 삭제합니다.", description = "삭제하고싶은 id를 입력하세요.")
    public boolean deleteMember(@PathVariable Long id) throws Exception {
        boolean result = memberService.deleteMember(id);
        return result;
    }

    // MemberController -> MemberSerivce -> MemberRepository ->Member
    // ProductConto
    // 장바구니
    //

    /*
        get방식.. member 테이블 전체조회...
        get방식.. member 테이블 행 한개씩 조회...
     */


}
