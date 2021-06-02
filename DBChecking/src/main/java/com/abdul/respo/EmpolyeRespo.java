package com.abdul.respo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdul.entity.EmpolyeEntity;

@Repository

public interface EmpolyeRespo extends JpaRepository<EmpolyeEntity,Long> {

}
