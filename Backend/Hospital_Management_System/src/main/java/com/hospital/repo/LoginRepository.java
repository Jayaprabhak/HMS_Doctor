package com.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.bean.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
