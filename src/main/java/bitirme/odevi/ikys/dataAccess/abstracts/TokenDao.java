package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenDao extends JpaRepository<Token, Integer> {

//    @Query(value = """
//      select t from Token t inner join User u\s
//      on t.user.id = u.id\s
//      where u.id = :id and (t.expired = false or t.revoked = false)\s
//      """)
//    List<Token> findAllValidTokenByUser(Integer id);
//
//    Optional<Token> findByToken(String token);
}
