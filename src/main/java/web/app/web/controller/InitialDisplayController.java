package web.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.app.persistence.entity.Status;
import web.app.service.TimelineSearchService;

import java.util.List;

/**
 * 初期表示画面用のコントローラ
 * Created by Java on 2017/05/27.
 */
@Controller
@RequestMapping(value = "/")
public class InitialDisplayController {

    @Autowired
    TimelineSearchService searchService;

    /**
     * 初期画面表示処理
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "InitialDisplay";
    }

    /**
     * トゥート検索処理
     */
    @RequestMapping(value = "/search")
    public String search(Model model) {

        // Toot検索サービス
        List<Status> toot = searchService.getPublicTimeline();

        model.addAttribute("tootList", toot);
        return "InitialDisplay";
    }

    /**
     * タグ検索処理
     */
    @RequestMapping(value = "/tags")
    public String searchTags(@RequestParam("key") String key, Model model) {
        //List<Status> timeline = searchService.getTagTimeline(key);
        ResponseEntity<List<Status>> responses = searchService.getTagTimeline(key);
        List<Status> timeline = responses.getBody();
        model.addAttribute("timelines", timeline);
        return "InitialDisplay";
    }
}
