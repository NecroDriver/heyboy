package com.mafh.repository;

import com.mafh.dao.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mafh on 2017/6/27 0027.09:51
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);
}
