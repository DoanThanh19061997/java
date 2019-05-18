package service.impl;

import Contact.Status;
import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.NewsModel;
import model.UserModel;
import service.INewsService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class NewsService implements INewsService{
    private INewsDAO newsDAO;

    public NewsService(){
        this.newsDAO = new NewsDaoImpl();
    }

    public void createdNews( NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setStatus(Status.PENDING.getValue());
        newsDAO.insertNews(newsModel);
    }



    public void updateNews(Long id, NewsModel updateNewsModel) {
        NewsModel oldNewsModel = newsDAO.findByID(id);
        updateNewsModel.setCreatedDate(oldNewsModel.getCreatedDate());
        updateNewsModel.setCreatedBy(oldNewsModel.getCreatedBy());
        updateNewsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        //updateNewsModel.setModifiedBy("");
        newsDAO.updateNews(id, updateNewsModel);
    }

    @Override
    public NewsModel findOneById(Long id) {
        return newsDAO.findNewsById(id);
    }



    @Override
    public List<NewsModel> findAll() {
        return newsDAO.findAll();
    }
}
