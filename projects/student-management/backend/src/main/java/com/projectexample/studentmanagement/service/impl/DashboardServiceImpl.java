package com.projectexample.studentmanagement.service.impl;

import com.projectexample.studentmanagement.mapper.AcademicClassMapper;
import com.projectexample.studentmanagement.mapper.DisciplineRecordMapper;
import com.projectexample.studentmanagement.mapper.SysMenuMapper;
import com.projectexample.studentmanagement.mapper.SysRoleMapper;
import com.projectexample.studentmanagement.mapper.SysUserMapper;
import com.projectexample.studentmanagement.mapper.StudentProfileMapper;
import com.projectexample.studentmanagement.mapper.ScoreRecordMapper;
import com.projectexample.studentmanagement.service.DashboardService;
import com.projectexample.studentmanagement.vo.DashboardMetricVO;
import com.projectexample.studentmanagement.vo.DashboardOverviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;
    private final AcademicClassMapper academicClassMapper;
    private final StudentProfileMapper studentProfileMapper;
    private final ScoreRecordMapper scoreRecordMapper;
    private final DisciplineRecordMapper disciplineRecordMapper;

    @Override
    public DashboardOverviewVO getOverview() {
        return DashboardOverviewVO.builder()
                .headline("Student management baseline is ready for academic operations")
                .summary("This derived project keeps the shared admin core and layers in core student archive, class, score, and discipline flows.")
                .metrics(List.of(
                        new DashboardMetricVO("Students", studentProfileMapper.selectCount(null), "Student archive records"),
                        new DashboardMetricVO("Classes", academicClassMapper.selectCount(null), "Active class groups"),
                        new DashboardMetricVO("Scores", scoreRecordMapper.selectCount(null), "Recorded course scores"),
                        new DashboardMetricVO("Discipline", disciplineRecordMapper.selectCount(null), "Leave or discipline follow-up records")
                ))
                .nextActions(List.of(
                        "Keep auth, menu, and role modules aligned with the shared base.",
                        "Add attendance, dorm, and guardian modules only after the current archive flow is stable.",
                        "Promote repeated student lifecycle patterns back into shared guidance when they mature."
                ))
                .build();
    }
}

