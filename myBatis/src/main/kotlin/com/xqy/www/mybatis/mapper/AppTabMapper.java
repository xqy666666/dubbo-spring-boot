package com.xqy.www.mybatis.mapper;

import com.xqy.www.mybatis.dao.AppTab;
import java.util.List;

public interface AppTabMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_tab
     *
     * @mbg.generated Mon Apr 16 15:59:16 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_tab
     *
     * @mbg.generated Mon Apr 16 15:59:16 CST 2018
     */
    int insert(AppTab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_tab
     *
     * @mbg.generated Mon Apr 16 15:59:16 CST 2018
     */
    AppTab selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_tab
     *
     * @mbg.generated Mon Apr 16 15:59:16 CST 2018
     */
    List<AppTab> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_tab
     *
     * @mbg.generated Mon Apr 16 15:59:16 CST 2018
     */
    int updateByPrimaryKey(AppTab record);
}