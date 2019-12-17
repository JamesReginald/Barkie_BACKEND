package com.barkie.barkie.controller.repository;

import com.barkie.barkie.domein.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
}
