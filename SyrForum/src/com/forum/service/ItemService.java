package com.forum.service;

import com.forum.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> selectAllItemsByCatID(int CatID);

    int selectTopicIdByItemId(int itemId);

    void  save(Item item);
    Item  selectItemById(int itemId);

    List<Item> selectItemByKeyword(String keyword);

    List<Item> selectItemByTopicId(int topicId);

    void deleteItem(int itemId);

    List<Item> selectAllItems();


}
