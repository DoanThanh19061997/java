package dao;

import model.NewsModel;

import java.util.List;

public interface INewsDAO extends IGenericDao<NewsModel> {
    void insertNews(NewsModel newsModel);
    List<NewsModel> findAll();
    NewsModel findNewsById(Long id);
    void delete(Long id);
    void updateNews(Long id, NewsModel newsModel);
    NewsModel findByID(Long id);
    List<NewsModel> findTitle(String content);
}
