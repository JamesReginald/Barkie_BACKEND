package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.WalletRepository;
import com.barkie.barkie.domein.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class doesn't extends from DefaultServiceImplementation because you don't want te return all Wallet objects
 */
@Service
public class WalletService {

    /** WalletRepository object to persist Wallet objects */
    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet getFromId(Long id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        return null;
    }

    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Iterable<Wallet> getAll() {
        return walletRepository.findAll();
    }
}
