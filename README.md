# Practice JPA for remind

### 영속성 컨텍스트의 변경 내용 데이터베이스에 반영 방법(플러시)
1) 직접호출 : em.flush()  
2) 트랜잭션 커밋 시 자동호출  
3) JPQL 쿼리 실행 시 자동호출  
* 플러시모드  
FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시(기본값)  
FlushModeType.COMMIT : 커밋할 때만 플러시  

플러시는 영속성 컨텍스트에 보관된 엔티티를 지우는게 아니고 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화 하는 것  
  
### 준영속 상태
영속성 컨텍스트의 관리를 벗어난 상태
  
1. detach() : 
2. clear()
3. close()