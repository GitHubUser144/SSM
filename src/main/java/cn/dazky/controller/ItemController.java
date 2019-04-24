package cn.dazky.controller;

import cn.dazky.pojo.Item;
import cn.dazky.service.ItemSetvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.chen
 * @create 2019-04-19 7:45
 */
@Controller()
public class ItemController {
    @Autowired
    private ItemSetvice itemSetvice;
    @RequestMapping("/getItems")
    public ModelAndView getAllItem() {
        System.out.println("进入了controller");
        List<Item> list = itemSetvice.queryItemList();
        // 创建ModelAndView，用来存放数据和视图
        ModelAndView modelAndView = new ModelAndView();
        // 设置数据到模型中
        modelAndView.addObject("list",list);
        // 设置视图jsp，需要设置视图的物理地址
        modelAndView.setViewName("showdata");
        return modelAndView;
    }
    @RequestMapping("searchItem")
    public String editItem(@RequestParam("name")String name, Model model){
        System.out.println(name);
        List<Item> list = itemSetvice.queryByName(name);
        model.addAttribute("list",list);
        return "showdata";
    }
    @RequestMapping(value="/showDetail/{id}")
    public  ModelAndView showDetail(@PathVariable()Integer id){
        System.out.println("传过来的id为"+id);
        ModelAndView modelAndView=new ModelAndView();
        List<Item> list=new ArrayList<Item>();
        list.add(itemSetvice.selectItemById(id));
        modelAndView.addObject("list",list);
        modelAndView.setViewName("showdata");
        return modelAndView;
    }
}
