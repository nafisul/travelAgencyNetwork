package com.bs23.travelagencynetwork.controller;

import com.bs23.travelagencynetwork.dto.StatusDTO;
import com.bs23.travelagencynetwork.dto.UserPostDTO;
import com.bs23.travelagencynetwork.entity.Location;
import com.bs23.travelagencynetwork.entity.Status;
import com.bs23.travelagencynetwork.service.LocationService;
import com.bs23.travelagencynetwork.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {

    private static final Logger logger = LogManager.getLogger(PostController.class);

    @Autowired
    private LocationService locationService;

    @Autowired
    private PostService postService;

    @GetMapping({"/","welcome"})
    public String index(HttpServletRequest request){
        logger.info("welcome controller");
        List<StatusDTO> statusDTOList = postService.getAllPublicPost(request);
        return "welcome";
    }

    @GetMapping("/newPost")
    public String newPost(Model model){
        logger.info("new post controller");
        List<Location> locationList = locationService.getAllLocation();
        model.addAttribute("locationList",locationList);
        return "newPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String newPostSave(UserPostDTO userPostDTO, HttpServletRequest request, Model model){
        boolean isValid = true;
        if(userPostDTO.getPost() == null || "".equals(userPostDTO.getPost())){
            model.addAttribute("nullPost","Post is empty");
            isValid = false;
        }

        if(userPostDTO.getLocation() == null){
            model.addAttribute("nullLocation","Location is empty");
            isValid = false;
        }

        if(userPostDTO.getPostPrivacy() == null){
            model.addAttribute("nullPrivacy","Privacy is empty");
            isValid = false;
        }

        if(isValid){
            postService.save(userPostDTO, request);
            logger.info("Post successfully saved");
            return "redirect:/welcome";
        }

        return "newPost";
    }

    @RequestMapping(value = "/personalPosts", method = RequestMethod.GET)
    public String getPersonalPost(Model model, HttpServletRequest request){
        List<StatusDTO> statusDTOList = postService.findByUserEmail(request.getUserPrincipal().getName());
        model.addAttribute("personalPostList", statusDTOList);
        return "personalPosts";
    }

    @RequestMapping(value = "/editPost/{postId}", method = RequestMethod.GET)
    public String editPost(@PathVariable Long postId, Model model){
        Status status = postService.findById(postId);
        model.addAttribute("postId",status.getId());
        model.addAttribute("post",status.getPost());
        return "editPost";
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String updatePost(StatusDTO statusDTO, HttpServletRequest request, Model model){
        boolean isValid = true;
        if(statusDTO.getPost() == null || "".equals(statusDTO.getPost())) {
            isValid = false;
            model.addAttribute("error","Post can not be empty");
        }
        if(isValid) {
            postService.updatePost(statusDTO, request);
            logger.info("Post successfully updated");
            return "redirect:/personalPosts";
        }
        model.addAttribute("postId",statusDTO.getPostId());
        return "editPost";
    }


    @RequestMapping(value = "/changePrivacy/{postId}", method = RequestMethod.GET)
    public String changePrivacy(@PathVariable Long postId, Model model){
        Status status = postService.findById(postId);
        model.addAttribute("postId",status.getId());
        model.addAttribute("post",status.getPost());
        model.addAttribute("privacy",status.getPostPrivacy());

        return "changePrivacy";
    }

    @RequestMapping(value = "/updatePrivacy", method = RequestMethod.POST)
    public String updatePrivacy(StatusDTO statusDTO, HttpServletRequest request, Model model){
        boolean isValid = true;
        if(statusDTO.getPostPrivacy() == -1){
            isValid = false;
            model.addAttribute("error","Privacy must be selected");
        }

        if(isValid){
            postService.updatePrivacy(statusDTO,request);
            logger.info("Post privacy successfully updated");
            return "redirect:/personalPosts";
        }

        model.addAttribute("postId",statusDTO.getPostId());
        return "changePrivacy";
    }

}
