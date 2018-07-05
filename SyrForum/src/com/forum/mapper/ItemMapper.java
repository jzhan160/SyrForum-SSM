package com.forum.mapper;

import com.forum.entity.Item;

import java.util.List;

public interface ItemMapper {

    List<Item> selectAllItemsByCatID(int catID);

    int selectTopicIdByItemId(int itemId);

    void  insertItem(Item item);

    Item  selectItemById(int itemId);

    List<Item> selectItemByKeyword(String keyword);

    List<Item> selectItemByTopicId(int topicId);

    void deleteItem(int itemId);

    List<Item> selectAllItems();
}
