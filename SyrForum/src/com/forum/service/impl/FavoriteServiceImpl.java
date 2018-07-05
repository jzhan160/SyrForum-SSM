package com.forum.service.impl;

import com.forum.entity.Favorite;
import com.forum.mapper.FavoriteMapper;
import com.forum.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public boolean favoriteExist(Favorite favorite) {
        if (favoriteMapper.favoriteExist(favorite) != null)
           return true;
        else
            return false;
    }

    @Override
    public void addFavorite(Favorite favorite) {
        favoriteMapper.addFavorite(favorite);
    }

    @Override
    public void deleteFavorite(Favorite favorite) {
        favoriteMapper.deleteFavorite(favorite);
    }

    @Override
    public List<Favorite> selectFavoriteListByUser(int userId) {
        return favoriteMapper.selectFavoriteListByUser(userId);
    }
}
