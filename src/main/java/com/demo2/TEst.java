package com.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/test")
public class TEst {


    List<StringBuilder> sb = new ArrayList<>();

    public static void main(String[] args) {
        List<StringBuilder> sb = new ArrayList<>();
        StringBuilder delete = new StringBuilder("w");
        sb.add(delete);
        sb.add(new StringBuilder("n"));
        sb.add(new StringBuilder("d"));
        sb.add(new StringBuilder("s"));
        sb.add(new StringBuilder("a"));
        sb.remove("n");
        System.out.println(sb);
    }
}
