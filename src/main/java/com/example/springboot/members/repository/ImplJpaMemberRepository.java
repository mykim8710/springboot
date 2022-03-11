package com.example.springboot.members.repository;

//@RequiredArgsConstructor
//@Repository  implements JpaMemberRepository
public class ImplJpaMemberRepository {

//    private final EntityManager em;  // EntityManager를 통해 JPA 실행
//
//    @Override
//    public JPAMember save(JPAMember jpaMember) {
//        em.persist(jpaMember);  // insert Query
//        return jpaMember;
//    }
//
//    @Override
//    public Optional<JPAMember> findById(Long id) {
//        JPAMember jpaMember = em.find(JPAMember.class, id);   // select Query By id(pk)
//        return Optional.ofNullable(jpaMember);
//    }
//
//
//    // List 및 조건을 필요로하는 것은 query(JPQL)를 작성해야함
//    @Override
//    public Optional<JPAMember> findByName(String name) {
//        List<JPAMember> result = em.createQuery("select m from JPAMember m where m.name = :name", JPAMember.class)
//                                            .setParameter("name", name)
//                                            .getResultList();
//
//        return result.stream().findAny(); // findAny()는 Stream에서 가장 먼저 탐색되는 요소를 리턴
//    }
//
//    @Override
//    public List<JPAMember> findAll() {
//        return em.createQuery("select m from JPAMember m", JPAMember.class)   // m == sql문의 AS , *(sql) == m
//                .getResultList();
//    }
}
