package com.kennyouchou.community.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.kennyouchou.commons.annotation.logger.LLogger;
import com.kennyouchou.commons.result.Result;
import com.kennyouchou.commons.result.impl.ErrorResult;
import com.kennyouchou.commons.result.impl.SuccessResult;
import com.kennyouchou.community.CommunityUrls;
import com.kennyouchou.community.entity.CommunityInAndOut;
import com.kennyouchou.community.service.CommunityInAndOutService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 小区-进出登记表 前端控制器
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-21
 */
@RestController
@Api(tags = "社区-进出登记表")
@ApiSupport(order = 8)
@Slf4j
@RequestMapping(CommunityUrls.InAndOutCtrls.BASE_URL)
public class CommunityInAndOutController {

    @Resource
    private CommunityInAndOutService communityInAndOutService;

    @LLogger(description = "添加进出信息", params = {"添加进出信息"})
    @ApiOperation("添加进出信息")
    @ApiOperationSupport(order = 1)
    @PostMapping(CommunityUrls.InAndOutCtrls.ADD)
    public Result<String> add(@RequestBody CommunityInAndOut communityInAndOut){
        try {
            communityInAndOutService.addCommunityInAndOut(communityInAndOut);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ErrorResult<>("添加出入登记异常");
        }
        return new SuccessResult<>("添加出入登记信息成功");
    }

}
