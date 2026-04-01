package com.projectexample.librarymanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.librarymanagement.entity.BorrowRecord;
import com.projectexample.librarymanagement.mapper.BookCatalogMapper;
import com.projectexample.librarymanagement.mapper.BorrowRecordMapper;
import com.projectexample.librarymanagement.mapper.ReaderProfileMapper;
import com.projectexample.librarymanagement.mapper.SysMenuMapper;
import com.projectexample.librarymanagement.mapper.SysRoleMapper;
import com.projectexample.librarymanagement.mapper.SysUserMapper;
import com.projectexample.librarymanagement.service.DashboardService;
import com.projectexample.librarymanagement.vo.DashboardMetricVO;
import com.projectexample.librarymanagement.vo.DashboardOverviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;
    private final BookCatalogMapper bookCatalogMapper;
    private final ReaderProfileMapper readerProfileMapper;
    private final BorrowRecordMapper borrowRecordMapper;

    @Override
    public DashboardOverviewVO getOverview() {
        return DashboardOverviewVO.builder()
                .headline("Library operations baseline is ready for extension")
                .summary("This derived project keeps the shared admin core and layers in catalog, reader, and circulation modules for a reusable library template.")
                .metrics(List.of(
                        new DashboardMetricVO("Books", bookCatalogMapper.selectCount(null), "Catalog records"),
                        new DashboardMetricVO("Readers", readerProfileMapper.selectCount(null), "Library membership profiles"),
                        new DashboardMetricVO("Borrowed", borrowRecordMapper.selectCount(Wrappers.lambdaQuery(BorrowRecord.class).eq(BorrowRecord::getStatus, 0)), "Currently borrowed books"),
                        new DashboardMetricVO("Returned", borrowRecordMapper.selectCount(Wrappers.lambdaQuery(BorrowRecord.class).eq(BorrowRecord::getStatus, 1)), "Completed returns")
                ))
                .nextActions(List.of(
                        "Keep the auth, menu, and role modules aligned with the shared base.",
                        "Add reservation, fine, and inventory audit flows after the core circulation path is stable.",
                        "Promote repeated catalog and circulation patterns back into shared guidance when they mature."
                ))
                .build();
    }
}
