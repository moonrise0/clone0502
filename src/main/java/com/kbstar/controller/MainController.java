package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {


    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    CustService custService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RequestMapping("/")
    public String main() {
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }
    @RequestMapping("/custinfo")
    public String custinfo(Model model,String id) throws Exception {
        Cust cust = null;
        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }
        model.addAttribute("custinfo", cust); //뿌릴 정보를 준비
        model.addAttribute("center", "custinfo"); //뿌림
        return "index";
    }
    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model,Cust cust) throws Exception {
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }
        return "redirect:/custinfo?id="+cust.getId();
    }
    @RequestMapping("/logout")
    public String login(Model model, HttpSession session) {
        if( session != null) {
            session.invalidate();
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        logger.info("---------------" + id + "  " + pwd);
        Cust cust = null;
        String nextPage = "loginfail";
        try {
            cust = custService.get(id);
            if(cust != null){
                if( cust != null && encoder.matches(pwd, cust.getPwd())){
                    nextPage = "loginok";
                    session.setMaxInactiveInterval(600000);
                    session.setAttribute("logincust", cust);
                }
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애, 잠시 후 다시 로그인 시도하세요");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/rgsimpl")
    public String rgsimpl(Model model, Cust cust, HttpSession session) throws Exception{
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.register(cust);
            session.setAttribute("logincust", cust);
        } catch (Exception e) {
            throw new Exception("가입 오류ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ");
        }
        model.addAttribute("center", "registerok");
        model.addAttribute("rcust", cust);
        return "index";
    }
    // /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page) {
        return page;
    }
}