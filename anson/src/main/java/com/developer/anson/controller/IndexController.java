package com.developer.anson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/20.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "login";
    }

/*    *//**
     * 从本地导出文件
     * @param exportPathName
     * @param exportFileName
     * @param request
     * @param response
     * @param model
     *//*
    @RequestMapping(value = { "/exportFile" })
    public void exportFile(String exportPathName, String exportFileName, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        if (StringUtils.isBlank(exportPathName)) {
            return;
        }
        if (StringUtils.isBlank(exportFileName)) {
            return;
        }
        //把流传到网络
        FileUtil.exportFile(response, exportPathName, exportFileName);
    }*/
}
