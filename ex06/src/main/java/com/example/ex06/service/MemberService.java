package com.example.ex06.service;

import com.example.ex06.entity.Member;
import com.example.ex06.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        // select * from member;
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        // select * from member where id = ?id;
        Optional<Member> optionalMember =  memberRepository.findById(id);
        return optionalMember.get();
    }

    public Member save(Member member) {
        return  memberRepository.save(member);
    }

    public Member update(Long id, Member member) throws Exception {
        Optional<Member> memberOptional = memberRepository.findById(id);

        System.out.println(memberOptional);
        System.out.println(member);
        if (memberOptional.isPresent()){
            Member temp = memberOptional.get();
            temp.setEmail(member.getEmail());
            temp.setName(member.getName());

            return memberRepository.save(temp);
        }
        else{
            throw new Exception("해당하는 id가 없어서 수정할 내용이 없습니다.");
        }
    }


    public boolean deleteMember(Long id) throws Exception {
        Member member = memberRepository
                .findById(id)
                .orElseThrow(() -> new Exception("해당하는 id "+id+"가 없어서 수정할 내용이 없습니다."));// select * from member where id = ?
        memberRepository.delete(member);
        return true;
    }
}