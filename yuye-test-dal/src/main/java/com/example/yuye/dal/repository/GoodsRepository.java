//package com.example.yuye.dal.repository;
//
//
//import com.example.yuye.dal.model.Goods;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
///**
// * @author zhouliang
// * @date 2022/7/25 10:50 AM
// */
//public interface GoodsRepository extends JpaRepository<Goods, Long> {
//    List<Goods> findAllByGoodsIdBetween(Long goodsId1, Long goodsId2);
//
//    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);
//}
