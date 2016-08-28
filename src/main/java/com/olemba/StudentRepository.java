package com.olemba;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz on 28.08.2016.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
