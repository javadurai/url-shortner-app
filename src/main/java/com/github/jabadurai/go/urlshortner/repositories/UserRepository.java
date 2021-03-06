package com.github.jabadurai.go.urlshortner.repositories;

import com.github.jabadurai.go.urlshortner.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    @Query("select u from User u where u.userid = ?1")
    User findByUserid(String userid);

    @Modifying
    @Query("update User u set u.password = ?1 where u.userid = ?2")
    int updatePassword(String password, String userid);

    @Modifying
    @Query("update User u set u.email = ?1 where u.userid = ?2")
    int updateEmail(String email, String userid);
}
