package com.haiidea.controller;

import com.haiidea.bean.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class StudentController {
    private int id  =1;
    @RequestMapping("save")
    public String save(Student student){
        System.out.println("name="+student.getName()+"  age="+student.getAge()+"  phone="+student.getPhone());
        try {
            FileWriter fileWriter = new FileWriter("student.txt",true);

            fileWriter.write(id+++"#"+student.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "add succes";
    }
    @RequestMapping("del")
    public String delete(String id){
        try {
            FileReader fileReader = new FileReader("student.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line,content="";
            while ((line=br.readLine()) != null){
                if (!line.startsWith(id+"#")){
                    content=content+line+"\n";
                }
            }
            FileWriter fileWriter = new FileWriter("student.txt");
            fileWriter.write(content);
            fileWriter.close();
            br.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "del success";
    }

}

