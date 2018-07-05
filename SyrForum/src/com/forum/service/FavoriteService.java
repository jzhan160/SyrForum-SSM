package com.forum.service;

import com.forum.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    boolean favoriteExist(Favorite favorite);
    void addFavorite(Favorite favorite);
    void deleteFavorite(Favorite favorite);
    List<Favorite> selectFavoriteListByUser(int userId);


}
