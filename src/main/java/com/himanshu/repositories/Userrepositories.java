package com.himanshu.repositories;

//package com.himanshu.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.entities.User;

public interface Userrepositories extends JpaRepository<User, Long> {
}

