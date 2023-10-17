package com.example.securitytest.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,String>{
}
