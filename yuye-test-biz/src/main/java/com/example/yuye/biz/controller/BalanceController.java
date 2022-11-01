package com.example.yuye.biz.controller;

import com.example.yuye.dal.entity.Balance;
import com.example.yuye.biz.service.BalanceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Balance)表控制层
 *
 * @author makejava
 * @since 2022-07-27 15:39:27
 */
@RestController
@RequestMapping("balance")
public class BalanceController {
    /**
     * 服务对象
     */
    @Resource
    private BalanceService balanceService;

    /**
     * 分页查询
     *
     * @param balance     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Balance>> queryByPage(Balance balance, PageRequest pageRequest) {
        return ResponseEntity.ok(this.balanceService.queryByPage(balance, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Balance> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.balanceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param balance 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Balance> add(Balance balance) {
        return ResponseEntity.ok(this.balanceService.insert(balance));
    }

    /**
     * 编辑数据
     *
     * @param balance 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Balance> edit(Balance balance) {
        return ResponseEntity.ok(this.balanceService.update(balance));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.balanceService.deleteById(id));
    }

}

