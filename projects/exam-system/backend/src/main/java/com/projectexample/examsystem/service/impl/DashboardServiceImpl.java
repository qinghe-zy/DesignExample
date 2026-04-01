package com.projectexample.examsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.examsystem.entity.ExamPaper;
import com.projectexample.examsystem.mapper.ExamPaperMapper;
import com.projectexample.examsystem.mapper.ExamRecordMapper;
import com.projectexample.examsystem.mapper.QuestionBankMapper;
import com.projectexample.examsystem.mapper.SysMenuMapper;
import com.projectexample.examsystem.mapper.SysRoleMapper;
import com.projectexample.examsystem.mapper.SysUserMapper;
import com.projectexample.examsystem.service.DashboardService;
import com.projectexample.examsystem.vo.DashboardMetricVO;
import com.projectexample.examsystem.vo.DashboardOverviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;
    private final QuestionBankMapper questionBankMapper;
    private final ExamPaperMapper examPaperMapper;
    private final ExamRecordMapper examRecordMapper;

    @Override
    public DashboardOverviewVO getOverview() {
        return DashboardOverviewVO.builder()
                .headline("Exam operations baseline is ready for extension")
                .summary("This derived project keeps the shared admin core and layers in question bank, paper, and result modules for a reusable exam template.")
                .metrics(List.of(
                        new DashboardMetricVO("Questions", questionBankMapper.selectCount(null), "Question bank records"),
                        new DashboardMetricVO("Published Papers", examPaperMapper.selectCount(Wrappers.lambdaQuery(ExamPaper.class).eq(ExamPaper::getPublishStatus, 1)), "Ready-to-use papers"),
                        new DashboardMetricVO("Exam Records", examRecordMapper.selectCount(null), "Exam attempt results"),
                        new DashboardMetricVO("Menus", sysMenuMapper.selectCount(null), "Navigation and permission nodes")
                ))
                .nextActions(List.of(
                        "Keep the auth, menu, and role modules aligned with the shared base.",
                        "Add scheduling, auto-grading, and anti-cheat features after the current exam core is stable.",
                        "Promote repeated assessment patterns back into shared guidance when they mature."
                ))
                .build();
    }
}
