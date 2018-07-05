package com.forum.controller;

import com.forum.entity.*;
import com.forum.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.apache.shiro.subject.Subject;
import sun.nio.cs.US_ASCII;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private NotificationService notificationService;

    private static Map<Integer,SlideInfo> slideInfoMap;

    static {
        slideInfoMap = new HashMap<>();
        slideInfoMap.put(1,new SlideInfo("/images/slider/usedcars1.jpg",
                "/images/slider/usedcars2.jpg",
                "Cars"));
        slideInfoMap.put(2,new SlideInfo("/images/slider/usedbooks1.jpg",
                "/images/slider/usedbooks2.jpg",
                "Books"));
        slideInfoMap.put(3,new SlideInfo("/images/slider/usedfurnitures1.jpg",
                "/images/slider/usedfurnitures2.jpg",
                "Furniture"));
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "username", required = false) String username, Map<String, Object> map) throws Exception {
        User user = userService.selectUserByName(username);
        map.put("user", user);
    }

    @ModelAttribute
    public void getItemInfo(@RequestParam(value = "itemId", required = false) String itemId, Map<String, Object> map) throws Exception {
        if (itemId == null)
            return;
        int item_id = Integer.parseInt(itemId);
        Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item_id));
        ItemInfo itemInfo = getItemInfoById(item_id,topic);
        map.put("itemInfo", itemInfo);
        map.put("topic", topic);
    }
    private ItemInfo getItemInfoById(int item_id,Topic topic) throws Exception {
        ItemInfo itemInfo = new ItemInfo();
        Item item = itemService.selectItemById(item_id);
        itemInfo.setItem(item);
        itemInfo.setComments(commentService.selectCommentsByItemId(item.getItemID()));
        itemInfo.setCreateTime(topic.getCreateTime());
        itemInfo.setUserName(userService.selectUserById(topic.getUsers_UserID()).getUserName());
        return itemInfo;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView save(User user) throws Exception {
        ModelAndView mv = new ModelAndView();
        try {
            user.setIsAdmin(0);
            user.setCreateTime(new Date());
            userService.save(user);
            //Integer id = user.getUserID();
            // System.out.println(user);
            mv.setViewName("homePage");
        } catch (Exception e) {
            mv.setViewName("TestError");
            e.printStackTrace();
        }
        mv.addObject("user", user);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/user/checkUser", method = RequestMethod.GET)
    public String checkUser(String username, HttpServletRequest resqust,
                            HttpServletResponse response) throws Exception {
        System.out.println(username);
        Boolean b = userService.userIsExist(username);
        String result = b ? "true" : "false";
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/user/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(User user) throws Exception {
       /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        System.out.println("loginUser"+user);
        modelAndView.setViewName("homePage");
        return modelAndView;*/
        if (user.getUserName().equals("admin"))
            return "admin";
        return "homePage";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "loginAndReg";
    }

    @RequestMapping("/home")
    public String home(User user){
      //  System.out.println("back home user:"+ user);
        return "homePage";
    }

    @ResponseBody
    @RequestMapping(value = "/validatePassword")
    public String validateUser(User user) throws Exception {
        //User _user = userService.selectUserByName(user.getUserName());
        //System.out.println("==========val" + user);
        String _password = user.getUserPassword();
        //System.out.println("===========pass" + _password);
        if (_password == null) {
            return "";
        } else {
            return _password;
        }
    }

    @RequestMapping(value = "/user/profile", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView profile(User user) throws Exception {
       /* System.out.println(username);
        User user = userService.selectUserByName(username);*/
       /* */
       List<Topic> topics = topicService.selectTopicsByUser(user.getUserID());
       List<Item> items = new ArrayList<>();
       for (Topic topic : topics)
           items.addAll(itemService.selectItemByTopicId(topic.getTopicID()));
        List<ItemInfo> itemsInfo = new ArrayList<>();
        for (Item item : items) {
            Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item.getItemID()));
            ItemInfo itemInfo = getItemInfoById(item.getItemID(),topic);
            itemsInfo.add(itemInfo);
        }

        ModelAndView mv = new ModelAndView("profile");
        mv.addObject("itemsInfo",itemsInfo);
        return mv;
    }

    @RequestMapping("/editPassword")
    public String editPassword(){
        return "editpassword";
    }

    @RequestMapping("/changePassword")
    public String changePassword(User user,@RequestParam String password) throws Exception {
        user.setUserPassword(password);
        userService.updateByIdSelective(user);
        return "redirect:/user/profile?username="+user.getUserName();
    }

    @RequestMapping("/deleteItem")
    public  String deleteItem(User user,ItemInfo itemInfo){
        itemService.deleteItem(itemInfo.getItem().getItemID());
        if (user.getUserName().equals("admin"))
            return "admin";
        return "redirect:/user/profile?username="+user.getUserName();
    }

  /*  @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ModelAndView updateUser(User user) throws Exception{
        userService.updateByIdSelective(user);


    }
*/
    @RequestMapping("/topics")
    public ModelAndView topics(@RequestParam(value = "category", required = true) String category) throws Exception {
        int catId = 0;
        SlideInfo slideInfo = null;
        if (category.equals("books"))
            catId = 2;
        else if (category.equals("cars"))
            catId = 1;

        else if (category.equals("furniture"))
            catId = 3;

        List<Item> items = itemService.selectAllItemsByCatID(catId);
        List<ItemInfo> itemsInfo = new ArrayList<>();
        for (Item item : items) {
            Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item.getItemID()));
            ItemInfo itemInfo = getItemInfoById(item.getItemID(),topic);
            itemsInfo.add(itemInfo);
        }
      //  PageHelper.startPage(1, 5);
        ModelAndView mv = new ModelAndView();
       // PageInfo<ItemInfo> p = new PageInfo<ItemInfo>(itemsInfo);
       // mv.addObject("page", p);
        mv.addObject("itemsInfo", itemsInfo);
        mv.addObject("slideInfo", slideInfoMap.get(catId));
        mv.setViewName("topics");
        return mv;
    }

    @RequestMapping("/item")
    public ModelAndView item(User user, ItemInfo itemInfo, Topic topic) throws Exception {

        Map<String, Comment> comments = new LinkedHashMap<>();
        int count = 1;
        for (Comment c : itemInfo.getComments()) {
            String name = userService.selectUserById(c.getUsers_UserID()).getUserName() + " " + count;
            comments.put(name, c);
            System.out.println("============="+c);
            count++;
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("item");
        mv.addObject("comments", comments);
       /* mv.addObject("itemInfo", itemInfo);
        mv.addObject("topic", topic);*/
        mv.addObject("slideInfo", slideInfoMap.get(itemInfo.getItem().getCatID()));
        Favorite favorite = new Favorite();
        favorite.setItemID(itemInfo.getItem().getItemID());
        favorite.setUserID(user.getUserID());
        mv.addObject("favExist",favoriteService.favoriteExist(favorite));
        return mv;
    }

    @RequestMapping(value = "/addComments",method = {RequestMethod.POST})
    public String addComment(User user,ItemInfo itemInfo,@RequestParam String contents) throws Exception {
       // System.out.println(request.getAttribute("content"));
        int itemId = itemInfo.getItem().getItemID();
        Comment comment = new Comment();
       // comment.setContent((String)request.getAttribute("content"));
        comment.setContent(contents);
        comment.setCreateTime(new Date());
        comment.setUsers_UserID(user.getUserID());
        comment.setItemID(itemId);
        commentService.insertComment(comment);
        Notification notification = new Notification();
        notification.setCommentID(comment.getCommentID());
        notification.setAuthor(userService.selectUserById(user.getUserID()).getUserName());//who writes comment
        notification.setUserID(topicService.selectOneTopicById(itemService.selectItemById(itemId).getTopicID()).getUsers_UserID());//who posted the item
        notificationService.insertNotification(notification);
        return "redirect:/item?username="+user.getUserName()+"&itemId="+itemInfo.getItem().getItemID();
    }

    @RequestMapping("/newPost")
    public String newPost() {
        return "newPost";
    }

    @RequestMapping(value = "/postSubmit", method = RequestMethod.POST)
    public String postSubmit(HttpServletRequest request, User user) {
        FileUpload fileUpload = new FileUpload(topicService, itemService);
        fileUpload.uploadFile(request, user.getUserID());
        return "homePage";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) throws Exception {
        List<Item> items = itemService.selectItemByKeyword(keyword);
        ModelAndView mv = new ModelAndView("searchItems");
        if (items.size() == 0)
            System.out.println("NO found!");
        else {
            List<ItemInfo> itemsInfo = new ArrayList<>();
            for (Item item : items) {
                Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item.getItemID()));
                ItemInfo itemInfo = getItemInfoById(item.getItemID(),topic);
                itemsInfo.add(itemInfo);
                mv.addObject("itemsInfo", itemsInfo);
            }
        }
        return mv;
    }

    @RequestMapping("/favorite")
    public String favorite(ItemInfo itemInfo,User user,@RequestParam String operation)throws Exception{
        Favorite favorite = new Favorite();
        favorite.setUserID(user.getUserID());
        favorite.setItemID(itemInfo.getItem().getItemID());
        if (operation.equals("add")) {
            if (!favoriteService.favoriteExist(favorite))
                favoriteService.addFavorite(favorite);
        } else if (operation.equals("delete")) {
            if (favoriteService.favoriteExist(favorite))
                favoriteService.deleteFavorite(favorite);
        }
        return "redirect:/item?username="+user.getUserName()+"&itemId="+itemInfo.getItem().getItemID();
    }

    @RequestMapping("/showFavorite")
    public ModelAndView showFavorite(User user) throws Exception{
        List<Favorite> favorite = favoriteService.selectFavoriteListByUser(user.getUserID());
        List<Item> items = new ArrayList<>();

        for(Favorite fav : favorite){
            Item temp = itemService.selectItemById(fav.getItemID());
            items.add(temp);
        }
        List<ItemInfo> itemsInfo = new ArrayList<>();

        for (Item item : items) {
            Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item.getItemID()));
            ItemInfo itemInfo = getItemInfoById(item.getItemID(),topic);
            itemsInfo.add(itemInfo);
        }
        ModelAndView mv = new ModelAndView("myfavorites");
        mv.addObject("itemsInfo",itemsInfo);
        return mv;
    }

    @RequestMapping("/notification")
    public ModelAndView notification(User user){
        List<Notification> noteList = notificationService.selectNoteByUser(user.getUserID());
        List<Message> messages = new ArrayList<>();
        for (Notification note:noteList){
            Message message = new Message();
            message.setNotification(note);
            Comment comment = commentService.selectCommentById(note.getCommentID());
            message.setCommentContent(comment.getContent());
            message.setCreateTime(comment.getCreateTime());
            message.setItemId(comment.getItemID());
            message.setItemName(itemService.selectItemById(comment.getItemID()).getItemName());
            messages.add(message);
        }
        ModelAndView mv = new ModelAndView("notifications");
        mv.addObject("messages",messages);
        return mv;
    }

    @RequestMapping("/admin/showUsers")
    public ModelAndView showUsers( @RequestParam(required = false, defaultValue = "1") Integer page,
                                   @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
        ModelAndView mv = new ModelAndView("users");
        // mv.addObject("users",users);
        PageHelper.startPage(page, rows);
        List<User> users = userService.selectAllUsers();//query must be after pagehelper
//        System.out.println("////////////////page:"+page+"rows:"+rows);
        PageInfo<User> p = new PageInfo<>(users);
        mv.addObject("page", p);
        return mv;
    }

    @RequestMapping("/admin/showItems")
    public ModelAndView showItems(  @RequestParam(required = false, defaultValue = "1") Integer page,
                                    @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        List<Item> items = itemService.selectAllItems();
        List<ItemInfo> itemsInfo = new ArrayList<>();
        for (Item item : items) {
            Topic topic = topicService.selectOneTopicById(itemService.selectTopicIdByItemId(item.getItemID()));
            ItemInfo itemInfo = getItemInfoById(item.getItemID(),topic);
            itemsInfo.add(itemInfo);
        }
        ModelAndView mv = new ModelAndView("items");
        //mv.addObject("itemsInfo",itemsInfo);
        PageInfo<ItemInfo> p = new PageInfo<ItemInfo>(itemsInfo);
        mv.addObject("page", p);
        return mv;
    }
}
