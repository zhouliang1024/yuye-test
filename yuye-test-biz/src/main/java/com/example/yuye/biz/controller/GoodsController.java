package com.example.yuye.biz.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.example.yuye.biz.component.annotation.OpLog;
import com.example.yuye.biz.component.annotation.WebLog;
import com.example.yuye.dal.mapper.GoodsMapper;
import com.example.yuye.dal.model.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyang
 * @date 2019/1/29
 */
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private KeyGenerator keyGenerator;


    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsMapper.insert(goods);
        }
        return "success";
    }

    @GetMapping("select")
    public String select(){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_name","shangpin13");
        return goodsMapper.selectList(queryWrapper).toString();
    }

    @GetMapping("delete")
    public void delete(){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        goodsMapper.delete(queryWrapper);
    }

    @GetMapping("query1")
    public Object query1(){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("goods_id",10L, 30L);
        return goodsMapper.selectList(queryWrapper);
    }

    @GetMapping("query2")
    @WebLog
    public Object query2(@RequestParam("id1") String test1 , @RequestParam("id2") Integer test2){
        List<Long> goodsIds = new ArrayList<>();
        goodsIds.add(10L);
        goodsIds.add(15L);
        goodsIds.add(20L);
        goodsIds.add(25L);
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("goods_id",goodsIds);
        List<Goods> goods = goodsMapper.selectList(queryWrapper);
        log.debug(JSONUtil.toJsonStr(goods));
        return goods;
    }

    /*@PostMapping("/show")
    public GoodsDetail showGoods(@RequestBody GoodsDetailRequest request) {

        StoryRequest<GoodsDetail> req = ReqBuilder.returnType(GoodsDetail.class)
                .startId("kstry-demo-goods-show").request(request).build();
        TaskResponse<GoodsDetail> fire = storyEngine.fire(req);
        if (fire.isSuccess()) {
            return fire.getResult();
        }
        return null;
    }*/


}