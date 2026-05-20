package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.ProfilePic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfilePicRepository extends JpaRepository<ProfilePic, UUID> {

}
