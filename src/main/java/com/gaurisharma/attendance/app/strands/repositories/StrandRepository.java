

package com.gaurisharma.attendance.app.strands.repositories;

import com.gaurisharma.attendance.app.strands.models.entities.Strand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrandRepository extends JpaRepository<Strand, Integer> {
}