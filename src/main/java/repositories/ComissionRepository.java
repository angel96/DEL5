
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;
import domain.Comission;

@Repository
public interface ComissionRepository extends JpaRepository<Comission, Integer> {

	@Query("select a from Actor a where a.account.id = ?1")
	Actor findActorByUserAccountId(int id);

	@Query("select c from Comission c where c.member.id = ?1")
	Collection<Comission> getComissionsByMemberId(final int idMember);
}
