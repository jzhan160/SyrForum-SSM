package com.forum.service.impl;

import com.forum.entity.Item;
import com.forum.mapper.ItemMapper;
import com.forum.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    public List<Item> selectAllItemsByCatID(int catID){
        return itemMapper.selectAllItemsByCatID(catID);
    }


    public int selectTopicIdByItemId(int itemId){
        return itemMapper.selectTopicIdByItemId(itemId);
    }

    @Override
    public void save(Item item) {
        itemMapper.insertItem(item);
    }

    @Override
    public Item selectItemById(int itemId) {
        return itemMapper.selectItemById(itemId);
    }

    @Override
    public List<Item> selectItemByKeyword(String keyword) {
        return itemMapper.selectItemByKeyword(keyword);
    }

    @Override
    public List<Item> selectItemByTopicId(int topicId) {
        return itemMapper.selectItemByTopicId(topicId);
    }

    @Override
    public void deleteItem(int itemId) {
        itemMapper.deleteItem(itemId);
    }

    @Override
    public List<Item> selectAllItems() {
        return itemMapper.selectAllItems();
    }

}
