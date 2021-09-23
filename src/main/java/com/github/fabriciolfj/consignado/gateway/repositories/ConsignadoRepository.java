package com.github.fabriciolfj.consignado.gateway.repositories;

import com.github.fabriciolfj.consignado.gateway.repositories.entities.ConsignadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsignadoRepository extends JpaRepository<ConsignadoEntity, Long> {

    Optional<ConsignadoEntity> findByCode(final String code);

    @Query(value = "Select * from Consignado c where c.status = :status order by c.data_primeiro_vencimento desc limit 5", nativeQuery = true)
    List<ConsignadoEntity> findTop5ByStatusByOrderByDueDateAsc(@Param("status") final int status);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update from ConsignadoEntity c set c.status = ?1, c.describeError = ?2 where c.code = ?3")
    void updateStatus(final int status, final String describeError, final String code);
}
