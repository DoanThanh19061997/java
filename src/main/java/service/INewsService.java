package service;

        import model.NewsModel;

        import javax.servlet.http.HttpServletRequest;
        import java.util.List;

public interface INewsService {
    void createdNews(NewsModel newsModel);
    void updateNews(Long id, NewsModel updateNewsModel);
    NewsModel findOneById(Long id);
    List<NewsModel> findAll();
}
