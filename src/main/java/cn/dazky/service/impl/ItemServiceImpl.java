package cn.dazky.service.impl;

import cn.dazky.dao.ItemMapper;
import cn.dazky.pojo.Item;
import cn.dazky.pojo.ItemExample;
import cn.dazky.service.ItemSetvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.chen
 * @2019-04-22 10:37
 */
@Service
public class ItemServiceImpl implements ItemSetvice {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Item> queryItemList() {
        return this.itemMapper.selectByExample(null);
    }

    @Override
    public Item selectItemById(int id) {

        return this.itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Item> queryByName(String name) {
        ItemExample example=new ItemExample();
        ItemExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike(name);
        List<Item> list = this.itemMapper.selectByExample(example);
        return list;
    }

}
