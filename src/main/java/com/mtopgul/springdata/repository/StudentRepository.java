package com.mtopgul.springdata.repository;

import com.mtopgul.springdata.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muhammed-topgul
 * @since 16/06/2023 08:34
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
