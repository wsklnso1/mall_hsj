package org.mall_hsj_mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mall_hsj_mbg.model.TTxException;
import org.mall_hsj_mbg.model.TTxExceptionExample;

public interface TTxExceptionMapper {
    long countByExample(TTxExceptionExample example);

    int deleteByExample(TTxExceptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TTxException record);

    int insertSelective(TTxException record);

    List<TTxException> selectByExample(TTxExceptionExample example);

    TTxException selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TTxException record, @Param("example") TTxExceptionExample example);

    int updateByExample(@Param("record") TTxException record, @Param("example") TTxExceptionExample example);

    int updateByPrimaryKeySelective(TTxException record);

    int updateByPrimaryKey(TTxException record);
}