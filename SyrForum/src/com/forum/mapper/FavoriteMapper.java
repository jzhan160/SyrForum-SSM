package com.forum.mapper;

import com.forum.entity.Favorite;

import java.util.List;

public interface FavoriteMapper {
    Favorite favoriteExist(Favorite favorite);
    void addFavorite(Favorite favorite);
    void deleteFavorite(Favorite favorite);
    List<Favorite> selectFavoriteListByUser(int userId);
}
