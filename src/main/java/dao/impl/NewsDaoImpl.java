package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.NewsModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NewsDaoImpl extends AbtractDAOI<NewsModel> implements INewsDAO {

    public void insertNews(NewsModel newsModel) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, createdDate, thumbnail, status, categoryID) \n" +
                "values (?,?,?,?,?,?,?,?)";
        insert(sql, newsModel.getTitle(), newsModel.getShortDescription(), newsModel.getContent(),
                newsModel.getCreatedBy(), newsModel.getCreatedDate(), newsModel.getThumbnail(),
                newsModel.getStatus(), newsModel.getCategoryID());
    }

    public List<NewsModel> findAll() {
        String sql = "SELECT * FROM news.news";
        return query(sql, new NewsMapper());
    }

    @Override
    public NewsModel findNewsById(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> list = query(sql,new NewsMapper(),id);
        return list.isEmpty()?null:list.get(0);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM news.news WHERE id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement pr = getConnection().prepareStatement(sql);
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNews(Long id, NewsModel newsModel) {
        String sql = "UPDATE news SET title = ?, shortDescription = ?, content = ?, createdBy = ?, createdDate = ?,\n" +
                "modifiedBy = ?, modifiedDate = ?,thumbnail = ?, categoryID = ?\n" +
                "WHERE id = ?";
        update(sql, newsModel.getTitle(), newsModel.getShortDescription(), newsModel.getContent(),
                newsModel.getCreatedBy(), newsModel.getCreatedDate(), newsModel.getModifiedBy(),
                newsModel.getCreatedDate(), newsModel.getThumbnail(),
                 newsModel.getCategoryID(), id);
    }
// lấy id theo content
    public NewsModel findByID(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> list = query(sql, new NewsMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<NewsModel> findTitle(String content) {
        String sql = "SELECT * FROM news WHERE content LIKE ?";
        List<NewsModel> list = query(sql, new NewsMapper(), "%" + content + "%");
        return list;
    }

//    public static void main(String[] args) {
//        INewsDAO iNewsDAO = new NewsDaoImpl();
////        NewsModel news = iNewsDAO.findByID(2L);
////        System.out.println(news);
////        List<NewsModel> newsList = iNewsDAO.findByID(2L);
//        List<NewsModel> list = iNewsDAO.findTitle("dc");
//        for (NewsModel news : list) {
//            System.out.println(news);
//        }
////        Date date = new Date();
////        Timestamp timestamp = new Timestamp(date.getTime());
////        NewsModel news = new NewsModel();
////        news.setId(2L);
////        news.setTitle("I Just");
////        news.setShortDescription("a");
////        news.setContent("dc");
////        news.setCreatedBy("dinh");
////        news.setCreatedDate(timestamp);
////        news.setModifiedBy("dinh");
////        news.setModifiedDate(timestamp);
////        news.setCensor("dinh");
////        news.setThumbnail("img");
////        news.setStatus("HD");
////        news.setCategoryID(2L);
////        iNewsDAO.updateNews(2L,news);
////        iNewsDAO.delete(1L);
//
//    }

}
