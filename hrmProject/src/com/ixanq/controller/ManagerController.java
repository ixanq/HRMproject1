package com.ixanq.controller;

import com.ixanq.entity.*;
import com.ixanq.service.EmployeeService;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 主要用来解决jsp获取的Date类型数据出现类型异常的问题
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }


    /**
     * 用异步ajax 验证管理员存不存在
     * @param name
     * @return
     */
    @RequestMapping("ajaxCheckManager")
    @ResponseBody
    public String validate(String name ){
        Manager manager = managerService.findAdminByName(name);
        if(null==manager){
            return "yes";
        }else {
            return "no";
        }
    }


    /**
     * 管理员登陆完后，跳转到管理员界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("managerNav")
    public String visitorNav(Manager manager, Model model, HttpSession managerSession){
        Manager manager2=managerService.findAdminByName(manager.getName());//判断名字是否为错误
        Manager manager3=managerService.findAdminByNameAndPassword(manager);
        if(null==manager2) {//名字错误
            model.addAttribute("nameError","nameError");
            return "forward:/adminLogin.jsp";
        } else if(null!=manager3) {//账号密码正确
            List<ResumeForManager> resumes=managerService.findResumeByStatus("未读");
            List<GoInterview> goInterviews=managerService.findGoInterviewByStatus("未读");
            List<Reconsider> reconsiders= managerService.findAllReconsider();
            if(null!=reconsiders&&reconsiders.size()!=0){
                model.addAttribute("thereAreReconsiderMesseges",55);
            }
            if(null!=resumes&&resumes.size()!=0){
                model.addAttribute("thereAreMesseges","thereAreMesseges");
            }
            if(null!=goInterviews&&goInterviews.size()!=0){
                model.addAttribute("thereAregoInterviewsMesseges","thereAregoInterviewsMesseges");
            }
            managerSession.removeAttribute("manager");
            managerSession.setAttribute("manager",manager2);
            return "manager/managerIndexNav";
        }else{ //密码错误
            model.addAttribute("manager2", manager2);
            model.addAttribute("passwordError","passwordError");
            return "forward:/adminLogin.jsp";
        }
    }


    /**
     * 管理员考勤界面
     * @param model
     * @return
     */
    @RequestMapping("mworkAtendance")
    public String workAtendance( Model model){
        List<Employee> employees = managerService.findAllEmployee();
        model.addAttribute("employees",employees);
        return "manager/workAttandance";
    }


    /**
     * 管理员部门管理界面
     * @param model
     * @return
     */
    @RequestMapping("mmanageDepartment")
    public String manageDepartment(Model model){
        List<Department> allDepartment = managerService.findAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "manager/department";
    }

    /**
     * 管理员招聘管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("manageAdvertise")
    public String manageResume(Manager manager, Model model){
        List<Advertises> advertises = managerService.finaAllAdvertise();
        if(advertises==null||advertises.size()==0){
            model.addAttribute("manageAdvertiseEmpty",11);
            return "manager/managerIndexNav";
        }else {
            model.addAttribute("advertises",advertises);
            return "manager/advertise";
        }
    }

    /**
     * 管理员培训管理界面
     * @param model
     * @return
     */
    @RequestMapping("mmanageTrain")
    public String manageTrain(Model model){
        List<Train> allTrain = managerService.findAllTrain();
        model.addAttribute("allTrain",allTrain);
        List<Department> allDepartment = managerService.findAllDepartment();
        model.addAttribute("allDepartment",allDepartment);
        return "manager/train";
    }



    /**
     * 管理员奖惩管理界面
     * @param model
     * @return
     */
    @RequestMapping("lookTheRewardMesseges")
    public String manageReward(Model model){

        return "manager/reward";
    }

    /**
     * 简历查删
     */
    @RequestMapping("lookAndDeleteResume")
    public String lookAndDeleteResume( Model model)
    {
        List<ResumeForManager> resumesForManager= managerService.findAllResumeForManager();
        if(resumesForManager==null||resumesForManager.size()==0){
            model.addAttribute("thereIsNoMesseges","thereIsNoMesseges");
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("resumesForManager",resumesForManager);
            return "manager/showResume";
        }
    }

    @RequestMapping("lookTheResumeDetailsForAdmin")
    public String lookTheResumeDetailsForAdmin(String id,Model model){
        if(null==id){
            model.addAttribute("messegesIsDelete",111);
            return "manager/managerIndexNav";
        }
        Integer newId = Integer.valueOf(id);
        ResumeForManager resumeForManager=managerService.findResumeById(newId);
        System.out.println(resumeForManager);
        if(null==resumeForManager){//没有简历
            model.addAttribute("empityResumeMasseges",333);
            return "manager/managerIndexNav";
        }else{
            Department departmentbyId = managerService.findDepartmentbyId(resumeForManager.getDepartmentId());
            WorkPosition workPositionById = managerService.findWorkPositionById(resumeForManager.getWorkPositionId());
            model.addAttribute("resumeForManager",resumeForManager);
            model.addAttribute("departmentbyId",departmentbyId);
            model.addAttribute("workPositionById",workPositionById);
            return "manager/lookMResume";
        }

    }
    @RequestMapping("alterResumeStatus")
    @ResponseBody
    public String alterResumeStatus(Integer id ){
        ResumeForManager resumeById = managerService.findResumeById(id);
        System.out.println(resumeById);
        managerService.updateResumeStatusForManager(resumeById);
        return "yes";
    }

    @RequestMapping("ajaxDeleteResumeForManagerById")
    @ResponseBody
    public String ajaxDeleteResumeForManagerById(Integer id ){
        managerService.deleteResumeForManagerById(id);
        return "yes";
    }

    @RequestMapping("addAdvertisesforAdmin")
    public String addAdvertisesforAdmin( ){
        return "manager/addAdvertise";
    }

    @RequestMapping("addAdvertiseAndCommit")
    public String addAdvertiseAndCommit(String advertiseName,String salary,Integer needPersonNumber, String advertiseDescreption,Model model){
        Advertises advertises=new Advertises(advertiseName,salary,needPersonNumber,advertiseDescreption);
        System.out.println(advertiseDescreption);
        managerService.addAdvertise(advertises);
        model.addAttribute("addAdvertiseAndCommit",333);
        return "manager/managerIndexNav";
    }

    @RequestMapping("lookTheAdvertiseDetailMasseges")
    public String lookTheAdvertiseDetailMasseges(String id,Model model){
        Integer newId = Integer.valueOf(id);
        if(newId==null){
            model.addAttribute("lookTheAdvertiseDetailMasseges",11);
            return "manager/managerIndexNav";
        }else{
            Advertises advertises = managerService.findAdvertisesById(newId);
            if(advertises==null){
                model.addAttribute("noadvertises",11);
                return "manager/managerIndexNav";
            }
            model.addAttribute("advertises",advertises);
            return "manager/showAdvertise";
        }

    }

    @RequestMapping("ajaxDeleteAdvertiseById")
    @ResponseBody
    public String ajaxDeleteAdvertiseById(Integer id){
        managerService.deleteAdvertiseById(id);
        return "deleteSeccessfully";
    }

    @RequestMapping("interviewforVisitor")
    public String interviewforVisitor(String visitorName, String advertiseId, Date viewTime, Model model){
        Integer advertiseId1 = Integer.valueOf(advertiseId);
        Interview interview=new Interview(visitorName,advertiseId1,viewTime);
        System.out.println(interview);
        Interview interview1 =managerService.findInterviewforVisitorByVisitorName(interview.getVisitorName());
        if(interview1!=null){
            model.addAttribute("visitorViewxist",88);
            return "manager/managerIndexNav";
        }
        managerService.addInterviewforVisitor(interview);
        model.addAttribute("visitorViewSeccessfully",99);
        return "manager/managerIndexNav";
    }

    @RequestMapping("lookAllGoInterview")
    public String lookAllGoInterview(Model model){
        List<GoInterview> goInterviews= managerService.findAllGoInterview();
        if(goInterviews==null||goInterviews.size()==0){
            model.addAttribute("goInterviewsMessegesEmpty",88);
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("goInterviews",goInterviews);
            return "manager/showGoInterview";
        }
    }

    @RequestMapping("ajaxDeleteGoInterviewForManagerById")
    @ResponseBody
    public String ajaxDeleteGoInterviewForManagerById(Integer id,Model model){
        managerService.deleteGoInterviewById(id);
        return "yes";
    }



    @RequestMapping("lookTheGoInterviewDetailsForAdmin")
    public String lookTheGoInterviewDetailsForAdmin(String id,Model model){
        Integer gointerviewId = Integer.valueOf(id);
        GoInterview goInterview=managerService.findGoInterviewByGointerviewId(gointerviewId);
        //要写录用未录用，查看游客请求的信息，如果录用，保存游客的信息到员工。
        if(goInterview==null){
            model.addAttribute("nogoInterview",88);
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("goInterview",goInterview);
            return "manager/showGoInterviewDetails";
        }
    }


    @RequestMapping("changeToEmployee")
    public String changeToEmployee(String id,String name,Model model){
        Integer goInterviewId = Integer.valueOf(id);
        GoInterview g= managerService.findGoInterviewByGointerviewId(goInterviewId);
        GoInterview goInterview1=new GoInterview(g.getId(),g.getVisitorName(),"已查看","已录用");
        managerService.updateGoInterview(goInterview1);
        List<ResumeForManager>  resumeForManagers=managerService.findResumeForManagerByVisitorName(name);
        if(resumeForManagers==null||resumeForManagers.size()==0){
            model.addAttribute("NochangeToEmployee",11);
            return "manager/managerIndexNav";
        }
        ResumeForManager r=resumeForManagers.get(0);
        System.out.println(r);
        Visitor visitor = visitorService.findByName(r.getVisitorName());
        Employee employee=new Employee(visitor.getName(),visitor.getPassword(),r.getName(),r.getGender(),r.getAge(),
                r.getMaster(),r.getEmail(),new Date(),"在职",r.getWorkPositionId());
        System.out.println(employee);
        Employee employee1=managerService.findEmployeeByVisitorName(visitor.getName());
        if(employee1!=null){
            model.addAttribute("changeToEmployeeExist",44);
            return "manager/managerIndexNav";
        }
        managerService.addEmployee(employee);
        Employee employee2=managerService.findEmployeeByVisitorName(visitor.getName());
        EmployeeInfo employeeInfo=new EmployeeInfo(employee2.getId(),-1,-1,-1,-1,r.getDepartmentId(),r.getWorkPositionId());
        managerService.addEmployeeInfo(employeeInfo);
        model.addAttribute("changeToEmployeeSeccessfully",44);
        return "manager/managerIndexNav";
    }


    @RequestMapping("refuseToChangeEmployee")
    public String refuseToChangeEmployee(String id,Model model){
        Integer goInterviewId = Integer.valueOf(id);
        GoInterview g= managerService.findGoInterviewByGointerviewId(goInterviewId);
        GoInterview goInterview1=new GoInterview(g.getId(),g.getVisitorName(),"已查看","未录用");
        managerService.updateGoInterview(goInterview1);
        model.addAttribute("updaterefuseToChangeEmployee",33);
        return "manager/managerIndexNav";
    }


    @RequestMapping("lookDepartmentWorkPosirion")
    public String lookDepartmentWorkPosirion(String id,Model model){
        Integer departmentId = Integer.valueOf(id);
        List<WorkPosition> workPositions = managerService.findWorkPositionByDepartmentId(departmentId);
        model.addAttribute("departmentId",departmentId);
        model.addAttribute("workPositions",workPositions);
        return "manager/workPosition";
    }

    @RequestMapping("addworkPositionForDepartment")
    public String addworkPositionForDepartment(String name, Integer departmentId, Model model, RedirectAttributes attr){
        WorkPosition workPosition=new WorkPosition(-1,name,departmentId,new Date());
        System.out.println(workPosition);
        managerService.addWorkPosition(workPosition);
        attr.addAttribute("id",departmentId.toString());
        return "redirect:/lookDepartmentWorkPosirion";
    }

    @RequestMapping("deleteWorkPositionForDepartmen")
    @ResponseBody
    public String deleteWorkPositionForDepartmen(Integer id){
        List<EmployeeInfo> employeeInfos = managerService.findEmployeeInfoByworkPositionId(id);
        if(employeeInfos==null||employeeInfos.size()==0){
            managerService.deleteWorkPosition(id);
            return "ok";
        }else{
            return "cantbeDelete";
        }
    }


    @RequestMapping("addDepartmentToDB")
    public String addDepartmentToDB(String name,Model model){
        Department department=new Department(-1,name,new Date());
        managerService.addDepartment(department);
        return "redirect:/mmanageDepartment";
    }

    @RequestMapping("ajaxdeleteDepartmentById")
    @ResponseBody
    public String deleteDepartmentById(Integer id){
        Integer departmentId = Integer.valueOf(id);
        List<EmployeeInfo> employeeInfos=managerService.findAllEmployeeInfoByDepartmentId(departmentId);
        if(employeeInfos.size()>0){
            return "false";
        }
        managerService.deleteWorkPositionByDepartmentId(departmentId);
        managerService.deleteDepartment(departmentId);
        return "seccess";
    }


    @RequestMapping("updateEmployeeDepartmentMesseges")
    public String updateEmployeeDepartmentMesseges(String id,String workPositionId,Model model) {
        Integer employeeId = Integer.valueOf(id);
        Integer newWorkPositionId = Integer.valueOf(workPositionId);
        WorkPosition workPosition = managerService.findWorkPositionById(newWorkPositionId);//员工部门职位信息
        model.addAttribute("workPosition", workPosition);

        if (workPosition != null) {
            Department department = managerService.findDepartmentbyId(workPosition.getDepartmentId());//员工部门信息
            model.addAttribute("department", department);
        }
        List<Department> allDepartment = managerService.findAllDepartment();//所有部门
        model.addAttribute("allDepartment", allDepartment);
        Employee employee = managerService.findEmployeeById(employeeId);//员工信息
        model.addAttribute("employee", employee);
        return "manager/updateEmployeeDept";
    }

    @RequestMapping("updateEmployeeAndCommit")
    public String updateEmployeeAndCommit(Integer employeeId,Integer departmentId,Integer workPositionId,Model model){
        System.out.println(employeeId);
        System.out.println(departmentId);
        System.out.println(workPositionId);
        Employee e = managerService.findEmployeeById(employeeId);
        managerService.updateEmployee(new Employee(e.getId(),e.getName(),e.getPassword(),e.getRealName(),e.getGender(),e.getAge()
                ,e.getDegree(),e.getEmail(),e.getBeginTime(),e.getStatus(),workPositionId));
        EmployeeInfo eInfo=managerService.findEmployeeInfoByEmployeeId(employeeId);
        managerService.updateEmployeeInfo(new EmployeeInfo(eInfo.getId(),eInfo.getEmployeeId(),eInfo.getTrainId(),eInfo.getSalaryId(),eInfo.getRewardId(),
                eInfo.getCheckworkattendId(),departmentId,workPositionId));
        model.addAttribute("updateEmployeeAndCommit1",44);
        return "manager/managerIndexNav";
    }

    @RequestMapping("addTrainForDepartment")
    public String addTrainForDepartment(String name,Date trainDate,String department,Model model) {
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:SS");
        Date parse = new Date();
        try {
            parse = sdf.parse(trainDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Train train=managerService.findTrainByDepartmentName(department);
        if(train!=null){
            model.addAttribute("addTrainForDepartmentExist",33);
            return "manager/managerIndexNav";
        }
        managerService.addTrain(new Train(name, trainDate, department));

        return "forward:/mmanageTrain";
    }


    @RequestMapping("ajaxDeleteTrainById")
    @ResponseBody
    public String ajaxDeleteTrainById(Integer id,Model model){
        Train train = managerService.findTrainById(id);
        if(train==null){
            model.addAttribute("ajaxDeleteTrainById",44);
            return "manager/managerIndexNav";
        }else {
            managerService.deleteTrain(id);
            return "deleteSeccessfully";
        }
    }

    @RequestMapping("addRewardForEmployee")
    public String addRewardMesseges(String employeeId,String reason,Integer money,Model model){
        Integer employeeId1 = Integer.valueOf(employeeId);
        Reward reward=new Reward(employeeId1,reason,money,new Date());
        managerService.addReward(reward);
        model.addAttribute("addRewardForEmployee",33);
        return "manager/managerIndexNav";
    }


    @RequestMapping("mmanageSalary")
    public String manageSalary(String employeeId, Model model){
        Integer employeeId1 = Integer.valueOf(employeeId);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        if(date>10){
            model.addAttribute("cantbehandelSalary",date);
            return "manager/managerIndexNav";
        }
        String monthLike="";
        if(month==1){
            year = c.get(Calendar.YEAR)-1;//当年减去一年
            monthLike="%"+year+"-12%";//如果是第二年一月份，则发放第一年12月份的的工资
            month=12;
        }else{
            monthLike="%"+year+"-"+(month-1)+"%";//%2018-09%
            month=month-1;
        }
        Salary salary=managerService.findSalaryByEIdAndByYearAndByMonth(employeeId1,year,month);
        if(salary!=null){//已经发放过
            model.addAttribute("salaryHasHandeled",99);
            return "manager/managerIndexNav";
        }
        List<Reward> rewards = managerService.findRewardByEmployeeIdAndByMonthLike(employeeId1,monthLike);
        List<CheckWorkAttendance> attendances=managerService.findAllCheckWorkAttendanceByEIdAndByMonth(employeeId1,monthLike);
        Integer TotalSalary=0;
        for(Reward r:rewards){
            TotalSalary+=r.getMoney();
        }
        Integer eSalary=attendances.size()*250+TotalSalary;//员工总工资
        Salary salary1=new Salary(eSalary,employeeId1,month,year,attendances.size());
        managerService.addSalary(salary1);
        model.addAttribute("handelSalarySeccess",55);
        return "manager/managerIndexNav";

    }

    @RequestMapping("lookThisDetailsAttandance")
    public String lookThisDetailsAttandance(Integer employeeId,Integer month,Integer year,Model model){
        Employee employee = managerService.findEmployeeById(employeeId);
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        List<CheckWorkAttendance> attendances=managerService.findAllCheckWorkAttendanceByEIdMonthYear(employee.getId(),month,year);
        model.addAttribute("attendances",attendances);
        model.addAttribute("employee",employee);
        return "manager/attandanceDetails";
    }

    @RequestMapping("lookThisDetailsSalary")
    public String lookThisDetailsSalary(Integer employeeId,Integer month,Integer year,Model model){
        Employee employee = managerService.findEmployeeById(employeeId);
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        List<Salary> salaries=managerService.findSalaryByEmployeeId(employee.getId(),month,year);
        model.addAttribute("salaries",salaries);
        model.addAttribute("employee",employee);
        return "manager/salaryDetails";
    }

    @RequestMapping("mmanageEmployee")
    public String manageEmployee( Model model){
        List<Employee> employees = managerService.findAllEmployee();
        model.addAttribute("employees",employees);
        return "manager/employee";
    }

    @RequestMapping("lookThisDetailsRewards")
    public String lookThisDetailsRewards(Integer employeeId,Integer month,Integer year,Model model){
        Employee employee = managerService.findEmployeeById(employeeId);
        if(month==null||year==null){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH)+1;//当前月
            month=month-1;//上个月
        }
        List<Reward> rewards=managerService.findAllRewardByEId(employee.getId(),month,year);
        model.addAttribute("rewards",rewards);
        model.addAttribute("employee",employee);
        return "manager/rewardDetails";
    }

    @RequestMapping("outOfTheEmployeeFromWork")
    public String outOfTheEmployeeFromWork(Integer employeeId,  Model model){
        Employee e = managerService.findEmployeeById(employeeId);
        if("离职".equals(e.getStatus())){
            model.addAttribute("isAlreadyOutOfFromWork",44);
            return "manager/managerIndexNav";
        }
        Employee employee1=new Employee(e.getId(),e.getName(),e.getPassword(),e.getRealName(),
                e.getGender(),e.getAge(),e.getDegree(),e.getEmail(),e.getBeginTime(),"离职",e.getWorkPositionId());
        managerService.updateEmployee(employee1);
        model.addAttribute("outOfTheEmployeeFromWork",44);
        return "manager/managerIndexNav";
    }

    @RequestMapping("reconsiderManagement")
    public String reconsiderManagement(Model model){
        List<Reconsider> reconsiders=managerService.findAllReconsiderMessegess();
        if(reconsiders.size()==0){
            model.addAttribute("reconsiderManagementEmpty",22);
            return "manager/managerIndexNav";
        }
        model.addAttribute("reconsiders",reconsiders);
        return "manager/reconsiderDetails";
    }

    @RequestMapping("ajaxDeleteReconsiderById")
    @ResponseBody
    public String ajaxDeleteReconsiderById(Integer id){
        Reconsider reconsider=managerService.findReconsiderById(id);
        if(reconsider==null){
            return "false";
        }
        managerService.deleteReconsiderById(id);
        return "seccess";
    }
}
