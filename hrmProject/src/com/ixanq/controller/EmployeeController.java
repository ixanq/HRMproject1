package com.ixanq.controller;

import com.ixanq.entity.*;
import com.ixanq.service.EmployeeService;
import com.ixanq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManagerService managerService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
    /**
     * 用异步ajax 验证员工信息存不存在
     * @param name
     * @return
     */
    @RequestMapping("ajaxCheckEmployee")
    @ResponseBody
    public String validate(String name ){
        Employee employee = employeeService.findEmployeeByName(name);
        if(null==employee){
            return "yes";
        }else {
            //存在
            return "no";
        }
    }

    /**
     * 游客登陆完后，跳转到游客界面
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("employeeNav")
    public String visitorNav(String name, String password, Model model, HttpSession employeeSession){
        Employee employee2=employeeService.findEmployeeByName(name);//判断名字是否为错误
        Employee employee3=employeeService.findEmployeeByNameAndPassword(name,password);
        if(null==employee2) {//名字错误
            model.addAttribute("nameError","nameError");
            return "forward:/employeeLogin.jsp";
        } else if(null!=employee3) {//账号密码正确
            employeeSession.removeAttribute("employee");
            employeeSession.setAttribute("employee",employee2);
            return "employee/employeeIndexNav";
        }else{ //密码错误
            model.addAttribute("employee2", employee2);
            model.addAttribute("passwordError","passwordError");
            return "forward:/employeeLogin.jsp";
        }
    }


    @RequestMapping("eeployeeInfoctrl")
    public String eployeeInfoctrl(Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        Employee employee1 = employeeService.findEmployeeByName(employee.getName());
        WorkPosition position = managerService.findWorkPositionById(employee1.getWorkPositionId());
        Department department = managerService.findDepartmentbyId(position.getDepartmentId());
        model.addAttribute("employee1",employee1);
        model.addAttribute("position",position);
        model.addAttribute("department",department);
        return "employee/employeeInfo";
    }

    @RequestMapping("updateEmployeeInfoToDb")
    public String updateEmployeeInfoToDb(Integer employeeId,String realName,String gender,Integer age,String degree,String email,Model model,HttpSession session){
        System.out.println(employeeId+" "+realName+" "+gender+" "+age+" "+degree+" "+email);
        Employee employee= (Employee) session.getAttribute("employee");
        Employee e = employeeService.findEmployeeByName(employee.getName());
        Employee employee2 = new Employee(e.getId(),e.getName(),e.getPassword(),realName,gender,age,degree,email,e.getBeginTime(),e.getStatus(),e.getWorkPositionId());
        managerService.updateEmployee(employee2);
        model.addAttribute("updateEmployeeInfoToDb",33);
        return "employee/employeeIndexNav";
    }

    @RequestMapping("eworkAttandance")
    public String workAttandance(Model model){
        return "employee/workAttandance";
    }

    @RequestMapping("edeptWorkPosition")
    public String edeptWorkPosition(Model model){
        List<Department> allDepartment = managerService.findAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "employee/deptWorkPosition";
    }

    @RequestMapping("lookDepartmentWorkPosirionInEmployee")
    public String lookDepartmentWorkPosirionInEmployee(Model model,String departmentId){
        System.out.println(departmentId);
        Integer departmentId1 = Integer.valueOf(departmentId);
        List<WorkPosition> workPositions = managerService.findWorkPositionByDepartmentId(departmentId1);
        model.addAttribute("workPositions",workPositions);
        return "employee/WorkPositionDeatils";
    }

    @RequestMapping("lookEmployeeUnderworkPosition")
    public String lookEmployeeUnderworkPosition(Model model,String workPositionId){
        System.out.println(workPositionId);
        List<Employee> employees=new ArrayList<>();
        Integer workPositionId1 = Integer.valueOf(workPositionId);
        List<EmployeeInfo> employeeInfos = managerService.findEmployeeInfoByworkPositionId(workPositionId1);
        for(EmployeeInfo e:employeeInfos){
            Employee employee = managerService.findEmployeeById(e.getEmployeeId());
            employees.add(employee);
        }
        model.addAttribute("employees",employees);
        return "employee/UnderWPEmployeeDetails";
    }

    @RequestMapping("etrain")
    public String etrain(Model model,HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        EmployeeInfo employeeInfo=employeeService.findEmployeeInfoByEId(employee.getId());
        Department department = managerService.findDepartmentbyId(employeeInfo.getDepartmentId());
        Train train = managerService.findTrainByDepartmentName(department.getName());
        if(train==null){
            model.addAttribute("etrainIsEmpty",33);
            return "employee/employeeIndexNav";
        }
        model.addAttribute("train",train);
        return "employee/train";
    }

    @RequestMapping("addworkAttendenceForEmployee")
    public String addworkAttendenceForEmployee(Model model,HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        Date date1=null;
        Date endWork=null;
        try {
            date1 = sdf.parse(dateString);
            endWork=sdf.parse("2000-12-12 12:12:12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2017-12-12 12:12:12
        String stringDate=dateString.substring(0,11);//2017-12-12
        Integer day = Integer.valueOf(dateString.substring(8, 10));
        Integer hour = Integer.valueOf(dateString.substring(11, 13));
        Integer min = Integer.valueOf(dateString.substring(14, 16));
        CheckWorkAttendance workAttendance=employeeService.findCheckWorkAttendanceByEIdAndBeginStringDateLike(employee.getId(),"%"+stringDate+"%");
        if(workAttendance!=null){
            model.addAttribute("youHaveAlreadyWorkAtendance",11);
            return "employee/workAttandance";
        }else{
            if(hour<9){
                employeeService.addCheckWorkAttendance(new CheckWorkAttendance(-1,employee.getId(),date1,endWork,"正常","待定"));
                model.addAttribute("WorkAtendanceIsInTime",11);
                return "employee/workAttandance";
            }else if(hour>=9&&hour<12){
                managerService.addReward(new Reward(employee.getId(),"迟到"+(hour-8)+"小时",-(hour-8)*20,date1));//迟到1小时扣20元
                employeeService.addCheckWorkAttendance(new CheckWorkAttendance(employee.getId(),date1,endWork,"迟到","待定"));
                model.addAttribute("WorkAtendanceIsLate",(hour-9+1));
                return "employee/workAttandance";
            }else{
                employeeService.addCheckWorkAttendance(new CheckWorkAttendance(employee.getId(),date1,endWork,"旷工","待定"));
                model.addAttribute("WorkAtendanceIsTooLate",11);
                return "employee/workAttandance";
            }

        }
    }


    @RequestMapping("updateworkAttendenceForEmployee")
    public String updateworkAttendenceForEmployee(Model model,HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        Date date1=null;
        try {
            date1 = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2017-12-12 12:12:12
        String stringDate=dateString.substring(0,11);//2017-12-12
        Integer day = Integer.valueOf(dateString.substring(8, 10));
        Integer hour = Integer.valueOf(dateString.substring(11, 13));
        Integer min = Integer.valueOf(dateString.substring(14, 16));

        CheckWorkAttendance beginwork=employeeService.findCheckWorkAttendanceByEIdAndBeginStringDateLike(employee.getId(),"%"+stringDate+"%");
        CheckWorkAttendance workAttendance=employeeService.findCheckWorkAttendanceByEIdAndEndStringDateLike(employee.getId(),"%"+stringDate+"%");
        if(workAttendance!=null){
            model.addAttribute("youHaveAlreadyLeaveWorkAtendance",11);
            return "employee/workAttandance";
        }else if(beginwork!=null){
            if(hour>18){
                employeeService.updateCheckWorkAttendance(new CheckWorkAttendance(beginwork.getId(),employee.getId(),beginwork.getBeginWork(),date1,beginwork.getIsLate(),"正常"));
                model.addAttribute("WorkAtendanceLeveIsInTime",11);
                return "employee/workAttandance";
            }else if(hour>14&&hour<=18){
                managerService.addReward(new Reward(employee.getId(),"早退"+(18-hour)+"小时",-(18-hour)*20,date1));//早退1小时扣20元
                employeeService.updateCheckWorkAttendance(new CheckWorkAttendance(beginwork.getId(),employee.getId(),beginwork.getBeginWork(),date1,beginwork.getIsLate(),"早退"));
                model.addAttribute("WorkLeaveAtendanceIsBefore",(18-hour));
                return "employee/workAttandance";
            }else{
                managerService.addReward(new Reward(employee.getId(),"早退"+(18-hour)+"小时",-200,date1));//上午签退扣200
                employeeService.updateCheckWorkAttendance(new CheckWorkAttendance(beginwork.getId(),employee.getId(),date1,date1,beginwork.getIsLate(),"早退"));
                model.addAttribute("WorkLeaveAtendanceIsSoEarly",11);
                return "employee/workAttandance";
            }

        }else {
            model.addAttribute("youHaveNoworkAttandance",55);
            return "employee/workAttandance";
        }
    }

    @RequestMapping("updateEmployeePassword")
    public String updateEmployeePassword(Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        model.addAttribute("employee",employee);
        return "employee/updateEPWD";
    }

    @RequestMapping("updatePWDandCommit")
    public String updatePWDandCommit(String oPassword,String password,Model model,HttpSession session){
        Employee e= (Employee) session.getAttribute("employee");
        if(e.getPassword().equals(oPassword)){
            managerService.updateEmployee(new Employee(e.getId(),e.getName(),password,
                    e.getRealName(),e.getGender(),e.getAge(),e.getDegree(),e.getEmail(),e.getBeginTime(),e.getStatus(),e.getWorkPositionId()));

            model.addAttribute("updatePWDandCommit",44);
            return "employee/employeeIndexNav";
        }
        return "employee/updateEPWD";
    }

    @RequestMapping("personalSalaryMesseges")
    public String personalSalaryMesseges(Integer month,Integer year, Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        System.out.println(employee.getId()+" "+month+" "+year);
        List<Salary> salaries=managerService.findSalaryByEmployeeId(employee.getId(),month,year);
        model.addAttribute("salaries",salaries);
        return "employee/salaryDetails";
    }

    @RequestMapping("personalRewardMessegess")
    public String personalRewardMessegess(Integer month,Integer year,Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        List<Reward> rewards=managerService.findAllRewardByEId(employee.getId(),month,year);
        model.addAttribute("rewards",rewards);
        return "employee/rewardDetails";
    }

    @RequestMapping("personalCheckWorkAttandanceMessegess")
    public String personalCheckWorkAttandanceMessegess(Integer month,Integer year,Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        List<CheckWorkAttendance> attendances=managerService.findAllCheckWorkAttendanceByEIdMonthYear(employee.getId(),month,year);
        model.addAttribute("attendances",attendances);
        return "employee/attandanceDetails";
    }

    @RequestMapping("haveErrorInThere")
    public String haveErrorInThere(){
        return "employee/haveError";
    }

    @RequestMapping("commitTheError")
    public String commitTheError(String content,Model model,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        Reconsider reconsider=new Reconsider(employee.getId(),content,dateString);
        employeeService.addReconsider(reconsider);
        model.addAttribute("commitTheErrorSeccess",55);
        return "employee/employeeIndexNav";
    }


}
