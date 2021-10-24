package Management.HumanResources.DepartmentCommand;

import Management.HumanResources.DepartmentType;
import Management.HumanResources.Staff.Auditor;
import Presentation.Protocol.OutputManager;

/**
 * 经济管理部门下的AuditReportCommand,由FinancialDepartment指派部门下一个Auditor去审阅Report
 *
 * @author 陈垲昕
 * @since 2021/10/21 9:50 下午
 */

public class AuditSalaryTableCommand extends Command {

    /**
     * 接受者：一个审计员
     */
    private Auditor receiver;

    /**
     * 审计命令初始化，无参，指定部门
     * @author 陈垲昕
     * @since 2021-10-21 9:58 下午
     */
    public AuditSalaryTableCommand(){super.accessedDepartment= DepartmentType.Finance;}

    /**
     * 审计命令初始化，带审计员，指定部门并设定receiver
     * @param receiver : 审计员
     * @author 陈垲昕
     * @since 2021-10-21 10:04 下午
     */
    public AuditSalaryTableCommand(Auditor receiver){
        super.accessedDepartment=DepartmentType.Finance;
        this.receiver=receiver;
    }

    /**
     * 设置该命令的审计员接受者
     * @param receiver :   一个审计员
     * @author 陈垲昕
     * @since 2021-10-21 10:05 下午
     */
    public void setAuditor(Auditor receiver){
        if(receiver==null){
            OutputManager.getInstance().errorMassage(
                    "审计员不能为空",
                    "審計員不能為空",
                    "The receiver (Auditor) cannot be empty."
            );
        }
        else{
            this.receiver=receiver;
        }
    }

    /**
     * 执行审计命令
     * @author 陈垲昕
     * @since 2021-10-21 10:05 下午
     */
    @Override
    public void executeCommand() {
        receiver.auditSalaryReport();
    }
}