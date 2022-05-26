package com.example.demo.repository;

import com.example.demo.Model.Patient;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
    public List<User> findAllBy();

    @Modifying
    @Query(value = "COPY forjava.public.user TO 'C:\\tmp\\users.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveUsers();

}
