package cn.edu.tongji.uniplus.good_information.repository;

import cn.edu.tongji.uniplus.good_information.model.GoodShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface GoodShoppingCartRepository extends JpaRepository<GoodShoppingCartEntity, Long> {
    void deleteGoodShoppingCartEntitiesByCartUserIdAndCartGoodId(Long userId, Long goodId);

    List<GoodShoppingCartEntity> findGoodShoppingCartEntitiesByCartUserId(Long userId);

    GoodShoppingCartEntity findByCartUserIdAndCartGoodId(Long userId, Long goodId);
}
