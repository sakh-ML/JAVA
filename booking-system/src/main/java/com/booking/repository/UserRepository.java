package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.booking.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(String role);
}
