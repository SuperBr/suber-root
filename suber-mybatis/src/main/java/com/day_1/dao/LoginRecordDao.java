package com.day_1.dao;

import com.day_1.model.ex.LoginRecordDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangyongchao
 * @date 2019/2/14  11:00
 */
public interface LoginRecordDao {

    List<LoginRecordDto> selectAll();
}
