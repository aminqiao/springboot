package com.boot.dao;

import com.boot.model.Userinfo;

public interface UserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    int insert(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    int insertSelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    Userinfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    int updateByPrimaryKeySelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinfo
     *
     * @mbg.generated Mon Dec 18 23:12:46 CST 2017
     */
    int updateByPrimaryKey(Userinfo record);
}