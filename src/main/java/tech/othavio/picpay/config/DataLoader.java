package tech.othavio.picpay.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import tech.othavio.picpay.entity.WalletType;
import tech.othavio.picpay.repository.WalletTypeRepository;

import java.util.Arrays;

//@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Abordagem mais conservadora - verifica por count
        if (walletTypeRepository.count() == 0) {
            Arrays.stream(WalletType.Enum.values())
                    .map(WalletType.Enum::get)
                    .forEach(walletTypeRepository::save);
            System.out.println("WalletTypes carregados com sucesso!");
        }
    }
}