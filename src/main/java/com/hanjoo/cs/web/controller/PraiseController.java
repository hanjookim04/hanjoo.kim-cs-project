package com.hanjoo.cs.web.controller;

import com.hanjoo.cs.web.dto.PageRequestDTO;
import com.hanjoo.cs.web.dto.PraiseDTO;
import com.hanjoo.cs.web.service.PraiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/devstudy/praise")
@Log4j2
@RequiredArgsConstructor
public class PraiseController {

    private final PraiseService praiseService; //final 로 선언



    @GetMapping("/")
    public String index(){
        return "redirect:/devstudy/praise/list";
    }


    @GetMapping({"/", "list"})
    public String list(PageRequestDTO pageRequestDTO, Model model){

        log.info("[PraiseController] praise list....");

        model.addAttribute("result", praiseService.getPraiseList(pageRequestDTO));

        return "/devstudy/praise/list";
    }


    @GetMapping("/register")
    public String register(){
        log.info("[PraiseController] praise register form......");
        return "/devstudy/praise/registerForm";
    }


    @PostMapping("/register")
    public String registerPost(PraiseDTO praiseDTO, RedirectAttributes redirectAttributes){
        log.info("[PraiseController] praise registerPost");
        log.info("[PraiseDTO]"+ praiseDTO);

        Long id = praiseService.registerPraise(praiseDTO);

        redirectAttributes.addAttribute("id",id);

        return "redirect:/devstudy/praise/detail";
    }


    @GetMapping({"detail"})
    public void detail(Long id, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model){

        log.info("[PraiseController] praise detail");
        log.info("[id]"+id);

        PraiseDTO praiseDTO = praiseService.getPraiseDetail(id);
        model.addAttribute("praiseDto", praiseDTO);
    }


    @PostMapping("modify")
    public String modify(PraiseDTO praiseDTO, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
        log.info("post modify....");
        log.info("[praiseDTO]"+ praiseDTO);

        praiseService.modifyPraise(praiseDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("type", pageRequestDTO.getType());
        redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
        redirectAttributes.addAttribute("id", praiseDTO.getId());

        return "redirect:/devstudy/praise/detail";
    }
}
