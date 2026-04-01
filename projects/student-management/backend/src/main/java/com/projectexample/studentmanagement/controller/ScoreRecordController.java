package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.dto.ScoreRecordSaveRequest;
import com.projectexample.studentmanagement.service.ScoreRecordService;
import com.projectexample.studentmanagement.vo.ScoreRecordVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/scores")
@RequiredArgsConstructor
public class ScoreRecordController {

    private final ScoreRecordService scoreRecordService;

    @GetMapping
    public ApiResponse<List<ScoreRecordVO>> list() {
        return ApiResponse.success(scoreRecordService.listScores());
    }

    @PostMapping
    public ApiResponse<ScoreRecordVO> create(@Valid @RequestBody ScoreRecordSaveRequest request) {
        return ApiResponse.success("score created", scoreRecordService.createScore(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<ScoreRecordVO> update(@PathVariable Long id, @Valid @RequestBody ScoreRecordSaveRequest request) {
        return ApiResponse.success("score updated", scoreRecordService.updateScore(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        scoreRecordService.deleteScore(id);
        return ApiResponse.success("score deleted", null);
    }
}
