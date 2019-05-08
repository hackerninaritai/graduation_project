package com.example.demo.controller;

import com.example.demo.entity.Staff;
import com.example.demo.entity.Task;
import com.example.demo.service.ProjectService;
import com.example.demo.service.StaffService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    StaffService staffService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/task/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("task") Task task) {
        String nameAssign = staffService.findOne(task.getStaffId().getStaffId()).getFullName();
        task.setNameAssign(nameAssign);
        taskService.saveTask(task);
        return new ModelAndView("redirect:/project");
    }

    @GetMapping(value = "/task/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        List<Staff> listStaff = projectService.getListStaffOfProject(task.getProjectId().getProjectId());
        Map<Integer, String> staffs = new HashMap<>();
        listStaff.forEach(item -> staffs.put(item.getStaffId(), item.getFullName()));
        model.addAttribute("staffs", staffs);
        return "taskform";
    }

    @GetMapping(value = "project/{id}/staff/{idstaff}/addtask")
    public String addTaskToStaff(@PathVariable("id") int id, @PathVariable("idstaff") int idstaff, Model model) {
        Task task = new Task();
        task.setProjectId(projectService.getProjecByiD(id));
        model.addAttribute("task", task);
        Map<Integer, String> staffs = new HashMap<>();
        Staff staff = staffService.findOne(idstaff);
        staffs.put(staff.getStaffId(), staff.getFullName());
        model.addAttribute("staffs", staffs);
        return "taskform";
    }

    @GetMapping(value = "/task/{id}/addsubtask")
    public String addSubTask(@PathVariable("id") int id, Model model) {
        Task parentTask = taskService.findById(id);
        Task task = new Task();
        task.setProjectId(parentTask.getProjectId());
        task.setTaskIdparent(parentTask.getTaskId());
        model.addAttribute("task", task);
        List<Staff> listStaff = projectService.getListStaffOfProject(task.getProjectId().getProjectId());
        Map<Integer, String> staffs = new HashMap<>();
        listStaff.forEach(item -> staffs.put(item.getStaffId(), item.getFullName()));
        model.addAttribute("staffs", staffs);
        return "taskform";
    }
}
