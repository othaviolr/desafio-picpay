package tech.othavio.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.othavio.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
