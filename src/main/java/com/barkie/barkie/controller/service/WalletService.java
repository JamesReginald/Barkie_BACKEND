package com.barkie.barkie.controller.service;

import com.barkie.barkie.controller.repository.WalletRepository;
import com.barkie.barkie.domein.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService implements DefaultService<Wallet> {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getFromId(Long id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        return null;
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Iterable<Wallet> getAll() {
        return walletRepository.findAll();
    }
}
