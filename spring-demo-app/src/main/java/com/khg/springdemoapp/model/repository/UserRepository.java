package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Yazılımı kullanıcıları ile veri tabanı sorguları
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Kullanıcı adı (Sicil bilgisi) ile personelin bulunması
     * @param name Kullanıcı adı
     * @return Kullanıcı addına (Sicil) sahip kullanıcı
     */
    User findByUsername(String name);
}
