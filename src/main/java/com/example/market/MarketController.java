package com.example.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/market")
public class MarketController {
    @Autowired
    MarketServicelmpl marketServicelmpl;
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String marketist(Model model){
//        model.addAttribute("list", marketServicelmpl.getMarketList());
//        return "list";
//    }
    @RequestMapping(value = "/list")
    public String marketist(){
        return "board";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost(){
        return "addpostform";
    }
    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPOk(MarketVO vo){
        if(marketServicelmpl.insertMarket(vo) == 0)
            System.out.println("데이터 추가 실패");
        else System.out.println("데이터 추가 성공!");
        return "redirect:list";
    }
    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        MarketVO marketVO = marketServicelmpl.getMarket(id);
        model.addAttribute("u", marketVO);
        return "editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(MarketVO vo){
        if(marketServicelmpl.updateMarket(vo) == 0)
            System.out.println("데이터 수정 실패");
        else System.out.println("데이터 수정 성공!");
        return "redirect:list";
    }
    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id, Model model){
        if(marketServicelmpl.deleteMarket(id) == 0)
            System.out.println("데이터 삭제 실패");
        else System.out.println("데이터 삭제 성공!");
        return "redirect:../list";
    }
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String boardview(@PathVariable("id") int id, Model model){
        MarketVO marketVO = marketServicelmpl.getMarket(id);
        model.addAttribute("view", marketVO);
        return "view";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
}
