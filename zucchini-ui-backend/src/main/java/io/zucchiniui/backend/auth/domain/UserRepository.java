package io.zucchiniui.backend.auth.domain;

import io.zucchiniui.backend.support.ddd.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {

    Optional<User> findByNameAndPassword(String name, String password);

}