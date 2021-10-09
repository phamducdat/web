package com.IT.IT4409.repo;
import com.IT.IT4409.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findById(Integer id);


//    User findByName(String name);

}