package cn.dazky.service;

import cn.dazky.pojo.Item;

import java.util.List;

/**
 * @author Mr.chen
 * @2019-04-22 10:35
 */
public interface ItemSetvice     {
    /**
     * 查询商品列表
     *
     * @return
     */
    List<Item> queryItemList();

    /**
     * 根据主键的值获得单个对象
     * @param id
     * @return
     */
    Item selectItemById(int id);

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     */
    List<Item> queryByName(String name);

}
